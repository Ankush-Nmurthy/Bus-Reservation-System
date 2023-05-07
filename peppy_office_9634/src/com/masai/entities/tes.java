package com.masai.entities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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
		
//		
//		File f = new File("Bookings.ser");
//		System.out.println(f.exists());
//		ObjectInputStream ois;
//		try {
//			ois = new ObjectInputStream(new FileInputStream(f));
//			List<Bookings> bookingsFile = (List<Bookings>) ois.readObject();
//			for(Bookings b: bookingsFile) {
//				System.out.println(b);
//			}
//			
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			System.out.println(e.getMessage());
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			System.out.println(e.getMessage());
//		}
		
		Map<Integer,Buses> buses = new HashMap<>();
		
		List<Bookings> b = new LinkedList<>();
		
		File f = new File("Bookings.ser");
		System.out.println(f.exists());
		ObjectInputStream ois;
		try {
			ois = new ObjectInputStream(new FileInputStream(f));
			b = (List<Bookings>) ois.readObject();
//			for(Map.Entry<Integer, Buses> bus : buses.entrySet()) {
//				System.out.println(bus.getValue().getBusName());
//			}
			
			for(Bookings b1 : b) {
				System.out.println(b1.getDt());
				Duration dur = Duration.between(b1.getDt(),LocalDateTime.now());
				long dur1 = dur.toHours();
				System.out.println(dur1);
//				System.out.println(dur.get);
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
