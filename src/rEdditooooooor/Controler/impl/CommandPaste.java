//Source file: C:\\Users\\nikkKO\\Desktop\\rEdditooooooor\\Controler\\CommandPaste.java

package rEdditooooooor.Controler.impl;

import rEdditooooooor.Controler.IEditorCommand;
import rEdditooooooor.Model.TextConcrete;


public class CommandPaste extends CommandUndoable implements IEditorCommand 
{
	private int start;
	private int end;
	private TextConcrete text;

   /**
    * Constructor
    */
   public CommandPaste() 
   {	  
   }
   
   public void execute() 
   {
	   this.end = text.paste(this.start);
   }

   @Override
	public void executeFrom(int aStart, int aEnd) {
	   this.end = text.paste(this.start + aStart);
	}
   
   @Override
   public void unexecute() {
	   	text.cut(start, start + end);
   }
   
   @Override
	public int getStart() {
		return this.start;
	}
   
   
   public void setCarets(int aStart, int aEnd){
	   this.start = aStart;
	   this.end = aEnd;
   }
   
   public void setText(TextConcrete aText) {
	   this.text = aText;
   }

	@Override
	public CommandUndoable getClone() {
		CommandPaste com = new CommandPaste();
		com.setCarets(start, end);
		com.setText(text);
		return com;
	}
}
