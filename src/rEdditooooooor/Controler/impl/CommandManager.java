package rEdditooooooor.Controler.impl;

import java.util.ArrayList;
import java.util.List;

import rEdditooooooor.Controler.IEditorCommand;

/**
 * Class created to manage the commands for undo/redo purpose
 */
public final class CommandManager {

	private static final CommandManager INSTANCECM = new CommandManager();
	private List<IEditorCommand> commandsUndo;
	private List<IEditorCommand> commandsRedo;
	
	private CommandCopy commandCopy;
	private CommandCut commandCut;
	private CommandPaste commandPaste;
	private CommandDelete commandDelete;
	private CommandDeleteAfter commandDeleteAfter;
	private CommandInsert commandInsert;
	private CommandNew commandNew;
	
	/**
	 * Default constructor
	 */
	private CommandManager() {
		commandsUndo = new ArrayList<IEditorCommand>();
		commandsRedo = new ArrayList<IEditorCommand>();
		
		commandCopy = new CommandCopy(0, 0);
		commandCut = new CommandCut(0, 0);
		commandPaste = new CommandPaste(0, 0);
		commandDelete = new CommandDelete(0, 0);
		commandDeleteAfter = new CommandDeleteAfter(0, 0);
		commandInsert = new CommandInsert(0, 0, ' ');
		commandNew = new CommandNew();
	}
		
	
	public void executeCommandNew(){
		commandNew.execute();		
	}
	
	public void executeCommandCopy(int start, int end) {
		commandCopy.setCarets(start, end);
		commandCopy.execute();		
	}
	
	public void executeCommandCut(int start, int end) {
		commandCut.setCarets(start, end);
		commandCut.execute();		
	}
	
	public void executeCommandPaste(int start, int end) {
		commandPaste.setCarets(start, end);
		commandPaste.execute();		
	}
	
	public void executeCommandDelete(int start, int end) {
		commandDelete.setCarets(start, end);
		commandDelete.execute();		
	}
	
	public void executeCommandDeleteAfter(int start, int end) {
		commandDeleteAfter.setCarets(start, end);
		commandDeleteAfter.execute();		
	}
	
	public void executeCommandInsert(int start, int end, char character) {
		commandInsert.setCarets(start, end);
		commandInsert.setChar(character);
		commandInsert.execute();		
	}
	
	/**
	 * Save an undoable command for undo purpose
	 * @param command an undoable command
	 */
	public void setCommandUndo(IEditorCommand command){
		this.commandsUndo.add(0, command);
	}
	
	public List<IEditorCommand> getCommandsUndo() {
		return commandsUndo;
	}
	
	public List<IEditorCommand> getCommandsRedo() {
		return commandsRedo;
	}
	
	/**
	 * Undo the last undoable command executed.
	 */
	public void undo() {
		if(this.commandsUndo.size() > 0){
			CommandUndoable command = (CommandUndoable) this.commandsUndo.get(0);
			command.undo();
			this.commandsUndo.remove(0);
		}
	}
	
	/**
	 * Save a redoable command for redo purpose
	 * @param command an undoable command
	 */
	public void setCommandRedo(IEditorCommand command){
		this.commandsRedo.add(0, command);
	}
	
	/**
	 * Redo the last redoable command executed.
	 */
	public void redo() {
		if(this.commandsRedo.size() > 0){
			CommandUndoable command = (CommandUndoable) this.commandsRedo.get(0);
			command.redo();
			this.commandsRedo.remove(0);
		}
	}
	
	/**
	 * @return the unique instance of CommandManager
	 */
	public static synchronized CommandManager getInstance() {
		return INSTANCECM;
	}
}
