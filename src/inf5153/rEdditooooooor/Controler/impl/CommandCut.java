package rEdditooooooor.Controler.impl;

import rEdditooooooor.Controler.IEditorCommand;

public class CommandCut extends CommandUndoable implements IEditorCommand {

	private int start;
	private int end;
	
        /**
         * Constructor
         * @param int aStart selection start
         * @param int aEnd selection end
         */
	public CommandCut(int aStart, int aEnd) {
		this.start = aStart;
		this.end = aEnd;
	}
	
	@Override
	public void execute() {
		this.text.cut(this.start, this.end);
		cM.setCommandUndo(this);
	}

}
