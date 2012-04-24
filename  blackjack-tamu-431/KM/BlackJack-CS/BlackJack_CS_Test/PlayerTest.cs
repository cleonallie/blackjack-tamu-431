using BlackJack_CS;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using System.Windows.Markup;
using player;
using engine;

namespace BlackJack_CS_Test {
	[TestClass]
	public class PlayerTest {

		[TestMethod]
		public void CanPlayTest() {
			Console.WriteLine("\nTesting Player : CanPlay()...");
			Player player = new Player("John Doe");
		
			Console.Write("\tPlayer cash > 0\t... ");
			player.setCash(100);
			Assert.IsTrue(player.canPlay());
			Console.WriteLine("OK");
		
			Console.Write("\tPlayer cash = 0\t... ");
			player.setCash(0);
			Assert.IsFalse(player.canPlay());
			Console.WriteLine("OK");
		
			Console.Write("\tPlayer cash < 0\t... ");
			player.setCash(-235);
			Assert.IsFalse(player.canPlay());
			Console.WriteLine("OK");
		}

		[TestMethod]
		public void ShowCardTest() {
			Console.WriteLine("\nTesting Player : ShowCard()...");
			Player player = new Player("John Doe");
		
			Console.Write("\tPlayer hand size = 0\t... ");
			Assert.AreEqual(null, player.showCard());
			Console.WriteLine("OK");
		
			Console.Write("\tPlayer hand size = 1\t... ");
			BlackJackCard card1 = new BlackJackCard(5, "hearts");
			player.addCardToHand(card1);
			Assert.IsTrue(player.showCard().equals(card1));
			Console.WriteLine("OK");
		
			Console.Write("\tPlayer hand size > 1\t... ");
			player = new Player("John Doe");
			BlackJackCard card2 = new BlackJackCard(10, "spades");
			BlackJackCard card3 = new BlackJackCard(2, "spades");
			BlackJackCard card4 = new BlackJackCard(1, "diamonds");
			player.addCardToHand(card1);
			player.addCardToHand(card2);
			player.addCardToHand(card3);
			player.addCardToHand(card4);
			Assert.IsTrue(player.showCard().equals(card1));
			Console.WriteLine("OK");
		}

		[TestMethod]
		public void ShowCardValTest() {
			Console.WriteLine("\nTesting Player : ShowCardVal()...");
			Player player;
			BlackJackCard card;
		
			Console.Write("\tCard is: Ace\t\t... ");
			player = new Player();
			card = new BlackJackCard(1, "hearts");
			player.addCardToHand(card);
			Assert.AreEqual(11, player.showCardVal());
			Console.WriteLine("OK");

			Console.Write("\tCard is: Number card\t... ");
			player = new Player();
			card = new BlackJackCard(7, "hearts");
			player.addCardToHand(card);
			Assert.AreEqual(7, player.showCardVal());
			Console.WriteLine("OK");
		
			Console.Write("\tCard is: Face card\t... ");
			player = new Player();
			card = new BlackJackCard(12, "hearts");
			player.addCardToHand(card);
			Assert.AreEqual(10, player.showCardVal());
			Console.WriteLine("OK");
		}
		
		[TestMethod]
		public void SetBetTest() {
			Console.WriteLine("\nTesting Player : SetBet()...");
			Player player = new Player("John Doe");
			player.setCash(100);
		
			Console.Write("\tBet < cash\t... ");
			player.setBet(50);
			Assert.AreEqual(50, player.getBet());
			Console.WriteLine("OK");
		
			Console.Write("\tBet = cash\t... ");
			player.setBet(100);
			Assert.AreEqual(100, player.getBet());
			Console.WriteLine("OK");
		
			Console.Write("\tBet > cash\t... ");
			player.setBet(250);
			Assert.AreEqual(100, player.getBet());
			Console.WriteLine("OK");

			Console.Write("\tBet < 0\t\t... ");
			player.setBet(-250);
			Assert.AreEqual(0, player.getBet());
			Console.WriteLine("OK");
		}

		[TestMethod]
		public void GetHandValueTest() {
			Console.WriteLine("\nTesting Player : GetHandValue()...");
			Player player = new Player();
		
			Console.Write("\tPlayer hand size = 0\t\t... ");
			Assert.AreEqual(0, player.getHandValue());
			Console.WriteLine("OK");
		
			Console.Write("\tPlayer hand size = 1 (Non-Ace)\t... ");
			BlackJackCard card1 = new BlackJackCard(5, "hearts");
			player.addCardToHand(card1);
			Assert.AreEqual(5, player.getHandValue());
			Console.WriteLine("OK");
		
			Console.Write("\tPlayer hand size = 1 (Ace)\t... ");
			player = new Player();
			card1 = new BlackJackCard(1, "hearts");
			player.addCardToHand(card1);
			Assert.AreEqual(11, player.getHandValue());
			Console.WriteLine("OK");		
		
			Console.Write("\tAll number cards\t\t... ");
			player = new Player();
			card1 = new BlackJackCard(10, "spades");
			BlackJackCard card2 = new BlackJackCard(2, "spades");
			BlackJackCard card3 = new BlackJackCard(7, "diamonds");
			player.addCardToHand(card1);
			player.addCardToHand(card2);
			player.addCardToHand(card3);
			Assert.AreEqual(19, player.getHandValue());
			Console.WriteLine("OK");
		
			Console.Write("\tNumber and face cards\t\t... ");
			player = new Player();
			card1 = new BlackJackCard(11, "spades");
			card2 = new BlackJackCard(12, "spades");
			card3 = new BlackJackCard(7, "clubs");
			player.addCardToHand(card1);
			player.addCardToHand(card2);
			player.addCardToHand(card3);
			Assert.AreEqual(27, player.getHandValue());
			Console.WriteLine("OK");
		
			Console.Write("\tMixed (Ace as 11)\t\t... ");
			player = new Player();
			card1 = new BlackJackCard(1, "spades");
			card2 = new BlackJackCard(7, "diamonds");
			player.addCardToHand(card1);
			player.addCardToHand(card2);
			Assert.AreEqual(18, player.getHandValue());
			Console.WriteLine("OK");
		
			Console.Write("\tMixed (Ace as 1)\t\t... ");
			player = new Player();
			card1 = new BlackJackCard(1, "hearts");
			card2 = new BlackJackCard(5, "clubs");
			card3 = new BlackJackCard(13, "spades");
			player.addCardToHand(card1);
			player.addCardToHand(card2);
			player.addCardToHand(card3);
			Assert.AreEqual(16, player.getHandValue());
			Console.WriteLine("OK");
		
			Console.Write("\tMixed (Multiple aces)\t\t... ");
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
			Assert.AreEqual(22, player.getHandValue());
			Console.WriteLine("OK");
		}
	}
}
