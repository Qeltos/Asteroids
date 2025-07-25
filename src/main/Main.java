package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import gameObjects.HeroShip;

public class Main extends JPanel implements KeyListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HeroShip hero;
	private final int WIDTH = 800, HEIGHT = 800;
	
	public Main() {
		setPreferredSize(new Dimension(HEIGHT, WIDTH));
		setBackground(Color.BLACK);
		
		JFrame frame = new JFrame("Asteroids");
		
		frame.add(this);
		frame.addKeyListener(this);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		hero = new HeroShip();
	}

	public static void main(String[] args) {
		
		Main game = new Main();

	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.white);
		hero.draw(g);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println(e.getKeyChar());
		
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			hero.rotate(5);
			repaint();
		}
		
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			hero.rotate(-5);
			repaint();
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
