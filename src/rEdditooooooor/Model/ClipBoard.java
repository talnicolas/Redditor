//Source file: C:\\Users\\nikkKO\\Desktop\\rEdditooooooor\\Model\\ClipBoard.java

package rEdditooooooor.Model;


/**
 * Save a selected text while the cut and copy operations
 */
public class ClipBoard 
{
   private String selection;

   /**
    * Default Constructor
    */
   public ClipBoard() 
   {    
	   selection = null;
   }
   
   /**
    * Save a selection previously selected by the user
    * 
    * @param aSelection the selection to be saved
    */
   public void save(String aSelection) 
   {
	   this.selection = aSelection;
   }
   
   /**  
    * @return the selection that has been previously saved
    */
   public String getSelection() 
   {
	   if(this.selection != null){
		   return this.selection;
	   }
	   return "";
   }
}
