package modules.objects.player;

import org.lwjgl.glfw.GLFW;

import core.kernel.CoreEngine;
import core.kernel.Input;
import core.scene.Component;

public class Controller extends Component{

	private float speed;
	private int[] input = {GLFW.GLFW_KEY_W,GLFW.GLFW_KEY_A,GLFW.GLFW_KEY_S,GLFW.GLFW_KEY_D};
	

	public Controller(float speed) {
		this.speed = speed;
	}
	
	public Controller(float speed, int[] input) {
		this(speed);
		this.input = input;
	}
	
	@Override public void update() {
		Input i = Input.getInstance();
		float xAxis = (i.isKeyHold(input[3])?1:0)-(i.isKeyHold(input[1])?1:0);
		float yAxis = (i.isKeyHold(input[0])?1:0)-(i.isKeyHold(input[2])?1:0);
		float xTarg = 0;
		float yTarg = 0;
		if(xAxis!=0||yAxis!=0) {
			xTarg = (float)(Math.cos(Math.atan2(yAxis,xAxis)))*speed*CoreEngine.deltaTime/1000;
			yTarg = (float)(Math.sin(Math.atan2(yAxis,xAxis)))*speed*CoreEngine.deltaTime/1000;
		}
		//do collision check;
		getWorldTransform().addTranslation(xTarg,yTarg,0);
	}

	@Override public void render() {
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

}
