package rEdditooooooor.Controler.impl;

import rEdditooooooor.Controler.IEditorCommand;
import rEdditooooooor.Model.TextConcrete;

public class CommandCut implements IEditorCommand{

	TextConcrete text;
	int start;
	int end;
	
	public CommandCut(int aStart, int aEnd) {
		this.text = TextConcrete.getInstance();
		this.start = aStart;
		this.end = aEnd;
	}
	@Override
	public void execute() {
		this.text.cut(this.start, this.end);
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		
	}

}
