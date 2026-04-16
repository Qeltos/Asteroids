package graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import gameObjects.GameObject;

public class GamePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private List<GameObject> objects;

	public GamePanel(Dimension dimension) {
		super();
		setPreferredSize(dimension);
		objects = new ArrayList<GameObject>();
	}

	@Override
	public void paintComponent(Graphics g) {

		g.setColor(Color.WHITE);
		for (int i = 0; i < objects.size(); i++) {
			objects.get(i).draw(g);
		}
	}

	public void addObject(GameObject o) {
		objects.add(o);
	}

}
