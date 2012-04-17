// Class: Player
// Package: players
// Extends the AbstractPlayer class and includes all capabilities of a player.

package players;

import static java.lang.System.*;
import java.util.Scanner;
import players.AbstractPlayer;

public class Player extends AbstractPlayer
{
	int cash = 0;
	int bet = 0;
	String name = "";
	Scanner scan = new Scanner(System.in);
	
	public Player()
	{
		super();
	}
	
	public Player(String n)
	{
		super();
		name = n;
	}
	
	public boolean isHitting( )
	{	
		out.println("Enter \"hit\" to hit or anything else to stay.");
		if (scan.nextLine().equalsIgnoreCase("hit"))
			return true;
		else
			return false;
	}
	
	public boolean isDoubling()
	{
		if ((cash - 2*bet)>=0 && getHandValue()<21)
		{
			out.println("Enter \"double\" to double down or anything else to continue.");
			if (scan.nextLine().equalsIgnoreCase("double"))
				return true;
		}
		return false;		
	}
	
	public boolean isSplitting()
	{
		if ((cash - 2*bet)>=0 && canSplit())
		{
			out.println("Enter \"split\" to split or anything else to continue.");
			if (scan.nextLine().equalsIgnoreCase("split"))
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
	public boolean canPlay()
	{
		if (getCash() <= 0)
			return false;
		else
			return true;
	}
}