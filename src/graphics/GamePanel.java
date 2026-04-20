package graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import gameObjects.GameObject;
import utils.WrapAroundHandler;

public class GamePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private List<GameObject> gameObjects;

	public GamePanel(Dimension dimension) {
		super();
		setPreferredSize(dimension);
		gameObjects = new ArrayList<GameObject>();
		setBackground(Color.black);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.setColor(Color.WHITE);
		for (GameObject o : gameObjects) {
			o.draw(g);
		}
	}

	public void addObject(GameObject o) {
		if (o != null) {
			gameObjects.add(o);
		}
	}

	public void update() {
		for (GameObject o : gameObjects) {
			WrapAroundHandler.wrap(o, getSize());
			o.move();
		}
	}

}
