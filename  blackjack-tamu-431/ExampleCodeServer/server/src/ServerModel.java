import java.util.HashMap;

/**
 * $Id: ServerModel.java 47 2009-11-07 09:03:45Z seongyupyoo $
 */

/**
 * Server communication model that facilitates 
 * communication and logic between multiple players in multiple games
 * @author dan
 *
 */
public class ServerModel {
	
	// Private members
	private HashMap<Integer,Game> games;
	private ServerModelListenerInterface modelListener;
	private ServerModel model;
	
	/**
	 * Private singleton constructor
	 */
	public ServerModel() {
		games = GameDB.getDB();
	}
	
	/**
	 * Adds a game
	 * @param gameId
	 * @param game
	 * @return
	 */
	public boolean addGame(int gameId, Game game) {
		if(!games.containsKey(gameId)) {
			games.put(gameId, game);
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Removes a game
	 * @param gameId
	 * @return
	 */
	public boolean removeGame(int gameId) {
		if(!games.containsKey(gameId)) {
			games.remove(gameId);
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Sets cell of given gameId, playerId with given value
	 * @param gameId
	 * @param playerId
	 * @param value
	 * @return
	 */
	public boolean setCell(int gameId, int playerId, String value) {
		return ((Game)games.get(gameId)).set(playerId, value);
	}
	
	/**
	 * Gets the model to invoke modelListener's method
	 * that returns the value of the given gameId and playerId's cell
	 * @param gameId
	 * @param playerId
	 */
	public void getCell(int gameId, int playerId) {
		modelListener.setCell(((Game)games.get(gameId)).get(playerId));
	}
	
	/**
	 * Gets the model to invoke modelListener's method 
	 * that returns list of gameIds to the caller
	 */
	public void getGameIds() {
		Object[] g = games.keySet().toArray();
		Integer[] convertedGames = new Integer[g.length];
		for(int i = 0; i < g.length; i++) {
			convertedGames[i] = (Integer)g[i];
		}
		modelListener.setGames(convertedGames);
	}
	
	/**
	 * Gets the model to invoke modelListener's methods
	 * that return the joining game's seed, last card index, playerIds, and 
	 * @param gameId
	 */
	public void joinGame(int gameId) {
		// check if you can join the game, else i call a different function letting you know that you cna't join
		Game gameToJoin = (Game)games.get(gameId);
		modelListener.setGameSeed(gameToJoin.getSeed());
		modelListener.setLastCardIndex(gameToJoin.getLastCardIndex());
		modelListener.setPlayerId(gameToJoin.makeNewPlayer());
		modelListener.setPlayers(gameToJoin.getPlayerIds());
	}
	
	/**
	 * Gets the model to invoke modelListener's methods
	 * that return the newly created game's id, and player id of the game creator 
	 * @param seed
	 */
	public synchronized void createGame(int seed) {
		int newGameId = 1;
		while(games.keySet().contains(newGameId)) newGameId++;
		Game newGame = new Game(newGameId, seed);
		games.put(newGameId,newGame);
		modelListener.setPlayerId(newGame.makeNewPlayer());
		modelListener.setGameId(newGameId);
	}

	/**
	 * Gets the model to invoke modelListener's method that
	 * returns the last dealt card's index
	 * @param gameId
	 */
	public void getLastCardIndex(int gameId) {
		modelListener.setLastCardIndex(((Game)games.get(gameId)).getLastCardIndex());		
	}

	/**
	 * Gets the model to invoke modelListener's method that
	 * returns the list of player id's in this game
	 * @param gameId
	 */
	public void getPlayerIds(int gameId) {
		modelListener.setPlayers(((Game)games.get(gameId)).getPlayerIds());
	}

	public void setListener(ServerModelListenerInterface listener) {
		modelListener = listener;
	}
}