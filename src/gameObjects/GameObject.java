package gameObjects;

import java.awt.Graphics;
import java.awt.Polygon;
import java.util.ArrayList;

import utils.Node;

public abstract class GameObject implements Collidable {
	protected ArrayList<Node> nodes;
	protected double rotation, radians, velocity;
	protected int radius, nrOfNodes;
	protected Node origin;
	protected Polygon p;

	public GameObject(Node spawnPoint) {
		nodes = new ArrayList<Node>();
		origin = spawnPoint;
	}

	public void move() {
		double dx = Math.cos(rotation) * velocity;
		double dy = Math.sin(rotation) * velocity;

		origin.setX(origin.getX() + dx);
		origin.setY(origin.getY() + dy);
	}

	protected void generateShape() {
		int angleStep = 360 / nrOfNodes;
		for (int i = 0; i < nrOfNodes; i++) {
			radians = Math.toRadians(i * angleStep);
			double px = Math.cos(radians) * radius;
			double py = Math.sin(radians) * radius;
			nodes.add(new Node(px, py));
		}
	}

	public void draw(Graphics g) {

		if (nodes.size() >= 2) {
			p = new Polygon();
			for (Node n : nodes) {

				double xRotated = n.getX() * Math.cos(rotation) - n.getY() * Math.sin(rotation);
				double yRotated = n.getX() * Math.sin(rotation) + n.getY() * Math.cos(rotation);

				p.addPoint((int) (origin.getX() + xRotated), (int) (origin.getY() + yRotated));
			}
			g.drawPolygon(p);
		}

	}

	public void rotate(int rotation) {
		this.rotation += Math.toRadians(rotation);
	}

	public void accelerate() {
		velocity += 1;
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
