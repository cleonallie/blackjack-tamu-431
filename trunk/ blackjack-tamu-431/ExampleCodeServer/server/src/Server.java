import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * $Id: Server.java 47 2009-11-07 09:03:45Z seongyupyoo $
 */

/**
 * Serves a client socket
 * @author dan
 *
 */
public class Server{

	// Private members
	private ClientProxy proxy;
	private ServerModel model;
	
	/**
	 * Constructor that takes a socket
	 * @param socket
	 */
	public Server(Socket socket) {
		/*model = new ServerModel();
		proxy = new ClientProxy(socket);
		proxy.setListener(new PlayerListenerInterface() {

			public void createGame(int seed) {
				model.createGame(seed);
			}

			public void getCell(int gameId, int playerId) {
				model.getCell(gameId, playerId);
			}

			public void getGames() {
				model.getGameIds();
			}

			public void getLastCardIndex(int gameId) {
				model.getLastCardIndex(gameId);
			}

			public void getPlayers(int gameId) {
				model.getPlayerIds(gameId);
			}

			public void joinGame(int gameId) {
				model.joinGame(gameId);
			}

			public void setCell(int gameId, int playerId, String value) {
				model.setCell(gameId, playerId, value);
			}
		});*/
	}
	
	public static void main(String [] args) {
		String host = "";
		int port = 0;
		if(args.length == 2) {
			host = args[0];
			port = Integer.parseInt(args[1]);
		}
		
		ServerSocket ss;
		try {
			ss = new ServerSocket();
			ss.bind(new InetSocketAddress(host, port));

		while(true) {
			Socket socket = null;
			socket = ss.accept();
			
			final ClientProxy proxy = new ClientProxy(socket);
			final ServerModel model = new ServerModel();
			
			model.setListener(proxy);
			
			proxy.setListener(new PlayerListenerInterface() {

				public void createGame(int seed) {
					model.createGame(seed);
				}

				public void getCell(int gameId, int playerId) {
					model.getCell(gameId, playerId);		
				}

				public void getGames() {
					model.getGameIds();
				}

				public void getLastCardIndex(int gameId) {
					model.getLastCardIndex(gameId);
				}

				public void getPlayers(int gameId) {
					model.getPlayerIds(gameId);
				}

				public void joinGame(int gameId) {
					model.joinGame(gameId);
				}

				public void setCell(int gameId, int playerId, String value) {
					model.setCell(gameId, playerId, value);
				}
			});
			
			proxy.start();
		}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
