import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.net.URL;
import java.util.Random;

public class RandomImages extends Applet {

	// image variable
	private Image image;

	//identity transformaton
	AffineTransform identity = new AffineTransform();
	
	private URL getURL(String fileName) {

		URL url = null;
		try {

			url = this.getClass().getResource(fileName);
		} catch (Exception e) {

		}
		return url;

	}

	// applet init event
	public void init() {
			
			image = getImage(getURL("spaceship.png"));
		}

	// applet paint event
	public void paint(Graphics g) {

		// create an instance of grapphics2d
		Graphics2D g2d = (Graphics2D) g;
		
		//working transform object
		AffineTransform trans = new AffineTransform();

		//random number gerator
		Random rand = new Random();
		
		//applet window width/height
		int width = getSize().width;
		int height = getSize().height;
		
		// fill the background with black
		g2d.setColor(Color.BLACK);
		g2d.fillRect(0, 0, getSize().width, getSize().height);

		//draw the image multiple times
		for(int n=0; n<50;n++) {
			
			trans.setTransform(identity);
			
			//move, rotate, scale the image randomly
			trans.translate(rand.nextInt() % width, rand.nextInt() % height);
			trans.rotate(Math.toRadians(360 * rand.nextDouble()));
			double scale = rand.nextDouble()+1;
			trans.scale(scale, scale);
			
			// draw Image
			g2d.drawImage(image, trans, this);
		}
	}
}
