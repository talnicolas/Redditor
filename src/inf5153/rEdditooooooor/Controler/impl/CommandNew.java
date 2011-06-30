//Source file: C:\\Users\\nikkKO\\Desktop\\rEdditooooooor\\Controler\\CommandNew.java

package rEdditooooooor.Controler.impl;

import rEdditooooooor.Controler.IEditorCommand;
import rEdditooooooor.Model.TextConcrete;


public class CommandNew extends CommandManager implements IEditorCommand 
{
   TextConcrete text;
   CommandManager cM;
   /**
   @param Text text
    */
   public CommandNew() 
   {
	   this.text = TextConcrete.getInstance();
	   this.cM = CommandManager.getInstance();
   }
   
   public void execute() 
   {
	   this.cM.commandsRedo.clear();
	   this.cM.commandsUndo.clear();
	   this.text.resetEverything();
   }
}
