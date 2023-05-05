package com.masai.entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.masai.service.BusesService;
import com.masai.service.BusesServiceImpl;
import com.masai.utility.IDGeneration;

public class tes {

	public static Buses printdetails(Scanner sc) {
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

		
		Buses newBus = new Buses(IDGeneration.generateID(),busName,busType,seats,source,destination, dateTime, dateTime1);
		
		//System.out.println(newBus);
		return newBus;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map<Integer, Buses> buses = new HashMap<>();
		
		BusesService busService = new BusesServiceImpl();
		Buses b1 = printdetails(sc);
		String ba = busService.addBus(b1, buses);
		
		System.out.println(ba);
		
		
	}
}
