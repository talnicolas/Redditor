package rEdditooooooor.Controler.impl;

import rEdditooooooor.Controler.IEditorCommand;
import rEdditooooooor.Model.TextConcrete;

public abstract class CommandUndoable extends CommandManager implements IEditorCommand {

	protected CommandManager cM;
	protected TextConcrete text;
	private String state;
	
	public CommandUndoable() {
		this.text = TextConcrete.getInstance();
		this.cM = CommandManager.getInstance();
		this.state = this.text.getState();
	}
	
	public void undo() {
		String previousState = this.state;
		this.state = this.text.getState();
		cM.setCommandRedo(this);
		this.text.setState(previousState);	
	}
	
	public void redo() {
		String previousState = this.state;
		this.state = this.text.getState();
		cM.setCommandUndo(this);
		this.text.setState(previousState);
	}
	
}
