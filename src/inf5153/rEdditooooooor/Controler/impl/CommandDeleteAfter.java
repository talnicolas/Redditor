package rEdditooooooor.Controler.impl;

import rEdditooooooor.Controler.IEditorCommand;
import rEdditooooooor.Model.TextConcrete;

public class CommandDeleteAfter extends CommandUndoable implements IEditorCommand {
	private TextConcrete text;
	private CommandManager cM;
	private int start;
	private int end;
   /**
   @param Text text
    */
   public CommandDeleteAfter(int aStart, int aEnd) 
   {
	   this.text = TextConcrete.getInstance();
	   this.start = aStart;
	   this.end = aEnd;
	   this.cM = CommandManager.getInstance();
   }
   
   public void execute() 
   {
	   this.text.deleteAfter(start, end);
	   cM.setCommandUndo(this);
   }
}


