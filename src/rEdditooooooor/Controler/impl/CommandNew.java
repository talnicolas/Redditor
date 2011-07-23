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
   }
   
   public boolean execute() 
   {
	   cM.clearAll();
	   text.resetEverything();
	   return true;
   }
   
   public void setText(TextConcrete aText) {
	   this.text = aText;
   }
   
   public void setCommandManager(CommandManager aCommandManager) {
	   this.cM = aCommandManager;
   }
  
}
