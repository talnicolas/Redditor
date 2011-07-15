//Source file: C:\\Users\\nikkKO\\Desktop\\rEdditooooooor\\Controler\\CommandDelete.java

package rEdditooooooor.Controler.impl;

import rEdditooooooor.Controler.IEditorCommand;
import rEdditooooooor.Model.TextConcrete;


public class CommandDelete extends CommandUndoable implements IEditorCommand 
{
	private int start;
	private int end;

   /**
    * Constructor
    */
   public CommandDelete() 
   {
   }
   
   public void execute() 
   {
	   	TextConcrete text = TextConcrete.getInstance();
		text.delete(this.start, this.end);
   }
   
   public void setCarets(int aStart, int aEnd){
	   this.start = aStart;
	   this.end = aEnd;
   }
}
