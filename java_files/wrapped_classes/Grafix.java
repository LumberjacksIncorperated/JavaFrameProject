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
// PACKAGE
//-----------------------------------------------------------------------------------------------------------------------
package wrapped_classes;

//-----------------------------------------------------------------------------------------------------------------------
// IMPORTS
//-----------------------------------------------------------------------------------------------------------------------
import java.awt.*;
import java.util.*;

// Chain Testing Framework
import chain_testing.*;

public class Grafix extends BaseObject {

	//-----------------------------------------------------------------------------------------------------------------------
    // FUNCTIONAL CODE
    //-----------------------------------------------------------------------------------------------------------------------	
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

	public void setColour(Color color) {
		this.monitorMethodCallWithNameAndObjects("setColour", new BaseObject[] {});
		
		if (this.graphics != null) {
			this.graphics.setColor(color);
		}
	}

	public void clear() {
		this.monitorMethodCallWithNameAndObjects("clear", new BaseObject[] {});
	}
}