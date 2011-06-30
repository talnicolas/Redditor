//Source file: C:\\Users\\nikkKO\\Desktop\\rEdditooooooor\\Model\\Text.java

package rEdditooooooor.Model;

import java.util.ArrayList;
import java.util.List;

import rEdditooooooor.View.IEditorView;

/**
 * Subject to be observed by the observers (views).
 */
public class Text
{
   private List<IEditorView> observers;
   
   /**
    * Default constructor
    */
   public Text() 
   {
	   this.observers = new ArrayList<IEditorView>();
   }
   
   /**
    * For an observer to be updated, it needs to be attached to this part of the Model.
    * 
    * @param view a view that wants to observe the model
    */
   public void attach(IEditorView view) 
   {
	   this.observers.add(view);
   }
   
   /**
    * Remove a view that won't be updated with the Model state anymore
    * 
    * @param view the view to remove
    */
   @return java.lang.Void
    */
   public void detach(IEditorView view) 
   {
	   if(this.observers.contains(view)){
		   this.observers.remove(this.observers.indexOf(view));
	   }
   }
   
   /**
    * Notify all the views that are observing the model that they need to be 
    * updated because the model state changed.
    */
   public void notifyObservers() 
   {
	   for(int idx = 0; idx < observers.size(); idx++){
		   observers.get(idx).update();
	   }
   }
}
