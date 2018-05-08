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
import wrapped_classes.*;

// Chain Testing Framework
import chain_testing.*;

public class Painter {

	//-----------------------------------------------------------------------------------------------------------------------
    // FUNCTIONAL CODE
    //-----------------------------------------------------------------------------------------------------------------------
	private Canvas canvasToDrawOn;

	private Painter(Canvas canvasToDrawOn) {
		this.canvasToDrawOn = canvasToDrawOn;
	}

	public static Painter findAHomelessDaveOnTheStreetAndGiveHimACanvasToDrawBeautifullyOn(Canvas canvasToDrawOn) {
		Painter newPainter = new Painter(canvasToDrawOn);
		return newPainter;
	}

	public void orderDaveToDoAThingWithPaintOnTheCanvasWeJustGaveHim(DrawingCommand drawingCommand) {
		if (drawingCommand.canIBeLeonardoDaVinciNow()) {
			drawLikeDaVinci();
		} else 
		if (drawingCommand.isATrashCommand()){
			drawLikeTrash();
		} else {}
	}

	private Colour DAVINCI_COLOR = Colour.davesColour();
	private double DAVINCI_STOKE_RADIUS = 2;
	private double DAVINCI_STOKE_X_POSITION = 5;
	private double DAVINCI_STOKE_Y_POSITION = 5;;
	private void drawLikeDaVinci() {
		System.out.println("here");
		BrushStroke daVinciBrushStroke = BrushStroke.strokeCircleWithColourRadiusXAndY(DAVINCI_COLOR, DAVINCI_STOKE_RADIUS, DAVINCI_STOKE_X_POSITION, DAVINCI_STOKE_Y_POSITION);
		canvasToDrawOn.drawBrushStrokeOnCanvas(daVinciBrushStroke);
	}

	private void drawLikeTrash() {
		canvasToDrawOn.clearCanvasOfAllPaintAndDaves();
	}

	//-----------------------------------------------------------------------------------------------------------------------
    // TESTING CODE
    //-----------------------------------------------------------------------------------------------------------------------
    public static void main(String[] args) {
        runTests();
    }

    private static void runTests() {
    	orderCommandTest();
    }

    private static void orderCommandTest() {

    	MonitorAssistant.compareNonThreadedMonitoredCallsWithCallbackAndTestDescription(new MonitorAssistantDelegate() {
    		
			private Colour DAVINCI_COLOR = Colour.davesColour();
			private double DAVINCI_STOKE_RADIUS = 2;
			private double DAVINCI_STOKE_X_POSITION = 5;
			private double DAVINCI_STOKE_Y_POSITION = 5;;

    		public void executeTestCalls() {
				GraphicWindowCanvas graphicWindowCanvas = new GraphicWindowCanvas();
				Painter dave = Painter.findAHomelessDaveOnTheStreetAndGiveHimACanvasToDrawBeautifullyOn(graphicWindowCanvas);
				DrawingCommand daVinviDrawingCommand = createDaVinciDrawingCommand();
    			dave.orderDaveToDoAThingWithPaintOnTheCanvasWeJustGaveHim(daVinviDrawingCommand);
    		}

    		private DrawingCommand createDaVinciDrawingCommand() {
    			DrawingCommand daVinviDrawingCommand = DrawingCommand.createADrawingCommandWithAnInputCommandString("what do you even do dave?");
    			return daVinviDrawingCommand;
    		}

    		public void executeExpectedCalls() {
    			GraphicWindowCanvas graphicWindowCanvas = new GraphicWindowCanvas();
    			BrushStroke daVinciBrushStroke = BrushStroke.strokeCircleWithColourRadiusXAndY(DAVINCI_COLOR, DAVINCI_STOKE_RADIUS, DAVINCI_STOKE_X_POSITION, DAVINCI_STOKE_Y_POSITION);
				graphicWindowCanvas.drawBrushStrokeOnCanvas(daVinciBrushStroke);
    		}

    	}, "Order Command Test");
    }
}