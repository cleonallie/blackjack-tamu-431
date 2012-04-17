using System;
using System.Collections.Generic;
using player;

namespace engine {

public class BlackJackGame
{
	private Dealer dealer;
	//private Scanner keyboard = new Scanner(System.in);
    private int numPlayers = 0;
	private int dealerWins = 0;
	private Player[] players;
	private bool allPlayersBust;

	public BlackJackGame(int numberOfDecks)
	{
		dealer = new Dealer(numberOfDecks);
	}

	/**
	 * Get the list of players involved in this game.
	 * @return Array of Player objects
	 */
	public Player[] getPlayers() {
		return players;
	}
	
	public Dealer getDealer() {
		return dealer;
	}
	
	/**
	 * Initialize the list of players and give them all the specified amount of starting cash.
	 * @param numPlayers Number of players involved in this game
	 * @param startingCash Amount of starting cash for each player
	 */
	public void initializePlayers(int numPlayers, int startingCash)
	{
		if (numPlayers < 1 || startingCash < 0) {
			players = new Player[0];
			return;
		}
		players = new Player[numPlayers];
		for (int player = 0; player < numPlayers; player++) {
			players[player] = new Player("\"Player " + (player+1) + "\"");
			players[player].setCash(startingCash);
			players[player].setWinCount(0);
		}
	}

	/**
	 * Decide how many players will play and initialize each of them.
	 */
	public void initializePlayers_Console()
	{
        int startCash;
		Console.WriteLine("How many players will there be?");
        string input = Console.ReadLine();
        
        while (!int.TryParse(input, out numPlayers)){
            Console.WriteLine("That is not a valid entry");
                input = Console.ReadLine();
         }
		
		// Set starting cash
		Console.WriteLine("\nHow much money will each player start with?");
		Console.Write("$");
        string input2 = Console.ReadLine();

        while (!int.TryParse(input2, out startCash))
        {
            Console.WriteLine("That is not a valid entry");
            input2 = Console.ReadLine();
        }  
		//Console.WriteLine(startCash);
        // Clear any characters still in the buffer
		
		players = new Player[numPlayers];
        String name;
		for (int player = 0; player < numPlayers; player++) {
			players[player] = new Player("\"Player " + (player+1) + "\"");

            Console.WriteLine(players[player].getName() + ", enter your name: ");
            name = Console.ReadLine();
			
			players[player].setName(name);
			players[player].setCash(startCash);
			players[player].setWinCount(0);
		}
	}
	
	/**
	 * Display game number and each player's current amount of cash and win count.
	 * @param gameNumber The current game number
	 */
	public void displayGameHeader_Console(int gameNumber)
	{
		Console.WriteLine("\n------------------------------------");
		Console.WriteLine("-----------Game Number: " + gameNumber + "-----------");
		for (int player = 0; player < numPlayers; player++) {
			Console.WriteLine(players[player].getName() + ":\tCash: $" + players[player].getCash() + " \t Wins: " + players[player].getWinCount());
		}
        Console.WriteLine("");		
	}
	
	/**
	 * Shuffle the deck and reset all players' hands
	 */
	public void shuffleAndReset()
	{
		allPlayersBust = true;
		dealer.shuffle();
		dealer.resetHand();
		for (int player = 0; player < players.Length; player++) {
			players[player].resetHand();
		}		
	}
	
	/**
	 * Deal each player their first two cards, with the dealer being dealt last
	 */
	public void dealFirstCards()
	{
		// Deal 2 cards to each player
		for (int card = 0; card < 2; card++) {
			for (int player = 0; player <= players.Length; player++) {
				// Make sure dealer is last one dealt
				if (player == players.Length)
					dealer.addCardToHand(dealer.deal());
				else if (players[player].getCash() > 0)
					players[player].addCardToHand(dealer.deal());
			}
		}		
	}
	
	// Have each active player place bets
	public void placeBets_Console()
	{
		for (int player = 0; player < players.Length; player++) {
			if (players[player].getCash() > 0) {
				Console.WriteLine(players[player].getName() + "'s bet: $");
				int bet = Console.Read();
				players[player].setBet(bet);
				Console.WriteLine("");		// Clear any characters still in the buffer
			}
		}
        Console.WriteLine("");			
	}
	
	// Let each player take their turn
	public void takePlayerTurns_Console()
	{
		for (int player = 0; player < players.Length; player++) {
			// Player can only take a turn if they still have cash
			if (players[player].getCash() > 0) {
				Console.WriteLine("---------\n" + players[player].getName() + "'s " + players[player]);
				Console.WriteLine("Total:: " +players[player].getHandValue());
				Console.WriteLine();
				
				// Double?
				if (players[player].isDoubling()) {
					players[player].setBet( players[player].getBet()*2 );
					players[player].addCardToHand(dealer.deal());
					Console.WriteLine("\tDrew: " +players[player].getLastCard());
					Console.WriteLine("\tTotal:: " +players[player].getHandValue() + "\n");
				} 
				// Split?
				/*
				else if (players[player].isSplitting()) {
					players[player].playSplitHand1();
					players[player].
					players[player].addCardToHand(dealer.deal());
					Console.WriteLine("\nDrew: " +players[player].getLastCard());
					Console.WriteLine(players[player].getName() + "'s 1st " + players[player]);
					Console.WriteLine("Total:: " + players[player].getHandValue() + "\n");
					hitPlayer(player);
					
					players[player].playSplitHand2( players[player].getHand1Value() );
					players[player].addCardToHand(dealer.deal());
					Console.WriteLine("---------\nDrew: " +players[player].getLastCard());
					Console.WriteLine(players[player].getName() + "'s 2nd " + players[player]);
					Console.WriteLine("Total:: " +players[player].getHandValue() + "\n");
					hitPlayer(player);
				}
				*/
				else {
					hitPlayer_Console(player);
				}
				
				// Check if player busted
				if (players[player].getHandValue() > 21)
                    Console.WriteLine("*** " + players[player].getName() + " BUSTS. ***\n");
				else
					allPlayersBust = false;
			}
		}		
	}

	// Continue checking if player wants to hit while total is under 21
	public void hitPlayer_Console(int player)
	{
		while(players[player].getHandValue() < 21){
			if (players[player].isHitting()) {
				players[player].addCardToHand(dealer.deal());
				Console.WriteLine("\tDrew: " +players[player].getLastCard());
				Console.WriteLine("\tTotal:: " +players[player].getHandValue());
			}
			else
				break;					
		}
        Console.WriteLine("");
	}
	
	// Let the dealer take his turn
	public void takeDealersTurn_Console()
	{
		Console.WriteLine("---------");			
		Console.WriteLine("Dealer " +dealer);
		Console.WriteLine("Dealer total:: " +dealer.getHandValue());
		// Dealer continues to hit until hand value is over 16 or until he busts
		while (dealer.isHitting()) {
			Console.WriteLine("Dealer draws: " +dealer.getLastCard());
			Console.WriteLine("Dealer total:: " +dealer.getHandValue());
		}
        Console.WriteLine();	
	}
	
	/**
	 * Go through each player's hand and determine if the player beat the dealer. Each
	 * player's cash and win count is updated accordingly.
	 */
	public void determineWinners()
	{
		int dealerHandValue = dealer.getHandValue();
		bool dealerBlackjack = dealerHandValue == 21 && dealer.getHandSize() == 2;
//		Console.WriteLine("Dealer:: " + dealerHandValue + "\n");
		
		for (int player = 0; player < players.Length; player++) {
			if (players[player].canPlay()) {
				String name = players[player].getName();
				int bet = players[player].getBet();
				int playerHandValue = players[player].getHandValue();
				bool playerBlackjack = playerHandValue == 21 && players[player].getHandSize() == 2;
				
				/*
				int h1v = players[player].getHand1Value();
				if (h1v != 0) {
					if (h1v > 21 && playerHandValue > 21)
						playerHandValue = (h1v < playerHandValue) ? h1v : playerHandValue;
					else if (h1v <= 21 && playerHandValue <= 21)
						playerHandValue = (h1v > playerHandValue) ? h1v : playerHandValue;
					else
						playerHandValue = (h1v < playerHandValue) ? h1v : playerHandValue;
					
					playerBlackjack = false;
				}
				*/
				
				// LOSS: Player busted and automatically loses
				if (playerHandValue > 21) {
//					Console.WriteLine(name + ":: " + playerHandValue);
//					Console.WriteLine(name + " BUSTED");
					dealer.setWinCount(++dealerWins);
					players[player].setCash(players[player].getCash() - bet);
				}
				// WIN: Player has blackjack but dealer does not
				else if (playerBlackjack && !dealerBlackjack) {
//					Console.WriteLine(name + ":: " +playerHandValue);
//					Console.WriteLine(name + " BLACKJACK!");
					players[player].setWinCount(players[player].getWinCount() + 1);
					// NOTE: This has been hard coded for 3:2 Blackjack
					players[player].setCash(players[player].getCash() + ((3 * bet) / 2));
				}
				// WIN: Dealer busted and player did not, or player has higher hand than dealer
				else if (dealerHandValue > 21 || (playerHandValue > dealerHandValue)) {
//					Console.WriteLine(name + ":: " +playerHandValue);
//					Console.WriteLine(name + " wins!");
					players[player].setWinCount(players[player].getWinCount() + 1);
					players[player].setCash(players[player].getCash() + bet);
				}
				// PUSH: Player and dealer both have blackjack, or neither have blackjack but have the same hand value
				else if (playerBlackjack && dealerBlackjack
						|| (!playerBlackjack && !dealerBlackjack && playerHandValue == dealerHandValue)) {
//					Console.WriteLine(name + ":: " +playerHandValue);
//					Console.WriteLine(name + " PUSH");
					// Make no changes to the player's cash
				}
				// LOSS: Player has lower hand than, or equivalent to, the dealer
				else {
//					Console.WriteLine(name + ":: " +playerHandValue);
//					Console.WriteLine("Dealer wins.");
					dealer.setWinCount(++dealerWins);
					players[player].setCash(players[player].getCash() - bet);
				}
//				Console.WriteLine();		
			}
		}		
	}
	
	// Determine and display the players with the most amount of cash and most amount
	// of wins
	public void displayGameResults_Console()
	{
		int mostCash = 0;
		int mostWins = 0;
		List<String> cashWinners = new List<String>();
		List<String> winsWinners = new List<String>();
		
		Console.WriteLine();
		Console.WriteLine("--------------------------------------------");
		Console.WriteLine("----------------GAME RESULTS----------------");
		Console.WriteLine("--------------------------------------------\n");

		// Determine the most amount of cash held by a player
		for (int i = 0; i < players.Length; i++) {
			if (players[i].getCash() >= mostCash) {
				mostCash = players[i].getCash();
			}
		}
		// Find all of the players with the most amount of cash
		for (int i = 0; i < players.Length; i++) {
			if (players[i].getCash() == mostCash) {
				cashWinners.Add(players[i].getName());
			}
		}
		
		// Determine the most number of wins by a player
		for (int i = 0; i < players.Length; i++) {
			if (players[i].getWinCount() >= mostWins) {
				mostWins = players[i].getWinCount();
			}		
		}
		// Find all of the players with the most amount of wins
		for (int i = 0; i < players.Length; i++) {
			if (players[i].getWinCount() == mostWins) {
				cashWinners.Add(players[i].getName());
			}
		}
		
		// Display player(s) with most amount of cash
		Console.WriteLine("--------First Place(s) : Cash Count---------");
		for (int i = 0; i < cashWinners.Count; i++) {
			Console.WriteLine((i+1)+ ". " +cashWinners[i]+ "\t\t Cash Total = $" +mostCash);
		}
		Console.WriteLine("--------------------------------------------");
		
		// Display player(s) with most amount of wins
		Console.WriteLine("---------First Place(s) : Win Count---------");
		for (int i = 0; i < winsWinners.Count; i++) {
			Console.WriteLine((i+1)+ ". " +winsWinners[i]+ "\t\t Wins Total = " +mostWins);
		}
		Console.WriteLine("-------------------------------------------");		
	}

	public void playGame()
	{
		int gameNumber = 0;
		bool continueGame = true;
		
		Console.WriteLine("\nWelcome to the game.\n");
		
		// Set number of players and starting cash
		initializePlayers_Console();
		
		do {
			gameNumber++;
			displayGameHeader_Console(gameNumber);	// Display game information
			shuffleAndReset();				// Shuffle and reset all hands and variables
			dealFirstCards();				// Deal each player their first cards
			
			//Shows dealer's card
			Console.WriteLine("---------");			
			Console.WriteLine("Dealer shows: " + dealer.showCard());
			Console.WriteLine("Dealer total:: " + dealer.showCardVal() + "\n");
			
			placeBets_Console();					// Place bets for each player
			takePlayerTurns_Console();				// Go through each player's turn
			if (!allPlayersBust)
				takeDealersTurn_Console();			// Only take dealer's turn if a player didn't bust
			
			determineWinners();
			
			// Determine if everyone is out of cash
			int numDone = 0;
			for (int player = 0; player < players.Length; player++) {
				if (players[player].getCash() == 0)
					numDone++;
			}
			// If there are still players left in the game, ask if player(s) want(s) to continue
			if (numDone < numPlayers) {
				Console.WriteLine("Enter \"y\" to play again.");
                continueGame = (Console.ReadLine()[0].Equals('y')) ? true : false;
			}
			else	// Once everyone is out of money, game defaults to end
				continueGame = false;
			
		} while (continueGame);
		
		displayGameResults_Console();			// Display players with the most cash and most wins
	}

    static public void Main(string[] args)
    {
        BlackJackGame game = new BlackJackGame(3);
        game.playGame();
    }
}

}