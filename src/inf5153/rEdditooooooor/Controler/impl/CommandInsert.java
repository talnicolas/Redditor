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
   @param Text text
    */
   public CommandInsert(int aStart, int aEnd, char aCharacter) 
   {
	   this.text = TextConcrete.getInstance();
	   this.character = aCharacter;
	   this.start = aStart;
	   this.end = aEnd;
	   this.cM = CommandManager.getInstance();
   }
   
   public void execute()
   {
		this.text.insert(start, end, this.character);
		cM.setCommandUndo(this);
   }

	
}
