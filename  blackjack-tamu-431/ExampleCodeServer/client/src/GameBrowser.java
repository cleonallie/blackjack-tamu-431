import java.awt.Graphics;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * $Id: GameBrowser.java 48 2009-11-07 09:48:14Z dan.arnold $
 */

/**
 * @author dan.arnold
 *
 */
public class GameBrowser {
	
	Socket s;
	ServerProxy proxy;
	GameBrowserGUI gui;
	
	int gameToJoin;
	int gameSeed;
	int lastCardIndex;
	List<Integer> playerIds;
	int playerId;
	
	public GameBrowser( Socket s ) {
		
		gameToJoin = -1;
		gameSeed = -1;
		lastCardIndex = -1;
		playerIds = null;
		playerId = -1;
		
		this.s = s;
		
		proxy = ServerProxy.getInstance();
		proxy.setSocket( s );
		
		gui = new GameBrowserGUI( this );
		gui.addListener( proxy );
		gui.getGames();
		
		proxy.setListener( new ServerModelListenerInterface() {

			public void setCell(String value) {
				// TODO Auto-generated method stub
				
			}

			public void setGameSeed(int seed) {
				GameBrowser.this.gameSeed = seed;
				if ( readyToJoinGame() ) {
					createJavajack();
				}
			}

			public void setLastCardIndex(int index) {
				GameBrowser.this.lastCardIndex = index;
			}

			public void setPlayers(List<Integer> playerIds) {
				GameBrowser.this.playerIds = playerIds;
			}

			public void setGames(Integer[] gameIds) {
				System.out.println("ServerProxy.setGames called (code in GameBrowser)");
				gui.populateList( gameIds );
				Graphics gfx = gui.getGraphics();
				gui.update( gfx );
			}

			public void setPlayerId(int playerId) {
				GameBrowser.this.playerId = playerId;
				if ( readyToJoinGame() ) {
					createJavajack();
				}
			}

			public void setGameId(int gameId) {
				GameBrowser.this.gameToJoin = gameId;
				if ( readyToJoinGame() ) {
					createJavajack();
				}
			}
		});
		
		proxy.start();
	}
	
	private boolean readyToJoinGame() {
		boolean returnVal = ( gameSeed >= 0 && gameToJoin >= 0 && playerId > 0 );
		System.out.println("Ready to join game = " + returnVal );
		return returnVal;
	}
	
	private void createJavajack() {
		System.out.println("Creating Javajack..." );
		
		Referee referee = new Referee( null, gameToJoin, gameSeed );
		Javajack game = new Javajack( referee );
	}
	
	// If player wants to create a new game:
		// Generate seed
		// Create LocalPlayer
		// Create a Dealer with List<PlayerInterface> and seed
		// Pass Dealer to constructor of Javajack
	// If player wants to join an already created game:
		// getSeed()
		// getListOfPlayers
		// getLastCardIndex
		// Create LocalPlayer
		// Create RemotePlayers based on list of players got from server
		// Create List<PlayerInterface> with LocalPlayer and RemotePlayers
		// Create Dealer with List we just created and lastCardIndex
		// Pass seed (from server) and new Dealer to constructor of javajack
}