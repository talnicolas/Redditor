//Source file: C:\\Users\\nikkKO\\Desktop\\rEdditooooooor\\Controler\\CommandDelete.java

package rEdditooooooor.Controler.impl;

import rEdditooooooor.Controler.IEditorCommand;


public class CommandDelete extends CommandUndoable implements IEditorCommand 
{
   private int start;
   private int end;

   /**
    * Constructor
    * @param int aStart selection start
    * @param int aEnd selection end
    */
   public CommandDelete(int aStart, int aEnd) 
   {
	   this.start = aStart;
	   this.end = aEnd;
   }
   
   public void execute() 
   {
	   this.text.delete(start, end);
	   this.cM.setCommandUndo(this);
   }
}
