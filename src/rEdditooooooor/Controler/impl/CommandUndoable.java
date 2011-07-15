package rEdditooooooor.Controler.impl;

/**
 * Undoable commands are commands that affects the state of the model
 */
public class CommandUndoable
{
	private String state;
	
	/**
	 * Default constructor
	 */
	public CommandUndoable() {
	}
	
	public String getState(){
		return this.state;
	}
	
	public void setState(String aState){
		this.state = aState;
	}
}
