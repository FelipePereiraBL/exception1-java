package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation
{
	private static SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
	private Integer roomNumber;
	private Date chechin,chechout,now=new Date();
	
	public Reservation()
	{
		
	}
	public Reservation(Integer roomNumber, Date chechin, Date chechout) 
	{
		 if(!chechout.after(chechin))
			{
				throw new DomainException( "Error in reservation: Check-out date must be after check-in date");
			}
		 
		 if(chechin.before(now) || chechout.before(now))
		    {
		    	throw new DomainException("Error in reservation: Reservation dates must be given in the future");
		    }
		 
		this.roomNumber = roomNumber;
		this.chechin = chechin;
		this.chechout = chechout;
	}
	
	public Integer getRoomNumber() 
	{
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) 
	{
		this.roomNumber = roomNumber;
	}

	public Date getChechin() 
	{
		return chechin;
	}

	public Date getChechout() 
	{
		return chechout;
	}
	
	public long duration()
	{
		long diff=chechout.getTime()-chechin.getTime();
		
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}

	public void UpdateDates(Date chechin, Date chechout) 
	{	    
		 if(chechin.before(now) || chechout.before(now)) 
		 {
		   throw new DomainException("Error in reservation: Reservation dates for update must be future dates");
		 }
		    
	     if(!chechout.after(chechin))
	     {
		   throw new DomainException( "Error in reservation: Check-out date must be after check-in date");
		 }
		    
		this.chechin=chechin;
		this.chechout=chechout;
		
	}
	
	@Override
	public String toString()
	{
		return "Room "+roomNumber
				+", chechin:"
				+sdf.format(chechin)
				+", chechout:"
				+sdf.format(chechout)
				+", "
				+duration()
				+" nights";
	}
}
