// Class: AbstractPlayer
// Package: players
// Abstracted player class that includes actions and information pertaining
// to any individual player of the game. This includes the player's hand,
// adding a card to the hand, the value of the player's hand, etc.

package players;

import java.util.ArrayList;
import engine.Card;

public abstract class AbstractPlayer implements Playerable
{
	private ArrayList<Card> hand;
	private int winCount;

	public AbstractPlayer()
	{
		hand = new ArrayList<Card>();
		winCount = 0;
	}
	
	public void addCardToHand( Card temp )
	{
		hand.add(temp);
	}
	
	public Card showCard()
	{
		return hand.get(0);
	}
	
	public int showCardVal()
	{
		return showCard().getValue();
	}

	public void resetHand( )
	{
		hand.clear();
	}

	public void setWinCount( int numwins )
	{
		winCount = numwins;
	}

	public int getWinCount()
	{
		return winCount;
	}

	public int getHandSize()
	{ 
		return hand.size();
	}
	
	public Card getLastCard()
	{
		return hand.get(hand.size()-1);
	}

	public int getHandValue()
	{
		int total = 0;
		for (Card c : hand) {
			total += c.getValue();
		}
		if (total > 21) {
			// Player busted; check for aces that can then take the value of 1
			for (Card c: hand) {
				// Check if this card is an ace
				if (c.getFace() == 1) {
					total = total - 10;
					if (total <= 21) {
						break;
					}
				}
			}
			return total;
		}
		else
			return total;
	}

	public String toString()
	{
		return "hand = " + hand.toString() + " \n-  # wins " + winCount;
	}
}