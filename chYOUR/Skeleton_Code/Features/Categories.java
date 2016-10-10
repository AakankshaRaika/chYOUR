package Features;
/*
 * Skeleton code author : @aakanksh @yosephh 
 * Task owners sprint 2 : Aakanksha and Barry 
 */
public class Categories {
	/*
	 * we need a drop down menu for the GUI part
	 */
	
	private string userLocation; // 43.001154, -78.786225 (Student Union)
	private string defaultmapURL;

	private string defaultGrocery1 = "Wegmens";
	private string defaultGrocery2 = "Tops";

	private string defaultHousehold1 = "Target";
	private string defaultHousehold2 = "Walmart";

	private string defaultHardware1 = "Home Depot";
	private string defaultHardware2 = "Lowes";

	private string defaultGenPharm1 = "CVS";
	private string defaultGenPharm2 = "Walgreens";
	
	public enum Categories{
		GROCERIES, HOUSEHOLD, HARDWARE, GENPHARM, MEETINGS_APPOINTMENTS, OTHER_CAT
	}
	
	public Categories() {
	 	/*
	 	 * this is just the constructor the class we will see in the future where and how to use it. 
	 	 */
		userLocation = "43.001154, -78.786225"; // For testing purposes (Student Union UB)
		defaultmapURL = "http://maps.google.com/maps?z=12&t=m&q=loc:";
	}
	
	public string groceries(){ // Tops and Wegmans
		/*
		 * This category will be coded as GREEN 
		 * 
		 */
		string groceryPreference; // We will use the default locations if a preference is not chosen
		// We will need to work on this this weekend. Adding a textbox/button for preference (prefered vendor) selection
		string userLocation; // Pulling coordinates from API // Weekend
		
		userLocation = defaultmapURL + userLocation;
		groceryPreference = defaultmapURL + "UserInput"; // Add a real user input
		
		int dist_defaultGrocery1 = 0; // Import distances from user to store from API
		int dist_defaultGrocery2 = 0; // Change, cannot keep as 0

		if (groceryPreference == Null) {
			if (dist_defaultGrocery1 <= dist_defaultGrocery2){	// If defaultGrocery1 (Wegmans) is closer than defaultGrocery2 (Tops), return Wegmans.
				return defaultGrocery1; // We used <= because if, in the rare case that the distances are equal, we will go with defaultGrocery1 (Wegmans)
			}
			else {												// Else return Tops
				return defaultGrocery2;
			}
		}

		else {
			return groceryPreference;							// Else else return preferred vendor, if supplied by user
		}
		
	}
	
	public string household(){ // Target and Walmart
		/*
		 * this category will fulfill things like cleaning supplies , 
		 * housing hold things like maybe pillow or shampoo anything like that that is not 
		 * grocery
		 */

		string householdPreference; // We will use the default locations if a preference is not chosen
		// We will need to work on this this weekend. Adding a textbox/button for preference (prefered vendor) selection
		string userLocation; // Pulling coordinates from API // Weekend
		
		userLocation = defaultmapURL + userLocation;
		householdPreference = defaultmapURL + "UserInput"; // Add a real user input
		
		int dist_defaultHousehold1 = 0; // Import distances from user to store from API
		int dist_defaultHousehold2 = 0; // Change, cannot keep as 0

		if (householdPreference == Null) {
			if (dist_defaultHousehold1 <= dist_defaultHousehold2){	// If defaultHousehold1 (Walmart) is closer than defaultHousehold2 (Target), return Walmart.
				return defaultHousehold1;
			}
			else {												// Else return Target
				return defaultHousehold2;
			}
		}

		else {
			return householdPreference;							// Else else return preferred vendor, if supplied by user
		}

	}

	public string hardware(){ // Home Depot and Lowes
		/*
		 * this category will fulfill things like any nails , hammers ,
		 *  Building stuff , paints , boxes etc. Anything that a hardware store 
		 * like lowes will carry
		 */

		string hardwarePreference; // We will use the default locations if a preference is not chosen
		// We will need to work on this this weekend. Adding a textbox/button for preference (prefered vendor) selection
		string userLocation; // Pulling coordinates from API // Weekend
		
		userLocation = defaultmapURL + userLocation;
		hardwarePreference = defaultmapURL + "UserInput"; // Add a real user input
		
		int dist_defaultHardware1 = 0; // Import distances from user to store from API
		int dist_defaultHardware2 = 0; // Change, cannot keep as 0

		if (hardwarePreference == Null) {
			if (dist_defaultHardware1 <= dist_defaultHardware2){	// If defaultHardware1 (Home Depot) is closer than defaultHardware2 (Lowes), return Home Depot.
				return defaultHardware1;
			}
			else {												// Else return Lowes
				return defaultHardware2;
			}
		}

		else {
			return hardwarePreference;							// Else else return preferred vendor, if supplied by user
		}
	}
	
	public string general_pharmacy(){ // CVS and Walgreens
		/*
		 * something like for stores like CVS. Something we need to pick up over
		 *  the counter meds have it on the list but we forget. 
		 */

		string general_pharmacyPreference; // We will use the default locations if a preference is not chosen
		// We will need to work on this this weekend. Adding a textbox/button for preference (prefered vendor) selection
		string userLocation; // Pulling coordinates from API // Weekend
		
		userLocation = defaultmapURL + userLocation;
		general_pharmacyPreference = defaultmapURL + "UserInput"; // Add a real user input
		
		int dist_defaultGeneral_pharmacy1 = 0; // Import distances from user to store from API
		int dist_defaultGeneral_pharmacy2 = 0; // Change, cannot keep as 0

		if (general_pharmacyPreference == Null) {
			if (dist_defaultGeneral_pharmacy1 <= dist_defaultGeneral_pharmacy2){	// If defaultGeneral_pharmacy1 (Home Depot) is closer than defaultGeneral_pharmacy2 (Lowes), return Home Depot.
				return defaultGeneral_pharmacy1;
			}
			else {												// Else return Lowes
				return defaultGeneral_pharmacy2;
			}
		}

		else {
			return general_pharmacyPreference;							// Else else return preferred vendor, if supplied by user
		}
	}
	
	public string meetings_appointments(){ // Manually Add Location
		/*
		 * this will have different notification settings than others. Location will be required. 
		 */

		string meetingsPreference; // We will use the default locations if a preference is not chosen
		// We will need to work on this this weekend. Adding a textbox/button for preference (prefered vendor) selection
		string userLocation; // Pulling coordinates from API // Weekend
		
		userLocation = defaultmapURL + userLocation;
		meetingsPreference = defaultmapURL + "UserInput"; // Add a real user input

		return meetingsPreference;							// Else else return preferred vendor, if supplied by user
	}
	public string other_cat(){ // Misc
		/*
		 * default category which will require you to put in a location in order to add the task. 
		 */

		string other_catPreference; // We will use the default locations if a preference is not chosen
		// We will need to work on this this weekend. Adding a textbox/button for preference (prefered vendor) selection
		string userLocation; // Pulling coordinates from API // Weekend
		
		userLocation = defaultmapURL + userLocation;
		other_catPreference = defaultmapURL + "UserInput"; // Add a real user input

		return meetingsPreference;	
	}
}
