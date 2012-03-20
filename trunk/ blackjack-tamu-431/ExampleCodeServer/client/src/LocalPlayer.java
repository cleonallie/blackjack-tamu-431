import java.util.List;

/**
 * $Id: LocalPlayer.java 44 2009-11-07 04:42:04Z dan.arnold $
 */

/**
 * @author dan
 *
 */
public class LocalPlayer implements PlayerInterface {

	private int id;
	
	public LocalPlayer(int playerId) {
		id = playerId;
	}

	public int getBet() {
		// get bet from gui
		return 0;
	}

	
	public int getMove() {
		// get hit or stay from gui
		return 0;
	}

	
	public int getId() {
		return id;
	}

	public void setBet(int bet, int id, int gameId) {
		// I'm local, ignore
	}

	
	public int getLastCardIndex() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public List<Integer> getPlayers() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void setResult(int result) {
		// TODO Auto-generated method stub
		
	}

	
	public void tellBet(int playerId, int amount) {
		// TODO Auto-generated method stub
		
	}

	
	public void tellCard(int playerId, int index) {
		// TODO Auto-generated method stub
		
	}

	
	public void tellLastCardIndex(int index) {
		// TODO Auto-generated method stub
		
	}

	
	public void tellPlayers(List<Integer> playerIds) {
		// TODO Auto-generated method stub
		
	}
}
