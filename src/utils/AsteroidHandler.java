package utils;

import java.awt.Dimension;
import java.util.Random;

import gameObjects.Asteroid;
import gameObjects.GameObject;

public final class AsteroidHandler {

	private static final Random RAND = new Random();

	private AsteroidHandler() {
	}

	public static GameObject create(Dimension dim) {

		int side = RAND.nextInt(4);
		double x = 0, y = 0, velocity = 1.5, orientation = 0;

		switch (side) {
		case 0: // top
			x = RAND.nextDouble(0, dim.getWidth());
			y = 0;
			orientation = 90;
			break;
		case 1: // bottom
			x = RAND.nextDouble(0, dim.getWidth());
			y = dim.getHeight();
			orientation = -90;
			break;
		case 2: // left
			x = 0;
			y = RAND.nextDouble(0, dim.getHeight());
			orientation = 0;
			break;
		case 3: // right
			x = dim.getWidth();
			y = RAND.nextDouble(0, dim.getHeight());
			orientation = 180;
			break;
		}

		Asteroid asteroid = new Asteroid(new Node(x, y));
		asteroid.rotate(orientation);
		asteroid.accelerate(velocity);
		return asteroid;
	}

}
