//Source file: C:\\Users\\nikkKO\\Desktop\\rEdditooooooor\\Controler\\CommandNew.java

package rEdditooooooor.Controler.impl;

import rEdditooooooor.Controler.IEditorCommand;
import rEdditooooooor.Model.TextConcrete;


public class CommandNew implements IEditorCommand 
{
	private TextConcrete text;
	private CommandManager cM;
	
   /**
    * Default constructor
    */
   public CommandNew() 
   {
	   this.text = TextConcrete.getInstance();
	   this.cM = CommandManager.getInstance();
   }
   
   public void execute() 
   {
	   this.cM.getCommandsUndo().clear();
	   this.cM.getCommandsRedo().clear();
	   text.resetEverything();
   }
  
}
