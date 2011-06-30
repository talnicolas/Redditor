//Source file: C:\\Users\\nikkKO\\Desktop\\rEdditooooooor\\Controler\\CommandDelete.java

package rEdditooooooor.Controler.impl;

import rEdditooooooor.Controler.IEditorCommand;


public class CommandDelete extends CommandUndoable implements IEditorCommand 
{
	private int start;
	private int end;
   /**
   @param Text text
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
