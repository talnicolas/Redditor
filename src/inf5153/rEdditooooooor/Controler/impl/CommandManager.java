package rEdditooooooor.Controler.impl;

import java.util.ArrayList;
import java.util.List;

import rEdditooooooor.Controler.IEditorCommand;


public class CommandManager {

	private static final CommandManager INSTANCE = new CommandManager();
	List<IEditorCommand> commandsUndo;
	List<IEditorCommand> commandsRedo;
	
	protected CommandManager() {
		commandsUndo = new ArrayList<IEditorCommand>();
		commandsRedo = new ArrayList<IEditorCommand>();
	}
			
	public void executeCommand(IEditorCommand command){
		command.execute();		
	}	
	
	public void setCommandUndo(IEditorCommand command){
		this.commandsUndo.add(0, command);
	}
	
	public void undo() {
		if(this.commandsUndo.size() > 0){
			CommandUndoable command = (CommandUndoable) this.commandsUndo.get(0);
			command.undo();
			this.commandsUndo.remove(0);
		}
	}
	
	public void setCommandRedo(IEditorCommand command){
		this.commandsRedo.add(0, command);
	}
	
	public void redo() {
		if(this.commandsRedo.size() > 0){
			CommandUndoable command = (CommandUndoable) this.commandsRedo.get(0);
			command.redo();
			this.commandsRedo.remove(0);
		}
	}
	
	public static CommandManager getInstance() {
		return INSTANCE;
	}
}
