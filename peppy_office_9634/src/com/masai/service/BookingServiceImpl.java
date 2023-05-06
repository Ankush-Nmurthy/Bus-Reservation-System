package com.masai.service;

import java.util.ArrayList;
import java.util.List;

import com.masai.entities.Bookings;
import com.masai.exceptions.BookingException;

public class BookingServiceImpl implements BookingService{

	@Override
	public void  ViewallBookings(List<Bookings> bookings) throws BookingException {
		// TODO Auto-generated method stub
		if(bookings != null && bookings.size() > 0) {
			for(Bookings b : bookings) {
				System.out.println(b);
			}
		}
		else {
			throw new BookingException("no bookings found");
		}
	}

	@Override
	public void ViewBoookingByPassengerName(String email, List<Bookings> bookings) throws BookingException {
		
		if(bookings != null && bookings.size() > 0) {
			for(Bookings b : bookings) {
				if(b.getUserName().equals(email)) {
					System.out.println(b);
				}
				else {
					throw new BookingException("Passenger Not Found");
				}
			}
		}
		else {
			throw new BookingException("Empty booking list(no bookings found)");
		}
		
	}

	@Override
	public List<Bookings> ViewallBookingsDateWise() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void ViewBookingBussName(String BusName, List<Bookings> bookings) throws BookingException {
		// TODO Auto-generated method stub
		if(bookings != null && bookings.size() > 0) {
			for(Bookings b : bookings) {
				if(b.getBusName().equals(BusName)) {
					System.out.println(b);
				}
			}
		}
		else {
			throw new BookingException("Bus Name enterd is not found..!");
		}
	}

//	@Override
//	public List<Bookings> ViewBookingsByUserName(String email, List<Bookings> bookings) throws BookingException {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
