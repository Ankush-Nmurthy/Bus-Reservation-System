package com.masai.entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class tes {

	public static void printdetails(Scanner sc) {
		
		System.out.println("enter the details of new bus");
		
		System.out.println("enter the departure date");
		String departure = sc.nextLine();
		
		System.out.println("enter the arival date");
		String arival = sc.nextLine();
		
		System.out.println("enter bus id");
		int id = sc.nextInt();
		
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

		
		Buses b1 = new Buses(id,busName,busType,seats,source,destination, dateTime, dateTime1);
		
		System.out.println(b1);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		printdetails(sc);
	}
}
