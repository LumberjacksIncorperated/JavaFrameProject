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
import javax.swing.*;
import java.util.*;

public class BrushStroke {
	
    //-----------------------------------------------------------------------------------------------------------------------
    // FUNCTIONAL CODE
    //-----------------------------------------------------------------------------------------------------------------------
	private Colour strokeColour;
	private int xPosition;
	private int yPosition;
	private int strokeRadius;

	private BrushStroke(Colour colour, int radius, int xPosition, int yPosition) {
		this.strokeColour = colour;
		this.strokeRadius = radius;
		this.xPosition = xPosition;
		this.yPosition = yPosition;
	}

	public void paintThisStrokeUponMyGraphics(Grafix graphics) {
		graphics.setColour(this.strokeColour);
		drawSelfOnGraphics(graphics);
	}

	private static final int RADIUS_TO_WIDTH_FACTOR = 2;
	private void drawSelfOnGraphics(Grafix graphics) {
		int leftMostPosition = xPosition-strokeRadius;
		int rightMostPosition = yPosition-strokeRadius;
		int cirleWidth = strokeRadius*BrushStroke.RADIUS_TO_WIDTH_FACTOR;
		int circleHeight = strokeRadius*BrushStroke.RADIUS_TO_WIDTH_FACTOR;
		graphics.fillOval(leftMostPosition, rightMostPosition, cirleWidth, circleHeight);
	}

	public static BrushStroke strokeCircleWithColourRadiusXAndY(Colour colour, double radius, double xPosition, double yPosition) {
		BrushStroke strokeOfACirlce = new BrushStroke(colour, (int) radius, (int) xPosition, (int) yPosition);
		return strokeOfACirlce;
	}

    //-----------------------------------------------------------------------------------------------------------------------
    // TESTING CODE
    //-----------------------------------------------------------------------------------------------------------------------
    private static Colour TEST_COLOR = Colour.davesColour();
    private static int TEST_RADIUS = 2;
    private static int TEST_X_POSITION = 5;
    private static int TEST_Y_POSITION = 5;
    private static Color TEST_DRAWING_COLOR = Color.red;
    private static int TEST_LEFTMOST_POSITION = BrushStroke.TEST_X_POSITION - BrushStroke.TEST_RADIUS;
    private static int TEST_RIGHTMOST_POSITION = BrushStroke.TEST_X_POSITION - BrushStroke.TEST_RADIUS;
    private static int TEST_CIRCLE_HEIGHT = BrushStroke.TEST_RADIUS*BrushStroke.RADIUS_TO_WIDTH_FACTOR;
    private static int TEST_CIRCLE_WIDTH = BrushStroke.TEST_RADIUS*BrushStroke.RADIUS_TO_WIDTH_FACTOR;

    public static void main(String[] args) {
        runTests();
    }

    private static void runTests() {
    	brushStrokeCirlceTest();
    }

    private static void brushStrokeCirlceTest() {

    	MonitorAssistant.compareNonThreadedMonitoredCallsWithCallbackAndTestDescription(new MonitorAssistantDelegate() {
    		
    		public void executeTestProgram() {
				Grafix fakeGrafix = Grafix.facadeGrafixObject();
				BrushStroke testStroke = strokeCircleWithColourRadiusXAndY(TEST_COLOR, TEST_RADIUS, TEST_X_POSITION, TEST_Y_POSITION);
				testStroke.paintThisStrokeUponMyGraphics(fakeGrafix);
    		}

    		public void executeExpectedCalls() {
    			Grafix fakeGrafix = Grafix.facadeGrafixObject();
				fakeGrafix.setColour(TEST_COLOR);
				fakeGrafix.fillOval(TEST_LEFTMOST_POSITION, TEST_RIGHTMOST_POSITION, TEST_CIRCLE_WIDTH, TEST_CIRCLE_HEIGHT);
    		}

    	}, "Brush stroke");
    }
}
