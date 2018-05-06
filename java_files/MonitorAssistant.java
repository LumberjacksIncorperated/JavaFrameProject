
public class MonitorAssistant {

    public static void compareNonThreadedMonitoredCallsWithCallbackAndTestDescription(MonitorAssistantDelegate monitorAssitentDelegate, String testDescription) {

        Monitor testedCalls = Monitor.startGlobalMonitoringOnANewMonitorWithMonitorDescription("Tested - " + testDescription);
        monitorAssitentDelegate.executeTestProgram();
        Monitor.stopGlobalMonitoring();
        
        Monitor expectedCalls = Monitor.startGlobalMonitoringOnANewMonitorWithMonitorDescription("Expected - " + testDescription);
        monitorAssitentDelegate.executeExpectedCalls();
        Monitor.stopGlobalMonitoring();

        Monitor.ensureActionLogsFromMonitorsAreIdentical(testedCalls, expectedCalls);
    }
}
    	