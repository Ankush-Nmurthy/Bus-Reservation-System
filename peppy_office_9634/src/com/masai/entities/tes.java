package com.masai.entities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;
import java.util.Scanner;

public class tes {

//	public static Buses printdetails(Scanner sc) {
//		String str = null;
//		System.out.println("enter the details of new bus");
//		
//		System.out.println("enter the departure date in dd/mm/yyyyHH:MM:SS formate");
//		String departure = sc.next();
//		
//		System.out.println("enter the arival date in dd/mm/yyyyHH:MM:SS formate");
//		String arival = sc.next();
//		
//		System.out.println("enter bus Name");
//		String busName = sc.next();
//		
//		System.out.println("enter the source");
//		String source = sc.next();
//
//		System.out.println("enter the destination");
//		String destination = sc.next();
//
//		System.out.println("enter the busType");
//		String busType = sc.next();
//
//		System.out.println("enter the no of seats");
//		int seats = sc.nextInt();
//		
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyyHH:mm:ss");
//		LocalDateTime dateTime1 = LocalDateTime.parse(departure, formatter);
//		LocalDateTime dateTime = LocalDateTime.parse(arival, formatter);
//
//		
//		Buses newBus = new Buses(IDGeneration.generateID(),busName,busType,seats,source,destination, dateTime, dateTime1);
//		
//		System.out.println(newBus);
//		return ;
//	}

	public static void main(String[] args) throws ClassNotFoundException {
//		Scanner sc = new Scanner(System.in);
//		Map<Integer, Buses> buses = new HashMap<>();
//		
//		BusesService busService = new BusesServiceImpl();
//		Buses b1 = printdetails(sc);
//		String ba = busService.addBus(b1, buses);
//		
//		System.out.println(ba);
		
		
		File f = new File("Bookings.ser");
		System.out.println(f.exists());
		ObjectInputStream ois;
		try {
			ois = new ObjectInputStream(new FileInputStream(f));
			List<Bookings> bookingsFile = (List<Bookings>) ois.readObject();
			for(Bookings b: bookingsFile) {
				System.out.println(b);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}
}
