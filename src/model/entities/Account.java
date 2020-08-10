package model.entities;

import model.exceptions.DomainException;

public class Account 
{
	private Integer number;
	private String holder;
	private Double balance,withDrawLimit;
	
	public Account()
	{
		
	}
	public Account(Integer number, String holder, Double balance, Double withDrawLimit) 
	{
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withDrawLimit = withDrawLimit;
	}
	
	public Integer getNumber() 
	{
		return number;
	}
	public void setNumber(Integer number)
	{
		this.number = number;
	}
	
	public String getHolder() 
	{
		return holder;
	}
	public void setHolder(String holder)
	{
		this.holder = holder;
	}
	
	public Double getWithDrawLimit()
	{
		return withDrawLimit;
	}
	public void setWithDrawLimit(Double withDrawLimit) 
	{
		this.withDrawLimit = withDrawLimit;
	}
	
	public void deposit(Double amount)
	{
		balance+=amount;
	}
	
	public void withDraw(Double amount)
	{
		if(balance<amount)
		{
			throw new DomainException("Saldo insuficiete !");
		}
		
		if(amount>withDrawLimit)
		{
			throw new DomainException("Valor de saque maior que limite !");
		}
		
		balance-=amount;
	}
}
