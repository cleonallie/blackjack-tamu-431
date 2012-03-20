
import java.awt.event.*;
import javax.swing.*;

/**
 * A container of buttons for player options in Blackjack: Hit, Stand, Double, 
 * Split, Surrender.
 * 
 * @author Vance Zuo
 */
public class ChoicePanel extends JPanel {
        
        private JButton hit = new JButton("Hit");
        private JButton stand = new JButton("Stand");
        private JButton dbl = new JButton("Double");    
        private JButton split = new JButton("Split");
        private JButton surrender = new JButton("Surrender");
        
        /**
         * Makes a choice panel with the above buttons
         */
        public ChoicePanel() {
                super();        
                setOpaque(false); 
                add(hit);
                add(stand);
                add(dbl);
                add(split);
                disableSplit(); //Not implementable, yet
                add(surrender);
        }
        
        /**
         * Enable hit button
         */
        public void enableHit() {
                hit.setEnabled(true);
        }
        
        /**
         * Enable stand button
         */
        public void enableStand() {
                stand.setEnabled(true);
        }
        
        /**
         * Enable double button
         */
        public void enableDouble() {
                dbl.setEnabled(true);
        }
        
        /**
         * Enable split button
         */
        public void enableSplit() {
                split.setEnabled(true);
        }

        /**
         * Enable surrender button
         */
        public void enableSurrender() {
                surrender.setEnabled(true);
        }
        
        /**
         * Disable hit button
         */
        public void disableHit() {
                hit.setEnabled(false);
        }
        
        /**
         * Disable stand button
         */
        public void disableStand() {
                stand.setEnabled(false);
        }

        /**
         * Disable double button
         */
        public void disableDouble() {
                dbl.setEnabled(false);
        }
        
        /**
         * Disable split button
         */
        public void disableSplit() {
                split.setEnabled(false);
        }
        
        /**
         * Disable surrender button
         */
        public void disableSurrender() {
                surrender.setEnabled(false);
        }

        /**
         * Adds a listener for these buttons. The listener should contain responses
         * for each of these button commands.
         * @param a listener of these buttons
         */
        public void addListener(ActionListener a) {
                hit.addActionListener(a);
                stand.addActionListener(a);
                dbl.addActionListener(a);
                split.addActionListener(a);
                surrender.addActionListener(a);
        }
}
