
public class DrawingCommand {
	private boolean isATrashCommand = false;
	private boolean isALeonardoDavinciCommand = false;

	private static String LEONARDO_DA_VINCI_COMMAND = "what do you even do dave?";
	private DrawingCommand(String inputCommandString) {
		if(inputCommandString.equals(LEONARDO_DA_VINCI_COMMAND)) {
			this.isALeonardoDavinciCommand = true;
		} else {
			this.isATrashCommand = true;
		}
	}

	public static DrawingCommand createADrawingCommandWithAnInputCommandString(String inputCommandString) {
		DrawingCommand newDrawingCommand = new DrawingCommand(inputCommandString);
		return newDrawingCommand;
	}

	public boolean canIBeLeonardoDaVinciNow() {
		return this.isALeonardoDavinciCommand;
	}

	public boolean isATrashCommand() {
		return this.isATrashCommand;
	}
}