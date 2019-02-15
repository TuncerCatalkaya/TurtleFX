package test;

/**
 * Constants class for the failed messages (for testing) see {@link test.TurtleFXTest}.
 * 
 * @author Tuncer Catalkaya
 * @version 1.0
 */
public final class FailedMsg {

	/**
	 * Constructor is private, so there is no way to create an object of this class.
	 */
	private FailedMsg() {}
	
	/**
	 * Constant for the failed message of the pen position.
	 */
	public static final String PEN = "Pen position failed!";
	
	/**
	 * Constant for the failed message of the angle in degrees.
	 */
	public static final String ANGLE_DEG = "Angle in degrees failed!";
	
	/**
	 * Constant for the failed message of the angle in radians.
	 */
	public static final String ANGLE_RAD = "Angle in radians failed!";
	
	/**
	 * Constant for the failed message of the usage of radians.
	 */
	public static final String RADIANS = "Radians boolean failed!";
	
	/**
	 * Constant for the failed message of the x position.
	 */
	public static final String POSITION_X = "Position x failed!";
	
	/**
	 * Constant for the failed message of the y position.
	 */
	public static final String POSITION_Y = "Position y failed!";
}