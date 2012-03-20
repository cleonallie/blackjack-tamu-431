import java.util.ArrayList;
import java.util.List;

/**
 * $Id: RemotePlayer.java 47 2009-11-07 09:03:45Z seongyupyoo $
 */

/**
 * @author dan
 *
 */
public class RemotePlayer implements PlayerInterface {

	ServerProxy proxy;
	Cell<String> cell;
	int gameId;
	int playerId;
	
	public RemotePlayer(int gameId, int playerId) {
		this.gameId = gameId;
		this.playerId = playerId;
		
		proxy = ServerProxy.getInstance();
		proxy.setListener( new ServerModelListenerInterface() {

			public void setCell(String value) {
				cell.set(value);
			}

			public void setGameId(int gameId) {
				// Nothing to do
			}

			public void setGameSeed(int seed) {
				// Nothing to do
			}

			public void setGames(Integer[] gameIds) {
				// Nothing to do
			}

			public void setLastCardIndex(int index) {
				// Nothing to do
			}

			public void setPlayerId(int playerId) {
				// Nothing to do
			}

			public void setPlayers(List<Integer> playerIds) {
				String value = "";
				for(int i = 0; i < playerIds.size(); i++) {
					value += playerIds.get(i).toString();
					if(playerIds.size() - 1 != i) {
						value += " ";
					}
				}
				cell.set(value);
			}
		} );
	}

	public int getBet() {
		proxy.getCell(gameId, playerId);
		return Integer.parseInt(cell.get());
	}

	public int getId() {
		return playerId;
	}

	public int getLastCardIndex() {
		proxy.getLastCardIndex(gameId);
		return Integer.parseInt(cell.get());
	}

	public int getMove() {
		proxy.getCell(gameId, playerId);
		return Integer.parseInt(cell.get());
	}

	public List<Integer> getPlayers() {
		proxy.getPlayers(gameId);
		String playersString = cell.get();
		String[] tokens = playersString.split(" ");
		List<Integer> convertedPlayers = new ArrayList<Integer>();
		for(int i = 0; i < tokens.length; i++) {
			convertedPlayers.add(Integer.parseInt(tokens[i]));
		}
		return convertedPlayers;
	}

	public void setResult(int result) {
		proxy.setCell(gameId, playerId, result + "");
	}

	public void tellBet(int playerId, int amount) {
		proxy.setCell(gameId, playerId, amount + "");
	}


	public void tellLastCardIndex(int index) {
		proxy.setCell(gameId, playerId, index + "");
	}

	public void tellPlayers(List<Integer> playerIds) {
		String value = "";
		for(int i = 0; i < playerIds.size(); i++) {
			value += playerIds.get(i).toString();
			if(playerIds.size() - 1 != i) {
				value += " ";
			}
		}
		proxy.setCell(gameId, playerId, value);
	}

	public void tellCard(int playerId, int index) {
		proxy.setCell(gameId, playerId, index + "");		
	}
}
