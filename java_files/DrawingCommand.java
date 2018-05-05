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

public class DrawingCommand {

	private static final int TRASH_COMMAND = 1;
	private static final int DAVINCI_COMMAND = 2;

	private int commandSpecification;

	private static String LEONARDO_DA_VINCI_COMMAND = "what do you even do dave?";
	private DrawingCommand(String inputCommandString) {
		if(inputCommandString.equals(LEONARDO_DA_VINCI_COMMAND)) {
			this.commandSpecification = DrawingCommand.DAVINCI_COMMAND;
		} else {
			this.commandSpecification = DrawingCommand.TRASH_COMMAND;
		}
	}

	public boolean canIBeLeonardoDaVinciNow() {
		boolean commandIsDavinciCommand = commandSpecificationIsCommand(DrawingCommand.DAVINCI_COMMAND);
		return commandIsDavinciCommand;
	}

	public boolean isATrashCommand() {
		boolean commandIsTrashCommand = commandSpecificationIsCommand(DrawingCommand.TRASH_COMMAND);
		return commandIsTrashCommand;
	}

	private boolean commandSpecificationIsCommand(int commandSpecification) {
		boolean commandIsGivenSpecification;
		if(this.commandSpecification == commandSpecification) {
			commandIsGivenSpecification = true;
		} else {
			commandIsGivenSpecification = false;
		}
		return commandIsGivenSpecification;
	}

	public static DrawingCommand createADrawingCommandWithAnInputCommandString(String inputCommandString) {
		DrawingCommand newDrawingCommand = new DrawingCommand(inputCommandString);
		return newDrawingCommand;
	}
}