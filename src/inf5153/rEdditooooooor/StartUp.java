//Source file: C:\\Users\\nikkKO\\Desktop\\rEdditooooooor\\StartUp.java

package rEdditooooooor;

import rEdditooooooor.View.impl.EditorUI;
import rEdditooooooor.Controler.impl.CommandManager;
import rEdditooooooor.Controler.impl.CommandNew;


public class StartUp 
{
      
   public StartUp() 
   {
    
   }
   
   public static void main(String[] args) {
	   new EditorUI();
	   CommandManager cM = CommandManager.getInstance();
	   cM.executeCommand(new CommandNew());
   }
   
}
