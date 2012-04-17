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
	private Card splitCard2;
	private int hand1Value;
	private int winCount;

	public AbstractPlayer()
	{
		hand = new ArrayList<Card>();
		winCount = 0;
		hand1Value = 0;
	}
	
	public void addCardToHand( Card temp )
	{
		hand.add(temp);
	}
	
	public Card showCard()
	{
		if (hand.size() > 0)
			return hand.get(0);
		else
			return null;
	}
	
	public int showCardVal()
	{
		return showCard().getValue();
	}

	public void resetHand( )
	{
		hand.clear();
		splitCard2 = null;
		hand1Value = 0;
	}

	public void setWinCount( int numwins )
	{
		winCount = numwins;
	}

	public ArrayList<Card> getHand()
	{
		return hand;
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
		if (hand.size() < 1)
			return null;
		
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
	
	public boolean canSplit()
	{
		return hand.size()==2 && hand.get(0).isPair(hand.get(1));
	}
	
	public void playSplitHand1()
	{
		splitCard2 = getLastCard();
		hand.remove(1);
	}
	
	public void playSplitHand2(int h1v)
	{
		hand1Value = h1v;
		hand.clear();
		addCardToHand(splitCard2);
	}
	
	public int getHand1Value()
	{
		return hand1Value;
	}
}