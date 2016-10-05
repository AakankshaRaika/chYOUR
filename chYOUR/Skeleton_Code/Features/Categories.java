package Features;
/*
 * Skeleton code author : @aakanksh @yosephh 
 * Task owners sprint 2 : Aakanksha and Barry 
 */
public class Categories {
	/*
	 * we need a drop down menu for the GUI part
	 */
	
	private string location; // 43.001154, -78.786225 (Student Union)
	private string defaultmapURL;
	
	
	public Categories() {
	 	/*
	 	 * this is just the constructor the class we will see in the future where and how to use it. 
	 	 */
		location = "43.001154, -78.786225"; // For testing purposes (Student Union UB)
		defaultmapURL = "http://maps.google.com/maps?z=12&t=m&q=loc:";
	}
	
	public void groceries(){ // Tops and Wegmans
		/*
		 * This category will be coded as GREEN 
		 * 
		 */
		string grocerylocation;
		string currentlocation;
		
		currentlocation = defaultmapURL + location
		grocerylocation = defaultmapURL + "Tops"
		
		
	}
	
	public void household(){ // Target and Walmart
		/*
		 * this category will fulfill things like cleaning supplies , 
		 * housing hold things like maybe pillow or shampoo anything like that that is not 
		 * grocery
		 */
	}

	public void hardware(){ // Home Depot and Lowes
		/*
		 * this category will fulfill things like any nails , hammers ,
		 *  Building stuff , paints , boxes etc. Anything that a hardware store 
		 * like lowes will carry
		 */
	}
	
	public void garden (){ // Home Depot and Lowes
		/*
		 * this category will take care of anything you need to make/maintain a garden 
		 */
	}
	
	public void general_pharmacy(){ // CVS, Walgreens, Rite Aid
		/*
		 * something like for stores like CVS. Something we need to pick up over
		 *  the counter meds have it on the list but we forget. 
		 */
	}
	
	public void meetings_appointments(){ // Manually Add Location
		/*
		 * this will have different notification settings than others. Location will be required. 
		 */
	}
	public void other_cat(){ // Misc
		/*
		 * default category which will require you to put in a location in order to add the task. 
		 */
	}
}
