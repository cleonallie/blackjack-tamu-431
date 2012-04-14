package testing;

import org.junit.*;
import static org.junit.Assert.*;
import engine.BlackJackCard;
import players.Player;

public class PlayerTest {

	@Test
	public void test_canPlay() {
		System.out.println("\nTesting Player : canPlay()...");
		Player player = new Player("John Doe");
		
		System.out.print("\tPlayer cash > 0\t... ");
		player.setCash(100);
		assertTrue(player.canPlay());
		System.out.println("OK");
		
		System.out.print("\tPlayer cash = 0\t... ");
		player.setCash(0);
		assertFalse(player.canPlay());
		System.out.println("OK");
		
		System.out.print("\tPlayer cash < 0\t... ");
		player.setCash(-235);
		assertFalse(player.canPlay());
		System.out.println("OK");
	}
	
	@Test
	public void test_showCard() {
		System.out.println("\nTesting Player : showCard()...");
		Player player = new Player("John Doe");
		
		System.out.print("\tPlayer hand size = 0\t... ");
		assertEquals(player.showCard(), null);
		System.out.println("OK");
		
		System.out.print("\tPlayer hand size = 1\t... ");
		BlackJackCard card1 = new BlackJackCard(5, "hearts");
		player.addCardToHand(card1);
		assertTrue(player.showCard().equals(card1));
		System.out.println("OK");
		
		System.out.print("\tPlayer hand size > 1\t... ");
		player = new Player("John Doe");
		BlackJackCard card2 = new BlackJackCard(10, "spades");
		BlackJackCard card3 = new BlackJackCard(2, "spades");
		BlackJackCard card4 = new BlackJackCard(1, "diamonds");
		player.addCardToHand(card1);
		player.addCardToHand(card2);
		player.addCardToHand(card3);
		player.addCardToHand(card4);
		assertTrue(player.showCard().equals(card1));
		System.out.println("OK");
	}

	@Test
	public void test_showCardVal() {
		System.out.println("\nTesting Player : showCardVal()...");
		Player player;
		BlackJackCard card;
		
		System.out.print("\tCard is: Ace\t\t... ");
		player = new Player("John Doe");
		card = new BlackJackCard(1, "hearts");
		player.addCardToHand(card);
		assertEquals(player.showCardVal(), 11);
		System.out.println("OK");

		System.out.print("\tCard is: Number card\t... ");
		player = new Player("John Doe");
		card = new BlackJackCard(7, "hearts");
		player.addCardToHand(card);
		assertEquals(player.showCardVal(), 7);
		System.out.println("OK");
		
		System.out.print("\tCard is: Face card\t... ");
		player = new Player("John Doe");
		card = new BlackJackCard(12, "hearts");
		player.addCardToHand(card);
		assertEquals(player.showCardVal(), 10);
		System.out.println("OK");
	}

	@Test
	public void test_setBet() {
		System.out.println("\nTesting Player : setBet()...");
		Player player = new Player("John Doe");
		player.setCash(100);
		
		System.out.print("\tBet < cash\t... ");
		player.setBet(50);
		assertEquals(player.getBet(), 50);
		System.out.println("OK");
		
		System.out.print("\tBet = cash\t... ");
		player.setBet(100);
		assertEquals(player.getBet(), 100);
		System.out.println("OK");
		
		System.out.print("\tBet > cash\t... ");
		player.setBet(250);
		assertEquals(player.getBet(), 100);
		System.out.println("OK");

		System.out.print("\tBet < 0\t\t... ");
		player.setBet(-250);
		assertEquals(player.getBet(), 0);
		System.out.println("OK");
	}

	@Test
	public void test_getHandValue() {
		System.out.println("\nTesting Player : getHandValue()...");
		Player player = new Player();
		
		System.out.print("\tPlayer hand size = 0\t\t... ");
		assertEquals(player.getHandValue(), 0);
		System.out.println("OK");
		
		System.out.print("\tPlayer hand size = 1 (Non-Ace)\t... ");
		BlackJackCard card1 = new BlackJackCard(5, "hearts");
		player.addCardToHand(card1);
		assertEquals(player.getHandValue(), 5);
		System.out.println("OK");
		
		System.out.print("\tPlayer hand size = 1 (Ace)\t... ");
		player = new Player();
		card1 = new BlackJackCard(1, "hearts");
		player.addCardToHand(card1);
		assertEquals(player.getHandValue(), 11);
		System.out.println("OK");		
		
		System.out.print("\tAll number cards\t\t... ");
		player = new Player();
		card1 = new BlackJackCard(10, "spades");
		BlackJackCard card2 = new BlackJackCard(2, "spades");
		BlackJackCard card3 = new BlackJackCard(7, "diamonds");
		player.addCardToHand(card1);
		player.addCardToHand(card2);
		player.addCardToHand(card3);
		assertEquals(player.getHandValue(), 19);
		System.out.println("OK");
		
		System.out.print("\tNumber and face cards\t\t... ");
		player = new Player();
		card1 = new BlackJackCard(11, "spades");
		card2 = new BlackJackCard(12, "spades");
		card3 = new BlackJackCard(7, "clubs");
		player.addCardToHand(card1);
		player.addCardToHand(card2);
		player.addCardToHand(card3);
		assertEquals(player.getHandValue(), 27);
		System.out.println("OK");
		
		System.out.print("\tMixed (Ace as 11)\t\t... ");
		player = new Player();
		card1 = new BlackJackCard(1, "spades");
		card2 = new BlackJackCard(7, "diamonds");
		player.addCardToHand(card1);
		player.addCardToHand(card2);
		assertEquals(player.getHandValue(), 18);
		System.out.println("OK");
		
		System.out.print("\tMixed (Ace as 1)\t\t... ");
		player = new Player();
		card1 = new BlackJackCard(1, "hearts");
		card2 = new BlackJackCard(5, "clubs");
		card3 = new BlackJackCard(13, "spades");
		player.addCardToHand(card1);
		player.addCardToHand(card2);
		player.addCardToHand(card3);
		assertEquals(player.getHandValue(), 16);
		System.out.println("OK");
		
		System.out.print("\tMixed (Multiple aces)\t\t... ");
		player = new Player();
		card1 = new BlackJackCard(1, "hearts");
		card2 = new BlackJackCard(9, "clubs");
		card3 = new BlackJackCard(1, "spades");
		BlackJackCard card4 = new BlackJackCard(1, "clubs");
		BlackJackCard card5 = new BlackJackCard(10, "clubs");
		player.addCardToHand(card1);
		player.addCardToHand(card2);
		player.addCardToHand(card3);
		player.addCardToHand(card4);
		player.addCardToHand(card5);
		assertEquals(player.getHandValue(), 22);
		System.out.println("OK");
	}
}