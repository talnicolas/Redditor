//Source file: C:\\Users\\nikkKO\\Desktop\\rEdditooooooor\\Controler\\CommandDelete.java

package rEdditooooooor.Controler.impl;

import rEdditooooooor.Controler.IEditorCommand;
import rEdditooooooor.Model.TextConcrete;


public class CommandDelete extends CommandUndoable implements IEditorCommand 
{
	private int start;
	private int end;
	private char character;
	private TextConcrete text;

   /**
    * Constructor
    */
   public CommandDelete() 
   {
   }
   
   public boolean execute() 
   {
	   this.character = text.delete(this.start);
	   if(this.character == '\u0000'){
		   return false;
	   }
	   return true;
   }

   @Override
   public void unexecute() {
	   text.insert(start, character);
   }
   
   @Override
	public int getStart() {
		return this.start;
	}
 
   @Override
	public int getEnd() {
		return this.end;
	}
   
   public void setCarets(int aStart, int aEnd){
	   this.start = aStart;
	   this.end = aEnd;
   }
   
   public void setText(TextConcrete aText) {
	   this.text = aText;
   }
   
   public void setCharacter(char aCharacter) {
	   this.character = aCharacter;
   }	

	@Override
	public CommandUndoable getClone() {
		CommandDelete com = new CommandDelete();
		com.setCarets(start, end);
		com.setCharacter(character);
		com.setText(text);
		return com;
}
}
