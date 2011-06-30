package rEdditooooooor.Controler.impl;

import rEdditooooooor.Controler.IEditorCommand;
import rEdditooooooor.Model.TextConcrete;

public class CommandDeleteAfter extends CommandUndoable implements IEditorCommand {
	
	private int start;
	private int end;

   /**
    * Constructor
    * @param int aStart selection start
    * @param int aEnd selection end
    */
   public CommandDeleteAfter(int aStart, int aEnd) 
   {
	   this.start = aStart;
	   this.end = aEnd;
   }
   
   public void execute() 
   {
	   this.text.deleteAfter(start, end);
	   this.cM.setCommandUndo(this);
   }
}


