//Source file: C:\\Users\\nikkKO\\Desktop\\rEdditooooooor\\Controler\\CommandInsert.java

package rEdditooooooor.Controler.impl;

import rEdditooooooor.Controler.IEditorCommand;
import rEdditooooooor.Model.TextConcrete;


public class CommandInsert extends CommandUndoable implements IEditorCommand
{
	private TextConcrete text;
	private CommandManager cM;
	
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
	   this.text = TextConcrete.getInstance();
	   this.cM = CommandManager.getInstance();
	   
	   this.character = aCharacter;
	   this.start = aStart;
	   this.end = aEnd;
   }
   
   public void execute()
   {
		text.insert(start, end, this.character);
		cM.getCommandsUndo().add(this);
		//cM.setCommandUndo(this);
   }
   
   public void setCarets(int aStart, int aEnd){
	   this.start = aStart;
	   this.end = aEnd;
   }
   
   public void setChar(char aChar) {
	   this.character = aChar;
   }

	
}
