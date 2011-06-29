//Source file: C:\\Users\\nikkKO\\Desktop\\rEdditooooooor\\Model\\TextConcrete.java

package rEdditooooooor.Model;

import java.util.ArrayList;
import java.util.List;

public final class TextConcrete extends Text 
{

	private static final TextConcrete INSTANCE = new TextConcrete();
	
   private List<Character> state;
   private List<Character> bufferOut;
   
   private ClipBoard clipboard;
      
   private TextConcrete() 
   {
	   this.state = new ArrayList<Character>();
	   this.bufferOut = new ArrayList<Character>();
	   this.clipboard = new ClipBoard();
   }
   
   /*****
    * 
    *TODO
    */
   public void insert(int start, int end, char character)
   {
	   if(start != end) {
		   if(start > end){
			   int back = end;
			   end = start;
			   start = back;
		   }
		   int len = end - start;
		   for(int idx = start; idx < start + len; idx++){
			   this.state.remove(start);
		   }	
		   this.state.add(start, character);
	   } else if((this.state.size() == 0) || (start == this.state.size())){
		   this.state.add(character);
	   } else {
		   this.state.add(start, character);
	   }
	   
	   this.notifyObservers();
   }
   
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
   
   public void paste(int start, int end)
   {
	   String toAdd = this.clipboard.getSelection();
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
	   int idxString = 0;
	   for(int idx = start; idx < start + toAdd.length(); idx++){
		   this.state.add(start + idxString, toAdd.charAt(idxString));
		   idxString++;
	   }	   
	   this.notifyObservers();
   }
   
   public void delete(int start, int end)
   {
	   if(this.state.size() > 0){
		   if(start == end){
			   char tmp = this.state.remove(start - 1);
			   this.bufferOut.add(tmp);
		   } else {
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
		   
	   }
	   this.notifyObservers();
   }
   
   public void resetEverything(){
	   this.state.clear();
	   this.bufferOut.clear();
	   this.clipboard.save("");
	   
	   this.notifyObservers();
   }
   
   public String getState() 
   {
	   StringBuilder temp = new StringBuilder();
	   
	   for(int idx = 0; idx < this.state.size(); idx++){
		   temp.append(this.state.get(idx));
	   }	   
	   return temp.toString();
   }
   
   public void setState(String aState) 
   {    
	   this.state.clear();
	   for(int idx = 0; idx < aState.length(); idx++){
		   this.state.add(aState.charAt(idx));
	   }
	   this.notifyObservers();
   }
   
   public void createMemento() 
   {
	   //TODO: Version 3
   }
   
   public void getMemento() 
   {
	   //TODO: Version 3
   }
   
   public static synchronized TextConcrete getInstance(){
	   return INSTANCE;
   }
}
