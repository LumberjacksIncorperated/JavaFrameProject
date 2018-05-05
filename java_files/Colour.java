//-----------------------------------------------------------------------------------------------------------------------
//
// PROJECT
// -------
// "Java Frame Project"
//
// AUTHOR
// ------
// Lumberjacks Incorperated (2018)
//
//-----------------------------------------------------------------------------------------------------------------------

//-----------------------------------------------------------------------------------------------------------------------
// IMPORTS
//-----------------------------------------------------------------------------------------------------------------------
import java.awt.*;

public class Colour {

	private static int RED_COLOUR = 0;
	private static int BLUE_COLOUR = 1;
	private static int GREEN_COLOUR = 2;

	private Color color;

	private Colour(int colourSpecification) {
		if(colourSpecification == Colour.RED_COLOUR) {
			this.color = Color.red;
		} else
		if(colourSpecification == Colour.BLUE_COLOUR) {
			this.color = Color.blue;
		} else
		if(colourSpecification == Colour.GREEN_COLOUR) {
			this.color = Color.green;
		} else {} 
	}

	public static Colour davesColour() {
		Colour davesColour = new Colour(Colour.RED_COLOUR);
		return davesColour;
	}

	public Color toColor() {
		return this.color;
	}
}