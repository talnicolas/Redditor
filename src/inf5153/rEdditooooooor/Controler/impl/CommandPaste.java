//Source file: C:\\Users\\nikkKO\\Desktop\\rEdditooooooor\\Controler\\CommandPaste.java

package rEdditooooooor.Controler.impl;

import rEdditooooooor.Controler.IEditorCommand;
import rEdditooooooor.Model.TextConcrete;


public class CommandPaste implements IEditorCommand 
{
	
	private TextConcrete text;
	private String state;
	private CommandManager cM;
	private int start;
	private int end;
   /**
   @param Text text
    */
   public CommandPaste(int aStart, int aEnd) 
   {
	   this.text = TextConcrete.getInstance();
	   this.state = this.text.getState();
	   this.start = aStart;
	   this.end = aEnd;
	   this.cM = CommandManager.getInstance();
   }
   
   public void execute() 
   {
	   this.text.paste(start, end); 
	   cM.setCommand(this);
   }

	@Override
	public void undo() {
		this.text.setState(state);
	}
}
