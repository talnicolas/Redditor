package rEdditooooooor.Controler.impl;

import rEdditooooooor.Controler.IEditorCommand;
import rEdditooooooor.Model.TextConcrete;

public class CommandDeleteAfter extends CommandUndoable implements IEditorCommand 
{	
	private int start;
	private int end;

   /**
    * Constructor
    */
   public CommandDeleteAfter() 
   {
   }
   
   public void execute() 
   {
	   TextConcrete text = TextConcrete.getInstance();
	   text.deleteAfter(this.start, this.end);
   }
   
   public void setCarets(int aStart, int aEnd){
	   this.start = aStart;
	   this.end = aEnd;
   }
}


