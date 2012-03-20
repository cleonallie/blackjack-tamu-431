import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListModel;

/**
 * $Id: GameBrowserGUI.java 48 2009-11-07 09:48:14Z dan.arnold $
 */


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
/**
 * @author dan
 *
 */
public class GameBrowserGUI extends JFrame {
	
	private GameBrowser g;
	private JButton joinGameButton;
	private JButton createGameButton;
	private JPanel buttonPane;
	private JPanel listPane;
	private JList games;
	private JScrollPane scrollPane;
	
	private List<PlayerListenerInterface> listeners = new ArrayList<PlayerListenerInterface>();

	public GameBrowserGUI( final GameBrowser g ) {
		this.g = g;
		
		initGUI();
		this.setVisible( true );
		
	}
	
	public void getGames() {
		for (PlayerListenerInterface listener : listeners ) {
			System.out.println( "Calling listener.getGames()" );
			listener.getGames(); // Ask the server for the games
		}
	}
	
	public void createGame() {
		Random r = new Random();
		int seed = r.nextInt( Integer.MAX_VALUE );
		g.gameSeed = seed;
		for (PlayerListenerInterface listener : listeners ) {
			System.out.println( "Calling listener.createGame( " + seed + " )" );
			listener.createGame( seed ); // Ask the server for the games
		}
	}
	
	public void joinGame( Integer gameId ) {
		for (PlayerListenerInterface listener : listeners ) {
			System.out.println( "Calling listener.joinGame( " + gameId + ")" );
			listener.joinGame( gameId ); // Ask the server for the games
		}
	}

	/** put games in the JList */
	public void populateList(Integer[] gameIds) {
		DefaultComboBoxModel d = new DefaultComboBoxModel();
		for ( Integer i : gameIds ) {
			System.out.println( "Adding element to gameList: " + i );
			d.addElement( i );
		}
		games.setModel( d );
	}
	
	private void initGUI() {
		try {
			getContentPane().setLayout(null);
			{

				listPane = new JPanel();
				getContentPane().add(listPane);
				BoxLayout listPaneLayout = new BoxLayout(listPane, javax.swing.BoxLayout.Y_AXIS);
				listPane.setLayout(listPaneLayout);
				listPane.setBounds(12, 12, 280, 145);

				scrollPane = new JScrollPane();
				listPane.add(scrollPane);
				scrollPane.setBounds(12, 11, 269, 137);
				scrollPane.setPreferredSize(new java.awt.Dimension(280, 152));
				{
					ListModel gameListModel = 
						new DefaultComboBoxModel(); // stuff in list goes here
					games = new JList();
					scrollPane.setViewportView(games);
					BorderLayout gamesLayout = new BorderLayout();
					games.setLayout(gamesLayout);
					games.setModel(gameListModel);
					games.setBounds(12, 12, 266, 134);
					games.setPreferredSize(new java.awt.Dimension(266, 79));
				}
				
			}
			
			buttonPane = new JPanel();
			getContentPane().add(buttonPane);
			buttonPane.setBounds(19, 169, 263, 38);
			{
				final JButton joinGameButton = new JButton( "Join Game" );
				buttonPane.add(joinGameButton);
				joinGameButton.setBounds(401, 277, 128, 22);
				joinGameButton.addActionListener( new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						joinGame( (Integer)games.getSelectedValue() );
					}
				} );
			}
			
			{
				createGameButton = new JButton();
				buttonPane.add(createGameButton);
				createGameButton.setText("Create Game");
				createGameButton.setBounds(90, 277, 109, 22);
				createGameButton.addActionListener( new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						createGame();
					}
				} );
			}

			pack();
			this.setSize(320, 257);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public synchronized void addListener( PlayerListenerInterface listener ) {
		listeners.add( listener );
	}
}