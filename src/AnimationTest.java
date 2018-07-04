import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.Random;

public class AnimationTest extends Applet implements Runnable{

	static int SCREENWIDTH = 640;
	static int SCREENHEIGHT = 480;
	
	Thread gameLoop;
	Random rand = new Random();
	
	//double buffer objects
	BufferedImage backbuffer;
	Graphics2D g2d;
	
	//background image
	Image background;
	
	//sprite variables
	Image ball;
	int ballX = 300, ballY = 200;
	int speedX, speedY;
	
	//animation variables
	int currentFrame =0;
	int totalFrames = 64;
	int animationDirection=1;
	int frameCount=0;
	int frameDelay=5;
	
	private URL getURL(String fileName) {
		
		URL url = null;
		
		try {
			url = this.getClass().getResource(fileName);
		} catch (Exception e) {
			
		}
		
		return url;
	}
	
	public void init() {
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		
		//create the back buffer for smooth graphics
		backbuffer = new BufferedImage(SCREENWIDTH, SCREENHEIGHT, BufferedImage.TYPE_INT_RGB);
		g2d = backbuffer.createGraphics();
		
		//load the background image
		background = tk.getImage(getURL("dinossaurinhoC.png"));
		
		//load the ball animation strip
		ball = tk.getImage(getURL("dinossaurinhoC.png"));
		speedX = rand.nextInt(6)+1;
		speedY = rand.nextInt(6)+1;
	}
	
	public void start() {
		gameLoop = new Thread(this);
		gameLoop.start();
	}
	public void stop() {
		gameLoop = null;
	}
	
	@Override
	public void run() {
		
		Thread t = Thread.currentThread();
		
		while(t == gameLoop) {
			
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			gameUpdate();
			repaint();
		}
	}

	public void gameUpdate() {
		
		//see if it's time to animate
		frameCount++;
		if(frameCount > frameDelay) {
			
			frameCount = 0;
			//update the animation frame
			currentFrame += animationDirection;
			if(currentFrame > totalFrames -1) {
				currentFrame = 0;
			}
			else if(currentFrame < 0) {
				currentFrame = totalFrames -1;
			}
		}
		//update the ball position
		ballX += speedX;
		if((ballX < 0) || (ballX > SCREENWIDTH - 64)) {
			
			speedX *= -1;
			ballX += speedX;
		}
		ballY += speedY;
		if((ballY < 0) || (ballY > SCREENWIDTH - 64)) {
			
			speedY *= -1;
			ballY += speedY;
		}
	}
	
	public void update(Graphics g) {
		
		//draw the current frame of animation
		drawFrame(ball,g2d,ballX,ballY,8,currentFrame,64,64);
		
		g2d.setColor(Color.BLACK);
		g2d.drawString("Position: " + ballX +","+ballY, 5,10);
		g2d.drawString("Velocity: " + speedX +","+speedY, 5,25);
		g2d.drawString("Animation: " + currentFrame,5,40);
		paint(g);
	}
	public void paint(Graphics g) {
		
		//draw the back buffer to the screen
		g.drawImage(backbuffer, 0, 0, this);
	}
	
	//draw a single frame of animation
	public void drawFrame(Image source, Graphics2D dest, int x, int y, int cols, int frame, int width, int height) {
		int fx = (frame % cols) * width;
		int fy = (frame / cols) * height;
		dest.drawImage(source, x, y, x+width, y+height, fx, fy, fx+width, fy+height, this);
	}
}
