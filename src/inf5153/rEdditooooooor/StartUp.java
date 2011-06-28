//Source file: C:\\Users\\nikkKO\\Desktop\\rEdditooooooor\\StartUp.java

package rEdditooooooor;

import rEdditooooooor.View.impl.EditorUI;


public class StartUp 
{
   public EditorUI theEditorUI;
   
   public StartUp() 
   {
    
   }
   
   public static void main(String[] args) {
	   newEditor();
   }
   
   private static void newEditor() 
   {
	   new EditorUI();
   }
}
