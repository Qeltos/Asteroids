package gameObjects;


import utils.Node;

public interface Collidable {
	
	Boolean collided(Collidable object);
	void onCollision(Collidable object);
	Node getOrigin();
	double getRadius();

}
