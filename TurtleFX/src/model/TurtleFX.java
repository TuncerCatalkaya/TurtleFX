package model;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;

/**
 * The turtle is by default:<br>
 *  * using degrees<br>
 *  * facing 0 degrees<br>
 *  * pen up<br>
 *  * at the position x=0 and y=0<br><br>
 * The following definition is used for defining where the turtle should face at which degree(mathematical one):<br>
 *  * 0 degrees = facing right<br>
 *  * 90 degrees = facing up<br>
 *  * 180 degrees = facing left<br>
 *  * 270 degrees = facing down<br>
 *  * 360 degrees = facing right<br>
 *  * -90 degrees = facing down<br>
 *  * -180 degrees = facing left<br>
 *  * -270 degrees = facing up<br>
 *  * -360 degrees = facing right<br>
 * 
 * @author Tuncer Catalkaya
 * @version 1.0
 */
public class TurtleFX implements ITurtleFX {

	/**
	 * Default boolean value of the pen down attribute.
	 */
	public static final boolean DEFAULT_PENDOWN = false;
	
	/**
	 * Default boolean value of the radians attribute. 
	 */
	public static final boolean DEFAULT_RADIANS = false;
	
	/**
	 * Default double value of the angle attribute.
	 */
	public static final double DEFAULT_ANGLE = 0d;
	
	/**
	 * Default 2D vector of the position attribute.
	 */
	public static final Point2D DEFAULT_POS = new Point2D(0d, 0d);
	
	
	/**
	 * Attribute to keep track of the pen position (true = down, false = up).
	 */
	private boolean penDown = DEFAULT_PENDOWN;
	
	/**
	 * Attribute to keep track whether radians or degrees are used.
	 */
	private boolean radians = DEFAULT_RADIANS;
	
	/**
	 * Attribute to keep track of the current position of the turtle.
	 */
	private Point2D pos = DEFAULT_POS;
	
	/**
	 * Attribute to keep track of the current angle the turtle is facing.
	 */
	private double angle = DEFAULT_ANGLE;
	
	/**
	 * Attribute to keep track on which canvas the turtle should work.
	 */
	private GraphicsContext gc;
	
	/**
	 * Constructor to create a TurtleFX.
	 * 
	 * @param gc GraphicsContext of the canvas on which the turtle should work.
	 */
	public TurtleFX(GraphicsContext gc) {
		this.gc = gc;
	}

	
	@Override
	public void penUp() {
		penDown = false;
	}
	
	@Override
	public void penDown() {
		penDown = true;
	}

	
	@Override
	public void forward(double length) {
		// if the pen is up
		// then don't draw (exit the method)
		if(!penDown) {
			return;
		}
		
		double angleTmp = this.angle;
		// if degrees should be used
		// then convert the degrees to radians(in temp variable) and work with that
		if (!radians) {
			angleTmp = Math.toRadians(angleTmp);
		}
		
		// draw the line
		double newX = length * Math.sin(angleTmp);
		double newY = length * Math.cos(angleTmp);
		gc.strokeLine(pos.getX(), pos.getY(), newX, newY);
		
		// set the position to the new position(after drawing)
		setPos(newX, newY);
	}

	@Override
	public void turn(double angle) {
		this.angle += angle;
	}
	
	@Override
	public void reset() {
		penDown = DEFAULT_PENDOWN;
		radians = DEFAULT_RADIANS;
		pos = DEFAULT_POS;
		angle = DEFAULT_ANGLE;
	}

	
	@Override
	public void setPos(Point2D pos) {
		this.pos = pos;
	}

	@Override
	public void setPos(double posX, double posY) {
		this.pos = new Point2D(posX, posY);
	}

	@Override
	public void setAngle(double angle) {
		this.angle = angle;
	}

	@Override
	public void setRadians(boolean radians) {
		this.radians = radians;
	}

	@Override
	public boolean isPenDown() {
		return penDown;
	}

	@Override
	public Point2D getPos() {
		return pos;
	}

	@Override
	public double getAngle() {
		return angle;
	}

	@Override
	public boolean isRadians() {
		return radians;
	}
	
	@Override
	public GraphicsContext getGC() {
		return gc;
	}
}