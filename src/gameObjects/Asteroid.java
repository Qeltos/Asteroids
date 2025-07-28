package gameObjects;

import java.util.Random;

import utils.Node;

public class Asteroid extends GameObject{
	
	public Asteroid(double x, double y) {
		this(new Node(x, y));
	}
	
	public Asteroid(Node spawnPoint) {
		super(spawnPoint);
		Random rand = new Random();
		radius = 100;
		nrOfNodes = rand.nextInt(7,17);
		generateShape();
	}



}
