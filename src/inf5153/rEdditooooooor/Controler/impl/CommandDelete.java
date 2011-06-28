//Source file: C:\\Users\\nikkKO\\Desktop\\rEdditooooooor\\Controler\\CommandDelete.java

package rEdditooooooor.Controler.impl;

import rEdditooooooor.Controler.IEditorCommand;
import rEdditooooooor.Model.Text;
import rEdditooooooor.Model.TextConcrete;


public class CommandDelete implements IEditorCommand 
{
	TextConcrete text;
   /**
   @param Text text
    */
   public CommandDelete() 
   {
	   this.text = TextConcrete.getInstance();
   }
   
   public void execute() 
   {
	   this.text.delete();
   }

@Override
public void undo() {
	// TODO Auto-generated method stub
	
}
}
