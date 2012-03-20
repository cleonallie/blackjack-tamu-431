import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.List;

/**
 * $Id: ClientProxy.java 47 2009-11-07 09:03:45Z seongyupyoo $
 */

/**
 * @author dan
 *
 */
public class ClientProxy implements ServerModelListenerInterface {

	// Private members
	private Socket socket;
	private BufferedReader in;
	private PrintStream out;
	private PlayerListenerInterface listener;
	
	/**
	 * Constructor that takes a socket
	 * @param socket
	 */
	public ClientProxy(Socket socket) {
		this.socket = socket;
		try {
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintStream(socket.getOutputStream(), true);
		} catch (IOException e) {
			System.err.println(socket.getInetAddress().toString().substring(1) + ":" + socket.getPort() +  " <-- I/O error");
			finalize();		
		}
	}
	
	/**
	 * Sends cell value to the client
	 */
	public void setCell(String value) {
		out.println("setCell " + value);
	}

	/**
	 * Sends game id to the client
	 */
	public void setGameId(int gameId) {
		out.println("setGameId " + gameId);
	}

	/**
	 * Sends game seed to the client
	 */
	public void setGameSeed(int seed) {
		out.println("setGameSeed " + seed);		
	}

	/**
	 * Sends list of game ids to the client
	 */
	public void setGames(Integer[] gameIds) {
		String sendString = "setGames";
		if(gameIds.length != 0) {
			for(int i = 0; i < gameIds.length; i++) {
				sendString += " " + gameIds[i];
			}
		} else {
			sendString += " *";
		}
		out.println(sendString);
	}

	/**
	 * Sends last dealt card's index to the client
	 */
	public void setLastCardIndex(int index) {
		out.println("setLastCardIndex " + index);
	}
	
	/**
	 * Sends players id to the client
	 */
	public void setPlayerId(int playerId) {
		out.println("setPlayerId " + playerId);
	}

	/**
	 * sends list of player ids to the client
	 */
	public void setPlayers(List<Integer> playerIds) {
		String sendString = "setPlayers";
		if(playerIds.size() != 0) {
			for(int i = 0; i < playerIds.size(); i++) {
				sendString += " " + playerIds.get(i);
			}
		} else {
			sendString += " *";
		}
		out.println(sendString);
	}
	
	/**
	 * Closes open stream and socket
	 */
	public void finalize() {
		try{
			out.close();
			socket.close();
			System.out.println(socket.getInetAddress().toString().substring(1) + ":" + socket.getPort() +  " close");
		} catch (IOException e) {
			System.err.println(socket.getInetAddress().toString().substring(1) + ":" + socket.getPort() +  " --> I/O error");
		}
	}

	/**
	 * Sets the listener
	 * @param playerListenerInterface
	 */
	public void setListener(PlayerListenerInterface listener) {
		if( listener == null) {
			throw new NullPointerException();
		}
		this.listener = listener;
	}
	
	public void start() {
		Reader r = new Reader();
		r.start();
	}
	
	class Reader extends Thread {
		public void run() {
			System.out.println("listening");
			try {
				System.out.println("listening2");
				while(true) {
					String [] tokens = in.readLine().split(" ");
					String command = tokens[0];
					
					if(command.equals("createGame")) {
						listener.createGame(Integer.parseInt(tokens[1]));
					} else if (command.equals("getCell")) {
						listener.getCell(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
					} else if(command.equals("getGames")) {
						listener.getGames();
					} else if (command.equals("getLastCardIndex")) {
						listener.getLastCardIndex(Integer.parseInt(tokens[1]));
					} else if(command.equals("getPlayers")) {
						listener.getPlayers(Integer.parseInt(tokens[1]));
					} else if (command.equals("joinGame")) {
						listener.joinGame(Integer.parseInt(tokens[1]));
					} else if(command.equals("setCell")) {
						listener.setCell(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]), tokens[3]);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

