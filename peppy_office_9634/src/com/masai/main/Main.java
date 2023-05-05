package com.masai.main;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.masai.entities.Bookings;
import com.masai.entities.Buses;
import com.masai.entities.Passenger;
import com.masai.exceptions.BookingException;
import com.masai.exceptions.BusException;
import com.masai.exceptions.InvalidDetailsException;
import com.masai.service.BookingService;
import com.masai.service.BookingServiceImpl;
import com.masai.service.BusesService;
import com.masai.service.BusesServiceImpl;
import com.masai.service.PassengerService;
import com.masai.service.PassengerServiceImpl;
import com.masai.utility.Admin;
import com.masai.utility.FileExist;
import com.masai.utility.IDGeneration;

public class Main {
	public static void adminLogin(Scanner sc) throws InvalidDetailsException {

		System.out.println("Enter the user name");
		String userName = sc.next();
		System.out.println("Enter the password");
		String password = sc.next();

		if (userName.equals(Admin.username) && password.equals(Admin.password)) {
			System.out.println("Successfully logged in....!");
		} else {
			throw new InvalidDetailsException("Invalid Admin Credentials");
		}
	}

	public static String adminAddBus(Scanner sc, Map<Integer, Buses> buses, BusesService busesService) {
		String str = null;
		System.out.println("enter the details of new bus");

		System.out.println("enter the departure date in dd/mm/yy HH:MM:SS formate");
		String departure = sc.nextLine();

		System.out.println("enter the arival date in dd/mm/yy HH:MM:SS formate");
		String arival = sc.nextLine();

		System.out.println("enter bus Name");
		String busName = sc.next();

		System.out.println("enter the source");
		String source = sc.next();

		System.out.println("enter the destination");
		String destination = sc.next();

		System.out.println("enter the busType");
		String busType = sc.next();

		System.out.println("enter the no of seats");
		int seats = sc.nextInt();

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		LocalDateTime dateTime1 = LocalDateTime.parse(departure, formatter);
		LocalDateTime dateTime = LocalDateTime.parse(arival, formatter);

		Buses newBus = new Buses(IDGeneration.generateID(), busName, busType, seats, source, destination, dateTime,
				dateTime1);

		System.out.println(newBus);
		str = busesService.addBus(newBus, buses);

		return str;
	}

	private static  void adminViewAllBuses(Map<Integer, Buses> buses, BusesService busService) throws BusException{
		busService.ViewAllBusses(buses);
	}
	public static void adminFunctionality(Scanner sc, Map<Integer, Buses> buses, Map<String, Passenger> passengers,
			List<Bookings> bookings) throws InvalidDetailsException, BookingException, BusException {
		adminLogin(sc);
		BookingService bookService = new BookingServiceImpl();
		BusesService busService = new BusesServiceImpl();
		PassengerService pasenService = new PassengerServiceImpl();
		int choice = 0;
		try {

			do {
				System.out.println("Press 1 -> Add the bus");
				System.out.println("Press 2 -> view all buses");
				System.out.println("Press 3 -> Delete the bus");
				System.out.println("Press 4 -> Update the bus details");
				System.out.println("Press 5 -> View passenger details");
				System.out.println("Press 6 -> View all bookinga");
				System.out.println("Press 7 -> Log out");

				choice = sc.nextInt();

				switch (choice) {
				case 1:
					String added = adminAddBus(sc, buses, busService);
					System.out.println(added);
					break;
				case 2:
					adminViewAllBuses(buses,busService);
					break;
				case 3:
					adminDeleteBus(sc,buses,busService);
					break;
				case 4:
					String changedDetails = adminUpdateBusDetails(sc,buses,busService);
					break;
				case 5:
					break;
				case 6:
					break;
				case 7:
					break;
				default:
					System.out.println("unsuccessful");
					break;
				}
			} while (choice <= 2);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}



	private static String adminUpdateBusDetails(Scanner sc, Map<Integer, Buses> buses, BusesService busService2) throws BusException{
		String res = null;
		System.out.println("Please enter the id of the bus which you wish to be updated");
		int id = sc.nextInt();
		
		System.out.println("Enter below the details to be updated \n");
		String Busname = sc.next();
		
		System.out.println("Enter Bus type");
		String bustype = sc.next();
		
		System.out.println("Enter the no of seats to be updated");
		int NoOfSeats = sc.nextInt();
		
		Buses b1 = new Buses(Busname,bustype,NoOfSeats);
		
		return res;
	}

	private static void adminDeleteBus(Scanner sc, Map<Integer, Buses> busses, BusesService busService) throws BusException {
		// TODO Auto-generated method stub
		System.out.println("please enter the id of Bus to be deleted");
		int id = sc.nextInt();
		busService.deleteBus(id, busses);
	}

	public static void passengersFunctionality(Scanner sc, Map<Integer, Buses> busses,
			Map<String, Passenger> passengers, List<Bookings> bookings) {

	}

	public static void passengerSignup(Scanner sc, Map<String, Passenger> passengers) {

	}

	public static void main(String[] args) {

		Map<Integer, Buses> buses = FileExist.BusesFile();
		Map<String, Passenger> passengers = FileExist.PassengerFile();
		List<Bookings> bookings = FileExist.BookingsFile();

		Scanner sc = new Scanner(System.in);

		System.out.println("Welcome..! to Bus Ticket Reservation System \n");

		try {
			int preference = 0;

			do {
				System.out.println(
						"Please enter your preference,\n 1 --> Admin Login. \n 2 --> Passenger Login.\n 3 --> Passenger Sign Up.\n 0 --> To close the application.");
				preference = sc.nextInt();

				switch (preference) {
				case 1:
					adminFunctionality(sc, buses, passengers, bookings);
					break;
				case 2:
					passengersFunctionality(sc, buses, passengers, bookings);
					break;
				case 3:
					passengerSignup(sc, passengers);
					break;

				case 0:
					System.out.println("successfully existed from the system");
					break;

				default:
					throw new IllegalArgumentException("Invalid Selection");
				}
			} while (preference != 0);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		} finally {
			try {
				ObjectOutputStream boos = new ObjectOutputStream(new FileOutputStream("Buses.ser"));
				boos.writeObject(buses);
				ObjectOutputStream poos = new ObjectOutputStream(new FileOutputStream("Passenger.ser"));
				poos.writeObject(passengers);

				ObjectOutputStream bkoos = new ObjectOutputStream(new FileOutputStream("Bookings.ser"));
				bkoos.writeObject(bookings);
			} catch (Exception e2) {
				// TODO: handle exception
				System.out.println(e2.getMessage());
			}
		}
	}
}
