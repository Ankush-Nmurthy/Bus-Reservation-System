package com.masai.service;

import java.util.List;

import com.masai.entities.Bookings;
import com.masai.exceptions.BookingException;

public interface BookingService {
	public List<Bookings> ViewallBookings(List<Bookings> bookings) throws BookingException;
	public List<Bookings> ViewPassengerBooking(String email,List<Bookings> bookings) throws BookingException;
	public List<Bookings> ViewallBookingsDateWise();// implement this ;
//	public List<Bookings> ViewBookingsByUserName(String email, List<Bookings> bookings) throws BookingException;
}
