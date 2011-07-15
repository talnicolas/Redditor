package rEdditooooooor.Controler.impl;

import rEdditooooooor.Controler.IEditorCommand;
import rEdditooooooor.Model.TextConcrete;

public class CommandCut extends CommandUndoable implements IEditorCommand {

	private int start;
	private int end;
	
        /**
         * Constructor
         */
	public CommandCut() {
	}
	
	@Override
	public void execute() {
		TextConcrete text = TextConcrete.getInstance();
		text.cut(this.start, this.end);
	}
	
	public void setCarets(int aStart, int aEnd){
		   this.start = aStart;
		   this.end = aEnd;
	   }

}
