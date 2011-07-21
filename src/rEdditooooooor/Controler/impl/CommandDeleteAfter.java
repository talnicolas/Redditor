package rEdditooooooor.Controler.impl;

import rEdditooooooor.Controler.IEditorCommand;
import rEdditooooooor.Model.TextConcrete;

public class CommandDeleteAfter extends CommandUndoable implements IEditorCommand 
{	
	private int start;
	private int end;
	private char character;
	private TextConcrete text;

   /**
    * Constructor
    */
   public CommandDeleteAfter() 
   {
   }
   
   public void execute() 
   {
	   this.character = text.deleteAfter(this.start);
   }

   @Override
	public void executeFrom(int aStart, int aEnd) {
	   this.character = text.deleteAfter(this.start + aStart);
	}
   
   @Override
   public void unexecute() {
	   text.insert(start, character);
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
   
   public void setCharacter(char aCharacter) {
	   this.character = aCharacter;
   }
   
   @Override
	public CommandUndoable getClone() {
		CommandDeleteAfter com = new CommandDeleteAfter();
		com.setCarets(start, end);
		com.setCharacter(character);
		com.setText(text);
		return com;
	}
}


