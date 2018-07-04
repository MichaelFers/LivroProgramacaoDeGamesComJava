import java.awt.*;
import java.awt.geom.Point2D;
import java.applet.*;

public class Sprite extends Object {

	private ImageEntity entity;
	protected Point2D pos;
	protected Point2D vel;;
	protected double rotRate;
	protected int currentState;
	
	//constructor
	public Sprite(Applet a, Graphics2D g2d) {
		
		entity = new ImageEntity(a);
		entity.setGraphics(g2d);
		entity.setAlive(false);

		pos = new Point2D(0,0);
		vel = new Point2D(0,0);
		rotRate = 0.0;
		currentState = 0;
	}
	//load bitmap file
	public void load() {
		
	}
}
