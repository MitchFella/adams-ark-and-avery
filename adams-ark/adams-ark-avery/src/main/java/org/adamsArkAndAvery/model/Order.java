package org.adamsArkAndAvery.model;

import java.util.List;

public class Order {
	private List<String> selectedServices;
	private PetBooking booking;
	
	// Constructor
	public Order(PetBooking booking, List<String> selectedServices) {
		this.booking = booking;
		this.selectedServices = selectedServices;
	}
	
	//setter and getter
	public void setBooking(PetBooking booking) {
		this.booking = booking;
	}
	
	public PetBooking getBooking() {
		return booking;
	}
	
	public void setSelectedServices(List<String> selectedServices) {
		this.selectedServices = selectedServices;
	}
	
	public List<String> getSelectedServices() {
		return selectedServices;
	}
	
	//display selected services in confirmation page
	public String showServices() {
		String showServices = "";
		for(String i : selectedServices) {
			showServices += i + ", ";
		}
		return showServices;
	}
	
	//count total price
	public double price() {
		return 0;
	}
}
