import static java.lang.System.*;
import java.util.Scanner;
import java.util.ArrayList;
import players.Player;
import players.Dealer;

public class BlackJackGame
{
	private Dealer dealer;
	private Scanner keyboard = new Scanner(System.in);
	private int numPlayers = 1;
	private int dealerWins = 0;
	private Player[] players;
	private boolean allPlayersBust;

	public BlackJackGame()
	{
		dealer = new Dealer();
	}
	
	// Decide how many players will play and initialize each of them
	public void initializePlayers()
	{
		int startCash = 0;
		out.println("How many players will there be?");
		numPlayers = keyboard.nextInt();
		
		// Set starting cash
		out.println("\nHow much money will each player start with?");
		out.print("$");
		startCash = keyboard.nextInt();
		out.println();
		String clear = keyboard.nextLine();		// Clear any characters still in the buffer
		
		players = new Player[numPlayers];
		for (int player = 0; player < numPlayers; player++) {
			players[player] = new Player("\"Player " + (player+1) + "\"");

			out.print(players[player].getName() + ", enter your name: ");
			String name = keyboard.nextLine();
			
			players[player].setName(name);
			players[player].setCash(startCash);
			players[player].setWinCount(0);
		}
	}
	
	// Display game number and each player's current amount of cash and win count
	public void displayGameHeader(int gameNumber)
	{
		out.println("\n------------------------------------");
		out.println("-----------Game Number: " + gameNumber + "-----------");
		for (int player = 0; player < numPlayers; player++) {
			out.println(players[player].getName() + ":\tCash: $" + players[player].getCash() + " \t Wins: " + players[player].getWinCount());
		}
		out.println();		
	}
	
	// Shuffle the deck and reset all players' hands
	public void shuffleAndReset()
	{
		allPlayersBust = true;
		dealer.shuffle();
		dealer.resetHand();
		for (int player = 0; player < players.length; player++) {
			players[player].resetHand();
		}		
	}
	
	// Deal each player their first two cards, with the dealer being dealt last
	public void dealFirstCards()
	{
		// Deal 2 cards to each player
		for (int card = 0; card < 2; card++) {
			for (int player = 0; player <= players.length; player++) {
				// Make sure dealer is last one dealt
				if (player == players.length)
					dealer.addCardToHand(dealer.deal());
				else if (players[player].getCash() > 0)
					players[player].addCardToHand(dealer.deal());
			}
		}		
	}
	
	// Have each active player place bets
	public void placeBets()
	{
		for (int player = 0; player < players.length; player++) {
			if (players[player].getCash() > 0) {
				out.print(players[player].getName() + "'s bet: $");
				int bet = keyboard.nextInt();
				players[player].setBet(bet);
				String clear = keyboard.nextLine();		// Clear any characters still in the buffer
			}
		}
		out.println();		
	}
	
	// Let each player take their turn
	public void takePlayerTurns()
	{
		for (int player = 0; player < players.length; player++) {
			// Player can only take a turn if they still have cash
			if (players[player].getCash() > 0) {
				out.println("---------\n" + players[player].getName() + "'s " + players[player]);
				out.println("Total:: " +players[player].getHandValue());
				out.println();
				
				// Continue checking if player wants to hit while total is under 21
				while(players[player].getHandValue() < 21){
					if (players[player].isHitting()) {
						players[player].addCardToHand(dealer.deal());
						out.println("\tDrew: " +players[player].getLastCard());
						out.println("\tTotal:: " +players[player].getHandValue());
					}
					else
						break;					
				}
				out.println();
				
				// Check if player busted
				if (players[player].getHandValue() > 21)
					out.println("*** " + players[player].getName()+ " BUSTS. ***\n");
				else
					allPlayersBust = false;
			}
		}		
	}
	
	// Let the dealer take his turn
	public void takeDealersTurn()
	{
		out.println("---------");			
		out.println("Dealer " +dealer);
		out.println("Dealer total:: " +dealer.getHandValue());
		// Dealer continues to hit until hand value is over 16 or until he busts
		while (dealer.isHitting()) {
			out.println("Dealer draws: " +dealer.getLastCard());
			out.println("Dealer total:: " +dealer.getHandValue());
		}
		out.println();	
	}
	
	// Go through each player's hand and determine if the player beat the dealer. Each
	// player's cash and win count is updated accordingly.
	public void determineWinners()
	{
		out.println("Dealer:: " + dealer.getHandValue() + "\n");
		
		for (int player = 0; player < players.length; player++) {
			// Players cannot play or win without any cash
			if (players[player].getCash() > 0) {
				// LOSS: Player busted and automatically loses
				if (players[player].getHandValue() > 21) {
					out.println(players[player].getName() + ":: " + players[player].getHandValue());
					out.println(players[player].getName() + " BUSTED");
					players[player].setCash(players[player].getCash() - players[player].getBet());
				}
				// WIN: Player has higher hand than dealer without busting
				else if (players[player].getHandValue() > dealer.getHandValue() && players[player].getHandValue() <= 21) {
					out.println(players[player].getName() + ":: " + players[player].getHandValue());
					out.println(players[player].getName() + " wins!");
					players[player].setWinCount(players[player].getWinCount() + 1);
					players[player].setCash(players[player].getCash() + players[player].getBet());
				}
				// LOSS: Player has lower hand than, or equivalent to, the dealer (if dealer's hand <= 21)
				else if ((players[player].getHandValue() < dealer.getHandValue() || players[player].getHandValue() == dealer.getHandValue())
						&& dealer.getHandValue() <= 21) {
					out.println(players[player].getName()+ ":: " +players[player].getHandValue());
					out.println("Dealer wins. :(");
					dealer.setWinCount(++dealerWins);
					players[player].setCash(players[player].getCash() - players[player].getBet());
				}
				// WIN: Dealer busted and player did not
				else if (dealer.getHandValue() > 21 && players[player].getHandValue() <= 21) {
					out.println(players[player].getName()+ ":: " +players[player].getHandValue());
					out.println(players[player].getName()+ " wins!");
					players[player].setWinCount(players[player].getWinCount() + 1);
					players[player].setCash(players[player].getCash() + (players[player].getBet()));
				}
				else {
					out.println("HUH??");
					out.println(players[player].getName()+ ":: " +players[player].getHandValue());
				}
				out.println();		
			}
		}		
	}
	
	// Determine and display the players with the most amount of cash and most amount
	// of wins
	public void displayGameResults()
	{
		int mostCash = 0;
		int mostWins = 0;
		ArrayList<String> cashWinners = new ArrayList<String>();
		ArrayList<String> winsWinners = new ArrayList<String>();
		
		out.println();
		out.println("--------------------------------------------");
		out.println("----------------GAME RESULTS----------------");
		out.println("--------------------------------------------\n");

		// Determine the most amount of cash held by a player
		for (int i = 0; i < players.length; i++) {
			if (players[i].getCash() >= mostCash) {
				mostCash = players[i].getCash();
			}
		}
		// Find all of the players with the most amount of cash
		for (int i = 0; i < players.length; i++) {
			if (players[i].getCash() == mostCash) {
				cashWinners.add(players[i].getName());
			}
		}
		
		// Determine the most number of wins by a player
		for (int i = 0; i < players.length; i++) {
			if (players[i].getWinCount() >= mostWins) {
				mostWins = players[i].getWinCount();
			}		
		}
		// Find all of the players with the most amount of wins
		for (int i = 0; i < players.length; i++) {
			if (players[i].getWinCount() == mostWins) {
				cashWinners.add(players[i].getName());
			}
		}
		
		// Display player(s) with most amount of cash
		out.println("--------First Place(s) : Cash Count---------");
		for (int i = 0; i < cashWinners.size(); i++) {
			out.println((i+1)+ ". " +cashWinners.get(i)+ "\t\t Cash Total = $" +mostCash);
		}
		out.println("--------------------------------------------");
		
		// Display player(s) with most amount of wins
		out.println("---------First Place(s) : Win Count---------");
		for (int i = 0; i < winsWinners.size(); i++) {
			out.println((i+1)+ ". " +winsWinners.get(i)+ "\t\t Wins Total = " +mostWins);
		}
		out.println("-------------------------------------------");		
	}

	public void playGame()
	{
		int gameNumber = 0;
		boolean continueGame = true;
		
		out.println("\nWelcome to the game.\n");
		
		// Set number of players and starting cash
		initializePlayers();
		
		do {
			gameNumber++;
			displayGameHeader(gameNumber);	// Display game information
			shuffleAndReset();				// Shuffle and reset all hands and variables
			dealFirstCards();				// Deal each player their first cards
			
			//Shows dealer's card
			out.println("---------");			
			out.println("Dealer shows: " + dealer.showCard());
			out.println("Dealer total:: " + dealer.showCardVal() + "\n");
			
			placeBets();					// Place bets for each player
			takePlayerTurns();				// Go through each player's turn
			if (!allPlayersBust)
				takeDealersTurn();			// Only take dealer's turn if a player didn't bust
			
			determineWinners();
			
			// Determine if everyone is out of cash
			int numDone = 0;
			for (int player = 0; player < players.length; player++) {
				if (players[player].getCash() == 0)
					numDone++;
			}
			// If there are still players left in the game, ask if player(s) want(s) to continue
			if (numDone < numPlayers) {
				out.println("Enter \"y\" to play again.");
				continueGame = (keyboard.next().charAt(0) == 'y') ? true : false;
			}
			else	// Once everyone is out of money, game defaults to end
				continueGame = false;
			
		} while (continueGame);
		
		displayGameResults();			// Display players with the most cash and most wins
	}

	public static void main(String[] args)
	{
		BlackJackGame game = new BlackJackGame();
		game.playGame();
	}
}