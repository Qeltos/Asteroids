package gameObjects;

import utils.Node;

public class HeroShip extends GameObject{

	public HeroShip(double x, double y) {
		this(new Node(x, y));
	}

	public HeroShip(Node spawnPoint) {
		super(spawnPoint);
		rotation = Math.toRadians(-90);
		radius = 30;
		generateShape();
	}

	public void rotate(int rotation) {
		this.rotation += Math.toRadians(rotation);
	}

	public void accelerate() {
		velocity += 1;
	}
}
