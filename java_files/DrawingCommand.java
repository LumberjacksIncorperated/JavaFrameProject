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

public class DrawingCommand extends BaseObject {

 	//-----------------------------------------------------------------------------------------------------------------------
    // FUNCTIONAL CODE
    //-----------------------------------------------------------------------------------------------------------------------
	private static final int TRASH_COMMAND = 1;
	private static final int DAVINCI_COMMAND = 2;

	private int commandSpecification;

	private static String LEONARDO_DA_VINCI_COMMAND = "what do you even do dave?";
	private DrawingCommand(String inputCommandString) {
		this.monitorMethodCallWithNameAndObjects("DrawingCommand()", new BaseObject[] {
			ObjectDescription.descriptionOfString(inputCommandString)
		});

		if(inputCommandString.equals(LEONARDO_DA_VINCI_COMMAND)) {
			this.commandSpecification = DrawingCommand.DAVINCI_COMMAND;
		} else {
			this.commandSpecification = DrawingCommand.TRASH_COMMAND;
		}
	}

	public boolean canIBeLeonardoDaVinciNow() {
		this.monitorMethodCallWithNameAndObjects("canIBeLeonardoDaVinciNow()", new BaseObject[] {
			ObjectDescription.descriptionOfInt(0)
		});

		boolean commandIsDavinciCommand = commandSpecificationIsCommand(DrawingCommand.DAVINCI_COMMAND);
		return commandIsDavinciCommand;
	}

	public boolean isATrashCommand() {
		this.monitorMethodCallWithNameAndObjects("isATrashCommand()", new BaseObject[] {
			ObjectDescription.descriptionOfInt(0)
		});

		boolean commandIsTrashCommand = commandSpecificationIsCommand(DrawingCommand.TRASH_COMMAND);
		return commandIsTrashCommand;
	}

	private boolean commandSpecificationIsCommand(int commandSpecification) {
		this.monitorMethodCallWithNameAndObjects("commandSpecificationIsCommand()", new BaseObject[] {
			ObjectDescription.descriptionOfInt(commandSpecification)
		});

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

 	//-----------------------------------------------------------------------------------------------------------------------
    // TESTING CODE
    //-----------------------------------------------------------------------------------------------------------------------
    public static void main(String[] args) {
        runTests();
    }

    private static void runTests() {
    	publicConstructionTest();
    }

    private static void publicConstructionTest() {

    	MonitorAssistant.compareNonThreadedMonitoredCallsWithCallbackAndTestDescription(new MonitorAssistantDelegate() {
    		
    		public void executeTestCalls() {
				DrawingCommand testDrawingCommand = createADrawingCommandWithAnInputCommandString("TEST");
    		}

    		public void executeExpectedCalls() {
    			DrawingCommand testDrawingCommand = new DrawingCommand("TEST");
    		}

    	}, "Drawing Command Public Construction");
    }
}