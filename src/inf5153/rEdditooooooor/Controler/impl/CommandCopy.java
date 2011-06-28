//Source file: C:\\Users\\nikkKO\\Desktop\\rEdditooooooor\\Controler\\CommandCopy.java

package rEdditooooooor.Controler.impl;

import rEdditooooooor.Controler.IEditorCommand;
import rEdditooooooor.Model.TextConcrete;


public class CommandCopy implements IEditorCommand 
{
	TextConcrete text;
	int start = 0;
	int end = 0;
   /**
   @param Text text
    */
   public CommandCopy(int aStart, int aEnd) 
   {
	   text = TextConcrete.getInstance();
	   this.start = aStart;
	   this.end = aEnd;
   }
   
   public void execute() 
   {
	   this.text.copy(this.start, this.end);
   }

@Override
public void undo() {
	// TODO Auto-generated method stub
	
}
}
