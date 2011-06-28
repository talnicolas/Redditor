//Source file: C:\\Users\\nikkKO\\Desktop\\rEdditooooooor\\Controler\\CommandInsert.java

package rEdditooooooor.Controler.impl;

import rEdditooooooor.Controler.IEditorCommand;
import rEdditooooooor.Model.TextConcrete;


public class CommandInsert implements IEditorCommand 
{
   private TextConcrete text;
   private char character;
   /**
   @param Text text
    */
   public CommandInsert(char aCharacter) 
   {
	   this.text = TextConcrete.getInstance();
	   this.character = aCharacter;
   }
   
   public void execute() 
   {
	   this.text.insert(this.character);
   }

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		
	}
}
