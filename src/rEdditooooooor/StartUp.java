//Source file: C:\\Users\\nikkKO\\Desktop\\rEdditooooooor\\StartUp.java

package rEdditooooooor;

import rEdditooooooor.Controler.impl.CommandCopy;
import rEdditooooooor.Controler.impl.CommandCut;
import rEdditooooooor.Controler.impl.CommandDelete;
import rEdditooooooor.Controler.impl.CommandInsert;
import rEdditooooooor.Controler.impl.CommandManager;
import rEdditooooooor.Controler.impl.CommandNew;
import rEdditooooooor.Controler.impl.CommandPaste;
import rEdditooooooor.Model.TextConcrete;
import rEdditooooooor.View.impl.EditorUI;

public class StartUp 
{
      
   public StartUp() 
   {    
   }
   
   public static void main(String[] args) {
	   
	   CommandCopy commandCopy = new CommandCopy();
	   CommandCut commandCut = new CommandCut();
	   CommandPaste commandPaste = new CommandPaste();
	   CommandDelete commandDelete = new CommandDelete();
	   CommandInsert commandInsert = new CommandInsert();
	   CommandNew commandNew = new CommandNew();
	  
	   TextConcrete text = new TextConcrete();
	   CommandManager cM = new CommandManager();
	   
	   new EditorUI(text, cM, commandCopy, commandCut, commandPaste, commandDelete, commandInsert, commandNew);
   }
   
}
