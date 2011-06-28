//Source file: C:\\Users\\nikkKO\\Desktop\\rEdditooooooor\\Model\\MacroRecorder.java

package rEdditooooooor.Model;

import java.util.ArrayList;
import java.util.List;


/**
Saves the states of the Text buffer so they can be replayed later
 */
public class MacroRecorder implements Memento 
{
   private List<String> states;
   
   public MacroRecorder() 
   {	   
	   this.states = new ArrayList<String>();
   }
   
   public String GetState() 
   {
	   return states.get(states.size());
   }
   
   public void SetState(String aState) 
   {
	   this.states.add(aState);
   }
}
