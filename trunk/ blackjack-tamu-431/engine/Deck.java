package engine;

import java.util.ArrayList;
import java.util.Collections;
import engine.Card;

public class Deck
{
	public static final int NUMFACES = 13;
	public static final int NUMSUITS = 4;
	public static final int NUMCARDS = NUMFACES * NUMSUITS;

	public static final String SUITS[] = {"CLUBS","SPADES","DIAMONDS","HEARTS"};

	private int topCardIndex;
	private ArrayList<Card> stackOfCards;

	public Deck ()
	{
		stackOfCards = new ArrayList<Card>();
		topCardIndex = NUMCARDS - 1;
		
		// Create deck of cards with all suits and faces
		for (int suit = 0; suit < NUMSUITS; suit++) {
			for (int face = 1; face <= NUMFACES; face++) {
				String s = SUITS[suit];
				stackOfCards.add(new BlackJackCard(face, s));
			}
		}
	}

	// Shuffle the deck and reset variables as needed
	public void shuffle ()
	{
		Collections.shuffle(stackOfCards);
		topCardIndex = NUMCARDS - 1;
	}
	
	// Get size of the deck
	public int size ()
	{
		return stackOfCards.size();
	}

	public int numCardsLeft()
	{
		if (topCardIndex > 0)
			return topCardIndex+1;
		else
			return 0;
	}

	public Card nextCard()
	{
		return stackOfCards.get(topCardIndex--);
	}

	public String toString()
	{
		return stackOfCards + "   topCardIndex = " + topCardIndex;
	} 
}