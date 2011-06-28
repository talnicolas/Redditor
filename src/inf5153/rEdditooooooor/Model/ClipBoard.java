//Source file: C:\\Users\\nikkKO\\Desktop\\rEdditooooooor\\Model\\ClipBoard.java

package rEdditooooooor.Model;


/**
Save a selected text while the cut and copy operations
 */
public class ClipBoard 
{
   private String selection = null;
   
   public ClipBoard() 
   {    
   }
   
   public void save(String aSelection) 
   {
	   this.selection = aSelection;
   }
   
   public String getSelection() 
   {
	   if(this.selection != null){
		   return this.selection;
	   }
	   return "";
   }
}
