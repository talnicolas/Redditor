//Source file: C:\\Users\\nikkKO\\Desktop\\rEdditooooooor\\Controler\\CommandInsert.java

package rEdditooooooor.Controler.impl;

import rEdditooooooor.Controler.IEditorCommand;
import rEdditooooooor.Model.TextConcrete;


public class CommandInsert extends CommandUndoable implements IEditorCommand
{
	private char character;
	private int start;
	private int end;
   
   /**
    * Constructor
    */
   public CommandInsert() 
   {
   }
   
   public void execute()
   {
	   TextConcrete text = TextConcrete.getInstance();
	   text.insert(this.start, this.end, this.character);
   }
   
   public void setCarets(int aStart, int aEnd){
	   this.start = aStart;
	   this.end = aEnd;
   }
   
   public void setChar(char aChar) {
	   this.character = aChar;
   }	
}
