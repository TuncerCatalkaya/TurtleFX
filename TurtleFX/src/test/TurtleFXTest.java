package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javafx.scene.canvas.Canvas;
import model.TurtleFX;

public class TurtleFXTest {
	
	private static TurtleFX t;
	
	@BeforeAll
	public static void initAll() {
		t = new TurtleFX(new Canvas(1000, 1000).getGraphicsContext2D());
	}
	
	@Test
	public void testPenUpDown() {	
		// Test if the initialisation values are correct
		Assertions.assertEquals(false, t.isPenDown());
		
		// Set the pen up while the pen is up
		t.penUp();
		Assertions.assertEquals(false, t.isPenDown());
		
		// Set the pen down while the pen is up
		t.penDown();
		Assertions.assertEquals(true, t.isPenDown());
		
		// Set the pen down while the pen is down
		t.penDown();
		Assertions.assertEquals(true, t.isPenDown());
		
		// Set the the pen  up while the pen is down
		t.penUp();
		Assertions.assertEquals(false, t.isPenDown());
		
		
	}
}