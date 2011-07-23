//Source file: C:\\Users\\nikkKO\\Desktop\\rEdditooooooor\\Controler\\CommandCopy.java

package rEdditooooooor.Controler.impl;

import rEdditooooooor.Controler.IEditorCommand;
import rEdditooooooor.Model.TextConcrete;


public class CommandCopy extends CommandUndoable implements IEditorCommand 
{
	private int start;
	private int end;
	private TextConcrete text;

   /**
    * Constructor
    */
   public CommandCopy() 
   {
   }
   
   public boolean execute() 
   {	   
	   return this.text.copy(this.start, this.end);
   }
   
   public void setCarets(int aStart, int aEnd){
	   this.start = aStart;
	   this.end = aEnd;
   }
   
   public void setText(TextConcrete aText){
	   this.text = aText;
   }
	
	@Override
	public void unexecute() {
		this.text.clearClipBoard();
	}
	
	@Override
	public int getStart() {
		return this.start;
	}
	
	@Override
	public int getEnd() {
		return this.end;
	}
	
	@Override
	public CommandUndoable getClone() {
		CommandCopy com = new CommandCopy();
		com.setCarets(start, end);
		com.setText(text);
		return com;
	}   
}
