//Source file: C:\\Users\\nikkKO\\Desktop\\rEdditooooooor\\Controler\\CommandNew.java

package rEdditooooooor.Controler.impl;

import rEdditooooooor.Controler.IEditorCommand;
import rEdditooooooor.Model.TextConcrete;


public class CommandNew implements IEditorCommand 
{
   TextConcrete text;
   /**
   @param Text text
    */
   public CommandNew() 
   {
	   this.text = TextConcrete.getInstance();
   }
   
   public void execute() 
   {
	   this.text.resetEverything();
   }

@Override
public void undo() {
	// TODO Auto-generated method stub
	
}
}
