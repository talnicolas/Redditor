//Source file: C:\\Users\\nikkKO\\Desktop\\rEdditooooooor\\Controler\\CommandDelete.java

package rEdditooooooor.Controler.impl;

import rEdditooooooor.Controler.IEditorCommand;
import rEdditooooooor.Model.TextConcrete;


public class CommandDelete implements IEditorCommand 
{
	private TextConcrete text;
	private CommandManager cM;
	private String state;
	private int start;
	private int end;
   /**
   @param Text text
    */
   public CommandDelete(int aStart, int aEnd) 
   {
	   this.text = TextConcrete.getInstance();
	   this.state = this.text.getState();
	   this.start = aStart;
	   this.end = aEnd;
	   this.cM = CommandManager.getInstance();
   }
   
   public void execute() 
   {
	   this.text.delete(start, end);
	   cM.setCommand(this);
   }

	@Override
	public void undo() {
		this.text.setState(state);
	}
}
