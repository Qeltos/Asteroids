package utils;

import java.awt.Dimension;

import gameObjects.GameObject;

public final class WrapAroundHandler {
	
	private WrapAroundHandler() {
	}
	
	public static void wrap(GameObject o, Dimension dim) {
		if (o.getOrigin().getX() < 0) {
			o.getOrigin().setX(dim.width);
		}
		
		else if (o.getOrigin().getX() > dim.width) {
			o.getOrigin().setX(0);
		}
		if (o.getOrigin().getY() < 0) {
			o.getOrigin().setY(dim.height);
		}
		
		else if (o.getOrigin().getY() > dim.height) {
			o.getOrigin().setY(0);
		}
	}

}
