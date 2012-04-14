package testing;

import org.junit.*;
import static org.junit.Assert.*;
import engine.Card;
import engine.Deck;

public class DeckTest {
	@Test
	public void test_nextCard() {
		System.out.println("\nTesting Deck : nextCard()...");
		Deck deck;
		
		System.out.print("\tBeginning of deck\t... ");
		deck = new Deck();
		Card card = deck.nextCard();
		assertFalse(card.equals(null));
		System.out.println("OK");
		
		System.out.print("\tMiddle of deck\t\t... ");
		deck = new Deck();
		for (int i = 0; i < deck.size() / 2; i++) {
			card = deck.nextCard();
		}
		assertFalse(card.equals(null));
		System.out.println("OK");
		
		System.out.print("\tBeyond end of deck\t... ");
		deck = new Deck();
		for (int i = 0; i < deck.size(); i++) {
			card = deck.nextCard();
		}
		card = deck.nextCard();
		assertEquals(card, null);
		System.out.println("OK");
	}
}
