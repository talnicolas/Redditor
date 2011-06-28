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
   
   public void insert(char character)
   {
	   this.state.add(character);
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
	   int len = Math.abs(end - start);
	   int tmp = Math.min(start, end);
	   for(int idx = tmp; idx < tmp + len; idx++){
		   this.state.remove(tmp);		   
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
		   int len = Math.abs(end - start);
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
   
   public void delete()
   {
	   if(this.state.size() > 0){
		   char temp = this.state.remove(this.state.size() - 1);
		   this.bufferOut.add(temp);
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
   
   public void setState() 
   {
    
   }
   
   public void createMemento() 
   {
	   //TODO: Version 3
   }
   
   public void getMemento() 
   {
	   //TODO: Version 3
   }
   
   public static TextConcrete getInstance(){
	   return INSTANCE;
   }
}
