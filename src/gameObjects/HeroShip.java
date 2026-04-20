package gameObjects;

import utils.Node;

public class HeroShip extends GameObject {

	public HeroShip(double x, double y) {
		this(new Node(x, y));
	}

	public HeroShip(Node spawnPoint) {
		super(spawnPoint);
		rotation = Math.toRadians(-90); // riktning som skeppet pekar vid start
		generateShape();
	}

	@Override
	public void onCollision(Collidable object) {
	}
	
	@Override
	protected void generateShape() {
        nodes.add(new Node(15, 0));	// skepp nos
        nodes.add(new Node(-10, -10));	// vänster bak
        nodes.add(new Node(-5, 0));		// skepp mitt bak
        nodes.add(new Node(-10, 10));	// höger bak
	}

}
