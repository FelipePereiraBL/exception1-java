package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation
{
	private static SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
	private Integer roomNumber;
	private Date chechin,chechout;
	
	public Reservation()
	{
		
	}
	public Reservation(Integer roomNumber, Date chechin, Date chechout) 
	{
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

	public String UpdateDates(Date chechin, Date chechout)
	{
		 Date now=new Date();
		    
		    if(chechin.before(now) || chechout.before(now))
		    {
		    	return "Error in reservation: Reservation dates for update must be future dates";
		    }
		    
		    if(!chechout.after(chechin))
			{
				return "Error in reservation: Check-out date must be after check-in date";
			}
		    
		this.chechin=chechin;
		this.chechout=chechout;
		
		return null;
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
