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
import wrapped_classes.*;

// Chain Testing Framework
import chain_testing.*;

public class BrushStroke extends BaseObject {
	
    //-----------------------------------------------------------------------------------------------------------------------
    // FUNCTIONAL CODE
    //-----------------------------------------------------------------------------------------------------------------------
	private Colour strokeColour;
	private int xPosition;
	private int yPosition;
	private int strokeRadius;

	private BrushStroke(Colour colour, int radius, int xPosition, int yPosition) {
		this.monitorMethodCallWithNameAndObjects("BrushStroke()", new BaseObject[] {
			new ObjectDescription(colour.asString()),
			ObjectDescription.descriptionOfInt(radius),
			ObjectDescription.descriptionOfInt(xPosition),
			ObjectDescription.descriptionOfInt(yPosition)
		});

		this.strokeColour = colour;
		this.strokeRadius = radius;
		this.xPosition = xPosition;
		this.yPosition = yPosition;
	}

	public void paintThisStrokeUponMyGraphics(Grafix graphics) {
		this.monitorMethodCallWithNameAndObjects("paintThisStrokeUponMyGraphics()", new BaseObject[] {
			ObjectDescription.descriptionOfInt(0)
		});
		Color strokeColourToDraw = this.strokeColour.toColor();
		graphics.setColour(strokeColourToDraw);
		drawSelfOnGraphics(graphics);
	}

	private static final int RADIUS_TO_WIDTH_FACTOR = 2;
	private void drawSelfOnGraphics(Grafix graphics) {
		this.monitorMethodCallWithNameAndObjects("drawSelfOnGraphics()", new BaseObject[] {
			ObjectDescription.descriptionOfInt(0)
		});

		int leftMostPosition = xPosition-strokeRadius;
		int topMostPosition = yPosition-strokeRadius;
		int cirleWidth = strokeRadius*BrushStroke.RADIUS_TO_WIDTH_FACTOR;
		int circleHeight = strokeRadius*BrushStroke.RADIUS_TO_WIDTH_FACTOR;
		graphics.fillOval(leftMostPosition, topMostPosition, cirleWidth, circleHeight);
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
    	publicConstructionTest();
    	brushStrokeCirlceTest();
    }

    private static void publicConstructionTest() {

    	MonitorAssistant.compareNonThreadedMonitoredCallsWithCallbackAndTestDescription(new MonitorAssistantDelegate() {
    		
    		public void executeTestCalls() {
				BrushStroke testStroke = strokeCircleWithColourRadiusXAndY(TEST_COLOR, TEST_RADIUS, TEST_X_POSITION, TEST_Y_POSITION);
    		}

    		public void executeExpectedCalls() {
    			BrushStroke brushStoke = new BrushStroke(TEST_COLOR, TEST_RADIUS, TEST_X_POSITION, TEST_Y_POSITION);
    		}

    	}, "Brush Stroke Public Construction");
    }

    private static void brushStrokeCirlceTest() {

    	MonitorAssistant.compareNonThreadedMonitoredCallsWithCallbackAndTestDescription(new MonitorAssistantDelegate() {
    		
    		public void executeTestCalls() {
				Grafix fakeGrafix = Grafix.facadeGrafixObject();
				BrushStroke testStroke = strokeCircleWithColourRadiusXAndY(TEST_COLOR, TEST_RADIUS, TEST_X_POSITION, TEST_Y_POSITION);
				testStroke.paintThisStrokeUponMyGraphics(fakeGrafix);
    		}

    		public void executeExpectedCalls() {
    			Grafix fakeGrafix = Grafix.facadeGrafixObject();
				fakeGrafix.setColour(TEST_COLOR.toColor());
				fakeGrafix.fillOval(TEST_LEFTMOST_POSITION, TEST_RIGHTMOST_POSITION, TEST_CIRCLE_WIDTH, TEST_CIRCLE_HEIGHT);
    		}

    	}, "Brush Stroke Painting");
    }
}