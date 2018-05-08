//-----------------------------------------------------------------------------------------------------------------------
//
// PROJECT
// -------
// "Chain Testing Project"
//
// AUTHOR
// ------
// Lumberjacks Incorperated (2018)
//
//-----------------------------------------------------------------------------------------------------------------------

//-----------------------------------------------------------------------------------------------------------------------
// Testing Package
//-----------------------------------------------------------------------------------------------------------------------
package chain_testing;

//-----------------------------------------------------------------------------------------------------------------------
// IMPORTS
//-----------------------------------------------------------------------------------------------------------------------
// <NONE>

public class MonitorAssistant {

    //-----------------------------------------------------------------------------------------------------------------------
    // FUNCTIONAL CODE
    //-----------------------------------------------------------------------------------------------------------------------
    public static void compareNonThreadedMonitoredCallsWithCallbackAndTestDescription(MonitorAssistantDelegate monitorAssitentDelegate, String testDescription) {
        Monitor testedCallsMonitor = executeTestCallsOnDelegateAndReturnCorrespondingMonitorWithDescription(monitorAssitentDelegate, testDescription);
        Monitor expectedCallsMonitor = executeExpectedCallsOnDelegateAndReturnCorrespondingMonitorWithDescription(monitorAssitentDelegate, testDescription);
        testedCallsMonitor.checkIfMonitorLogContainsGivenMonitorLog(expectedCallsMonitor);
        System.exit(0);
    }

    private static Monitor executeTestCallsOnDelegateAndReturnCorrespondingMonitorWithDescription(MonitorAssistantDelegate monitorAssitentDelegate, String testDescription) {
        Monitor testedCallsMonitor = Monitor.startGlobalMonitoringOnANewMonitorWithMonitorDescription("Tested - " + testDescription);
        monitorAssitentDelegate.executeTestCalls();
        Monitor.stopGlobalMonitoring();
        return testedCallsMonitor;
    }

    private static Monitor executeExpectedCallsOnDelegateAndReturnCorrespondingMonitorWithDescription(MonitorAssistantDelegate monitorAssitentDelegate, String testDescription) {
        Monitor expectedCallsMonitor = Monitor.startGlobalMonitoringOnANewMonitorWithMonitorDescription("Expected - " + testDescription);
        monitorAssitentDelegate.executeExpectedCalls();
        Monitor.stopGlobalMonitoring();      
        return expectedCallsMonitor; 
    }
}
    	