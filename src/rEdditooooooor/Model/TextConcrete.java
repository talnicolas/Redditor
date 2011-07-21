//Source file: C:\\Users\\nikkKO\\Desktop\\rEdditooooooor\\Model\\TextConcrete.java

package rEdditooooooor.Model;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import rEdditooooooor.Controler.impl.CommandDelete;
import rEdditooooooor.Controler.impl.CommandInsert;
import rEdditooooooor.Controler.impl.CommandManager;
import rEdditooooooor.Controler.impl.CommandUndoable;

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
    * @param end if different from start, a selection 
    * 			from start to end gonna have to be deleted
    * @param character the character to be inserted
    */  
   public void insert(int start, char character)
   {	
	   synchronized (state) {		   
		   if(start > this.state.size()){
			   start = this.state.size();
			   //end = this.state.size();
		   }
//		   if(start != end) {		
//			   int len = end - start;
//			   for(int idx = start; idx < start + len; idx++){
//				   this.state.remove(start);
//			   }	
//		   }		   
		   if((this.state.size() == 0) || (start == this.state.size())){
			   this.state.add(character);
		   } else {	
			   this.state.add(start, character);
		   }
	   } 	   
	   this.notifyObservers();	
   }
   
   /**
    * Copy a selection into the clipboard
    * @param start the index of the selection start
    * @param end the index of the selection end
    */
   public void copy(int start, int end)
   {
	   StringBuilder temp = new StringBuilder();
	   if(end < start){
		   int back = end;
		   end = start;
		   start = back;
	   }
	   for(int idx = start; idx < end; idx++){
		   temp.append(this.state.get(idx));
	   }
	   this.clipboard.save(temp.toString());
   }
   
   /**
    * Save a selection into the clipboard and then delete it.
    * @param start the index of the selection start
    * @param end the index of the selection end
    */
   public void cut(int start, int end)
   {
	   copy(start, end);
	   if(start != end){
		   if(start > end){
			   int back = end;
			   end = start;
			   start = back;		   
		   }
		   int len = end - start;
		   for(int idx = start; idx < start + len; idx++){
			   this.state.remove(start);
		   }
	   }
	   this.notifyObservers();
   }
   
   /**
    * Insert the previously saved selection (from copy or cut) at the specified index.
    * @param start the index where the insertion starts
    * @param end if different from start, a selection 
    * 			from start to end gonna have to be deleted
    */
   public int paste(int start)
   {
	   String toAdd = this.clipboard.getSelection();	   
	   if(toAdd.length() > 0 && toAdd != null){
//		   if(start != end){
//			   if(start > end){
//				   int back = end;
//				   end = start;
//				   start = back;		   
//			   }
//			   int len = end - start;
//			   for(int idx = start; idx < start + len; idx++){
//				   this.state.remove(start);
//			   }
//		   }
		   int idxString = 0;
		   for(int idx = start; idx < start + toAdd.length(); idx++){
			   this.state.add(start + idxString, toAdd.charAt(idxString));
			   idxString++;
		   }
		   this.notifyObservers();
		   return idxString;
	   }
	   return 0;
   }
   
   /**
    * Delete the previous character in the state
    * @param start the index where the deletion starts (will delete start - 1)
    * @param end if different from start, a selection 
    * 			from start to end gonna have to be deleted
    */
   public char delete(int start)
   {
//	   if(start >= 0){
//		   if(start == end){
//			   this.state.remove(start - 1);
//		   } else {			   
//			   int len = end - start;
//			   for(int idx = start; idx < start + len; idx++){
//				   this.state.remove(start);
//			   }
//		   }		   
//	   }
	   char temp = this.state.remove(start - 1);
	   this.notifyObservers();
	   return temp;
   }
   
   /**
    * Delete the following character in the state
    * @param start the index where the deletion starts (will delete start)
    * @param end if different from start, a selection 
    * 			from start to end gonna have to be deleted
    */
   public char deleteAfter(int start)
   {
//	   if(start == end){
//			   this.state.remove(start);
//	   } else {		   
//		   int len = end - start;
//		   for(int idx = start; idx < start + len; idx++){
//			   this.state.remove(start);
//		   }  
//		}	
	   char temp = this.state.remove(start);	   
	   this.notifyObservers();
	   return temp;
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
   
   /**
    * Set the state of the model
    * @param aState a new state
    */
   public void setState(String aState) 
   {    
	   this.state.clear();
	   for(int idx = 0; idx < aState.length(); idx++){
		   this.state.add(aState.charAt(idx));
	   }
	   this.notifyObservers();
   }
   
//   public CommandUndoable createMemento() 
//   {
//	   CommandUndoable mem = new CommandUndoable();
//	   mem.setState(getState());
//	   return mem;
//   }
//   
//   public void restoreMemento(CommandUndoable com) 
//   {
//	   setState(com.getState());
//   }
//  
}
