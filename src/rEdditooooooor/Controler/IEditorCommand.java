//Source file: C:\\Users\\nikkKO\\Desktop\\rEdditooooooor\\Controler\\IEditorCommand.java

package rEdditooooooor.Controler;

/**
 * Interface that allows developers to create custom commands, so an action in the 
 * view will modify the model
 */
public interface IEditorCommand 
{   
	/**
	 * Execute the specific command on the Model (TextConcrete)
     */
	public boolean execute();
}
