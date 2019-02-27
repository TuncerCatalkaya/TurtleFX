package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import model.TurtleFX;


/**
 * Unit test for the TurtleFX class.<br>
 *  Test objectives:<br>
 *   - check if the method reset() sets the turtle back to the default values/settings.<br>
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
	
	public static final double CANVAS_SIZE = 1000d; 
	
	@Test
	public void testReset() {
		TurtleFX t = new TurtleFX(new Canvas(CANVAS_SIZE, CANVAS_SIZE).getGraphicsContext2D());
		
		// check if the default values of the turtle are correct
		Assertions.assertEquals(false, t.isPenDown(), "1: " + FailedMsg.PEN);
		Assertions.assertEquals(0d, t.getAngle(), "2: " + FailedMsg.ANGLE_DEG);
		Assertions.assertEquals(false, t.isRadians(), "3: " + FailedMsg.RADIANS);
		Assertions.assertEquals(0d, t.getPos().getX(), "4: " + FailedMsg.POSITION_X);
		Assertions.assertEquals(0d, t.getPos().getY(), "5: " + FailedMsg.POSITION_Y);
		
		// change the pendown value
		t.penDown();
		Assertions.assertEquals(true, t.isPenDown(), "6: " + FailedMsg.PEN);
		
		// change the angle value
		t.setAngle(66.04d);
		Assertions.assertEquals(66.04d, t.getAngle(), "7: " + FailedMsg.ANGLE_DEG);
		
		// change the radians value
		t.setRadians(true);
		Assertions.assertEquals(true, t.isRadians(), "8: " + FailedMsg.RADIANS);
		
		// change the position value
		t.setPos(23.43d, 34.67d);
		Assertions.assertEquals(23.43d, t.getPos().getX(), "9: " + FailedMsg.POSITION_X);
		Assertions.assertEquals(34.67d, t.getPos().getY(), "10: " + FailedMsg.POSITION_Y);
		
		// reset the turtle back, after all the value changes
		t.reset();
		
		// check if all the values of the reseted turtle are back to the default values
		Assertions.assertEquals(false, t.isPenDown(), "11: " + FailedMsg.PEN);
		Assertions.assertEquals(0d, t.getAngle(), "12: " + FailedMsg.ANGLE_DEG);
		Assertions.assertEquals(false, t.isRadians(), "13: " + FailedMsg.RADIANS);
		Assertions.assertEquals(0d, t.getPos().getX(), "14: " + FailedMsg.POSITION_X);
		Assertions.assertEquals(0d, t.getPos().getY(), "15: " + FailedMsg.POSITION_Y);
	}
	
	@Test
	public void testPen() {
		TurtleFX t = new TurtleFX(new Canvas(CANVAS_SIZE, CANVAS_SIZE).getGraphicsContext2D());
		
		// set the pen up while the pen is up
		t.penUp();
		Assertions.assertEquals(false, t.isPenDown(), "1: " + FailedMsg.PEN);
		
		// set the pen down while the pen is up
		t.penDown();
		Assertions.assertEquals(true, t.isPenDown(), "2: " + FailedMsg.PEN);
		
		// set the pen down while the pen is down
		t.penDown();
		Assertions.assertEquals(true, t.isPenDown(), "3: " + FailedMsg.PEN);
		
		// set the the pen up while the pen is down
		t.penUp();
		Assertions.assertEquals(false, t.isPenDown(), "4: " + FailedMsg.PEN);
	}
	
	@Test
	public void testAngle() {
		TurtleFX t = new TurtleFX(new Canvas(CANVAS_SIZE, CANVAS_SIZE).getGraphicsContext2D());
		
		
	}
	
	@Test
	public void testPos() {
		TurtleFX t = new TurtleFX(new Canvas(CANVAS_SIZE, CANVAS_SIZE).getGraphicsContext2D());
		
		// 0,0 position with setPos(double,double)
		t.setPos(0, 0);
		Assertions.assertEquals(0d, t.getPos().getX(), "1: " + FailedMsg.POSITION_X);
		Assertions.assertEquals(0d, t.getPos().getY(), "2: " + FailedMsg.POSITION_Y);
		
		// 0,0 position with setPos(Point2D(double,double)
		t.setPos(new Point2D(0, 0));
		Assertions.assertEquals(0d, t.getPos().getX(), "3: " + FailedMsg.POSITION_X);
		Assertions.assertEquals(0d, t.getPos().getY(), "4: " + FailedMsg.POSITION_Y);
		
		// positive integer position
		t.setPos(32, 16);
		Assertions.assertEquals(32d, t.getPos().getX(), "5: " + FailedMsg.POSITION_X);
		Assertions.assertEquals(16d, t.getPos().getY(), "6: " + FailedMsg.POSITION_Y);
		
		// positive double and positive integer position
		t.setPos(32.232, 16);
		Assertions.assertEquals(32.232d, t.getPos().getX(), "7: " + FailedMsg.POSITION_X);
		Assertions.assertEquals(16d, t.getPos().getY(), "8: " + FailedMsg.POSITION_Y);
		
		// positive integer and positive double position
		t.setPos(32, 16.123);
		Assertions.assertEquals(32d, t.getPos().getX(), "9: " + FailedMsg.POSITION_X);
		Assertions.assertEquals(16.123d, t.getPos().getY(), "10: " + FailedMsg.POSITION_Y);
		
		// positive double and positive double position
		t.setPos(32.14, 16.68);
		Assertions.assertEquals(32.14d, t.getPos().getX(), "11: " + FailedMsg.POSITION_X);
		Assertions.assertEquals(16.68d, t.getPos().getY(), "12: " + FailedMsg.POSITION_Y);
		
		// negative integer position
		t.setPos(-1, -2323);
		Assertions.assertEquals(-1d, t.getPos().getX(), "13: " + FailedMsg.POSITION_X);
		Assertions.assertEquals(-2323d, t.getPos().getY(), "14: " + FailedMsg.POSITION_Y);
		
		// negative double and negative double position
		t.setPos(-342.43, -548.3);
		Assertions.assertEquals(-342.43d, t.getPos().getX(), "15: " + FailedMsg.POSITION_X);
		Assertions.assertEquals(-548.3d, t.getPos().getY(), "16: " + FailedMsg.POSITION_Y);
	}
	
	@Test
	public void testDraw() {
		TurtleFX t = new TurtleFX(new Canvas(CANVAS_SIZE, CANVAS_SIZE).getGraphicsContext2D());
		// TODO
	}
}