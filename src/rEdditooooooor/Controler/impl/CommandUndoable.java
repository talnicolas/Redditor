package rEdditooooooor.Controler.impl;

import rEdditooooooor.Controler.IEditorCommand;
import rEdditooooooor.Model.TextConcrete;

/**
 * Undoable commands are commands that affects the state of the model
 */
public abstract class CommandUndoable implements IEditorCommand
{
	protected CommandManager cM = CommandManager.getInstance();
	
	public abstract void executeFrom(int start, int end);
	
	public abstract void unexecute();
	
	public abstract int getStart();
	
	public abstract void setCarets(int start, int end);
	
	public abstract void setText(TextConcrete text);
	
	public abstract CommandUndoable getClone();

}
