//Source file: C:\\Users\\nikkKO\\Desktop\\rEdditooooooor\\Controler\\CommandNew.java

package rEdditooooooor.Controler.impl;

import rEdditooooooor.Controler.IEditorCommand;
import rEdditooooooor.Model.TextConcrete;


public class CommandNew implements IEditorCommand 
{
	private TextConcrete text;
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
	   text.resetEverything();
   }
   
   public void setText(TextConcrete aText) {
	   this.text = aText;
   }
  
}
