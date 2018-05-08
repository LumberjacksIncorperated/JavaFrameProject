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

class GraphicWindowCanvas extends BaseObject implements Canvas {

    //-----------------------------------------------------------------------------------------------------------------------
    // FUNCTIONAL CODE
    //-----------------------------------------------------------------------------------------------------------------------
    private ArrayList<BrushStroke> brushStrokes;
    private JPanelWrapper jPanelWrapper;

    public GraphicWindowCanvas() {
        this.monitorMethodCallWithNameAndObjects("GraphicWindowCanvas()", new BaseObject[] {
            ObjectDescription.descriptionOfInt(0)
        });

        this.brushStrokes = new ArrayList<BrushStroke>();
        this.jPanelWrapper = new JPanelWrapper();
    }

    public JPanelWrapper getWindowCanvasPanel() {
        this.monitorMethodCallWithNameAndObjects("getWindowCanvasPanel()", new BaseObject[] {
            ObjectDescription.descriptionOfInt(0)
        });

        return this.jPanelWrapper;
    }

    public void drawBrushStrokeOnCanvas(BrushStroke brushStroke) {
        this.monitorMethodCallWithNameAndObjects("drawBrushStrokeOnCanvas()", new BaseObject[] {
            ObjectDescription.descriptionOfInt(0)
        });

        brushStrokes.add(brushStroke);
     	this.askNicelyForThisJPanelToRepaintPlease();
    }

 	public void clearCanvasOfAllPaintAndDaves() {
        this.monitorMethodCallWithNameAndObjects("clearCanvasOfAllPaintAndDaves()", new BaseObject[] {
            ObjectDescription.descriptionOfInt(0)
        });

 		brushStrokes = new ArrayList<BrushStroke>();
 		this.askNicelyForThisJPanelToRepaintPlease();
 	}

 	private void askNicelyForThisJPanelToRepaintPlease() {
 		System.out.println("Gods Be Merciful");
 		this.jPanelWrapper.repaint();
 	}

    public void paintComponent(Grafix graphics) {
        this.monitorMethodCallWithNameAndObjects("paintComponent()", new BaseObject[] {
            ObjectDescription.descriptionOfInt(0)
        });

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
        paintComponentTest();
    }

    private static void paintComponentTest() {

        MonitorAssistant.compareNonThreadedMonitoredCallsWithCallbackAndTestDescription(new MonitorAssistantDelegate() {
            
            private BrushStroke brushStroke1;
            private BrushStroke brushStroke2;
            private BrushStroke brushStroke3;

            public void executeTestCalls() {
                GraphicWindowCanvas graphicWindowCanvas = new GraphicWindowCanvas();
                Grafix fakeGrafix = Grafix.facadeGrafixObject();
                setupTestBrushStrokes();
                drawBrushStrokesOnCanvas(graphicWindowCanvas);
                graphicWindowCanvas.paintComponent(fakeGrafix);

            }

            public void executeExpectedCalls() {
                Grafix fakeGrafix = Grafix.facadeGrafixObject();
                setupTestBrushStrokes();
                paintBrushStrokesOnGrafix(fakeGrafix);
            }

            private void drawBrushStrokesOnCanvas(GraphicWindowCanvas graphicWindowCanvas) {
                graphicWindowCanvas.drawBrushStrokeOnCanvas(this.brushStroke1);
                graphicWindowCanvas.drawBrushStrokeOnCanvas(this.brushStroke2);
                graphicWindowCanvas.drawBrushStrokeOnCanvas(this.brushStroke3);
            }

            private void setupTestBrushStrokes() {
                this.brushStroke1 = BrushStroke.strokeCircleWithColourRadiusXAndY(Colour.davesColour(), 2, 5, 5);
                this.brushStroke2 = BrushStroke.strokeCircleWithColourRadiusXAndY(Colour.davesColour(), 2, 10, 10);
                this.brushStroke3 = BrushStroke.strokeCircleWithColourRadiusXAndY(Colour.davesColour(), 2, 20, 20);
            }

            private void paintBrushStrokesOnGrafix(Grafix grafix) {
                this.brushStroke1.paintThisStrokeUponMyGraphics(grafix);
                this.brushStroke2.paintThisStrokeUponMyGraphics(grafix);
                this.brushStroke3.paintThisStrokeUponMyGraphics(grafix);
            } 

        }, "Paint Component");
    }
}



