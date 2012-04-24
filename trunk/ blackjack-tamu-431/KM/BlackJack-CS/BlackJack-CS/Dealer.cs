// Class: Dealer
// Package: players
// Extends the AbstractPlayer class and includes all capabilities of a dealer:
// shuffling the deck, dealing a card, and hitting (if the dealer is playing
// the game).
using System;
using System.Collections.Generic;
using engine;
namespace player {


public class Dealer : AbstractPlayer
{
	private Deck deckOfCards;

	public Dealer():base()
	{
        //super();
		deckOfCards = new Deck();
	}
	
	public Dealer(int numberOfDecks): base()
	{
		//super();
		deckOfCards = new Deck(numberOfDecks);
	}

	public Deck shuffle()
	{
		deckOfCards.shuffle();
		return deckOfCards;
	}

	public Card deal()
	{
		if (deckOfCards.numCardsLeft() == 0) {
			deckOfCards.addExtraDeck();
		}
		return deckOfCards.nextCard();
	}

	public bool isHitting()
	{
		// Dealer must hit if total hand value is 16 or less
		if (base.getHandValue() <= 16) {
			this.addCardToHand(this.deal());
			return true;	
		}
		else
			return false;
	}
}
}