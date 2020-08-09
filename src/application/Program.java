package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program 
{

	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		
		try
		{
			System.out.print("Room number:");
			int roomNumber=sc.nextInt();
			
			System.out.print("Check-in date (dd/MM/yyyy):");
			Date chechin=sdf.parse(sc.next());
			
			System.out.print("Check-out date (dd/MM/yyyy):");
			Date chechout=sdf.parse(sc.next());
				
			System.out.println("----------");
			
				Reservation reserva=new Reservation(roomNumber, chechin, chechout);
				
				System.out.println("Reservation: "+reserva);
				
				System.out.println();
				
				System.out.println("Enter data to update the reservation:");
				
				System.out.print("Check-in date (dd/MM/yyyy):");
				chechin=sdf.parse(sc.next());
				
				System.out.print("Check-out date (dd/MM/yyyy):");
			    chechout=sdf.parse(sc.next());
				
			    System.out.println("----------");
			    
			    reserva.UpdateDates(chechin, chechout);
			    
			    System.out.println("Reservation: "+reserva);
		}
		catch (ParseException e) 
		{
			System.out.println("Invalid date format !");
		}
		catch (DomainException e)
		{
			System.out.println(e.getMessage());
		}
		catch (RuntimeException e) 
		{
			System.out.println("Unexpected error !");
		}
				
		sc.close();

	}

}
