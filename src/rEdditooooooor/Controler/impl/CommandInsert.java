//Source file: C:\\Users\\nikkKO\\Desktop\\rEdditooooooor\\Controler\\CommandInsert.java

package rEdditooooooor.Controler.impl;

import rEdditooooooor.Controler.IEditorCommand;


public class CommandInsert extends CommandUndoable implements IEditorCommand
{
   private char character;
   private int start;
   private int end;
   
   /**
    * Constructor
    * @param int aStart selection start
    * @param int aEnd selection end
    * @param char aCharacter the character to insert
    */
   public CommandInsert(int aStart, int aEnd, char aCharacter) 
   {
	   this.character = aCharacter;
	   this.start = aStart;
	   this.end = aEnd;
   }
   
   public void execute()
   {
		this.text.insert(start, end, this.character);
		this.cM.setCommandUndo(this);
   }

	
}
