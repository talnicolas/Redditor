//Source file: C:\\Users\\nikkKO\\Desktop\\rEdditooooooor\\Model\\CareTaker.java

package rEdditooooooor.Model;

import java.util.ArrayList;
import java.util.List;


public class CareTaker 
{
   private List<Memento> savedStates;
   
   public CareTaker() 
   {
	   savedStates = new ArrayList<Memento>();
   }
   
   public void addMemento() 
   {
    
   }
   
   public Memento getMemento() 
   {
	   Memento mem = this.savedStates.get(this.savedStates.size());
	   this.savedStates.remove(this.savedStates.indexOf(mem));
	   return mem;
	   
   }
}
