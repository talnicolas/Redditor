//Source file: C:\\Users\\nikkKO\\Desktop\\rEdditooooooor\\Controler\\IEditorCommand.java

package rEdditooooooor.Controler;


/**
Interface that allows developers to create custom commands, so an action in the 
view will modify the model
 */
public interface IEditorCommand 
{   
   public void execute();
   
   public void undo();
}
