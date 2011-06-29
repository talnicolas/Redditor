//Source file: C:\\Users\\nikkKO\\Desktop\\rEdditooooooor\\Controler\\CommandInsert.java

package rEdditooooooor.Controler.impl;

import rEdditooooooor.Controler.IEditorCommand;
import rEdditooooooor.Model.TextConcrete;


public class CommandInsert implements IEditorCommand
{
	private CommandManager cM;
   private TextConcrete text;
   private char character;
   private int start;
   private int end;
   
   private String state;
   /**
   @param Text text
    */
   public CommandInsert(int aStart, int aEnd, char aCharacter) 
   {
	   this.text = TextConcrete.getInstance();
	   this.state = this.text.getState();
	   this.character = aCharacter;
	   this.start = aStart;
	   this.end = aEnd;
	   this.cM = CommandManager.getInstance();
   }
   
   public void execute() 
   {
		this.text.insert(start, end, this.character);
		cM.setCommand(this);
   }

	@Override
	public void undo() {
		this.text.setState(this.state);
	}
}
