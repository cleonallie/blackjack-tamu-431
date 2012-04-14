package testing;

import org.junit.*;
import static org.junit.Assert.*;
import engine.BlackJackCard;
import engine.BlackJackGame;
import players.Player;
import players.Dealer;

public class BlackJackGameTest {

	@Test
	public void test_initializePlayers() {
		System.out.println("\nTesting BlackJackGame : initializePlayers()...");
		BlackJackGame game = new BlackJackGame(1);
		Player[] players;
		int numPlayers, cash;
		
		numPlayers = 1;
		cash = 100;
		System.out.print("\tNum players: " + numPlayers + "\tStarting cash: " + cash + "\t... ");
		game.initializePlayers(numPlayers, cash);
		players = game.getPlayers();
		assertEquals(players.length, numPlayers);
		for (int i = 0; i < players.length; i++) {
			assertEquals(players[i].getCash(), cash);
		}
		System.out.println("OK");

		numPlayers = 30;
		cash = 10000;
		System.out.print("\tNum players: " + numPlayers + "\tStarting cash: " + cash + "\t... ");
		game.initializePlayers(numPlayers, cash);
		players = game.getPlayers();
		assertEquals(players.length, numPlayers);
		for (int i = 0; i < players.length; i++) {
			assertEquals(players[i].getCash(), cash);
		}
		System.out.println("OK");

		numPlayers = 3;
		cash = 0;
		System.out.print("\tNum players: " + numPlayers + "\tStarting cash: " + cash + "\t... ");
		game.initializePlayers(numPlayers, cash);
		players = game.getPlayers();
		assertEquals(players.length, numPlayers);
		for (int i = 0; i < players.length; i++) {
			assertEquals(players[i].getCash(), cash);
		}
		System.out.println("OK");

		numPlayers = 0;
		cash = 100;
		System.out.print("\tNum players: " + numPlayers + "\tStarting cash: " + cash + "\t... ");
		game.initializePlayers(numPlayers, cash);
		players = game.getPlayers();
		assertEquals(players.length, numPlayers);
		for (int i = 0; i < players.length; i++) {
			assertEquals(players[i].getCash(), cash);
		}
		System.out.println("OK");

		numPlayers = 0;
		cash = 0;
		System.out.print("\tNum players: " + numPlayers + "\tStarting cash: " + cash + "\t... ");
		game.initializePlayers(numPlayers, cash);
		players = game.getPlayers();
		assertEquals(players.length, numPlayers);
		for (int i = 0; i < players.length; i++) {
			assertEquals(players[i].getCash(), cash);
		}
		System.out.println("OK");
		
		numPlayers = 6;
		cash = -10000;
		System.out.print("\tNum players: " + numPlayers + "\tStarting cash: " + cash + "\t... ");
		game.initializePlayers(numPlayers, cash);
		players = game.getPlayers();
		assertEquals("For invalid number of players or cash, player list should be empty.", players.length, 0);
		System.out.println("OK");

		numPlayers = -1;
		cash = 100;
		System.out.print("\tNum players: " + numPlayers + "\tStarting cash: " + cash + "\t... ");
		game.initializePlayers(numPlayers, cash);
		players = game.getPlayers();
		assertEquals("For invalid number of players or cash, player list should be empty.", players.length, 0);
		System.out.println("OK");

		numPlayers = -1;
		cash = -100;
		System.out.print("\tNum players: " + numPlayers + "\tStarting cash: " + cash + "\t... ");
		game.initializePlayers(numPlayers, cash);
		players = game.getPlayers();
		assertEquals("For invalid number of players or cash, player list should be empty.", players.length, 0);
		System.out.println("OK");
	}

	@Test
	public void test_dealFirstTwoCards() {
		System.out.println("\nTesting BlackJackGame : dealFirstTwoCards()...");
		BlackJackGame game = new BlackJackGame(1);
		Player[] players;
		int numPlayers, cash;
		
		numPlayers = 0;
		cash = 100;
		System.out.print("\tNum players = 0\t\tDeck size = 1\t... ");
		game.initializePlayers(numPlayers, cash);
		game.dealFirstCards();
		players = game.getPlayers();
		assertEquals(players.length, 0);
		System.out.println("OK");
		
		game = new BlackJackGame(1);
		numPlayers = 1;
		System.out.print("\tNum players = 1\t\tDeck size = 1\t... ");
		game.initializePlayers(numPlayers, cash);
		game.dealFirstCards();
		players = game.getPlayers();
		assertEquals(players[0].getHandSize(), 2);
		assertTrue(players[0].getHandValue() >= 2);
		assertTrue(players[0].getHandValue() <= 21);
		System.out.println("OK");
		
		game = new BlackJackGame(1);
		numPlayers = 20;
		System.out.print("\tNum players > 1\t\tDeck size = 1\t... ");
		game.initializePlayers(numPlayers, cash);
		game.dealFirstCards();
		players = game.getPlayers();
		for (int i = 0; i < players.length; i++) {
			assertEquals(players[i].getHandSize(), 2);
			assertTrue(players[i].getHandValue() >= 2);
			assertTrue(players[i].getHandValue() <= 21);
		}
		System.out.println("OK");
		
		game = new BlackJackGame(1);
		numPlayers = 35;
		System.out.print("\tNum players > 25\tDeck size = 1\t... ");
		game.initializePlayers(numPlayers, cash);
		game.dealFirstCards();
		players = game.getPlayers();
		for (int i = 0; i < players.length; i++) {
			assertEquals(players[i].getHandSize(), 2);
			assertTrue(players[i].getHandValue() >= 2);
			assertTrue(players[i].getHandValue() <= 21);
		}
		System.out.println("OK");
		
		game = new BlackJackGame(3);
		numPlayers = 30;
		System.out.print("\tNum players > 25\tDeck size > 1\t... ");
		game.initializePlayers(numPlayers, cash);
		game.dealFirstCards();
		players = game.getPlayers();
		for (int i = 0; i < players.length; i++) {
			assertEquals(players[i].getHandSize(), 2);
			assertTrue(players[i].getHandValue() >= 2);
			assertTrue(players[i].getHandValue() <= 21);
		}
		System.out.println("OK");
	}

	@Test
	public void test_determineWinners() {
		System.out.println("\nTesting BlackJackGame : determineWinners()...");
		BlackJackGame game;
		Player[] players;
		Dealer dealer;
		int numPlayers, cash, bet;
		
		// ------------------------------  BEGIN WINS ------------------------------
		System.out.println("\tWINS:");
		// Player has Blackjack, dealer has less than 21
		game = new BlackJackGame(1);
		numPlayers = 1;
		cash = 100;
		bet = 50;
		game.initializePlayers(numPlayers, cash);
		players = game.getPlayers();
		dealer = game.getDealer();
		players[0].setBet(bet);
		players[0].addCardToHand(new BlackJackCard(1, "spades"));
		players[0].addCardToHand(new BlackJackCard(12, "clubs"));
		dealer.addCardToHand(new BlackJackCard(9, "spades"));
		dealer.addCardToHand(new BlackJackCard(4, "diamonds"));
		System.out.println("\tPlayer 1: " + players[0].getHand() + "\t= Blackjack");
		System.out.print("\tDealer: " + dealer.getHand() + "\t< 21\t... ");
		game.determineWinners();
		assertEquals(players[0].getWinCount(), 1);
		assertEquals(players[0].getCash(), cash + ((3 * bet) / 2));
		assertEquals(dealer.getWinCount(), 0);
		System.out.println("OK\n");
		
		// Player has Blackjack, dealer has 21 (but NOT Blackjack)
		game = new BlackJackGame(1);
		numPlayers = 1;
		cash = 100;
		bet = 50;
		game.initializePlayers(numPlayers, cash);
		players = game.getPlayers();
		dealer = game.getDealer();
		players[0].setBet(bet);
		players[0].addCardToHand(new BlackJackCard(1, "spades"));
		players[0].addCardToHand(new BlackJackCard(10, "clubs"));
		dealer.addCardToHand(new BlackJackCard(9, "spades"));
		dealer.addCardToHand(new BlackJackCard(4, "diamonds"));
		dealer.addCardToHand(new BlackJackCard(8, "diamonds"));
		System.out.println("\tPlayer 1: " + players[0].getHand() + "\t\t\t\t\t= Blackjack");
		System.out.print("\tDealer: " + dealer.getHand() + "\t= 21\t... ");
		game.determineWinners();
		assertEquals(players[0].getWinCount(), 1);
		assertEquals(players[0].getCash(), cash + ((3 * bet) / 2));
		assertEquals(dealer.getWinCount(), 0);
		System.out.println("OK\n");
		
		// Player has higher hand than dealer
		game = new BlackJackGame(1);
		numPlayers = 1;
		cash = 100;
		bet = 50;
		game.initializePlayers(numPlayers, cash);
		players = game.getPlayers();
		dealer = game.getDealer();
		players[0].setBet(bet);
		players[0].addCardToHand(new BlackJackCard(10, "spades"));
		players[0].addCardToHand(new BlackJackCard(9, "clubs"));
		dealer.addCardToHand(new BlackJackCard(10, "spades"));
		dealer.addCardToHand(new BlackJackCard(4, "diamonds"));
		System.out.println("\tPlayer 1: " + players[0].getHand() + "\t= " + players[0].getHandValue());
		System.out.print("\tDealer: " + dealer.getHand() + "\t= " + dealer.getHandValue() + "\t... ");
		game.determineWinners();
		assertEquals(players[0].getWinCount(), 1);
		assertEquals(players[0].getCash(), cash + bet);
		assertEquals(dealer.getWinCount(), 0);
		System.out.println("OK\n");
		
		// Dealer busts, player does not
		game = new BlackJackGame(1);
		numPlayers = 1;
		cash = 100;
		bet = 50;
		game.initializePlayers(numPlayers, cash);
		players = game.getPlayers();
		dealer = game.getDealer();
		players[0].setBet(bet);
		players[0].addCardToHand(new BlackJackCard(1, "spades"));
		players[0].addCardToHand(new BlackJackCard(7, "clubs"));
		dealer.addCardToHand(new BlackJackCard(10, "spades"));
		dealer.addCardToHand(new BlackJackCard(4, "diamonds"));
		dealer.addCardToHand(new BlackJackCard(13, "spades"));
		System.out.println("\tPlayer 1: " + players[0].getHand() + "\t\t\t\t<= 21");
		System.out.print("\tDealer: " + dealer.getHand() + "\t> 21\t... ");
		game.determineWinners();
		assertEquals(players[0].getWinCount(), 1);
		assertEquals(players[0].getCash(), cash + bet);
		assertEquals(dealer.getWinCount(), 0);
		System.out.println("OK\n");

		// ------------------------------  BEGIN PUSHES ------------------------------
		System.out.println("\tPUSHES:");
		// Dealer and player have identical hands (not Blackjack)
		game = new BlackJackGame(1);
		numPlayers = 1;
		cash = 100;
		bet = 50;
		game.initializePlayers(numPlayers, cash);
		players = game.getPlayers();
		 dealer = game.getDealer();
		players[0].setBet(bet);
		players[0].addCardToHand(new BlackJackCard(1, "spades"));
		players[0].addCardToHand(new BlackJackCard(1, "hearts"));
		dealer.addCardToHand(new BlackJackCard(1, "hearts"));
		dealer.addCardToHand(new BlackJackCard(1, "spades"));
		System.out.println("\tPlayer 1: " + players[0].getHand() + "\t= " + players[0].getHandValue());
		System.out.print("\tDealer: " + dealer.getHand() + "\t= " + dealer.getHandValue() + "\t... ");
		game.determineWinners();
		assertEquals(players[0].getWinCount(), 0);
		assertEquals(players[0].getCash(), cash);
		assertEquals(dealer.getWinCount(), 0);
		System.out.println("OK\n");
		
		// Dealer and player have different hands, but same hand value (not Blackjack)
		game = new BlackJackGame(1);
		numPlayers = 1;
		cash = 100;
		bet = 50;
		game.initializePlayers(numPlayers, cash);
		players = game.getPlayers();
		dealer = game.getDealer();
		players[0].setBet(bet);
		players[0].addCardToHand(new BlackJackCard(1, "spades"));
		players[0].addCardToHand(new BlackJackCard(7, "hearts"));
		dealer.addCardToHand(new BlackJackCard(8, "clubs"));
		dealer.addCardToHand(new BlackJackCard(12, "diamonds"));
		System.out.println("\tPlayer 1: " + players[0].getHand() + "\t= " + players[0].getHandValue());
		System.out.print("\tDealer: " + dealer.getHand() + "\t= " + dealer.getHandValue() + "\t... ");
		game.determineWinners();
		assertEquals(players[0].getWinCount(), 0);
		assertEquals(players[0].getCash(), cash);
		assertEquals(dealer.getWinCount(), 0);
		System.out.println("OK\n");
		
		// Dealer and player have 21, but neither have Blackjack
		game = new BlackJackGame(1);
		numPlayers = 1;
		cash = 100;
		bet = 50;
		game.initializePlayers(numPlayers, cash);
		players = game.getPlayers();
		dealer = game.getDealer();
		players[0].setBet(bet);
		players[0].addCardToHand(new BlackJackCard(4, "spades"));
		players[0].addCardToHand(new BlackJackCard(7, "hearts"));
		players[0].addCardToHand(new BlackJackCard(12, "hearts"));
		dealer.addCardToHand(new BlackJackCard(8, "clubs"));
		dealer.addCardToHand(new BlackJackCard(12, "diamonds"));
		dealer.addCardToHand(new BlackJackCard(3, "clubs"));
		System.out.println("\tPlayer 1: " + players[0].getHand() + "\t= " + players[0].getHandValue());
		System.out.print("\tDealer: " + dealer.getHand() + "\t= " + dealer.getHandValue() + "\t... ");
		game.determineWinners();
		assertEquals(players[0].getWinCount(), 0);
		assertEquals(players[0].getCash(), cash);
		assertEquals(dealer.getWinCount(), 0);
		System.out.println("OK\n");
		
		// Dealer and player both have Blackjack
		game = new BlackJackGame(1);
		numPlayers = 1;
		cash = 100;
		bet = 50;
		game.initializePlayers(numPlayers, cash);
		players = game.getPlayers();
		dealer = game.getDealer();
		players[0].setBet(bet);
		players[0].addCardToHand(new BlackJackCard(1, "spades"));
		players[0].addCardToHand(new BlackJackCard(13, "hearts"));
		dealer.addCardToHand(new BlackJackCard(1, "clubs"));
		dealer.addCardToHand(new BlackJackCard(11, "diamonds"));
		System.out.println("\tPlayer 1: " + players[0].getHand() + "\t= Blackjack");
		System.out.print("\tDealer: " + dealer.getHand() + "\t= Blackjack\t... ");
		game.determineWinners();
		assertEquals(players[0].getWinCount(), 0);
		assertEquals(players[0].getCash(), cash);
		assertEquals(dealer.getWinCount(), 0);
		System.out.println("OK\n");
		
		// ------------------------------  BEGIN LOSSES ------------------------------
		System.out.println("\tLOSSES:");
		// Player busts, dealer does not
		game = new BlackJackGame(1);
		numPlayers = 1;
		cash = 100;
		bet = 50;
		game.initializePlayers(numPlayers, cash);
		players = game.getPlayers();
		dealer = game.getDealer();
		players[0].setBet(bet);
		players[0].addCardToHand(new BlackJackCard(5, "spades"));
		players[0].addCardToHand(new BlackJackCard(7, "hearts"));
		players[0].addCardToHand(new BlackJackCard(12, "hearts"));
		dealer.addCardToHand(new BlackJackCard(8, "clubs"));
		dealer.addCardToHand(new BlackJackCard(12, "diamonds"));
		System.out.println("\tPlayer 1: " + players[0].getHand() + "\t> 21");
		System.out.print("\tDealer: " + dealer.getHand() + "\t\t\t\t\t<= 21\t... ");
		game.determineWinners();
		assertEquals(players[0].getWinCount(), 0);
		assertEquals(players[0].getCash(), cash - bet);
		assertEquals(dealer.getWinCount(), 1);
		System.out.println("OK\n");
		
		// Player busts, dealer busts
		game = new BlackJackGame(1);
		numPlayers = 1;
		cash = 100;
		bet = 50;
		game.initializePlayers(numPlayers, cash);
		players = game.getPlayers();
		dealer = game.getDealer();
		players[0].setBet(bet);
		players[0].addCardToHand(new BlackJackCard(9, "spades"));
		players[0].addCardToHand(new BlackJackCard(1, "hearts"));
		players[0].addCardToHand(new BlackJackCard(13, "hearts"));
		players[0].addCardToHand(new BlackJackCard(4, "clubs"));
		dealer.addCardToHand(new BlackJackCard(8, "clubs"));
		dealer.addCardToHand(new BlackJackCard(12, "hearts"));
		dealer.addCardToHand(new BlackJackCard(7, "clubs"));
		System.out.println("\tPlayer 1: " + players[0].getHand() + "\t> 21");
		System.out.print("\tDealer: " + dealer.getHand() + "\t\t\t\t\t> 21\t... ");
		game.determineWinners();
		assertEquals(players[0].getWinCount(), 0);
		assertEquals(players[0].getCash(), cash - bet);
		assertEquals(dealer.getWinCount(), 1);
		System.out.println("OK\n");
		
		// Player's hand is less than dealer's
		game = new BlackJackGame(1);
		numPlayers = 1;
		cash = 100;
		bet = 50;
		game.initializePlayers(numPlayers, cash);
		players = game.getPlayers();
		dealer = game.getDealer();
		players[0].setBet(bet);
		players[0].addCardToHand(new BlackJackCard(9, "spades"));
		players[0].addCardToHand(new BlackJackCard(4, "clubs"));
		dealer.addCardToHand(new BlackJackCard(8, "clubs"));
		dealer.addCardToHand(new BlackJackCard(12, "diamonds"));
		System.out.println("\tPlayer 1: " + players[0].getHand() + "\t= " + players[0].getHandValue());
		System.out.print("\tDealer: " + dealer.getHand() + "\t= " + dealer.getHandValue() + "\t... ");
		game.determineWinners();
		assertEquals(players[0].getWinCount(), 0);
		assertEquals(players[0].getCash(), cash - bet);
		assertEquals(dealer.getWinCount(), 1);
		System.out.println("OK\n");
	}
}
