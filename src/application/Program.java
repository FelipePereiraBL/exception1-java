package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program 
{

	public static void main(String[] args) throws ParseException 
	{
		Scanner sc=new Scanner(System.in);
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room number:");
		int roomNumber=sc.nextInt();
		
		System.out.print("Check-in date (dd/MM/yyyy):");
		Date chechin=sdf.parse(sc.next());
		
		System.out.print("Check-out date (dd/MM/yyyy):");
		Date chechout=sdf.parse(sc.next());
			
		System.out.println("----------");
		
		if(!chechout.after(chechin))
		{
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		}
		else
		{
			Reservation reserva=new Reservation(roomNumber, chechin, chechout);
			
			System.out.println(reserva);
			
			System.out.println();
			
			System.out.println("Enter data to update the reservation:");
			
			System.out.print("Check-in date (dd/MM/yyyy):");
			chechin=sdf.parse(sc.next());
			
			System.out.print("Check-out date (dd/MM/yyyy):");
		    chechout=sdf.parse(sc.next());
			
		    System.out.println("----------");
		    
		    Date now=new Date();
		    
		    if(chechin.before(now) || chechout.before(now))
		    {
		    	System.out.println("Error in reservation: Reservation dates for update must be future dates");
		    }
		    else
		    {
		    	reserva.UpdateDates(chechin, chechout);
		    	
		    	System.out.println("Reservation: "+reserva);
		    }			
			
		}
				
		sc.close();

	}

}
