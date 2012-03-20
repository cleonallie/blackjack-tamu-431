import java.lang.reflect.Array;
import java.util.List;

/**
 * $Id: PlayerListenerInterface.java 21 2009-11-07 00:28:27Z seongyupyoo $
 */

/**
 * @author dan.arnold
 *
 */
public interface PlayerListenerInterface {
	void setCell( int gameId, int playerId, String value );
	
	void getCell( int gameId, int playerId );
	
	void getGames();
	
	void getPlayers( int gameId );
	
	void joinGame( int gameId );
	
	void createGame( int seed );
	
	void getLastCardIndex( int gameId );
}