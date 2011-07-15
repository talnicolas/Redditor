//Source file: C:\\Users\\nikkKO\\Desktop\\rEdditooooooor\\Controler\\CommandPaste.java

package rEdditooooooor.Controler.impl;

import rEdditooooooor.Controler.IEditorCommand;
import rEdditooooooor.Model.TextConcrete;


public class CommandPaste extends CommandUndoable implements IEditorCommand 
{
	private int start;
	private int end;

   /**
    * Constructor
    */
   public CommandPaste() 
   {	  
   }
   
   public void execute() 
   {
	   TextConcrete text = TextConcrete.getInstance();
	   text.paste(this.start, this.end);
   }
   
   public void setCarets(int aStart, int aEnd){
	   this.start = aStart;
	   this.end = aEnd;
   }
}
