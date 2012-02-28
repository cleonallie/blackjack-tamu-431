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
	
	public void setCash(int m)
	{
		cash = m;
	}
	
	public void setBet(int b)
	{
		while (b > getCash()) {
			out.print("Bet exceeds cash available. Enter new bet: $");
			b = scan.nextInt();
		}
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