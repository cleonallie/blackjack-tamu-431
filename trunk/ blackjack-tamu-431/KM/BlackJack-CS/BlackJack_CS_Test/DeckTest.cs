using BlackJack_CS;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using System.Windows.Markup;
using engine;

namespace BlackJack_CS_Test
{
	[TestClass]
	public class DeckTest {

		[TestMethod]
		public void NextCardTest() {
			Console.WriteLine("\nTesting Deck : NextCard()...");
			Deck deck;
		
			Console.Write("\tBeginning of deck\t... ");
			deck = new Deck();
			Card card = deck.nextCard();
			Assert.IsFalse(card.equals(null));
			Console.WriteLine("OK");
		
			Console.Write("\tMiddle of deck\t\t... ");
			deck = new Deck();
			for (int i = 0; i < deck.size() / 2; i++) {
				card = deck.nextCard();
			}
			Assert.IsFalse(card.equals(null));
			Console.WriteLine("OK");
		
			Console.Write("\tBeyond end of deck\t... ");
			deck = new Deck();
			for (int i = 0; i < deck.size(); i++) {
				card = deck.nextCard();
			}
			card = deck.nextCard();
			Assert.AreEqual(null, card);
			Console.WriteLine("OK");
		}
	}
}
