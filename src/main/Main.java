package main;

import javax.swing.*;

import gameObjects.Asteroid;
import gameObjects.GameObject;
import gameObjects.HeroShip;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Main extends JPanel implements ActionListener, KeyListener {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<GameObject> gameObjects = new ArrayList<>();
	private GameObject ship;
    private Timer timer;
    private Timer asteroidSpawnTimer;
    private final int WIDTH = 800, HEIGHT = 600;
    
    public Main() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);
        
        ship = new HeroShip(WIDTH / 2, HEIGHT /2) ;
        gameObjects.add(ship);
        
        timer = new Timer(16, this); // 60 FPS (1000ms / 60 ≈ 16ms per frame)
        asteroidSpawnTimer = new Timer(5000, x -> {
        	gameObjects.add(new Asteroid(150,150));
        }) ;
        timer.start();
        asteroidSpawnTimer.start();
        
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        
    }
    
    public void spawnAsteroids() {
    	
    }
   

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        
        for (GameObject o : gameObjects) {
        	o.draw(g);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	for (GameObject o : gameObjects) {
    		o.move();
    	}
                
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            ship.rotate(-5);
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            ship.rotate(5);
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            ship.accelerate();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}

    public static void main(String[] args) {
        JFrame frame = new JFrame("Asteroids Game");
        Main game = new Main();
        frame.add(game);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
