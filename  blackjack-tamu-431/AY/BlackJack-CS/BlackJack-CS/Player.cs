// Class: Player
// Package: players
// Extends the AbstractPlayer class and includes all capabilities of a player.
using System;
using System.Collections.Generic;
using engine;

namespace player {

public class Player : AbstractPlayer
{
	int cash = 0;
	int bet = 0;
	String name = "";
		
	public Player(): base()
	{
        //super();
	}
	
	public Player(String n):base()
	{
		//super();
		name = n;
	}
	
	public bool isHitting( )
	{	
		Console.WriteLine("Enter \"hit\" to hit or anything else to stay.");
		if (Console.ReadLine() == "hit")
			return true;
		else
			return false;
	}
	
	public bool isDoubling()
	{
		if ((cash - 2*bet)>=0 && getHandValue()<21)
		{
			Console.WriteLine("Enter \"double\" to double down or anything else to continue.");
			if (Console.ReadLine() == "double")
				return true;
		}
		return false;		
	}
	
	public bool isSplitting()
	{
		if ((cash - 2*bet)>=0 && canSplit())
		{
			Console.WriteLine("Enter \"split\" to split or anything else to continue.");
			if (Console.ReadLine() =="split")
				return true;
		}
		return false;
	}
	
	public void setCash(int m)
	{
		cash = m;
	}
	
	public void setBet(int b)
	{
		/*
		while (b > getCash()) {
			out.print("Bet exceeds cash available. Enter new bet: $");
			b = scan.nextInt();
		}
		*/
		if (b > cash)
			bet = cash;
		else if (b < 0)
			bet = 0;
		else
			bet = b;
	}
	
	public void setName(String n)
	{
		name = n;
	}	
	
	public int getCash()
	{
		return cash;
	}
	
	public int getBet()
	{
		return bet;
	}	
	
	public String getName()
	{
		return name;
	}
	
	// Players can no longer play once they have no money
	public bool canPlay()
	{
		if (getCash() <= 0)
			return false;
		else
			return true;
	}
}
}