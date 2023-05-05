package com.masai.service;

import java.util.List;
import java.util.Map;

import com.masai.entities.Bookings;
import com.masai.entities.Passenger;
import com.masai.exceptions.BusException;
import com.masai.exceptions.DuplicateDataException;
import com.masai.exceptions.InvalidDetailsException;

public interface PassengerService {
	public boolean login(String email,String password,Map<String, Passenger> pasenger)throws InvalidDetailsException;
	public void signup(Passenger pas,Map<String, Passenger> pasenger) throws DuplicateDataException;
	public boolean buyTickets(int id,int noSeats, String email,Map<String, Passenger> buses,Map<String, Passenger> pasenger,List<Bookings> bookings)throws InvalidDetailsException,BusException;
	public String updatePassengerDetails(String email,Map<String, Passenger> pasenger) throws InvalidDetailsException;
	public boolean addMoneytoWallet(double amout,String email,Map<String, Passenger> pasenger)throws InvalidDetailsException;
	public double viewWalletBalance(String email,Map<String, Passenger> pasenger)throws InvalidDetailsException;
	public Passenger viewPassengerDetails(String email,Map<String, Passenger> pasenger) throws InvalidDetailsException;
	public List<Passenger> viewAllPassenger(Map<String, Passenger> pasenger);
}
