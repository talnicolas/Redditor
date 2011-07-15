//Source file: C:\\Users\\nikkKO\\Desktop\\rEdditooooooor\\Controler\\CommandCopy.java

package rEdditooooooor.Controler.impl;

import rEdditooooooor.Controler.IEditorCommand;
import rEdditooooooor.Model.TextConcrete;


public class CommandCopy implements IEditorCommand 
{
	private int start = 0;
	private int end = 0;

   /**
    * Constructor
    */
   public CommandCopy() 
   {
   }
   
   public void execute() 
   {
	   TextConcrete text = TextConcrete.getInstance();
	   text.copy(this.start, this.end);
   }
   
   public void setCarets(int aStart, int aEnd){
	   this.start = aStart;
	   this.end = aEnd;
   }
}
