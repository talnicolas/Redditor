//Source file: C:\\Users\\nikkKO\\Desktop\\rEdditooooooor\\Controler\\CommandNew.java

package rEdditooooooor.Controler.impl;

import rEdditooooooor.Controler.IEditorCommand;
import rEdditooooooor.Model.TextConcrete;


public class CommandNew implements IEditorCommand 
{
   /**
    * Default constructor
    */
   public CommandNew() 
   {
   }
   
   public void execute() 
   {
	   CommandManager cM = CommandManager.getInstance();
	   cM.clearAll();
	   TextConcrete text = TextConcrete.getInstance();
	   text.resetEverything();
   }
  
}
