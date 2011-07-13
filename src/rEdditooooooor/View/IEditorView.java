//Source file: C:\\Users\\nikkKO\\Desktop\\rEdditooooooor\\IEditorView.java

package rEdditooooooor.View;

import rEdditooooooor.Controler.impl.CommandManager;
import rEdditooooooor.Model.TextConcrete;


/**
 * Interface that allows developers to create their own custom UI for this 
 * application
 */
public interface IEditorView 
{   
	TextConcrete subject = TextConcrete.getInstance();
	CommandManager commandManager = CommandManager.getInstance();
	
   /**
    * Get the state of the Model (TextConcrete) and update the view for the user.
    */
   public void update();
}
