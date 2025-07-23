package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import gameObjects.HeroShip;

public class Main extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HeroShip hero;
	private final int WIDTH = 800, HEIGHT = 800;
	
	public Main() {
		setPreferredSize(new Dimension(HEIGHT, WIDTH));
		setBackground(Color.BLACK);
		hero = new HeroShip();
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Asteroids");
		Main game = new Main();
		frame.add(game);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.white);
		hero.draw(g);
	}

}
