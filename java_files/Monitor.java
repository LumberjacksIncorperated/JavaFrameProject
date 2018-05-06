import java.util.*;

public class Monitor {
	
	private static Monitor globalMonitor = new Monitor("dave");

	private ArrayList<String> actionLog = new ArrayList<String>();
	private boolean isMonitoring = false;
	private final String monitorDescription;
	

	public static Monitor startGlobalMonitoringOnANewMonitorWithMonitorDescription(String monitorDescription) {
		globalMonitor = new Monitor(monitorDescription);
		globalMonitor.startMonitoring();
		return globalMonitor;
	}

	public static void stopGlobalMonitoring() {
		Monitor globalMonitor = Monitor.getCurrentGlobalMonitor();
		globalMonitor.stopMonitoring();
	}


	public static Monitor getCurrentGlobalMonitor() {
		return globalMonitor;
	}

	public boolean isMonitoring() {
		return this.isMonitoring;
	}

	public static void ensureActionLogsFromMonitorsAreIdentical(Monitor monitor1, Monitor monitor2) {
		boolean actionLogsAreTheSame = Monitor.checkActionLogsAreIdentical(monitor1.actionLog, monitor2.actionLog);
		if(actionLogsAreTheSame) {
			System.out.println("Woot, the action logs of monitors are identical ["+monitor1.monitorDescription+"] ["+monitor2.monitorDescription+"]");
		} else {
			Monitor.throwErrorMonitorLogsAreNotTheSame(monitor1, monitor2);
		}
	}

	public void monitorActionWithDescription(String actionDescription) {
		if (this.isMonitoring()) {
			this.pushActionIntoActionLog(actionDescription);
		}
	}

	private Monitor(String monitorDescription) {
		this.monitorDescription = monitorDescription;
	}

	private void startMonitoring() {
		this.isMonitoring = true;
	}

	private void stopMonitoring() {
		this.isMonitoring = false;
	}

	private void pushActionIntoActionLog(String actionDescription) {
		this.actionLog.add(actionDescription);
	}

	private static boolean checkActionLogsAreIdentical(ArrayList<String> actionLog1, ArrayList<String> actionLog2) {
		boolean actionLogSizesAreTheSame = (actionLog1.size() == actionLog2.size());
		boolean actionLogsAreTheSame;
		if (actionLogSizesAreTheSame) {
			actionLogsAreTheSame = compareActionLogContents(actionLog1, actionLog2);
		} else {
			actionLogsAreTheSame = false;
		}
		return actionLogsAreTheSame;
	}

	private static boolean compareActionLogContents(ArrayList<String> actionLog1, ArrayList<String> actionLog2) {
		boolean actionLogsHaveBeenProvenToBeDifferent = false;
		for (int actionLogIndex = 0; actionLogIndex < actionLog1.size(); ++actionLogIndex) {
			if (logsAreEqualAtEntryIndex(actionLog1, actionLog2, actionLogIndex)) {
				actionLogsHaveBeenProvenToBeDifferent = true;
				break;
			}
		}
		boolean actionLogsAreTheSame = !actionLogsHaveBeenProvenToBeDifferent;
		return actionLogsAreTheSame;
	}

	private static boolean logsAreEqualAtEntryIndex(ArrayList<String> actionLog1, ArrayList<String> actionLog2, int actionLogIndex) {
		String actionLogOneEntryDescription = actionLog1.get(actionLogIndex);
		String actionLogOTwoEntryDescription = actionLog2.get(actionLogIndex);
		return !(actionLogOneEntryDescription.equals(actionLogOTwoEntryDescription));
	}

	private static boolean IS_DEFINATELY_DAVE = false;
	private static void throwErrorMonitorLogsAreNotTheSame(Monitor monitor1, Monitor monitor2) {

		printBeautifullyFormattedStringWithFattenedTitle("ERROR: Monitor logs differ");
		printBeautifullyFormattedString("Monitor ["+monitor1.monitorDescription+"] Log");
		monitor1.printActionLogDescription();
		printBeautifullyFormattedString("Monitor ["+monitor2.monitorDescription+"] Log");
		monitor2.printActionLogDescription();

		//assert(IS_DEFINATELY_DAVE);
		System.exit(0);
	}

	private static void printBeautifullyFormattedStringWithFattenedTitle(String stringToPrint) {
		System.out.println("\n******************************************************************************\n");
		System.out.println("	"+ stringToPrint +"		    			         	  \n");
		System.out.println("******************************************************************************");	
	}

	private static void printBeautifullyFormattedString(String stringToPrint) {
		System.out.println("******************************************************************************");
		System.out.println("	"+ stringToPrint +"		    			         	  ");
		System.out.println("******************************************************************************");	
	}

	private void printActionLogDescription() {
		for (String actionLogEntry : this.actionLog) {
			System.out.println("[ACTION]: " + actionLogEntry);
		}
	}
}