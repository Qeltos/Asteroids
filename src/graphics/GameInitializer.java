package graphics;

import java.awt.Dimension;
import javax.swing.Timer;
import controllers.Controller;
import gameObjects.HeroShip;
import utils.AsteroidHandler;

public class GameInitializer {

	private final GamePanel panel;
	private final GameFrame frame;
	private final HeroShip player;
	private final Controller controller;
	private Timer timer, asteroidSpawnTimer;

	public GameInitializer(Dimension dimension) {

		panel = new GamePanel(dimension);
		frame = new GameFrame(panel);
		player = new HeroShip(dimension.getWidth() / 2, dimension.getHeight() / 2);
		controller = new Controller(player);

		panel.addObject(player);

		controllerSetup();
		timer = new Timer(16, e -> {
			controller.update();
			panel.update();
			panel.repaint();
		});
		timer.start();
		asteroidSpawnTimer = new Timer(2000, e -> {
			panel.addObject(AsteroidHandler.create(dimension));
		});
		asteroidSpawnTimer.start();

	}

	private void controllerSetup() {
		panel.setInputMap(0, controller.getInputMap());
		panel.setActionMap(controller.getActionMap());
	}
}
