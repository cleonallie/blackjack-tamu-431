using BlackJack_CS;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using System.Windows.Markup;
using engine;

namespace BlackJack_CS_Test
{
	[TestClass]
	public class BlackJackCardTest {

		[TestMethod]
		public void GetValueTest() {
			Console.WriteLine("\nTesting BlackJackCard : GetValue()...");
			BlackJackCard card;

			Console.Write("\tDefault card\t... ");
			card = new BlackJackCard();
			Assert.AreEqual(0, card.getValue());
			Console.WriteLine("OK");

			Console.Write("\tNumber card\t... ");
			card = new BlackJackCard(6, "clubs");
			Assert.AreEqual(6, card.getValue());
			Console.WriteLine("OK");

			Console.Write("\tFace card\t... ");
			card = new BlackJackCard(12, "clubs");
			Assert.AreEqual(10, card.getValue());
			Console.WriteLine("OK");

			Console.Write("\tAce\t\t... ");
			card = new BlackJackCard(1, "clubs");
			Assert.AreEqual(11, card.getValue());
			Console.WriteLine("OK");
		}

		[TestMethod]
		public void EqualsTest() {
			Console.WriteLine("\nTesting BlackJackCard : Equals()...");
			BlackJackCard card1, card2;

			Console.Write("\tDefault card | Default card\t... ");
			card1 = new BlackJackCard();
			card2 = new BlackJackCard();
			Assert.IsTrue(card1.equals(card2));
			Console.WriteLine("OK");

			Console.Write("\tDefault card | (Num, Suit)\t... ");
			card1 = new BlackJackCard();
			card2 = new BlackJackCard(4, "diamonds");
			Assert.IsFalse(card1.equals(card2));
			Console.WriteLine("OK");

			Console.Write("\tDefault card | (Face, Suit)\t... ");
			card1 = new BlackJackCard();
			card2 = new BlackJackCard(13, "diamonds");
			Assert.IsFalse(card1.equals(card2));
			Console.WriteLine("OK");

			Console.Write("\t(Num1, Suit1) | (Num1, Suit1)\t... ");
			card1 = new BlackJackCard(3, "hearts");
			card2 = new BlackJackCard(3, "hearts");
			Assert.IsTrue(card1.equals(card2));
			Console.WriteLine("OK");

			Console.Write("\t(Num1, Suit1) | (Num1, Suit2)\t... ");
			card1 = new BlackJackCard(7, "spades");
			card2 = new BlackJackCard(7, "diamonds");
			Assert.IsFalse(card1.equals(card2));
			Console.WriteLine("OK");

			Console.Write("\t(Num1, Suit1) | (Num2, Suit1)\t... ");
			card1 = new BlackJackCard(7, "spades");
			card2 = new BlackJackCard(9, "spades");
			Assert.IsFalse(card1.equals(card2));
			Console.WriteLine("OK");

			Console.Write("\t(Num1, Suit1) | (Num2, Suit2)\t... ");
			card1 = new BlackJackCard(2, "spades");
			card2 = new BlackJackCard(7, "diamonds");
			Assert.IsFalse(card1.equals(card2));
			Console.WriteLine("OK");

			Console.Write("\t(Face1, Suit1) | (Face1, Suit1)\t... ");
			card1 = new BlackJackCard(11, "hearts");
			card2 = new BlackJackCard(11, "hearts");
			Assert.IsTrue(card1.equals(card2));
			Console.WriteLine("OK");

			Console.Write("\t(Face1, Suit1) | (Face1, Suit2)\t... ");
			card1 = new BlackJackCard(11, "hearts");
			card2 = new BlackJackCard(11, "clubs");
			Assert.IsFalse(card1.equals(card2));
			Console.WriteLine("OK");

			Console.Write("\t(Face1, Suit1) | (Face2, Suit1)\t... ");
			card1 = new BlackJackCard(11, "hearts");
			card2 = new BlackJackCard(13, "hearts");
			Assert.IsFalse(card1.equals(card2));
			Console.WriteLine("OK");

			Console.Write("\t(Face1, Suit1) | (Face2, Suit2)\t... ");
			card1 = new BlackJackCard(11, "hearts");
			card2 = new BlackJackCard(12, "clubs");
			Assert.IsFalse(card1.equals(card2));
			Console.WriteLine("OK");

			Console.Write("\t(Ace, Suit1) | (Ace, Suit1)\t... ");
			card1 = new BlackJackCard(1, "clubs");
			card2 = new BlackJackCard(1, "clubs");
			Assert.IsTrue(card1.equals(card2));
			Console.WriteLine("OK");

			Console.Write("\t(Ace, Suit1) | (Ace, Suit2)\t... ");
			card1 = new BlackJackCard(1, "clubs");
			card2 = new BlackJackCard(1, "diamonds");
			Assert.IsFalse(card1.equals(card2));
			Console.WriteLine("OK");
		}
	}
}
