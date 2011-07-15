//Source file: C:\\Users\\nikkKO\\Desktop\\rEdditooooooor\\StartUp.java

package rEdditooooooor;

import rEdditooooooor.Controler.impl.CommandManager;
import rEdditooooooor.View.impl.EditorUI;

public class StartUp 
{
      
   public StartUp() 
   {    
   }
   
   public static void main(String[] args) {
	   new EditorUI();
	   CommandManager cM = CommandManager.getInstance();
	   cM.executeCommandNew();
   }
   
}
