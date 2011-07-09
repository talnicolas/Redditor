package rEdditooooooor.Controler.impl;

import rEdditooooooor.Controler.IEditorCommand;
import rEdditooooooor.Model.TextConcrete;

/**
 * Undoable commands are commands that affects the state of the model
 */
public abstract class CommandUndoable implements IEditorCommand {

	protected CommandManager cM;
	protected TextConcrete text;
	private String state;
	
	/**
	 * Default constructor
	 */
	public CommandUndoable() {
		this.text = TextConcrete.getInstance();
		this.cM = CommandManager.getInstance();
		this.state = this.text.getState();
	}
	
	/**
	 * @see rEdditooooooor.Controler.impl.CommandManager.undo()
	 */
	public void undo() {
		String previousState = this.state;
		this.state = this.text.getState();
		cM.setCommandRedo(this);
		this.text.setState(previousState);	
	}
	
	/**
	 * @see rEdditooooooor.Controler.impl.CommandManager.redo()
	 */
	public void redo() {
		String previousState = this.state;
		this.state = this.text.getState();
		cM.setCommandUndo(this);
		this.text.setState(previousState);
	}
	
}
