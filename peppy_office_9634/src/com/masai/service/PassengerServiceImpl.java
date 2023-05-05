package com.masai.service;

import java.util.List;
import java.util.Map;

import com.masai.entities.Bookings;
import com.masai.entities.Passenger;
import com.masai.exceptions.BusException;
import com.masai.exceptions.DuplicateDataException;
import com.masai.exceptions.InvalidDetailsException;

public class PassengerServiceImpl implements PassengerService{

	@Override
	public boolean login(String email, String password, Map<String, Passenger> pasenger)
			throws InvalidDetailsException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void signup(Passenger pas, Map<String, Passenger> pasenger) throws DuplicateDataException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean buyTickets(int id, int noSeats, String email, Map<String, Passenger> buses,
			Map<String, Passenger> pasenger, List<Bookings> bookings) throws InvalidDetailsException, BusException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String updatePassengerDetails(String email, Map<String, Passenger> pasenger) throws InvalidDetailsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addMoneytoWallet(double amout, String email, Map<String, Passenger> pasenger)
			throws InvalidDetailsException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public double viewWalletBalance(String email, Map<String, Passenger> pasenger) throws InvalidDetailsException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Passenger viewPassengerDetails(String email, Map<String, Passenger> pasenger)
			throws InvalidDetailsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Passenger> viewAllPassenger(Map<String, Passenger> pasenger) {
		// TODO Auto-generated method stub
		return null;
	}

}
