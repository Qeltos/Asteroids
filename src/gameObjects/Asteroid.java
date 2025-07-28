package gameObjects;

import java.util.Random;

import utils.Node;

public class Asteroid extends GameObject {

	public Asteroid(double x, double y) {
		this(new Node(x, y));
	}

	public Asteroid(Node spawnPoint) {
		super(spawnPoint);
		Random rand = new Random();
		radius = 100;
		rotation = rand.nextDouble(-1, 1);
		velocity = 1;
		nrOfNodes = rand.nextInt(7, 17);
		generateShape();
	}

	@Override
	public void onCollision(Collidable object) {
		// TODO Auto-generated method stub

	}
}
