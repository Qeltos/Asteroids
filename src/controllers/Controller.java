package controllers;

import java.awt.event.ActionEvent;
import java.util.HashSet;
import java.util.Set;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.KeyStroke;

import gameObjects.GameObject;

public class Controller {
    private final GameObject ship;
    private ActionMap am;
    private InputMap im;
    private final Set<String> keysPressed = new HashSet<>();

    public Controller(GameObject ship) {
        this.ship = ship;
        am = new ActionMap();
        im = new InputMap();

        // Key PRESSED
        im.put(KeyStroke.getKeyStroke("pressed UP"), "up_pressed");
        im.put(KeyStroke.getKeyStroke("pressed LEFT"), "left_pressed");
        im.put(KeyStroke.getKeyStroke("pressed RIGHT"), "right_pressed");

        // Key RELEASED
        im.put(KeyStroke.getKeyStroke("released UP"), "up_released");
        im.put(KeyStroke.getKeyStroke("released LEFT"), "left_released");
        im.put(KeyStroke.getKeyStroke("released RIGHT"), "right_released");

        am.put("up_pressed", new KeyAction("up", true));
        am.put("left_pressed", new KeyAction("left", true));
        am.put("right_pressed", new KeyAction("right", true));

        am.put("up_released", new KeyAction("up", false));
        am.put("left_released", new KeyAction("left", false));
        am.put("right_released", new KeyAction("right", false));
    }

    private class KeyAction extends AbstractAction {
        private final String key;
        private final boolean pressed;

        KeyAction(String key, boolean pressed) {
            this.key = key;
            this.pressed = pressed;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (pressed) keysPressed.add(key);
            else keysPressed.remove(key);
        }
    }

    // Anropas av game loopen varje tick
    public void update() {
        if (keysPressed.contains("up")) {
            ship.accelerate(0.1);
        }

        if (keysPressed.contains("left")) {
            ship.rotate(-5);
        }

        if (keysPressed.contains("right")) {
            ship.rotate(5);
        }

        ship.friction(0.99);
        ship.move();
    }

    public InputMap getInputMap()   { return im; }
    public ActionMap getActionMap() { return am; }
}
