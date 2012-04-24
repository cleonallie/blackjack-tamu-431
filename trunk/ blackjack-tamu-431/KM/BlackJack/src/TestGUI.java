import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;

public class TestGUI extends JFrame {

	private JPanel mainStage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestGUI frame = new TestGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TestGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 800, 600);
		mainStage = new JPanel();
		mainStage.setBackground(SystemColor.desktop);
		mainStage.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainStage);
		mainStage.setLayout(null);
		
		JButton btnNewButton = new JButton("Play Game");
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(255, 204, 0));
		btnNewButton.setFont(new Font("Verdana", Font.BOLD, 18));
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Adam\\Documents\\School\\CSCE 431\\cmagedeck\\SA.png"));
		btnNewButton.setBounds(286, 200, 250, 105);
		mainStage.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Exit");
		btnNewButton_1.setFont(new Font("Verdana", Font.BOLD, 16));
		btnNewButton_1.setBounds(286, 330, 250, 40);
		mainStage.add(btnNewButton_1);
	}
}
