package gameObjects;

import utils.Node;

public class HeroShip extends GameObject {

	public HeroShip(double x, double y) {
		this(new Node(x, y));
	}

	public HeroShip(Node spawnPoint) {
		super(spawnPoint);
		rotation = Math.toRadians(-90);
		radius = 30;
		nrOfNodes = 3;
		generateShape();
	}

	@Override
	public void onCollision(Collidable object) {
	}

}
