package rEdditooooooor.Controler.impl;

import java.util.ArrayList;
import java.util.List;

import rEdditooooooor.Controler.IEditorCommand;
import rEdditooooooor.Model.TextConcrete;


/**
 * Class created to manage the commands for undo/redo purpose
 */
public final class CommandManager {

	private List<CommandUndoable> commandsUndo;
	private List<CommandUndoable> commandsRedo;
	private List<CommandUndoable> recordings;
	private boolean recordMode;
	private boolean replayable;
	private int startRecordIdx;
	
	private int start;
	private int end;
	private char character;
	
	/**
	 * Default constructor
	 */
	public CommandManager() {
		commandsUndo = new ArrayList<CommandUndoable>();
		commandsRedo = new ArrayList<CommandUndoable>();
		recordings = new ArrayList<CommandUndoable>();
		recordMode = false;
	}
		
	/**
	 * Execute the command received by the UI on a specified text. If the recording mode is
	 * on, save the command in the recordings buffer.
	 * @param text text on which the command has to be executed
	 * @param command the command to be executed
	 * @return true if the command executed correctly
	 */
	public boolean executeCommand(TextConcrete text, IEditorCommand command){
		if(command instanceof CommandUndoable) { 
			((CommandUndoable) command).setCarets(start, end);
			((CommandUndoable) command).setText(text);
			if(command instanceof CommandInsert){
				((CommandInsert) command).setChar(character);
			} 
			if(command.execute()) {
				CommandUndoable temp = ((CommandUndoable) command).getClone();
				commandsUndo.add(0, temp);

				if(recordMode){
					recordings.add(temp);
				}
				return true;
			} else {
				return false;
			}
		} else {
			if(command instanceof CommandNew){
				((CommandNew) command).setText(text);
				((CommandNew) command).setCommandManager(this);				
			} 
			return command.execute();
		}
	}
	
	/**
	 * Start the recording. Clear the buffer if it isn't empty
	 */
	public void startRecording() {
		if(recordings.size() > 0){
			recordings.clear();
		}
		startRecordIdx = this.start;
		recordMode = true;
	}
	
	/**
	 * Stop the recording
	 */
	public void stopRecording() {		
		recordMode = false;
	}
	
	/**
	 * Reset the recordings buffer
	 */
	public void resetRecordings() {
		recordings.clear();
	}
	
	/**
	 * The command play executes all the commands that has been executed by the user since he
	 * started the recording, in order. If a non replayable action has been recorded, an error
	 * box will be displayed to the user.
	 * @param start position from which the replay starts
	 * @param end position where the replay ends
	 * @return true if the replay executed successfully
	 */
	public boolean playRecordings(final int start, final int end) {	
		replayable = true;		
		int idx = 0;
		while(replayable && idx < recordings.size()){
			CommandUndoable com = recordings.get(idx).getClone();
			com.setCarets(start + (com.getStart() - startRecordIdx), end + (com.getEnd() - startRecordIdx));
			if(!com.execute()){
				resetRecordings();
				replayable = false;
			}
			idx++;
		}		
		return replayable;
	}
	
	/**
	 * Call the method unexecute of the command so this command can be reverted
	 */
	public void undo() {
		if(this.commandsUndo.size() > 0){
			CommandUndoable command = this.commandsUndo.get(0);			
			command.unexecute();		
			this.commandsRedo.add(0, command);
			this.commandsUndo.remove(0);
		}
	}
	
	/**
	 * Reexecute a command that has been previously undone
	 */
	public void redo() {
		if(this.commandsRedo.size() > 0){
			CommandUndoable command = this.commandsRedo.get(0);			
			command.execute();		
			this.commandsUndo.add(0, command);
			this.commandsRedo.remove(0);
		}
	}
	
	public void setCarets(int aStart, int aEnd){
		this.start = aStart;
		this.end = aEnd;
		if(this.start > this.end){
			int back = this.start;
			this.start = this.end;
			this.end = back;
		}
	}
	
	public void setCharacter(char aCharacter) {
		this.character = aCharacter;
	}
	
	/**
	 * Reset all the buffers (for the New command)
	 */
	public void clearAll(){
		this.commandsRedo.clear();
		this.commandsUndo.clear();
		this.recordings.clear();
	}	
}
