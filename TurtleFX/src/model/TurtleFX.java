package model;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;

/**
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
		if (penDown) {
			penDown = !penDown;
		}
	}
	
	@Override
	public void penDown() {
		if (!penDown) {
			penDown = !penDown;
		}
	}

	@Override
	public void forward(double length) {
		double angleTmp = this.angle;
		if (!radians) {
			angleTmp = Math.toRadians(angleTmp);
		}	
		gc.strokeLine(pos.getX(), pos.getY(), length * Math.sin(angleTmp), length * Math.cos(angleTmp));
	}

	@Override
	public void turn(double angle) {
		if (radians) {
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
		if (radians) {
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