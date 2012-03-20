import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * $Id: Referee.java 47 2009-11-07 09:03:45Z seongyupyoo $
 */

/**
 * @author dan.arnold
 *
 */
public class Referee {
	
	private static final int HIT_VALUE = -1;
	private static final int STAND_VALUE = -2;
	private HashMap<Integer, PlayerInterface> players;
	
	private int lastCardIndex;
	
	public Referee( List<PlayerInterface> newPlayers, int seed, int gameId ) {
		
		RemotePlayer dealer = new RemotePlayer( gameId, 0 );
		players.put( 0, dealer );
		
		for ( PlayerInterface player : newPlayers ) {
			players.put( player.getId(), player );
		}
		
		Object[] g = players.keySet().toArray();
		List<Integer> convertedPlayers = new ArrayList<Integer>();
		for(int i = 0; i < g.length; i++) {
			convertedPlayers.add((Integer)g[i]);
		}
		
		for (;;) {
			
			for ( PlayerInterface p : players.values() ) {
				p.tellPlayers(convertedPlayers);
				
				p.tellLastCardIndex(lastCardIndex);
			}
			for ( PlayerInterface p : players.values() ) {
				
				int bet = p.getBet( );
				for ( PlayerInterface p2 : players.values() ) {
					p2.tellBet( p2.getId(), bet );
				}
				int move = p.getMove();
				switch (move) {
				case HIT_VALUE:
					// do something
					break;
				case STAND_VALUE:
					// do something else
					break;
				}
			}
		}
	}
}