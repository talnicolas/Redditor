package rEdditooooooor.Controler.impl;

import rEdditooooooor.Controler.IEditorCommand;


public class CommandManager {

	public CommandManager() {
	}
	
	public void executeCommand(IEditorCommand command){
		command.execute();
	}
}
