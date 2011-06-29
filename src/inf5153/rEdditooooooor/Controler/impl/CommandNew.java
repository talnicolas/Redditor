//Source file: C:\\Users\\nikkKO\\Desktop\\rEdditooooooor\\Controler\\CommandNew.java

package rEdditooooooor.Controler.impl;

import rEdditooooooor.Controler.IEditorCommand;
import rEdditooooooor.Model.TextConcrete;


public class CommandNew extends CommandManager implements IEditorCommand 
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
	   this.commandsRedo.clear();
	   this.commandsUndo.clear();
	   this.text.resetEverything();
   }
}
