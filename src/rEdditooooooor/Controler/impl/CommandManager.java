package rEdditooooooor.Controler.impl;

import java.util.ArrayList;
import java.util.List;

import rEdditooooooor.Model.TextConcrete;

/**
 * Class created to manage the commands for undo/redo purpose
 */
public final class CommandManager {

	private static final CommandManager INSTANCECM = new CommandManager();
	private List<CommandUndoable> commandsUndo;
	private List<CommandUndoable> commandsRedo;
	private List<CommandUndoable> recordings;
	private boolean recordMode;
	
	private CommandCopy commandCopy;
	private CommandCut commandCut;
	private CommandPaste commandPaste;
	private CommandDelete commandDelete;
	private CommandDeleteAfter commandDeleteAfter;
	private CommandInsert commandInsert;
	private CommandNew commandNew;
	private CommandPlay commandPlay;
	
	/**
	 * Default constructor
	 */
	private CommandManager() {
		commandsUndo = new ArrayList<CommandUndoable>();
		commandsRedo = new ArrayList<CommandUndoable>();
		recordings = new ArrayList<CommandUndoable>();
		recordMode = false;
		
		commandCopy = new CommandCopy();
		commandCut = new CommandCut();
		commandPaste = new CommandPaste();
		commandDelete = new CommandDelete();
		commandDeleteAfter = new CommandDeleteAfter();
		commandInsert = new CommandInsert();
		commandNew = new CommandNew();
		commandPlay = new CommandPlay();
	}
		
	
	public void executeCommandNew(){
		commandNew.execute();	
	}
	
	public void executeCommandCopy(int start, int end) {
		commandCopy.setCarets(start, end);
		commandCopy.execute();		
	}
	
	public void executeCommandCut(int start, int end) {	
		addMementoUndo();	
		commandCut.setCarets(start, end);
		commandCut.execute();	
	}
	
	public void executeCommandPaste(int start, int end) {	
		addMementoUndo();	
		commandPaste.setCarets(start, end);
		commandPaste.execute();	
	}
	
	public void executeCommandDelete(int start, int end) {	
		addMementoUndo();	
		commandDelete.setCarets(start, end);
		commandDelete.execute();	
	}
	
	public void executeCommandDeleteAfter(int start, int end) {	
		addMementoUndo();	
		commandDeleteAfter.setCarets(start, end);
		commandDeleteAfter.execute();		
	}
	
	public void executeCommandInsert(int start, int end, char character) {	
		addMementoUndo();	
		commandInsert.setCarets(start, end);
		commandInsert.setChar(character);
		commandInsert.execute();	
	}
	
	public void executeCommandStart() {
		TextConcrete text = TextConcrete.getInstance();
		if(recordings.size() > 0){
			recordings.clear();
		}
		recordings.add(text.createMemento());
		recordMode = true;
	}
	
	public void executeCommandStop() {		
		recordMode = false;
	}
	
	public void executeCommandPlay() {
		TextConcrete text = TextConcrete.getInstance();
		recordings.add(text.createMemento());
		commandPlay.setRecord(recordings);
		commandPlay.execute();
	}
	
	public void executeCommandReset() {
		recordings.clear();
	}

	public void addMementoUndo() 
	{
		TextConcrete text = TextConcrete.getInstance();
		this.commandsUndo.add(0, text.createMemento());
		if(recordMode){
			this.recordings.add(text.createMemento());
		}
	}
	
	public void addMementoRedo() 
	{
		TextConcrete text = TextConcrete.getInstance();
		this.commandsRedo.add(0, text.createMemento());
		if(recordMode){
			this.recordings.add(text.createMemento());
		}
	}
 	
	/**
	 * Undo the last undoable command executed.
	 */
	public void undo() {
		if(commandsUndo.size() != 0){
			CommandUndoable tmp = this.commandsUndo.get(0);
			this.commandsUndo.remove(0);
			addMementoRedo();
			TextConcrete text = TextConcrete.getInstance();
			text.restoreMemento(tmp);
		}
	}
	
	/**
	 * Redo the last redoable command executed.
	 */
	public void redo() {
		if(commandsRedo.size() > 0) {
			CommandUndoable tmp = this.commandsRedo.get(0);
			this.commandsRedo.remove(0);
			addMementoUndo();
			TextConcrete text = TextConcrete.getInstance();
			text.restoreMemento(tmp);
		}
	}
	
	public void clearAll(){
		this.commandsRedo.clear();
		this.commandsUndo.clear();
		this.recordings.clear();
	}
	
	/**
	 * @return the unique instance of CommandManager
	 */
	public static synchronized CommandManager getInstance() {
		return INSTANCECM;
	}
}
