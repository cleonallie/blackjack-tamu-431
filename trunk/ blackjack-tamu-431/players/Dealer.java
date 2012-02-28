// Class: Dealer
// Package: players
// Extends the AbstractPlayer class and includes all capabilities of a dealer:
// shuffling the deck, dealing a card, and hitting (if the dealer is playing
// the game).

package players;

import engine.Card;
import engine.Deck;
import players.AbstractPlayer;

public class Dealer extends AbstractPlayer
{
	private Deck deckOfCards;

	public Dealer()
	{
		super();
		deckOfCards = new Deck();
	}

	public Deck shuffle()
	{
		deckOfCards.shuffle();
		return deckOfCards;
	}

	public Card deal()
	{
		return deckOfCards.nextCard();
	}

	public boolean isHitting()
	{
		// Dealer must hit if total hand value is 16 or less
		if (super.getHandValue() <= 16) {
			this.addCardToHand(this.deal());
			return true;	
		}
		else
			return false;
	}
}