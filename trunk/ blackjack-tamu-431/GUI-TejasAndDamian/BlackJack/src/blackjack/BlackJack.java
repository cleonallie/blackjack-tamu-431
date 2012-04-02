/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;
import java.awt.*;
import javax.swing.JFrame;
/**
 *
 * @author Tejas
 */
public class BlackJack {
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       MainPage mP = new MainPage();
       mP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       mP.setVisible(true);
    }
}
