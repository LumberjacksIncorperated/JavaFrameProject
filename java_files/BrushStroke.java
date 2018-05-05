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

public class BrushStroke {
	
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

	public void paintThisStrokeUponMyGraphics(Graphics graphics) {
		Color strokeColorOnGraphics = this.strokeColour.toColor();
		graphics.setColor(strokeColorOnGraphics);
		drawSelfOnGraphics(graphics);
	}

	private int RADIUS_TO_WIDTH_FACTOR = 2;
	private void drawSelfOnGraphics(Graphics graphics) {
		int leftMostPosition = xPosition-strokeRadius;
		int rightMostPosition = yPosition-strokeRadius;
		int cirleWidth = strokeRadius*RADIUS_TO_WIDTH_FACTOR;
		int circleHeight = strokeRadius*RADIUS_TO_WIDTH_FACTOR;
		graphics.fillOval(leftMostPosition, rightMostPosition, cirleWidth, circleHeight);
	}

	public static BrushStroke strokeCircleWithColourRadiusXAndY(Colour colour, double radius, double xPosition, double yPosition) {
		BrushStroke strokeOfACirlce = new BrushStroke(colour, (int) radius, (int) xPosition, (int) yPosition);
		return strokeOfACirlce;
	}
}