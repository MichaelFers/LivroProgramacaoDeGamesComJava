import java.awt.*;
import java.awt.Rectangle;

//bullet class - polygonal shape of bullet
public class Bullet extends BaseVectorShape{

	//boounding rectangle
	public Rectangle getBounds() {
		
		return new Rectangle((int) getX(),(int) getY(),1,1);
	}
	//default constructor
	public Bullet() {
		setShape(new Rectangle(0,0,1,1));
		setAlive(false);
	}
}
