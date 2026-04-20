package gameObjects;

import java.util.Random;

import utils.Node;

public class Asteroid extends GameObject {

	private final int SMALL = 10;
	private final int MEDIUM = 25;
	private final int LARGE = 50;

	public Asteroid(double x, double y) {
		this(new Node(x, y));
	}

	public Asteroid(Node spawnPoint) {
		super(spawnPoint);
		Random rand = new Random();
		rotation = rand.nextDouble(-1, 1);
		nrOfNodes = rand.nextInt(7, 17);
		size(rand.nextInt(1, 4));
		generateShape();
	}

	private void size(int key) {

		switch (key) {
		case 1: {
			radius = SMALL;
			break;
		}
		case 2: {
			radius = MEDIUM;
			break;
		}
		case 3: {
			radius = LARGE;
			break;
		}
		}
	}

	@Override
	public void onCollision(Collidable object) {
		// TODO Auto-generated method stub
	}

	@Override
	protected void generateShape() {
		int angleStep = 360 / nrOfNodes;
		for (int i = 0; i < nrOfNodes; i++) {
			radians = Math.toRadians(i * angleStep);
			double offset = (Math.random() - 0.5) * radius * 0.4;
			double px = Math.cos(radians) * radius + offset;
			double py = Math.sin(radians) * radius + offset;
			nodes.add(new Node(px, py));
		}
	}

}
