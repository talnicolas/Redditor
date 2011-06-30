package rEdditooooooor.Controler.impl;

import java.util.ArrayList;
import java.util.List;

import rEdditooooooor.Controler.IEditorCommand;

/**
 * Class created to manage the commands for undo/redo purpose
 */
public class CommandManager {

	private static final CommandManager INSTANCE = new CommandManager();
	List<IEditorCommand> commandsUndo;
	List<IEditorCommand> commandsRedo;
	
	/**
	 * Default constructor
	 */
	protected CommandManager() {
		commandsUndo = new ArrayList<IEditorCommand>();
		commandsRedo = new ArrayList<IEditorCommand>();
	}
		
	/**
	 * Execute the specified command, and save it in the commandsUndo buffer if it's undoable
	 * @param command a command
	 */	
	public void executeCommand(IEditorCommand command){
		command.execute();		
	}	
	
	/**
	 * Save an undoable command for undo purpose
	 * @param command an undoable command
	 */
	public void setCommandUndo(IEditorCommand command){
		this.commandsUndo.add(0, command);
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
	 * Save an redoable command for redo purpose
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
	public static CommandManager getInstance() {
		return INSTANCE;
	}
}
