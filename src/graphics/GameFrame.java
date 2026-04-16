package graphics;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

public class GameFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GamePanel gamePanel;

	public GameFrame(Dimension dimension) {
		super("Asteroids");

		gamePanel = new GamePanel(dimension);
		gamePanel.setFocusable(true);

		add(gamePanel);
		pack();
		setBackground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
