import java.awt.*;
public class Colour {

	private Colour() {}

	public static Colour davesColour() {
		Colour davesColour = new Colour();
		return davesColour;
	}

	public Color toColor() {
		return Color.red;
	}
}