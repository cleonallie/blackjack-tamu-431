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
		stackOfCards = generateDeck();
		/*
		stackOfCards = new ArrayList<Card>();
		// Create deck of cards with all suits and faces
		for (int suit = 0; suit < NUMSUITS; suit++) {
			for (int face = 1; face <= NUMFACES; face++) {
				String s = SUITS[suit];
				stackOfCards.add(new BlackJackCard(face, s));
			}
		}
		*/
		topCardIndex = stackOfCards.size() - 1;
	}
	
	public Deck(int numberOfDecks)
	{
		stackOfCards = new ArrayList<Card>();
		// Create full deck with specified number of decks
		for (int deck = 0; deck < numberOfDecks; deck++) {
			ArrayList<Card> newDeck = generateDeck();
			stackOfCards.addAll(newDeck);
		}
		topCardIndex = stackOfCards.size() - 1;
	}
	
	private ArrayList<Card> generateDeck()
	{
		ArrayList<Card> newDeck = new ArrayList<Card>();
		for (int suit = 0; suit < NUMSUITS; suit++) {
			for (int face = 1; face <= NUMFACES; face++) {
				String s = SUITS[suit];
				newDeck.add(new BlackJackCard(face, s));
			}
		}
		return newDeck;
	}

	// Shuffle the deck and reset variables as needed
	public void shuffle ()
	{
		Collections.shuffle(stackOfCards);
		topCardIndex = stackOfCards.size() - 1;
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
		if (topCardIndex == 0)
			return null;
		
		return stackOfCards.get(topCardIndex--);
	}
	
	public void addExtraDeck()
	{
		ArrayList<Card> extraDeck = generateDeck();
		Collections.shuffle(extraDeck);
		stackOfCards.addAll(0, extraDeck);
		topCardIndex = topCardIndex + (extraDeck.size() - 1);
	}

	public String toString()
	{
		return stackOfCards + "   topCardIndex = " + topCardIndex;
	} 
}