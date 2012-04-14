package testing;

import org.junit.*;
import static org.junit.Assert.*;
import engine.BlackJackCard;

public class BlackJackCardTest {

	@Test
	public void test_getValue() {
		System.out.println("\nTesting BlackJackCard : getValue()...");
		BlackJackCard card;
		
		System.out.print("\tDefault card\t... ");
		card = new BlackJackCard();
		assertEquals(card.getValue(), 0);
		System.out.println("OK");
		
		System.out.print("\tNumber card\t... ");
		card = new BlackJackCard(6, "clubs");
		assertEquals(card.getValue(), 6);
		System.out.println("OK");
		
		System.out.print("\tFace card\t... ");
		card = new BlackJackCard(12, "clubs");
		assertEquals(card.getValue(), 10);
		System.out.println("OK");
		
		System.out.print("\tAce\t\t... ");
		card = new BlackJackCard(1, "clubs");
		assertEquals(card.getValue(), 11);
		System.out.println("OK");
	}

	@Test
	public void test_equals() {
		System.out.println("\nTesting BlackJackCard : equals()...");
		BlackJackCard card1, card2;
		
		System.out.print("\tDefault card | Default card\t... ");
		card1 = new BlackJackCard();
		card2 = new BlackJackCard();
		assertTrue(card1.equals(card2));
		System.out.println("OK");
		
		System.out.print("\tDefault card | (Num, Suit)\t... ");
		card1 = new BlackJackCard();
		card2 = new BlackJackCard(4, "diamonds");
		assertFalse(card1.equals(card2));
		System.out.println("OK");

		System.out.print("\tDefault card | (Face, Suit)\t... ");
		card1 = new BlackJackCard();
		card2 = new BlackJackCard(13, "diamonds");
		assertFalse(card1.equals(card2));
		System.out.println("OK");
		
		System.out.print("\t(Num1, Suit1) | (Num1, Suit1)\t... ");
		card1 = new BlackJackCard(3, "hearts");
		card2 = new BlackJackCard(3, "hearts");
		assertTrue(card1.equals(card2));
		System.out.println("OK");

		System.out.print("\t(Num1, Suit1) | (Num1, Suit2)\t... ");
		card1 = new BlackJackCard(7, "spades");
		card2 = new BlackJackCard(7, "diamonds");
		assertFalse(card1.equals(card2));
		System.out.println("OK");
		
		System.out.print("\t(Num1, Suit1) | (Num2, Suit1)\t... ");
		card1 = new BlackJackCard(7, "spades");
		card2 = new BlackJackCard(9, "spades");
		assertFalse(card1.equals(card2));
		System.out.println("OK");
		
		System.out.print("\t(Num1, Suit1) | (Num2, Suit2)\t... ");
		card1 = new BlackJackCard(2, "spades");
		card2 = new BlackJackCard(7, "diamonds");
		assertFalse(card1.equals(card2));
		System.out.println("OK");
		
		System.out.print("\t(Face1, Suit1) | (Face1, Suit1)\t... ");
		card1 = new BlackJackCard(11, "hearts");
		card2 = new BlackJackCard(11, "hearts");
		assertTrue(card1.equals(card2));
		System.out.println("OK");
		
		System.out.print("\t(Face1, Suit1) | (Face1, Suit2)\t... ");
		card1 = new BlackJackCard(11, "hearts");
		card2 = new BlackJackCard(11, "clubs");
		assertFalse(card1.equals(card2));
		System.out.println("OK");
		
		System.out.print("\t(Face1, Suit1) | (Face2, Suit1)\t... ");
		card1 = new BlackJackCard(11, "hearts");
		card2 = new BlackJackCard(13, "hearts");
		assertFalse(card1.equals(card2));
		System.out.println("OK");
		
		System.out.print("\t(Face1, Suit1) | (Face2, Suit2)\t... ");
		card1 = new BlackJackCard(11, "hearts");
		card2 = new BlackJackCard(12, "clubs");
		assertFalse(card1.equals(card2));
		System.out.println("OK");
		
		System.out.print("\t(Ace, Suit1) | (Ace, Suit1)\t... ");
		card1 = new BlackJackCard(1, "clubs");
		card2 = new BlackJackCard(1, "clubs");
		assertTrue(card1.equals(card2));
		System.out.println("OK");
		
		System.out.print("\t(Ace, Suit1) | (Ace, Suit2)\t... ");
		card1 = new BlackJackCard(1, "clubs");
		card2 = new BlackJackCard(1, "diamonds");
		assertFalse(card1.equals(card2));
		System.out.println("OK");
	}
}