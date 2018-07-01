
import java.awt.*;
import java.awt.Event.*;
import java.applet.*;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.geom.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

//essa classe cria um pentágono giratório. Para girá-lo é necessário o clique do mouse
public class RotatePolygonSemUsoApplet extends JFrame implements KeyListener, MouseListener {

	public static void main(String[] args) {
		
		RotatePolygonSemUsoApplet a = new RotatePolygonSemUsoApplet();
		
	}
	private int[] xpoints = { 0, -10, -7, 7, 10 };
	private int[] ypoints = { -10, -2, 10, 10, -2 };

	// here's the shape used for drawing
	private Polygon poly;

	// polygon rotation variable
	int rotation = 0;
	
	// applet init event
	
	public  RotatePolygonSemUsoApplet() {

		setSize(800, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		// create the polygon
		poly = new Polygon(xpoints, ypoints, xpoints.length);

		// initialize the listeners
		addKeyListener(this);
		addMouseListener(this);
	}

	// applet paint event
	public void paint(Graphics g) {

		// create an instance of graphics2D
		Graphics2D g2d = (Graphics2D) g;

		// save the identity transform
		AffineTransform identity = new AffineTransform();

		// save the window width/height
		int width = getSize().width;
		int height = getSize().height;

		// fill the background with black
		g2d.setColor(Color.BLACK);
		g2d.fillRect(0, 0, width, height);

		// move, rotate, and scale the shape randomly
		g2d.translate(width / 2, height / 2);
		g2d.scale(20, 20);
		g2d.rotate(Math.toRadians(rotation));

		// draw the shape with a random color
		g2d.setColor(Color.RED);
		g2d.fill(poly);
		g2d.setColor(Color.BLUE);
		g2d.fill(poly);

	}

	// handle keyboard events
	@Override
	public void mouseClicked(MouseEvent e) {
		addKeyListener(this);
	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent m) {

		switch (m.getButton()) {
		case MouseEvent.BUTTON1:
			
			rotation--;
			if (rotation < 0) {
				rotation = 359;
			}
			repaint();
			break;
		case MouseEvent.BUTTON3:

			rotation++;
			if (rotation > 360) {
				rotation = 0;
			}
			repaint();
			break;

		default:
			break;
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent k) {

		switch (k.getKeyCode()) {
		case KeyEvent.VK_LEFT:

			rotation--;
			if (rotation < 0) {
				rotation = 359;
			}
			repaint();
			break;
		case KeyEvent.VK_RIGHT:
			rotation++;
			if (rotation > 360) {
				rotation = 0;
				repaint();
			}
			break;
		default:
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

}

