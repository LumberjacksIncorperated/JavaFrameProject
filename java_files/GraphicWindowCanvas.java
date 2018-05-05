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
        for (BrushStroke brushStroke : this.brushStrokes) {
            brushStroke.paintThisStrokeUponMyGraphics(graphics);
        }
    }
}