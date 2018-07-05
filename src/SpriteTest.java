import java.applet.*;
import java.awt.*;
import java.awt.Image.*;
import java.awt.image.BufferedImage;
import java.util.*;
import java.net.*;

public class SpriteTest extends Applet implements Runnable{

	int screenWidth = 640;
	int screenHeight = 480;
	
	//double buffer objects
	BufferedImage backbuffer;
	Graphics2D g2d;
	
	Sprite asteroid;
	ImageEntity background;
	Thread gameloop;
	Random rand = new Random();
	
	public void init() {
		
		//create the back buffer for smooth graphics
		backbuffer = new BufferedImage(screenWidth, screenHeight, BufferedImage.TYPE_INT_RGB);
		g2d = backbuffer.createGraphics();
		
		//load the background 
		background = new ImageEntity(this);
		background.load("dinossaurinhoC.png");
		
		//load the asteroid sprite
		asteroid = new Sprite(this, g2d);
		asteroid.load("dinossaurinhoC.png");
	}
	
	public void start() {
		
		gameloop = new Thread(this);
		gameloop.start();
	}
	
	public void stop() {
		gameloop = null;
	}
		
	@Override
	public void run() {
		
		Thread t = Thread.currentThread();
		while( t == gameloop) {
			
			try {
				Thread.sleep(30);
			} catch (Exception e) {
				e.printStackTrace();
			}
			repaint();
		}
	}

	public void update(Graphics g) {
		
		//draw the background
		g2d.drawImage(background.getImage(),0,0,screenWidth - 1, screenHeight - 1, this);
		
		int width = screenWidth - asteroid.imageWidth() -1;
		int height = screenHeight - asteroid.imageHeigt() - 1;
		
		Point2D point = new Point2D(rand.nextInt(width), rand.nextInt(height));
		asteroid.setPosition(point);
		asteroid.transform();
		asteroid.draw();
		paint(g);
	}
	
	public void paint(Graphics g) {
		
		//draw the back buffer to the screen
		g.drawImage(backbuffer,0,0,this);
	}
	
}







