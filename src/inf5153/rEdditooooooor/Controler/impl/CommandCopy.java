//Source file: C:\\Users\\nikkKO\\Desktop\\rEdditooooooor\\Controler\\CommandCopy.java

package rEdditooooooor.Controler.impl;

import rEdditooooooor.Controler.IEditorCommand;
import rEdditooooooor.Model.TextConcrete;


public class CommandCopy implements IEditorCommand 
{
	private TextConcrete text;
	int start = 0;
	int end = 0;

   /**
    * Constructor
    * @param int aStart selection start
    * @param int aEnd selection end
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
}
