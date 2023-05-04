package com.masai.main;

import java.util.List;
import java.util.Map;

import com.masai.entities.Bookings;
import com.masai.entities.Buses;
import com.masai.entities.Passenger;
import com.masai.utility.FileExist;

public class Main {
	public static void main(String[] args) {
		System.out.println("hello");
		
		Map<String, Passenger> b1 = FileExist.PassengerFile();
		
		Map<Integer,Buses> b2 = FileExist.BusesFile();
		
		List<Bookings> p1 = FileExist.BookingsFile();
	}
}
