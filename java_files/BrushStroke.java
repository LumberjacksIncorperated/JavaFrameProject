import java.awt.*;

public class BrushStroke {
	private Colour colour;
	private int x, y, radius;

	public void paintThisStrokeUponMyGraphics(Graphics graphics) {
		System.out.println("paint stuff here");
		graphics.setColor(colour.toColor());
		graphics.fillOval(x-radius, y-radius, radius*2, radius*2);
	}
	
	private BrushStroke() {}

	public static BrushStroke strokeCircleWithColourRadiusXAndY(Colour colour, double radius, double x, double y) {
		BrushStroke strokeOfACirlce = new BrushStroke();
System.out.println("brush stroke here");
		strokeOfACirlce.colour = colour;
		strokeOfACirlce.radius = (int)radius;
		strokeOfACirlce.x = (int)x;
		strokeOfACirlce.y = (int)y;

		return strokeOfACirlce;
	}
}