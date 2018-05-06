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

public class Colour extends BaseObject {

	//-----------------------------------------------------------------------------------------------------------------------
    // FUNCTIONAL CODE
    //-----------------------------------------------------------------------------------------------------------------------
	private static int RED_COLOUR = 0;
	private static int BLUE_COLOUR = 1;
	private static int GREEN_COLOUR = 2;

	private Color color;

	public String getStringDescriptionOfMonitoredInformation() {
		return "[is a trash dave colour]";
	}

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

	//-----------------------------------------------------------------------------------------------------------------------
    // TESTING CODE
    //-----------------------------------------------------------------------------------------------------------------------
    public static void main(String[] args) {
        runTests();
    }

    private static void runTests() {
        davesColourTest();
    }
    
    private static void davesColourTest() {
        Colour daveColour = Colour.davesColour();
    	assert(daveColour.toColor() == Color.red);
    }
}