
using System;
using System.Collections.Generic;
using engine;

namespace engine {

public class Deck
{
	public static int NUMFACES = 13;
	public static int NUMSUITS = 4;
	public static int NUMCARDS = NUMFACES * NUMSUITS;

	public static string[] SUITS = {"CLUBS","SPADES","DIAMONDS","HEARTS"};

	private int topCardIndex;
	private List<Card> stackOfCards;

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
		topCardIndex = stackOfCards.Count- 1;
	}
	
	public Deck(int numberOfDecks)
	{
		stackOfCards = new List<Card>();
		// Create full deck with specified number of decks
		for (int deck = 0; deck < numberOfDecks; deck++) {
			List<Card> newDeck = generateDeck();
            stackOfCards.InsertRange(0,newDeck);
		}
		topCardIndex = stackOfCards.Count - 1;
	}
	
	private List<Card> generateDeck()
	{
		List<Card> newDeck = new List<Card>();
		for (int suit = 0; suit < NUMSUITS; suit++) {
			for (int face = 1; face <= NUMFACES; face++) {
				String s = SUITS[suit];
				newDeck.Add(new BlackJackCard(face, s));
			}
		}
		return newDeck;
	}

	// Shuffle the deck and reset variables as needed
	public void shuffle ()
	{
		//Collections.shuffle(stackOfCards);
        Random rnd = new Random();
        for (int i = stackOfCards.Count; i > 1; i--) // shuffles the stack of cards
        {
            int pos = rnd.Next(i);
            var x = stackOfCards[i - 1];
            stackOfCards[i - 1] = stackOfCards[pos];
            stackOfCards[pos] = x;
        }

		topCardIndex = stackOfCards.Count - 1;
	}
	
	// Get size of the deck
	public int size ()
	{
		return stackOfCards.Count;
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
		
		return stackOfCards[topCardIndex--];
	}
	
	public void addExtraDeck()
	{
		List<Card> extraDeck = generateDeck();
		//Collections.shuffle(extraDeck);
        Random rnd = new Random();
        for (int i = extraDeck.Count; i > 1; i--)  // shuffles the Deck of cards
        {
            int pos = rnd.Next(i);
            var x = extraDeck[i - 1];
            extraDeck[i - 1] = extraDeck[pos];
            extraDeck[pos] = x;
        }
		stackOfCards.InsertRange(0, extraDeck);
		topCardIndex = topCardIndex + (extraDeck.Count - 1);
	}

	public String toString()
	{
		return stackOfCards + "   topCardIndex = " + topCardIndex;
	} 
}
}