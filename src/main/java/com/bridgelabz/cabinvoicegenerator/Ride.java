package com.bridgelabz.cabinvoicegenerator;

public class Ride {

	public double distance;
	public int time;
	public enum RideType {
		PREMIUM_RIDE,
		NORMAL_RIDE
	}
	public RideType rideType;
	public Ride(double distance, int time,RideType ridetype) {
		super();
		this.distance = distance;
		this.time = time;
		this.rideType=ridetype;
		
	}
	
}
