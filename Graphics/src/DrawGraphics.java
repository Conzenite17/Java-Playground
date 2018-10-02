import java.awt.Color;
import java.awt.Graphics;

public class DrawGraphics {
	BouncingBox box1;
	BouncingBox box2;
	BouncingBox box3;

	/** Initialises this class for drawing. */
	public DrawGraphics() {
		box1 = new BouncingBox(200, 50, Color.RED);
		box1.setMovementVector(0, -2);
		box2 = new BouncingBox(100, 100, Color.RED);
		box2.setMovementVector(1, 0);
		box3 = new BouncingBox(100, 200, Color.RED);
		box3.setMovementVector(-2, 1);
	}
	
	/** Draw the contents of the window on surface. Called 20 times per second. */
	public void draw(Graphics surface){
		surface.drawLine(50, 50, 250, 250);
		box1.draw(surface);
		box2.draw(surface);
		box3.draw(surface);
	}
}