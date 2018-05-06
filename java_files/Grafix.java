import java.awt.*;
import java.util.*;

public class Grafix extends BaseObject {
	private Graphics graphics = null;

	private Grafix(Graphics graphics) {
		this.graphics = graphics;
	}

	public static Grafix facadeGrafixObject() {
		return new Grafix(null);
	}

	public static Grafix grafixFromGraphics(Graphics graphics) {
		return new Grafix(graphics);
	}

	public void fillOval(int leftMostPosition, int topMostPosition, int height, int width) {
		this.monitorMethodCallWithNameAndObjects("fillOval", new BaseObject[] {
			ObjectDescription.descriptionOfInt(leftMostPosition),
			ObjectDescription.descriptionOfInt(topMostPosition),
			ObjectDescription.descriptionOfInt(height),
			ObjectDescription.descriptionOfInt(width)
		});
		
		if (this.graphics != null) {
			this.graphics.fillOval(leftMostPosition, topMostPosition, width, height);
		}
	}

	public void setColour(Colour colour) {
		this.monitorMethodCallWithNameAndObjects("setColour", new BaseObject[] {colour});
		if (this.graphics != null) {
			this.graphics.setColor(colour.toColor());
		}
	}

	public void clear() {
		this.monitorMethodCallWithNameAndObjects("clear", new BaseObject[] {});
	}


}