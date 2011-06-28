//Source file: C:\\Users\\nikkKO\\Desktop\\rEdditooooooor\\Model\\Text.java

package rEdditooooooor.Model;

import java.util.ArrayList;
import java.util.List;

import rEdditooooooor.View.IEditorView;

/**
Subject to be observed by the observers (views).
 */
public class Text
{
   private List<IEditorView> observers;
   
   public Text() 
   {
	   this.observers = new ArrayList<IEditorView>();
   }
   
   /**
    */
   public void attach(IEditorView view) 
   {
	   this.observers.add(view);
   }
   
   /**
   @return java.lang.Void
    */
   public void detach(IEditorView view) 
   {
	   if(this.observers.contains(view)){
		   this.observers.remove(this.observers.indexOf(view));
	   }
   }
   
   /**
   @return java.lang.Void
    */
   public void notifyObservers() 
   {
	   for(int idx = 0; idx < observers.size(); idx++){
		   observers.get(idx).update();
	   }
   }
}
