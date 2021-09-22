package com.bridgelabz.cabinvoicegenerator;

import java.util.ArrayList;
import java.util.HashMap;

public class InvoiceService {

	public static HashMap<String, ArrayList<Ride>>  userMap=new HashMap<String, ArrayList<Ride>>(); 

	public void addUsersRideInformation(String userId, Ride ride) {
		if(!userMap.containsKey(userId))
			userMap.put(userId, new ArrayList<Ride>());
		userMap.get(userId).add(ride);		

	}

	public ArrayList<Ride> getRidesList(String userId) {
		if(userMap.containsKey(userId)) 
			return userMap.get(userId);
		else {
			System.err.println("User does not exist");
			return null;
		}
	}


}
