package org.adamsArkAndAvery.service;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import org.adamsArkAndAvery.model.PetBooking;

@ManagedBean(name = "bookingStore")
@ApplicationScoped
public class BookingStore {
	private List<PetBooking> bookingList = new ArrayList<>();

	//submit button --> save pet book informations in bookstore
    public void saveBooking(PetBooking booking) {
        bookingList.add(booking);
        System.out.println("Booking saved for: " + booking.getPetName());
    }

   //show all book informations will use for history 
    public List<PetBooking> getAllBookings() {
        return bookingList;
    }
    
    //return current booking information
    public PetBooking getCurrentBooking() {
    	return bookingList.get(0);
    }
}
