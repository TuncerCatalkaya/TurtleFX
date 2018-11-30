package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javafx.scene.canvas.Canvas;
import model.FailedMsg;
import model.TurtleFX;


/**
 * Unit test for the TurtleFX class.<br>
 *  Test objectives:<br>
 *   - while doing all the tests listed down below, also check if the reset() method resets everything back to the default values.<br>
 *   - check if the methods penUp() and penDown() sets the pen exactly as defined up and down.<br>
 *   - check if the method turn(Double) turns exactly as defined the turtle and also check if the setAngle(Double) method sets the angle to the desired angle.
 *     While doing that, also check whether the radians and degrees boolean is working exactly as defined.<br>
 *   - check if the method setPos(Point2D) and setPos(Double, Double) is setting the position exactly as defined.<br>
 *   - check if the forward(Double) method is drawing while the pen is down. Also check if the the position is exactly as defined updated.
 *     While doing that, also check whether the radians and degrees boolean is working exactly as defined.<br>
 * 
 * The canvas that is used while testing is: 1000 by 1000 big.
 * 
 * @author Tuncer Catalkaya
 * @version 1.0
 */
public class TurtleFXTest {
	
	private static TurtleFX t;
	
	@BeforeAll
	public static void initAll() {
		t = new TurtleFX(new Canvas(1000, 1000).getGraphicsContext2D());
	}
	
	@Test
	public void testPen() {
		// Test if the initialisation values are correct
		Assertions.assertEquals(false, t.isPenDown(), "1: " + FailedMsg.PEN);

		// Set the pen up while the pen is up
		t.penUp();
		Assertions.assertEquals(false, t.isPenDown(), "2: " + FailedMsg.PEN);
		
		// Set the pen down while the pen is up
		t.penDown();
		Assertions.assertEquals(true, t.isPenDown(), "3: " + FailedMsg.PEN);
		
		// Set the pen down while the pen is down
		t.penDown();
		Assertions.assertEquals(true, t.isPenDown(), "4: " + FailedMsg.PEN);
		
		// Set the the pen  up while the pen is down
		t.penUp();
		Assertions.assertEquals(false, t.isPenDown(), "5: " + FailedMsg.PEN);
		
		// Reset while the pen is up
		t.reset();
		Assertions.assertEquals(false, t.isPenDown(), "6: " + FailedMsg.PEN);
		
		// Reset while the pen is down
		t.penDown();
		t.reset();
		Assertions.assertEquals(false, t.isPenDown(), "7: " + FailedMsg.PEN);
	}
	
	@Test
	public void testAngle() {
		// TODO
	}
	
	@Test
	public void testPos() {
		// TODO
	}
	
	@Test
	public void testDraw() {
		// TODO
	}
}