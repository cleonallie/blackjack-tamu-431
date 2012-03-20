import java.util.List;

/**
 * $Id: ServerModelListenerInterface.java 22 2009-11-07 01:09:01Z seongyupyoo $
 */

/**
 * @author dan.arnold
 *
 */
public interface ServerModelListenerInterface {
	void setCell(String value);
	void setGameSeed(int seed);
	void setPlayerId(int playerId);
	void setGames(Integer[] gameIds);
	void setPlayers(List<Integer> playerIds);
	void setLastCardIndex(int index);
	void setGameId(int gameId);
}
