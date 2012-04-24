using BlackJack_CS;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using System.Windows.Markup;
using player;
using engine;

namespace BlackJack_CS_Test {
	[TestClass]
	public class BlackJackGameTest {

		[TestMethod]
		public void InitializePlayersTest() {
			Console.WriteLine("\nTesting BlackJackGame : initializePlayers()...");
			BlackJackGame game = new BlackJackGame(1);
			Player[] players;
			int numPlayers, cash;
		
			numPlayers = 1;
			cash = 100;
			Console.Write("\tNum players: " + numPlayers + "\tStarting cash: " + cash + "\t... ");
			game.initializePlayers(numPlayers, cash);
			players = game.getPlayers();
			Assert.AreEqual(numPlayers, players.Length);
			for (int i = 0; i < players.Length; i++) {
				Assert.AreEqual(cash, players[i].getCash());
			}
			Console.WriteLine("OK");

			numPlayers = 30;
			cash = 10000;
			Console.Write("\tNum players: " + numPlayers + "\tStarting cash: " + cash + "\t... ");
			game.initializePlayers(numPlayers, cash);
			players = game.getPlayers();
			Assert.AreEqual(numPlayers, players.Length);
			for (int i = 0; i < players.Length; i++) {
				Assert.AreEqual(cash, players[i].getCash());
			}
			Console.WriteLine("OK");

			numPlayers = 3;
			cash = 0;
			Console.Write("\tNum players: " + numPlayers + "\tStarting cash: " + cash + "\t... ");
			game.initializePlayers(numPlayers, cash);
			players = game.getPlayers();
			Assert.AreEqual(numPlayers, players.Length);
			for (int i = 0; i < players.Length; i++) {
				Assert.AreEqual(cash, players[i].getCash());
			}
			Console.WriteLine("OK");

			numPlayers = 0;
			cash = 100;
			Console.Write("\tNum players: " + numPlayers + "\tStarting cash: " + cash + "\t... ");
			game.initializePlayers(numPlayers, cash);
			players = game.getPlayers();
			Assert.AreEqual(numPlayers, players.Length);
			for (int i = 0; i < players.Length; i++) {
				Assert.AreEqual(cash, players[i].getCash());
			}
			Console.WriteLine("OK");

			numPlayers = 0;
			cash = 0;
			Console.Write("\tNum players: " + numPlayers + "\tStarting cash: " + cash + "\t... ");
			game.initializePlayers(numPlayers, cash);
			players = game.getPlayers();
			Assert.AreEqual(numPlayers, players.Length);
			for (int i = 0; i < players.Length; i++) {
				Assert.AreEqual(cash, players[i].getCash());
			}
			Console.WriteLine("OK");
		
			numPlayers = 6;
			cash = -10000;
			Console.Write("\tNum players: " + numPlayers + "\tStarting cash: " + cash + "\t... ");
			game.initializePlayers(numPlayers, cash);
			players = game.getPlayers();
			Assert.AreEqual(0, players.Length);
			Console.WriteLine("OK");

			numPlayers = -1;
			cash = 100;
			Console.Write("\tNum players: " + numPlayers + "\tStarting cash: " + cash + "\t... ");
			game.initializePlayers(numPlayers, cash);
			players = game.getPlayers();
			Assert.AreEqual(0, players.Length);
			Console.WriteLine("OK");

			numPlayers = -1;
			cash = -100;
			Console.Write("\tNum players: " + numPlayers + "\tStarting cash: " + cash + "\t... ");
			game.initializePlayers(numPlayers, cash);
			players = game.getPlayers();
			Assert.AreEqual(0, players.Length);
			Console.WriteLine("OK");
		}

		[TestMethod]
		public void DealFirstTwoCardsTest() {
			Console.WriteLine("\nTesting BlackJackGame : dealFirstTwoCards()...");
			BlackJackGame game = new BlackJackGame(1);
			Player[] players;
			int numPlayers, cash;
		
			numPlayers = 0;
			cash = 100;
			Console.Write("\tNum players = 0\t\tDeck size = 1\t... ");
			game.initializePlayers(numPlayers, cash);
			game.dealFirstCards();
			players = game.getPlayers();
			Assert.AreEqual(0, players.Length);
			Console.WriteLine("OK");
		
			game = new BlackJackGame(1);
			numPlayers = 1;
			Console.Write("\tNum players = 1\t\tDeck size = 1\t... ");
			game.initializePlayers(numPlayers, cash);
			game.dealFirstCards();
			players = game.getPlayers();
			Assert.AreEqual(2, players[0].getHandSize());
			Assert.IsTrue(players[0].getHandValue() >= 2);
			Assert.IsTrue(players[0].getHandValue() <= 21);
			Console.WriteLine("OK");
		
			game = new BlackJackGame(1);
			numPlayers = 20;
			Console.Write("\tNum players > 1\t\tDeck size = 1\t... ");
			game.initializePlayers(numPlayers, cash);
			game.dealFirstCards();
			players = game.getPlayers();
			for (int i = 0; i < players.Length; i++) {
				Assert.AreEqual(2, players[i].getHandSize());
				Assert.IsTrue(players[i].getHandValue() >= 2);
				Assert.IsTrue(players[i].getHandValue() <= 21);
			}
			Console.WriteLine("OK");
		
			game = new BlackJackGame(1);
			numPlayers = 35;
			Console.Write("\tNum players > 25\tDeck size = 1\t... ");
			game.initializePlayers(numPlayers, cash);
			game.dealFirstCards();
			players = game.getPlayers();
			for (int i = 0; i < players.Length; i++) {
				Assert.AreEqual(2, players[i].getHandSize());
				Assert.IsTrue(players[i].getHandValue() >= 2);
				Assert.IsTrue(players[i].getHandValue() <= 21);
			}
			Console.WriteLine("OK");
		
			game = new BlackJackGame(3);
			numPlayers = 30;
			Console.Write("\tNum players > 25\tDeck size > 1\t... ");
			game.initializePlayers(numPlayers, cash);
			game.dealFirstCards();
			players = game.getPlayers();
			for (int i = 0; i < players.Length; i++) {
				Assert.AreEqual(2, players[i].getHandSize());
				Assert.IsTrue(players[i].getHandValue() >= 2);
				Assert.IsTrue(players[i].getHandValue() <= 21);
			}
			Console.WriteLine("OK");
		}
		
		[TestMethod]
		public void DetermineWinnersTest() {
			Console.WriteLine("\nTesting BlackJackGame : determineWinners()...");
			BlackJackGame game;
			Player[] players;
			Dealer dealer;
			int numPlayers, cash, bet;
		
			// ------------------------------  BEGIN WINS ------------------------------
			Console.WriteLine("\tWINS:");
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
			Console.WriteLine("\tPlayer 1: " + players[0].getHand() + "\t= Blackjack");
			Console.Write("\tDealer: " + dealer.getHand() + "\t< 21\t... ");
			game.determineWinners();
			Assert.AreEqual(1, players[0].getWinCount());
			Assert.AreEqual(cash + ((3 * bet) / 2), players[0].getCash());
			Assert.AreEqual(0, dealer.getWinCount());
			Console.WriteLine("OK\n");
		
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
			Console.WriteLine("\tPlayer 1: " + players[0].getHand() + "\t\t\t\t\t= Blackjack");
			Console.Write("\tDealer: " + dealer.getHand() + "\t= 21\t... ");
			game.determineWinners();
			Assert.AreEqual(1, players[0].getWinCount());
			Assert.AreEqual(cash + ((3 * bet) / 2), players[0].getCash());
			Assert.AreEqual(0, dealer.getWinCount());
			Console.WriteLine("OK\n");
		
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
			Console.WriteLine("\tPlayer 1: " + players[0].getHand() + "\t= " + players[0].getHandValue());
			Console.Write("\tDealer: " + dealer.getHand() + "\t= " + dealer.getHandValue() + "\t... ");
			game.determineWinners();
			Assert.AreEqual(1, players[0].getWinCount());
			Assert.AreEqual(cash + bet, players[0].getCash());
			Assert.AreEqual(0, dealer.getWinCount());
			Console.WriteLine("OK\n");
		
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
			Console.WriteLine("\tPlayer 1: " + players[0].getHand() + "\t\t\t\t<= 21");
			Console.Write("\tDealer: " + dealer.getHand() + "\t> 21\t... ");
			game.determineWinners();
			Assert.AreEqual(1, players[0].getWinCount());
			Assert.AreEqual(cash + bet, players[0].getCash());
			Assert.AreEqual(0, dealer.getWinCount());
			Console.WriteLine("OK\n");

			// ------------------------------  BEGIN PUSHES ------------------------------
			Console.WriteLine("\tPUSHES:");
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
			Console.WriteLine("\tPlayer 1: " + players[0].getHand() + "\t= " + players[0].getHandValue());
			Console.Write("\tDealer: " + dealer.getHand() + "\t= " + dealer.getHandValue() + "\t... ");
			game.determineWinners();
			Assert.AreEqual(0, players[0].getWinCount());
			Assert.AreEqual(cash, players[0].getCash());
			Assert.AreEqual(0, dealer.getWinCount());
			Console.WriteLine("OK\n");
		
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
			Console.WriteLine("\tPlayer 1: " + players[0].getHand() + "\t= " + players[0].getHandValue());
			Console.Write("\tDealer: " + dealer.getHand() + "\t= " + dealer.getHandValue() + "\t... ");
			game.determineWinners();
			Assert.AreEqual(0, players[0].getWinCount());
			Assert.AreEqual(cash, players[0].getCash());
			Assert.AreEqual(0, dealer.getWinCount());
			Console.WriteLine("OK\n");
		
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
			Console.WriteLine("\tPlayer 1: " + players[0].getHand() + "\t= " + players[0].getHandValue());
			Console.Write("\tDealer: " + dealer.getHand() + "\t= " + dealer.getHandValue() + "\t... ");
			game.determineWinners();
			Assert.AreEqual(0, players[0].getWinCount());
			Assert.AreEqual(cash, players[0].getCash());
			Assert.AreEqual(0, dealer.getWinCount());
			Console.WriteLine("OK\n");
		
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
			Console.WriteLine("\tPlayer 1: " + players[0].getHand() + "\t= Blackjack");
			Console.Write("\tDealer: " + dealer.getHand() + "\t= Blackjack\t... ");
			game.determineWinners();
			Assert.AreEqual(0, players[0].getWinCount());
			Assert.AreEqual(cash, players[0].getCash());
			Assert.AreEqual(0, dealer.getWinCount());
			Console.WriteLine("OK\n");
		
			// ------------------------------  BEGIN LOSSES ------------------------------
			Console.WriteLine("\tLOSSES:");
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
			Console.WriteLine("\tPlayer 1: " + players[0].getHand() + "\t> 21");
			Console.Write("\tDealer: " + dealer.getHand() + "\t\t\t\t\t<= 21\t... ");
			game.determineWinners();
			Assert.AreEqual(0, players[0].getWinCount());
			Assert.AreEqual(cash - bet, players[0].getCash());
			Assert.AreEqual(1, dealer.getWinCount());
			Console.WriteLine("OK\n");
		
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
			Console.WriteLine("\tPlayer 1: " + players[0].getHand() + "\t> 21");
			Console.Write("\tDealer: " + dealer.getHand() + "\t\t\t\t\t> 21\t... ");
			game.determineWinners();
			Assert.AreEqual(0, players[0].getWinCount());
			Assert.AreEqual(cash - bet, players[0].getCash());
			Assert.AreEqual(1, dealer.getWinCount());
			Console.WriteLine("OK\n");
		
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
			Console.WriteLine("\tPlayer 1: " + players[0].getHand() + "\t= " + players[0].getHandValue());
			Console.Write("\tDealer: " + dealer.getHand() + "\t= " + dealer.getHandValue() + "\t... ");
			game.determineWinners();
			Assert.AreEqual(0, players[0].getWinCount());
			Assert.AreEqual(cash - bet, players[0].getCash());
			Assert.AreEqual(1, dealer.getWinCount());
			Console.WriteLine("OK\n");
		}
	}
}
