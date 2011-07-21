//Source file: C:\\Users\\nikkKO\\Desktop\\rEdditooooooor\\Controler\\CommandCopy.java

package rEdditooooooor.Controler.impl;

import rEdditooooooor.Controler.IEditorCommand;
import rEdditooooooor.Model.TextConcrete;


public class CommandCopy implements IEditorCommand 
{
	private int start;
	private int end;
	private TextConcrete text;

   /**
    * Constructor
    */
   public CommandCopy() 
   {
   }
   
   public void execute() 
   {
	   this.text.copy(this.start, this.end);
   }
   
   public void setCarets(int aStart, int aEnd){
	   this.start = aStart;
	   this.end = aEnd;
   }
   
   public void setText(TextConcrete aText){
	   this.text = aText;
   }   
}
