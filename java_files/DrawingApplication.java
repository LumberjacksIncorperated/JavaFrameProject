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
import java.util.Scanner;

public class DrawingApplication {

    private Scanner commandLineInputReader = new Scanner(System.in);
    private Canvas graphicWindowCanvas;
    private Painter daveThePainter;

	public void runApplication() {
		setupCanvas();
		setupPainter();
		runUserInteractionLoopGivingCommandsToDave();
	}

	private void setupCanvas() {
		GraphicWindow graphicsWindow = new GraphicWindow();
		this.graphicWindowCanvas = graphicsWindow.getThisWindowsCanvas();
	}

	private void setupPainter() {
		Canvas canvasToDrawOn = this.graphicWindowCanvas;
		this.daveThePainter = Painter.findAHomelessDaveOnTheStreetAndGiveHimACanvasToDrawBeautifullyOn(canvasToDrawOn);
	}

	private void runUserInteractionLoopGivingCommandsToDave() {
		while(true) {
			printUserInteractionMessage();
			DrawingCommand userDrawingCommand = getDrawingCommand();
			giveDrawingCommandToDave(userDrawingCommand);
		}
	}

	private void printUserInteractionMessage() {
		System.out.println("*** Painting Application ***");
		System.out.println("To Paint Like Davinci - enter: what do you even do dave?");
		System.out.println("To Paint Like Trash - enter: literally anything else");
	}

	private DrawingCommand getDrawingCommand() {
		String userInputString = getUserInputString();
		DrawingCommand userDrawingCommand = DrawingCommand.createADrawingCommandWithAnInputCommandString(userInputString);
		return userDrawingCommand;
	}

	private String getUserInputString() {
		String userInputString = this.commandLineInputReader.nextLine();
        return userInputString;
	}

	private void giveDrawingCommandToDave(DrawingCommand drawingCommand) {
		this.daveThePainter.orderDaveToDoAThingWithPaintOnTheCanvasWeJustGaveHim(drawingCommand);
	}

	public static void main(String[] args) {
		DrawingApplication newDrawingApplication = new DrawingApplication();
		newDrawingApplication.runApplication();
	}
}