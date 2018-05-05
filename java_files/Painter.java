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
// <none>

public class Painter {

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

	private color DAVINCI_COLOR = Colour.davesColour();
	private double DAVINCI_STOKE_RADIUS = 2;
	private double DAVINCI_STOKE_X_POSITION = 5;
	private double DAVINCI_STOKE_Y_POSITION = 5;;
	private void drawLikeDaVinci() {
		BrushStroke daVinciBrushStroke = BrushStroke.strokeCircleWithColourRadiusXAndY(DAVINCI_COLOR, DAVINCI_STOKE_RADIUS, DAVINCI_STOKE_X_POSITION, DAVINCI_STOKE_Y_POSITION);
		canvasToDrawOn.drawBrushStrokeOnCanvas(daVinciBrushStroke);
	}

	private void drawLikeTrash() {
		canvasToDrawOn.clearCanvasOfAllPaintAndDaves();
	}
}