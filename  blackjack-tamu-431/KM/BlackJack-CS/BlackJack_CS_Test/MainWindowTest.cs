using BlackJack_CS;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using System.Windows.Markup;

namespace BlackJack_CS_Test
{
	/// <summary>
	///This is a test class for BlackJackCard and is intended
	///to contain all BlackJackCard Unit Tests
	///</summary>
	[TestClass()]
	public class BlackJackCardTest {
		/// <summary>
		///A test for MainWindow Constructor
		///</summary>
		[TestMethod()]
		public void MainWindowConstructorTest() {
			MainWindow target = new MainWindow();
			Assert.Inconclusive("TODO: Implement code to verify target");
		}

		/// <summary>
		///A test for InitializeComponent
		///</summary>
		[TestMethod()]
		public void InitializeComponentTest() {
			MainWindow target = new MainWindow(); // TODO: Initialize to an appropriate value
			target.InitializeComponent();
			Assert.Inconclusive("A method that does not return a value cannot be verified.");
		}

	}
}
