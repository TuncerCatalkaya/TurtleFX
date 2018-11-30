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

	public static final boolean DEFAULT_PENUP = true;
	public static final boolean DEFAULT_PENDOWN = false;
	public static final boolean DEFAULT_RADIANS = false;
	
	public static final double DEFAULT_ANGLE = 0d;
	
	public static final Point2D DEFAULT_POS = new Point2D(0d, 0d);
	
	
	private boolean penDown = DEFAULT_PENDOWN;
	private boolean radians = DEFAULT_RADIANS;
	
	private Point2D pos = DEFAULT_POS;
	
	private double angle = DEFAULT_ANGLE;
	
	private GraphicsContext gc;
	
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
		double angleTmp = this.angle;
		if (!radians) {
			angleTmp = Math.toRadians(angleTmp);
		}
		
		double newX = length * Math.sin(angleTmp);
		double newY = length * Math.cos(angleTmp);
		gc.strokeLine(pos.getX(), pos.getY(), newX, newY);
		setPos(newX, newY);
	}

	@Override
	public void turn(double angle) {
		if (!radians) {
			angle = Math.toRadians(angle);
		}
		this.angle += angle;
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
		if (!radians) {
			angle = Math.toRadians(angle);
		}
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
}