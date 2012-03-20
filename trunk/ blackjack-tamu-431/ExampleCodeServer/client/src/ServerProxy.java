/**
 * $Id: ServerProxy.java 48 2009-11-07 09:48:14Z dan.arnold $
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * @author dan.arnold
 *
 */
public class ServerProxy implements PlayerListenerInterface {

	// 
	private static ServerProxy instance;
	private Socket s;
	private BufferedReader in;
	private PrintStream out;
	
	private ServerModelListenerInterface listener;
	
    public static ServerProxy getInstance() {
        if ( instance == null )
            instance = new ServerProxy();
        return instance; 
    }
    
    public void setSocket( Socket s ) {
    	instance.s = s;
		try {
			in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			out = new PrintStream(s.getOutputStream(), true);
		} catch (IOException e) {
			System.err.println(s.getInetAddress().toString().substring(1) + ":" + s.getPort() +  " <-- I/O error");
			finalize();		
		}
    }

    private ServerProxy() {}

	public void createGame(int seed) {
		out.println("createGame " + seed);
	}

	public void getCell(int gameId, int playerId) {
		out.println("getCell " + gameId + " " + playerId);
	}

	public void getGames() {
		System.out.println( "ServerProxy.getGames(): sending \"getGames\" to Server" );
		out.println("getGames");
	}

	public void getLastCardIndex(int gameId) {
		out.println("getLastCardIndex " + gameId);
	}

	public void getPlayers(int gameId) {
		out.println("getPlayers " + gameId);
	}

	public void joinGame(int gameId) {
		out.println("joinGame " + gameId);
	}

	public void setCell(int gameId, int playerId, String value) {
		out.println("setCell " + gameId + " " + playerId + " " + value);
	}
	
	/**
	 * Closes open stream and socket
	 */
	public void finalize() {
		try{
			out.close();
			s.close();
			System.out.println(s.getInetAddress().toString().substring(1) + ":" + s.getPort() +  " close");
		} catch (IOException e) {
			System.err.println(s.getInetAddress().toString().substring(1) + ":" + s.getPort() +  " --> I/O error");
		}
	}
	
	/**
	 * Sets the ServerModelListener of this proxy.
	 * 
	 * @param listener the new listener
	 */
	public void setListener( ServerModelListenerInterface listener ) {
		if ( listener == null ) {
			throw new NullPointerException( "ServerProxy.setListener(): listener is null" );
		}
		this.listener = listener;
	}
	
	public void start() {
		new Reader().start();
	}
	
	private class Reader extends Thread {
		public void run() {
			try {
				System.out.println( "ServerProxy Reader started!" );
				while(true) {
					System.out.println("ServerProxy Reader: top of while");
					String [] tokens = in.readLine().split(" ");
					String command = tokens[0];
					
					System.out.println( "ServerProxy.Reader: got command = " + command );
					
					if(command.equals("setCell")) {
						listener.setCell(tokens[1]);
					} else if (command.equals("setGameSeed")) {
						listener.setGameSeed(Integer.parseInt(tokens[1]));
					} else if(command.equals("setPlayerId")) {
						listener.setPlayerId(Integer.parseInt(tokens[1]));
					} else if (command.equals("setGames")) {
						Integer [] gameIds = new Integer [tokens.length -1];
						if(!tokens[1].equals("*")) {
							for(int i = 1; i < tokens.length; i++) {
								gameIds[i-1] = Integer.parseInt(tokens[i]);
							}
						}
						listener.setGames(gameIds);
					} else if(command.equals("setPlayers")) {
						List<Integer> playerIds = new ArrayList<Integer>();
						if(!tokens[1].equals("*")) {
							for(int i = 1; i < tokens.length; i++) {
								playerIds.add(Integer.parseInt(tokens[i]));
							}
						}
						listener.setPlayers(playerIds);
					} else if (command.equals("setLastCardIndex")) {
						listener.setLastCardIndex(Integer.parseInt(tokens[1]));
					} else if(command.equals("setGameId")) {
						listener.setGameId(Integer.parseInt(tokens[1]));
					}
				}
			} catch (Exception e) {}
		}
	}
}