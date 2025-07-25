package gameObjects;

import java.awt.Graphics;
import java.awt.Polygon;
import java.util.ArrayList;
import utils.Node;

public class HeroShip {

	private ArrayList<Node> nodes;
	private int centerX = 400, centerY = 400, shipSize = 30;
	private double rotation, rad;

	public HeroShip() {
		nodes = new ArrayList<Node>();
		generateShape();
	}

	private void generateShape() {
		int angleStep = 360 / 3;
		for (int i = 0; i < 3; i++) {
			rad = Math.toRadians(i * angleStep - 90);
			int px = (int) (Math.cos(rad) * shipSize);
			int py = (int) (Math.sin(rad) * shipSize);
			nodes.add(new Node(px, py));
		}
	}

	public void draw(Graphics g) {

		if (nodes.size() >= 2) {
			Polygon p = new Polygon();
			for (Node n : nodes) {
				
				int xRotated = (int) (n.getX() * Math.cos(rotation) - n.getY() * Math.sin(rotation));
				int yRotated = (int) (n.getX() * Math.sin(rotation) + n.getY() * Math.cos(rotation));

				p.addPoint(centerX + xRotated, centerY + yRotated);
			}
			g.drawPolygon(p);
		}

	}

	public void rotate(int rotation) {
		this.rotation += Math.toRadians(rotation);
	}
}
