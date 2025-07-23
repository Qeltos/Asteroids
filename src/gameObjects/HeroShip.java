package gameObjects;

import java.awt.Graphics;
import java.awt.Polygon;
import java.util.ArrayList;
import utils.Node;

public class HeroShip {
	
	private ArrayList<Node> nodes;
	
	public HeroShip() {
		nodes = new ArrayList<Node>();
		generateShape();
	}

	private void generateShape() {
		int angleStep = 360 / 3;
		for (int i = 0; i < 3; i++) {
			double angle = Math.toRadians(i * angleStep - 90);
            int px = (int) (Math.cos(angle) * 120) + 400;
            int py = (int) (Math.sin(angle) * 120) + 400;
            nodes.add(new Node(px, py));
		}
		
		for(Node n : nodes) {
			System.out.println(n);
		}
    }
	
	public void draw(Graphics g) {
		if(nodes.size() >= 2) {
			Polygon p = new Polygon();
			for (Node n : nodes) {
			    p.addPoint(n.getX(), n.getY());
			}
			g.drawPolygon(p);		
		}
	}
}
