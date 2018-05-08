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

// Chain Testing Framework
import chain_testing.*;

public class Colour extends BaseObject {

	//-----------------------------------------------------------------------------------------------------------------------
    // FUNCTIONAL CODE
    //-----------------------------------------------------------------------------------------------------------------------
	private static int RED_COLOUR = 0;
	private static int BLUE_COLOUR = 1;
	private static int GREEN_COLOUR = 2;

	private Color color;

	public String asString() {
		String colorString;
		if(this.color == Color.red) {
			colorString =  "RED";
		} else 
		if(this.color == Color.blue) {
			colorString =  "BLUE";
		} else 
		if(this.color == Color.green) {
			colorString =  "GREEN";
		} else {
			colorString =  "NOT A COLOUR";
		}
		return colorString;
	}

	public String getStringDescriptionOfMonitoredInformation() {
		return "[is a trash dave colour]";
	}

	private Colour(int colourSpecification) {
		this.monitorMethodCallWithNameAndObjects("Colour()", new BaseObject[] {
			ObjectDescription.descriptionOfInt(colourSpecification),
		});

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
		this.monitorMethodCallWithNameAndObjects("toColor()", new BaseObject[] {
			ObjectDescription.descriptionOfInt(0),
		});

		return this.color;
	}
    //-----------------------------------------------------------------------------------------------------------------------
    // TESTING CODE
    //-----------------------------------------------------------------------------------------------------------------------
    private static int TEST_COLOR = Colour.RED_COLOUR;

    public static void main(String[] args) {
        runTests();
    }

    private static void runTests() {
    	daveColourTest();
    }

    private static void daveColourTest() {

    	MonitorAssistant.compareNonThreadedMonitoredCallsWithCallbackAndTestDescription(new MonitorAssistantDelegate() {
    		
    		public void executeTestCalls() {
				Colour newColour = Colour.davesColour();
    		}

    		public void executeExpectedCalls() {
    			Colour newColour = new Colour(TEST_COLOR);
    		}

    	}, "Daves Colour");
    }
}