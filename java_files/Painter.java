
public class Painter {

	private Canvas canvasToDrawOn;

	private Painter() {}

	public static Painter findAHomelessDaveOnTheStreetAndGiveHimACanvasToDrawBeautifullyOn(Canvas canvasToDrawOn) {
		Painter newPainter = new Painter();
		newPainter.canvasToDrawOn = canvasToDrawOn;
		return newPainter;
	}

	public void orderDaveToDoAThingWithPaintOnTheCanvasWeJustGaveHim(DrawingCommand drawingCommand) {
		if (drawingCommand.canIBeLeonardoDaVinciNow()) {
			drawLikeDaVinci();
		} else {
			drawLikeTash();
		}
	}

	private void drawLikeDaVinci() {
		BrushStroke daVinciBrushStroke = BrushStroke.strokeCircleWithColourRadiusXAndY(Colour.davesColour(), 2, 5, 5);
		canvasToDrawOn.drawBrushStroke(daVinciBrushStroke);
	}

	private void drawLikeTash() {
		canvasToDrawOn.clearCanvasOfAllPaintAndDaves();
	}
}