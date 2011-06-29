package rEdditooooooor.Controler.impl;

import java.util.ArrayList;
import java.util.List;

import rEdditooooooor.Controler.IEditorCommand;


public class CommandManager {

	private static final CommandManager INSTANCE = new CommandManager();
	List<IEditorCommand> commandsUndo;
	List<IEditorCommand> commandsRedo;
	
	private CommandManager() {
		commandsUndo = new ArrayList<IEditorCommand>();
		commandsRedo = new ArrayList<IEditorCommand>();
	}
			
	public void executeCommand(IEditorCommand command){
		command.execute();		
	}	
	
	public void setCommand(IEditorCommand command){
		this.commandsUndo.add(0, command);
	}
	
	public void undo() {
		if(this.commandsUndo.size() > 0){
			this.commandsUndo.get(0).undo();
			this.commandsUndo.remove(0);
		}
	}
	
	public static CommandManager getInstance() {
		return INSTANCE;
	}
}
