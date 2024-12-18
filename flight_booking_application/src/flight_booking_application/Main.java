package flight_booking_application;

import java.util.*;
public class Main {
	public static void main(String[] args)
	{
		
		
		FlightReservationSystem system = new FlightReservationSystem();
		Scanner scanner = new Scanner(System.in);
		
		while (true)
		{
			System.out.println("\n--- Flight Reservation System ---");
			System.out.println("1. Book Ticket");
			System.out.println("2. Cancel Ticket");
			System.out.println("3. Print Flight Details");
			System.out.println("4. Exit");
			System.out.println("Enter your choice: ");
			
			int choice = scanner.nextInt();
			scanner.nextLine(); //Consume newline
			
			
			switch (choice)
			{
			case 1: //Book Ticket
				System.out.print("Enter flight name (Indigo/SpiceJet): ");
				String flightName = scanner.nextLine();
				
				if(system.flights.containsKey(flightName))
				{
					system.displayFlightDetails(flightName);
					System.out.print("Enter Passenger Name: ");
					String passengerName = scanner.nextLine();
					System.out.print("Enter passenger age: ");
					int age = scanner.nextInt();
					System.out.print("Enter number of the seats to book: ");
					int seats = scanner.nextInt();
					
					//the belw function returns the bookingId.show the return of Id
					String bookingId = system.bookTicket(flightName, passengerName, age, seats);
					
					if(bookingId !=null)
					{
						System.out.println("Booking successfully your booking ID is: " + bookingId);
					}
						
					}else {
						System.out.println("Invalid flight name. Please try again...");
					}
					break;
					
					
					case 2: //Cancel Ticket
						System.out.print("Enter flight name (Indigo / SpiceJet): ");
						flightName = scanner.nextLine();
						System.out.print("Enter booking ID: ");
						String bookingId = scanner.nextLine();
						
						system.cancelTicket(flightName, bookingId);
						break;
						
					case 3: //print flight details
						System.out.print("Enter flight name (Indigo / Spicejet): ");
						flightName = scanner.nextLine();
						system.printFlightDetails(flightName);
						break;
						
					case 4: //Exit
						System.out.println("Exiting system. Thank you !!!");
						scanner.close();
						return;
						
					default:
						System.out.println("Invalid choice. Please try again.");
						
				}
			}
		}
		
	
	}