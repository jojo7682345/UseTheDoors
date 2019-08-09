package modules.objects.player;

import core.texturing.Sprite;
import modules.objects.Entity;
import modules.objects.SpriteObject;

public class Player extends SpriteObject implements Entity{

	public Player() {
		super(Sprite.load("player"));
	}
	
	@Override public void onCreate() {
		scale();
		Controller controller = new Controller(20);
		addComponent("Controller",controller);
	}

}
