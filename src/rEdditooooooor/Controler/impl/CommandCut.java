package rEdditooooooor.Controler.impl;

import rEdditooooooor.Controler.IEditorCommand;
import rEdditooooooor.Model.TextConcrete;

public class CommandCut extends CommandUndoable implements IEditorCommand {

	private int start;
	private int end;
	private TextConcrete text;
	
    /**
     * Constructor
     */
	public CommandCut() {
	}
	
	@Override
	public void execute() {
		text.cut(this.start, this.end);
	}
	
	@Override
	public void executeFrom(int aStart, int aEnd) {
		text.cut(this.start + aStart, this.end + aEnd);
	}
	
	@Override
	public void unexecute() {
		text.paste(start);
	}
	
	@Override
	public int getStart() {
		return this.start;
	}
	
	public void setCarets(int aStart, int aEnd){
		   this.start = aStart;
		   this.end = aEnd;
	}
	   
	public void setText(TextConcrete aText){
		this.text = aText;
	}  
	
	@Override
	public CommandUndoable getClone() {
		CommandCut com = new CommandCut();
		com.setCarets(start, end);
		com.setText(text);
		return com;
	}
}
