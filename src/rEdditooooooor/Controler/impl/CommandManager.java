package rEdditooooooor.Controler.impl;

import java.util.ArrayList;
import java.util.List;

import rEdditooooooor.Controler.IEditorCommand;
import rEdditooooooor.Model.TextConcrete;


/**
 * Class created to manage the commands for undo/redo purpose
 */
public final class CommandManager {

	private static final CommandManager INSTANCECM = new CommandManager();
	private List<CommandUndoable> commandsUndo;
	private List<CommandUndoable> commandsRedo;
	private List<CommandUndoable> recordings;
	private boolean recordMode;
	
	private int start;
	private int end;
	private char character;
	
	/**
	 * Default constructor
	 */
	private CommandManager() {
		commandsUndo = new ArrayList<CommandUndoable>();
		commandsRedo = new ArrayList<CommandUndoable>();
		recordings = new ArrayList<CommandUndoable>();
		recordMode = false;
	}
		
	public void executeCommand(TextConcrete text, IEditorCommand command){
		if(command instanceof CommandUndoable) { 
			((CommandUndoable) command).setCarets(start, end);
			((CommandUndoable) command).setText(text);
			if(command instanceof CommandInsert){
				((CommandInsert) command).setChar(character);
			} 
			command.execute();
			commandsUndo.add(0, ((CommandUndoable) command).getClone());

			recordings.add(((CommandUndoable) command).getClone());
		} else {
			if(command instanceof CommandNew){
				((CommandNew) command).setText(text);
			} else if(command instanceof CommandCopy){
				((CommandCopy) command).setCarets(start, end);
				((CommandCopy) command).setText(text);
			} 
			command.execute();
		}
	}
	
	public void executeCommandStart() {
		if(recordings.size() > 0){
			recordings.clear();
		}
		recordMode = true;
	}
	
	public void executeCommandStop() {		
		recordMode = false;
	}
	
	public void executeCommandReset() {
		recordings.clear();
	}
	
	public void executeCommandPlay(final int start, final int end) {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {					
				for(int idx = 0; idx < recordings.size(); idx++){	
					CommandUndoable com = recordings.get(idx);
					com.executeFrom(start, end);
					try {
						Thread.sleep(500);
					} catch (InterruptedException interruptedException) {
						interruptedException.printStackTrace();
					}
				}	  
			}
		});
		thread.start();
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
	}
	
	public void setCharacter(char aCharacter) {
		this.character = aCharacter;
	}

	public void clearAll(){
		this.commandsRedo.clear();
		this.commandsUndo.clear();
		this.recordings.clear();
	}
	
	/**
	 * @return the unique instance of CommandManager
	 */
	public static synchronized CommandManager getInstance() {
		return INSTANCECM;
	}
}
