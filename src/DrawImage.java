import java.awt.*;
import java.applet.*;
import java.net.*;

public class DrawImage extends Applet{

	//image variable
	private Image image;
	
	private URL getURL(String fileName) {
		
		URL url = null;
		try {
			
			url = this.getClass().getResource(fileName);
		}catch(Exception e) {

		}
		return url;
		
	}
	
	//applet init event
	public void init() {
		
		image = getImage(getURL("<<castle.png>>"));
	}
	
	//applet paint  event
	public void paint(Graphics g) {
		
		//create an instance of grapphics2d
		Graphics2D g2d = (Graphics2D) g;
		
		//fill the background with black
		g2d.setColor(Color.BLACK);
		g2d.fillRect(0, 0, getSize().width, getSize().height);
		
		//drawImaage
		g2d.drawImage(image,0,0,this);
	}
}
