/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.bridgelabz.cabinvoicegenerator;

import org.junit.Assert;
import org.junit.Test;

import com.bridgelabz.cabinvoicegenerator.Ride.RideType;

public class CabInvoiceGeneratorTest {
	@Test
	public void givenDistanceAndTime_ShouldReturnTotalFare() {
		CabInvoiceGenerator invoiceGenerator = new CabInvoiceGenerator();
		double distance = 10.0;
		int time = 5;
		double fare = invoiceGenerator.calculateFare(distance,time,RideType.NORMAL_RIDE);
		Assert.assertEquals(105, fare, 0.0);
	}
	
	@Test
	public void givenLessDistanceAndTime_ShouldReturnTotalFare() {
		CabInvoiceGenerator invoiceGenerator = new CabInvoiceGenerator();
		double distance = 0.2;
		int time = 2;
		double fare = invoiceGenerator.calculateFare(distance,time,RideType.NORMAL_RIDE);
		Assert.assertEquals(5, fare, 0.0);
	}
	
	@Test
	public void givenMultipleRides_ShouldReturnTotalFare() {
		CabInvoiceGenerator invoiceGenerator = new CabInvoiceGenerator();
		Ride[] rides = { new Ride(10.0,1,RideType.NORMAL_RIDE),new Ride(11,2,RideType.NORMAL_RIDE)};
		double fare = invoiceGenerator.calculateFare(rides);
		Assert.assertEquals(213, fare, 0.0);
	}
	
	@Test
	public void givenMultipleRides_ShouldReturnInvoiceSummary() {
		CabInvoiceGenerator invoiceGenerator = new CabInvoiceGenerator();
		Ride[] rides = { new Ride(2.0,5,RideType.NORMAL_RIDE),
						 new Ride(0.1,1,RideType.NORMAL_RIDE),
		};
		InvoiceSummary summary = invoiceGenerator.getSummary(rides);
		InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2,30.0);
		Assert.assertEquals(expectedInvoiceSummary,summary);
	}
	
	@Test
	public void givenUserId_ShouldReturnInvoiceSummary() {
		CabInvoiceGenerator invoiceGenerator = new CabInvoiceGenerator();
		InvoiceService invoiceService = new InvoiceService();
		String userId ="USER1";
		invoiceService.addUsersRideInformation(userId,new Ride(2.0, 5,RideType.NORMAL_RIDE));
		invoiceService.addUsersRideInformation(userId,new Ride(0.1, 1,RideType.NORMAL_RIDE));
		InvoiceSummary summary = invoiceGenerator.getSummaryByUserId(userId);
		InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2,30.0);
		Assert.assertEquals(expectedInvoiceSummary, summary);
	}
	
	@Test
	public void givenDistanceAndTime_ForPremiumRide_ShouldReturnTotalFare() {
		CabInvoiceGenerator invoiceGenerator = new CabInvoiceGenerator();
		double distance = 10.0;
		int time = 5;
		double fare = invoiceGenerator.calculateFare(distance,time,RideType.PREMIUM_RIDE);
		Assert.assertEquals(210, fare, 0.0);
	}
	
	@Test
	public void givenLessDistanceAndTime_ForPremiumRide_ShouldReturnTotalFare() {
		CabInvoiceGenerator invoiceGenerator = new CabInvoiceGenerator();
		double distance = 0.2;
		int time = 2;
		double fare = invoiceGenerator.calculateFare(distance,time,RideType.PREMIUM_RIDE);
		Assert.assertEquals(20, fare, 0.0);
	}
}
