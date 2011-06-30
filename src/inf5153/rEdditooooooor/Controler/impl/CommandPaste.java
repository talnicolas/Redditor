//Source file: C:\\Users\\nikkKO\\Desktop\\rEdditooooooor\\Controler\\CommandPaste.java

package rEdditooooooor.Controler.impl;

import rEdditooooooor.Controler.IEditorCommand;


public class CommandPaste extends CommandUndoable implements IEditorCommand 
{
	private int start;
	private int end;
   /**
   @param Text text
    */
   public CommandPaste(int aStart, int aEnd) 
   {
	   this.start = aStart;
	   this.end = aEnd;
   }
   
   public void execute() 
   {
	   this.text.paste(start, end); 
	   this.cM.setCommandUndo(this);
   }
}
