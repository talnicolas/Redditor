//Source file: C:\\Users\\nikkKO\\Desktop\\rEdditooooooor\\Controler\\CommandPaste.java

package rEdditooooooor.Controler.impl;

import rEdditooooooor.Controler.IEditorCommand;
import rEdditooooooor.Model.TextConcrete;


public class CommandPaste implements IEditorCommand 
{
	
   TextConcrete text;
   int start;
   int end;
   /**
   @param Text text
    */
   public CommandPaste(int aStart, int aEnd) 
   {
	   this.text = TextConcrete.getInstance();
	   this.start = aStart;
	   this.end = aEnd;
   }
   
   public void execute() 
   {
	   this.text.paste(start, end);    
   }

@Override
public void undo() {
	// TODO Auto-generated method stub
	
}
}
