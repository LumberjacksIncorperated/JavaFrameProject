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
import wrapped_classes.*;

// Chain Testing Framework
import chain_testing.*;

public class DrawingApplication {

	//-----------------------------------------------------------------------------------------------------------------------
    // MAIN
    //-----------------------------------------------------------------------------------------------------------------------
    public static void main(String args[]){
        DrawingApplication newDrawingApplication = new DrawingApplication();
        if(args.length > 0 && args[0] != null && args[0].equals("-test")) {
            newDrawingApplication.runTests();
        } else {
            newDrawingApplication.runApplication();
        }
    }

    //-----------------------------------------------------------------------------------------------------------------------
    // FUNCTIONAL CODE
    //-----------------------------------------------------------------------------------------------------------------------
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

    //-----------------------------------------------------------------------------------------------------------------------
    // TESTING CODE
    //-----------------------------------------------------------------------------------------------------------------------
    private static void runTests() {
    	System.out.println("No Testing For Application Class");
    }
}