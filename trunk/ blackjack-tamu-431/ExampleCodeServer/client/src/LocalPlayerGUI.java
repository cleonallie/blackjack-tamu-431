import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 * $Id: LocalPlayerGUI.java 39 2009-11-07 04:29:51Z dan.arnold $
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
public class LocalPlayerGUI extends JFrame {

	private JButton standButton;
	private JButton hitButton;
	private JButton bidButton;
	private JTextField bidField;
	
	private void initGUI() {
		try {
			{
				getContentPane().setLayout(null);
				{
					hitButton = new JButton();
					getContentPane().add(hitButton);
					hitButton.setText("Hit");
					hitButton.setBounds(391, 118, 79, 22);
				}
			}
			pack();
			this.setSize(481, 173);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
