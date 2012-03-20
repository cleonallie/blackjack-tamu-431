
/**
 * $Id: Javajack.java 48 2009-11-07 09:48:14Z dan.arnold $
 */

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * @author dan
 *
 */
public class Javajack {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		if ( args.length != 2 )
			printUsageAndExit();
		String host = args[0];
		int port = -1;
		try {
			port = Integer.parseInt( args[1] );
		} catch ( NumberFormatException e ) {
			System.err.println( "Error: The port number must be an integer!" );
			printUsageAndExit();
		}
		
		Socket socket = new Socket();
		try {
			socket.connect( new InetSocketAddress( host, port ) );
		} catch ( IOException e ) {
			System.err.println( "A connection cannot be made to " + host + ":"
					+ port + "." );
			printUsageAndExit();
		}
		
		GameBrowser g = new GameBrowser( socket );
		
		// Start GameBrowserGUI
	}
	
	private static void printUsageAndExit() {
		// TODO Auto-generated method stub
		
	}

	public Javajack( Referee referee ) {
		System.out.println( "New game joined!" );
		// Creates Deck from seed
		// Gives Deck to Referee
	}

}