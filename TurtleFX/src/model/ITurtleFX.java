package model;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;

/**
 * The interface holds all of the appointed methods of the {@link model.TurtleFX} class.
 * 
 * @author Tuncer Catalkaya
 * @version 1.0
 */
public interface ITurtleFX {

	/**
	 * Method to set the pen up.
	 */
	abstract void penUp();
	
	/**
	 * Method to set the pen down.
	 */
	abstract void penDown();
	
	
	/**
	 * Method to move the turtle by the given length.
	 * 
	 * @param length Length the turtle should move forward
	 */
	abstract void forward(double length);
	
	/**
	 * Method to turn the turtle by the given angle.<br>
	 * To use radians, look at the method "setRadians".
	 * 
	 * @param angle Angle the turtle should turn
	 */
	abstract void turn(double angle);
	
	/**
	 * Method to reset the turtle and set it to the default values.
	 */
	abstract void reset();
	
	
	/**
	 * Method to set the current position of the turtle on the canvas.
	 * 
	 * @param pos Desired position of the turtle as Point2D
	 */
	abstract void setPos(Point2D pos);
	
	/**
	 * Method to set the current position of the turtle on the canvas.
	 * 
	 * @param posX Desired x position of the turtle as double
	 * @param posY Desired y position of the turtle as double
	 */
	abstract void setPos(double posX, double posY);
	
	/**
	 * Method to set the angle of the turtle.<br>
	 * To use radians, look at the method "setRadians".
	 * 
	 * @param angle Angle the turtle should face
	 */
	abstract void setAngle(double angle);
	
	/**
	 * Method to decide whether degrees or radians should be used.<br>
	 * true = radians<br>
	 * false = degrees (default)
	 */
	abstract void setRadians(boolean radians);
	
	
	/**
	 * Method to get whether the pen is down or not.
	 * 
	 * @return Whether the pen is down or not
	 */
	abstract boolean isPenDown();
	
	/**
	 * Method to get the current position of the turtle.
	 * 
	 * @return Current position of the turtle as Point2D
	 */
	abstract Point2D getPos();
	
	/**
	 * Method to get the angle the turtle is facing.<br>
	 * To use radians, look at the method "setRadians".
	 * 
	 * @return Angle the turtle is facing
	 */
	abstract double getAngle();
	
	/**
	 * Method to get whether radians or degress are used.
	 * 
	 * @return true is radians and false is degrees
	 */
	abstract boolean isRadians();
	
	/**
	 * Method to get the canvas on which the turtle is working on.
	 * 
	 * @return The current active canvas of the turtle
	 */
	abstract GraphicsContext getGC();
}