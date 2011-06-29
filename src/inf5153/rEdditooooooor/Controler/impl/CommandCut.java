package rEdditooooooor.Controler.impl;

import rEdditooooooor.Controler.IEditorCommand;
import rEdditooooooor.Model.TextConcrete;

public class CommandCut extends CommandUndoable implements IEditorCommand{

	private TextConcrete text;
	private CommandManager cM;
	private int start;
	private int end;
	
	public CommandCut(int aStart, int aEnd) {
		this.text = TextConcrete.getInstance();
		this.start = aStart;
		this.end = aEnd;
		this.cM = CommandManager.getInstance();
	}
	
	@Override
	public void execute() {
		this.text.cut(this.start, this.end);
		cM.setCommandUndo(this);
	}

}
