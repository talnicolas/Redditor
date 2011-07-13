//Source file: C:\\Users\\nikkKO\\Desktop\\rEdditooooooor\\Controler\\CommandPaste.java

package rEdditooooooor.Controler.impl;

import rEdditooooooor.Controler.IEditorCommand;
import rEdditooooooor.Model.TextConcrete;


public class CommandPaste extends CommandUndoable implements IEditorCommand 
{
	private TextConcrete text;
	private CommandManager cM;
	
	private int start;
	private int end;

   /**
    * Constructor
    * @param int aStart selection start
    * @param int aEnd selection end
    */
   public CommandPaste(int aStart, int aEnd) 
   {
	   this.text = TextConcrete.getInstance();
	   this.cM = CommandManager.getInstance();	

	   this.start = aStart;
	   this.end = aEnd;
   }
   
   public void execute() 
   {
	   this.text.paste(start, end); 
	   this.cM.setCommandUndo(this);
   }
   
   public void setCarets(int aStart, int aEnd){
	   this.start = aStart;
	   this.end = aEnd;
   }
}
