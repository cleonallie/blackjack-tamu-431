import java.util.List;

/**
 * $Id: PlayerInterface.java 37 2009-11-07 04:22:04Z seongyupyoo $
 */

/**
 * @author dan.arnold
 *
 */
public interface PlayerInterface {

	public int getId();	
	
	public List<Integer> getPlayers();
	
	public void tellPlayers(List<Integer> playerIds);
	
	public int getLastCardIndex();
	
	public void tellLastCardIndex(int index);
	
	public int getBet();
	
	public void tellBet(int playerId, int amount);
	
	public void tellCard(int playerId, int index);
	
	public int getMove();
	
	public void setResult(int result);
	
}
