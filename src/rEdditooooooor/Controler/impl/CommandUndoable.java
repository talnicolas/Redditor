package rEdditooooooor.Controler.impl;

import rEdditooooooor.Controler.IEditorCommand;
import rEdditooooooor.Model.TextConcrete;

/**
 * Undoable commands are commands that affects the state of the model
 */
public abstract class CommandUndoable implements IEditorCommand
{
	/**
	 * Undo the command.
	 */
	public abstract void unexecute();
	
	/**
	 * @return index where command started
	 */
	public abstract int getStart();
	
	/**
	 * @return index where command ended
	 */
	public abstract int getEnd();
	
	 /**
	  * @param start the position to start the command
	  * @param end the position where the command end
	  */
	public abstract void setCarets(int start, int end);
	
	/**
	 * @param text the text on which the command is executed
	 */
	public abstract void setText(TextConcrete text);
	
	/**
	 * @return a new copy of the command to be saved in the undo redo buffer (and recorder)
	 */
	public abstract CommandUndoable getClone();

}
