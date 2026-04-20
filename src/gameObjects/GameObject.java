package gameObjects;

import java.awt.Graphics;
import java.awt.Polygon;
import java.util.ArrayList;

import utils.Node;

public abstract class GameObject implements Collidable {
	private final int LINE_LIMIT = 2;
	protected ArrayList<Node> nodes;
	protected double rotation, radians, vx, vy;
	protected int radius, nrOfNodes;
	protected Node origin;
	protected Polygon p;

	public GameObject(Node spawnPoint) {
		nodes = new ArrayList<Node>();
		origin = spawnPoint;
	}

	public void move() {
		origin.setX(origin.getX() + vx);
		origin.setY(origin.getY() + vy);
	}
	
	public void accelerate(double velocity) {
	    vx += Math.cos(rotation) * velocity;
	    vy += Math.sin(rotation) * velocity;
	}
	
	public void friction(double factor) {
	    vx *= factor;
	    vy *= factor;
	}

	protected abstract void generateShape();

	public void draw(Graphics g) {

		if (nodes.size() >= LINE_LIMIT) {
			p = new Polygon();
			for (Node n : nodes) {

				double xRotated = n.getX() * Math.cos(rotation) - n.getY() * Math.sin(rotation);
				double yRotated = n.getX() * Math.sin(rotation) + n.getY() * Math.cos(rotation);

				p.addPoint((int) (origin.getX() + xRotated), (int) (origin.getY() + yRotated));
			}
			g.drawPolygon(p);
		}

	}

	public void rotate(double rotation) {
		this.rotation += Math.toRadians(rotation);
	}

	@Override
	public Boolean collided(Collidable object) {

		double dx = origin.getX() - object.getOrigin().getX();
		double dy = origin.getY() - object.getOrigin().getY();
		double distanceSquared = dx * dx + dy * dy;

		double radiusSum = this.getRadius() + object.getRadius();

		return distanceSquared < (radiusSum * radiusSum);
	}

	@Override
	public abstract void onCollision(Collidable object);

	@Override
	public Node getOrigin() {
		return origin;
	}

	@Override
	public double getRadius() {
		return radius;
	}

}
