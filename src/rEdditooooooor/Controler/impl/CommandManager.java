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
	
	public void executeCommandStart() {
		if(recordings.size() > 0){
			recordings.clear();
		}
		startRecordIdx = this.start;
		recordMode = true;
	}
	
	public void executeCommandStop() {		
		recordMode = false;
	}
	
	public void executeCommandReset() {
		recordings.clear();
	}
	
	public boolean executeCommandPlay(final int start, final int end) {	
		replayable = true;		
		int idx = 0;
		while(replayable && idx < recordings.size()){
			CommandUndoable com = recordings.get(idx).getClone();
			com.setCarets(start + (com.getStart() - startRecordIdx), end + (com.getEnd() - startRecordIdx));
			if(!com.execute()){
				executeCommandReset();
				replayable = false;
			}
			idx++;
		}		
		return replayable;
	}
		
	/**
	* Save an undoable command for undo purpose
	* @param command an undoable command
	*/

	public void setCommandUndo(CommandUndoable command){
		this.commandsUndo.add(0, command);
	}
		
	public void setCommandRedo(CommandUndoable command){
		this.commandsRedo.add(0, command);
	}
	
	public void undo() {
		if(this.commandsUndo.size() > 0){
			CommandUndoable command = this.commandsUndo.get(0);			
			command.unexecute();		
			this.commandsRedo.add(0, command);
			this.commandsUndo.remove(0);
		}
	}
	
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
	
	public void clearAll(){
		this.commandsRedo.clear();
		this.commandsUndo.clear();
		this.recordings.clear();
	}	
}
