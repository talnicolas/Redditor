//Source file: C:\\Users\\nikkKO\\Desktop\\rEdditooooooor\\Controler\\CommandInsert.java

package rEdditooooooor.Controler.impl;

import rEdditooooooor.Controler.IEditorCommand;
import rEdditooooooor.Model.TextConcrete;


public class CommandInsert extends CommandUndoable implements IEditorCommand
{
	private char character;
	private int start;
	private int end;
	private TextConcrete text;
   
   /**
    * Constructor
    */
   public CommandInsert() 
   {
   }
   
   public void execute() {
	   text.insert(this.start, this.character);
   }
   
   @Override
	public void executeFrom(int aStart, int aEnd) {
	   text.insert(this.start + aStart, this.character);
	}
   
   @Override
   public void unexecute() {
	   
   		text.delete(start + 1);
   }
   
   @Override
	public int getStart() {
		return this.start;
	}
   
   public void setCarets(int aStart, int aEnd){
	   this.start = aStart;
	   this.end = aEnd;
   }
   
   public void setText(TextConcrete aText){
	   this.text = aText;
   }
   
   public void setChar(char aChar) {
	   this.character = aChar;
   }

	@Override
	public CommandUndoable getClone() {
		CommandInsert com = new CommandInsert();
		com.setCarets(start, end);
		com.setChar(character);
		com.setText(text);
		return com;
	}
}

