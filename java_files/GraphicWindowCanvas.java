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

class GraphicWindowCanvas extends JPanel implements Canvas {

    //-----------------------------------------------------------------------------------------------------------------------
    // FUNCTIONAL CODE
    //-----------------------------------------------------------------------------------------------------------------------
    private ArrayList<BrushStroke> brushStrokes;

    public GraphicWindowCanvas() {
        this.brushStrokes = new ArrayList<BrushStroke>();
    }

    public void drawBrushStrokeOnCanvas(BrushStroke brushStroke) {
        brushStrokes.add(brushStroke);
     	this.askNicelyForThisJPanelToRepaintPlease();
    }

 	public void clearCanvasOfAllPaintAndDaves() {
 		brushStrokes = new ArrayList<BrushStroke>();
 		this.askNicelyForThisJPanelToRepaintPlease();
 	}

 	private void askNicelyForThisJPanelToRepaintPlease() {
 		System.out.println("Gods Be Merciful");
 		this.repaint();
 	}

    public void paintComponent(Graphics graphics) {
        graphics.clear();
        for (BrushStroke brushStroke : this.brushStrokes) {
            brushStroke.paintThisStrokeUponMyGraphics(graphics);
        }
    }

    //-----------------------------------------------------------------------------------------------------------------------
    // TESTING CODE
    //-----------------------------------------------------------------------------------------------------------------------
    public static void main(String[] args) {
        runTests();
    }

    private static void runTests() {
    }
}


