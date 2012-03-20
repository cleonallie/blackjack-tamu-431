import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * $Id: Game.java 22 2009-11-07 01:09:01Z seongyupyoo $
 */

/**
 * Facilitates synchronization of a game between multiple players
 * @author dan
 *
 */
public class Game {

	// Private members
	private int id = 0;
	private int seed = 0;
	private int lastCardIndex = 0;
	private HashMap<Integer,Cell<String>> playerCells = new HashMap<Integer,Cell<String>>();
	
	/**
	 * 
	 */
	public Game() {}
	
	/**
	 * Constructor with seed parameter
	 * @param seed
	 */
	public Game(int id, int seed) {
		this.seed = seed;
	}
	
	/**
	 * Constructor with gameId, seed, and lastCardIndex parameters
	 * @param gameId
	 */
	public Game(int id, int seed, int lastCardIndex) {
		this.id = id;
		this.seed = seed;
		this.lastCardIndex = lastCardIndex;
	}

	/**
	 * Gets this game's id
	 * @return this game's id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getSeed() {
		return seed;
	}
	
	/**
	 * Gets last dealt card's index
	 * @return
	 */
	public int getLastCardIndex() {
		return lastCardIndex;
	}
	
	/**
	 * gets list of player ids
	 * @return
	 */
	public List<Integer> getPlayerIds() {
		List<Integer> returnList = new ArrayList<Integer>();
		for(int i = 0; i <= playerCells.size(); i++) {
			// 0 is dealer
			returnList.add(i);
		}
		return returnList;
	}
	
	/**
	 * Adds a new player to the game, and returns the new player's id
	 * @return new player's id
	 */
	public synchronized int makeNewPlayer() {
		int newPlayerId = 1;
		while(playerCells.containsKey(newPlayerId)) newPlayerId++;
		playerCells.put(newPlayerId,new Cell<String>());
		return newPlayerId;
	}
	
	/**
	 * Remove player with given playerId
	 * @param playerId
	 * @return
	 */
	public synchronized boolean removePlayer(int playerId) {
		if(playerCells.containsKey(playerId)) {
			playerCells.remove(playerId);
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Gets playerId's cell's value
	 * @param playerId
	 * @return playerId's cell's value
	 */
	public String get(int playerId) {
		return playerCells.get(playerId).get();
	}
	
	/**
	 * Sets playerId's cell's value with given value
	 * @param playerId
	 * @param value
	 * @return true if successfully set, else false
	 */
	public synchronized boolean set(int playerId, String value) {
		if(playerCells.containsKey(playerId)) {
			playerCells.get(playerId).set(value);
			return true;
		} else {
			return false;
		}
	}
}
