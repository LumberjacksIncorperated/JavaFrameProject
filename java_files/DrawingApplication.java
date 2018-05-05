import java.util.Scanner;

public class DrawingApplication {

    private Scanner commandLineInputReader = new Scanner(System.in);

	public void runApplication() {
		GraphicWindow window = new GraphicWindow();
		Canvas graphicWindowsCanvas = window.getThisWindowsCanvas();
		Painter daveThePainter = Painter.findAHomelessDaveOnTheStreetAndGiveHimACanvasToDrawBeautifullyOn(graphicWindowsCanvas);
		runUserInteractionLoopGivingCommandsToDave(daveThePainter);
	}

	private void runUserInteractionLoopGivingCommandsToDave(Painter daveThePainter) {
		while(true) {
			printUserInteractionMessage();
			DrawingCommand userDrawingCommand = getDrawingCommand();
			giveDrawingCommandToDave(userDrawingCommand, daveThePainter);
		}
	}

	private void printUserInteractionMessage() {
		System.out.println("Options for command here... TO DO");
	}

	private DrawingCommand getDrawingCommand() {
		String userInputString = getUserInputString();
	    System.out.println("["+userInputString+"]");
		DrawingCommand userDrawingCommand = DrawingCommand.createADrawingCommandWithAnInputCommandString(userInputString);
		return userDrawingCommand;
	}

	private String getUserInputString() {
		String userInputString = this.commandLineInputReader.nextLine();
        return userInputString;
	}

	private void giveDrawingCommandToDave(DrawingCommand drawingCommand, Painter daveThePainter) {
		daveThePainter.orderDaveToDoAThingWithPaintOnTheCanvasWeJustGaveHim(drawingCommand);
	}

	public static void main(String[] args) {
		DrawingApplication newDrawingApplication = new DrawingApplication();
		newDrawingApplication.runApplication();
	}
}