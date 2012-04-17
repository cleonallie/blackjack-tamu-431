// Class: AbstractPlayer
// Package: players
// Abstracted player class that includes actions and information pertaining
// to any individual player of the game. This includes the player's hand,
// adding a card to the hand, the value of the player's hand, etc.

//package players;

using System;
using System.Collections.Generic;
using engine;

namespace player {

public abstract class AbstractPlayer
{
    
	private List<Card> hand ;
	private Card splitCard2;
	private int hand1Value;
	private int winCount;

	public AbstractPlayer()
	{
		hand = new List<Card>();
		winCount = 0;
		hand1Value = 0;
	}
	
	public void addCardToHand( Card temp )
	{
		hand.Add(temp);
	}
	
	public Card showCard()
	{
		if (hand.Count > 0)
			return hand[0];
		else
			return null;
	}
	
	public int showCardVal()
	{
		return showCard().getValue();
	}

	public void resetHand( )
	{
		hand.Clear();
		splitCard2 = null;
		hand1Value = 0;
	}

	public void setWinCount( int numwins )
	{
		winCount = numwins;
	}

	public List<Card> getHand()
	{
		return hand;
	}
	
	public int getWinCount()
	{
		return winCount;
	}

	public int getHandSize()
	{ 
		return hand.Count;
	}
	
	public Card getLastCard()
	{
		if (hand.Count < 1)
			return null;
		
		return hand[hand.Count-1];
	}

	public int getHandValue()
	{
		int total = 0;
        foreach (Card c in hand)
        {
			total += c.getValue();
		}
		if (total > 21) {
			// Player busted; check for aces that can then take the value of 1
			foreach (Card c in hand) {
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
		return "hand = " + hand.ToString() + " \n-  # wins " + winCount;
	}
	
	public bool canSplit()
	{
		return hand.Count==2 && hand[0].isPair(hand[1]);
	}
	
	public void playSplitHand1()
	{
		splitCard2 = getLastCard();
        hand.RemoveAt(1);
	}
	
	public void playSplitHand2(int h1v)
	{
		hand1Value = h1v;
		hand.Clear();
		addCardToHand(splitCard2);
	}
	
	public int getHand1Value()
	{
		return hand1Value;
	}
}
}