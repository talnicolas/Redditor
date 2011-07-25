//Source file: C:\\Users\\nikkKO\\Desktop\\rEdditooooooor\\Model\\TextConcrete.java

package rEdditooooooor.Model;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class TextConcrete extends Text 
{
   private List<Character> state;
   
   private ClipBoard clipboard;
    
   /**
    * Default Constructor
    */
   public TextConcrete() 
   {
	   this.state = Collections.synchronizedList(new ArrayList<Character>());
	   this.clipboard = new ClipBoard();
   }
    
   /**
    * Insert a character into the state of the model.
    * @param start the index where the insertion starts
    * @param character the character to be inserted
    */  
   public boolean insert(int start, char character)
   {	
	   if(start > this.state.size()){
		   start = this.state.size();
	   }	
	   try{
		   if((this.state.size() == 0) || (start == this.state.size())){
			   this.state.add(character);
		   } else {	
			   this.state.add(start, character);
		   }
	   } catch(IndexOutOfBoundsException exception){
		   return false;
	   }
	   	   
	   this.notifyObservers();	
	   return true;
   }
   
   /**
    * Copy a selection into the clipboard
    * @param start the index of the selection start
    * @param end the index of the selection end
    */
   public boolean copy(int start, int end)
   {
	   StringBuilder temp = new StringBuilder();	   
	   for(int idx = start; idx < end; idx++){
		   try {
			   temp.append(this.state.get(idx));
		   } catch(IndexOutOfBoundsException exception) {
			   return false;
		   }
	   }
	   this.clipboard.save(temp.toString());
	   return true;
   }
   
   /**
    * Save a selection into the clipboard and then delete it.
    * @param start the index of the selection start
    * @param end the index of the selection end
    */
   public boolean cut(int start, int end)
   {
	   if(!copy(start, end)){
		   return false;
	   }
	   if(start != end){		   
		   int len = end - start;
		   for(int idx = start; idx < start + len; idx++){
			   try{
				   this.state.remove(start);
			   } catch(IndexOutOfBoundsException exception) {
				   return false;
			   }
		   }
	   }
	   this.notifyObservers();
	   return true;
   }
   
   /**
    * Insert the previously saved selection (from copy or cut) at the specified index.
    * @param start the index where the insertion starts
    */
   public int paste(int start)
   {
	   String toAdd = this.clipboard.getSelection();	   
	   if(toAdd.length() > 0 && toAdd != null){
		   int idxString = 0;
		   for(int idx = start; idx < start + toAdd.length(); idx++){
			   this.state.add(start + idxString, toAdd.charAt(idxString));
			   idxString++;
		   }
		   this.notifyObservers();
		   return idxString;
	   }
	   return -1;
   }
   
   /**
    * Delete the previous character in the state
    * @param start the index where the deletion starts (will delete start - 1)
    */
   public char delete(int start) {
	   char temp = '\u0000';
	   
	   if(start <= this.state.size()){
		   try {
			   temp = this.state.remove(start - 1);
		   } catch (IndexOutOfBoundsException exception){
			   return temp;
		   }
		   this.notifyObservers();
	   }	   
	   return temp;
   }
   
   /**
    * Delete the clipboard value when the copy is undone
    */
   public void clearClipBoard(){
	   this.clipboard.save("");
   }
   
   /**
    * Cleans the buffer and the clipboard
    */
   public void resetEverything(){
	   this.state.clear();
	   this.clipboard.save("");
	   
	   this.notifyObservers();
   }
   
   /**  
    * @return the state of the model (to update the view)
    */
   public String getState() 
   {
	   StringBuilder temp = new StringBuilder();
	   for(int idx = 0; idx < this.state.size(); idx++){
		   temp.append(this.state.get(idx));
	   }	
	   return temp.toString();
   }

}