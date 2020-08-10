package exercicios;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) 
	{
		Locale.setDefault(Locale.US);
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter account data");
		
		System.out.print("Number:");
		int number=sc.nextInt();
		
		System.out.print("Name:");
		sc.nextLine();
		String holder=sc.nextLine();			
		
		System.out.print("Initial balance:");
		double balance=sc.nextDouble();
		
		System.out.print("Withdraw limit:");
		double withDrawLimit=sc.nextDouble();
		
		Account account=new Account(number, holder, balance, withDrawLimit);
		
		System.out.print("Enter amount for withdraw:");
		
		try
		{		
			account.withDraw(sc.nextDouble());
			
			System.out.println("----------");
			
			System.out.println(account);
		}
		catch (DomainException e) 
		{
			System.out.println(e.getMessage());
			
		}
		catch (RuntimeException e)
		{
			System.out.println("Erro inesperado !");
		}
		
		sc.close();
	}

}
