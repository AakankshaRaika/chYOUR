package Skeleton_Code.Maping;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import Skeleton_Code.Features.Categories;

import static Skeleton_Code.Features.Categories.Categories_enum.GENPHARM;
import static Skeleton_Code.Features.Categories.Categories_enum.GROCERIES;
import static Skeleton_Code.Features.Categories.Categories_enum.HARDWARE;
import static Skeleton_Code.Features.Categories.Categories_enum.HOUSEHOLD;



/**
 * Created by Aakanksha and Barry on 10/4/2016.
 */

/*
 * Google Maps Place API to figure out hours of operations
 * Google Distance Matrix API to figure out distance and time needed to travel
 * JSON to Java Classes http://pojo.sodhanalibrary.com/
 * Need to figure out editStart (Date or Time? Which? Both? Neither?)
 * Google URL to find the closest store: http://maps.google.com/maps?q=%LOCATION
 * - %LOCATION can be any Google-readable string (coordinates, address, name of location, etc.)
 *
 * Algorithm:
 * Scanning the neighborhood for location:
 * 1. Have a circular radii (range determined by user) for:
 *  a. User's current location
 *  b. User's destination
 * 2. Have a semi-circular radius from user's current location to destination of size (distance)
 * - Point (2) Removed
 *
 * Searching and Working Parameters:
 *
 * 1. Types of Places by categories: https://developers.google.com/places/supported_types
 * 2. Types of Places by location/radius: https://developers.google.com/places/place-id
 *  - This will return a list of results in a list/array with results[0] being the closest location
 * 3. https://developers.google.com/maps/documentation/javascript/places#place_search_responses
 *  - Formatted Address, hours, rating, phone numbers, icon/logos, photographs, etc.
 */


public class Location {
    static Categories.Categories_enum c_enum;

    private String Location;
    private String defaultGoogleURL = "http://maps.google.com/maps?q=";
    // Concatenate with any name of store, address, coordinates, etc
    private String userLocation = "";
    private Categories category;
    private GoogleMap myGoogleMap;

    private int x = 0; // Pull values for lat/lng from API creation in Sprint 3
    private int y = 0;

    private GoogleMap mMap;

    public Location() {
        // Constructor
        // Location = get_Location(); // We will utilize this variable once we fix API. Temp: Setting userLocation to Student Union
        // ^ Will need to fix. get_Location() is giving errors. // Barry 10/28 @ 7:42 pm
    }

    public void userLocation(GoogleMap googleMap) {
        userLocation = "43.001120,-78.786133"; // No userLocation passed in from Google_Map.java
        // Student Union is our temp value
        // Because there is no range class from Dom/Viv Sprint 2 (1-10 miles), we are localizing this to UB Students (temp)
        String userLocationURL = defaultGoogleURL + userLocation; // Concatenating URL to location
        // string[] locationList = userLocation;
    }

    public void taskLocation(String location, GoogleMap googleMap) {
        location = Location;
        if (!(location.equals("")) | !(location.equals(null))) { // If there is a value for location
            // divert user to location
            mMap = googleMap;
            LatLng destination = new LatLng(x, y);
            mMap.addMarker(new MarkerOptions().position(destination).title("Marker at Destination"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(destination));

        } else {
            if (c_enum == GROCERIES) {
                String groceryURL = defaultGoogleURL + Integer.toString(x) + "," + Integer.toString(y);
                taskLocation(groceryURL, myGoogleMap);
            } else if (c_enum == HOUSEHOLD) {
                String householdURL = defaultGoogleURL + Integer.toString(x) + "," + Integer.toString(y);
                taskLocation(householdURL, myGoogleMap);
            } else if (c_enum == HARDWARE) {
                String hardwareURL = defaultGoogleURL + Integer.toString(x) + "," + Integer.toString(y);
                taskLocation(hardwareURL, myGoogleMap);
            } else if (c_enum == GENPHARM) {
                String genpharmURL = defaultGoogleURL + Integer.toString(x) + "," + Integer.toString(y);
                taskLocation(genpharmURL, myGoogleMap);
            }
        }

    }
}