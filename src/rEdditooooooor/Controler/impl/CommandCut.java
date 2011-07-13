package rEdditooooooor.Controler.impl;

import rEdditooooooor.Controler.IEditorCommand;
import rEdditooooooor.Model.TextConcrete;

public class CommandCut extends CommandUndoable implements IEditorCommand {

	private TextConcrete text;
	private CommandManager cM;
	
	private int start;
	private int end;
	
        /**
         * Constructor
         * @param int aStart selection start
         * @param int aEnd selection end
         */
	public CommandCut(int aStart, int aEnd) {
		this.text = TextConcrete.getInstance();
		this.cM = CommandManager.getInstance();
		
		this.start = aStart;
		this.end = aEnd;
	}
	
	@Override
	public void execute() {
		this.text.cut(this.start, this.end);
		this.cM.setCommandUndo(this);
	}
	
	public void setCarets(int aStart, int aEnd){
		   this.start = aStart;
		   this.end = aEnd;
	   }

}
