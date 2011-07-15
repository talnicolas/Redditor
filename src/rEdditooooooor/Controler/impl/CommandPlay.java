package rEdditooooooor.Controler.impl;

import java.util.List;

import rEdditooooooor.Controler.IEditorCommand;
import rEdditooooooor.Model.TextConcrete;

public class CommandPlay implements IEditorCommand{

	private List<CommandUndoable> record;
	
	public CommandPlay() {
	}
	
	@Override
	public void execute() {
		TextConcrete text = TextConcrete.getInstance();
		text.playRecordings(record);
	}
	
	public void setRecord(List<CommandUndoable> records) {
		this.record = records;
	}
}
