import java.util.*;

public class BaseObject {

	private final boolean ALWAYS_FAIL = false;
	public String getStringDescriptionOfMonitoredInformation() {
		System.out.println("This Object has not implemented getStringDescriptionOfMonitoredInformation");
		System.exit(0);
		return null;
	} 

	public void monitorMethodCallWithNameAndObjects(String methodCallIdentifier, BaseObject[] methodCallParameters) {
		Monitor currentGlobalMonitor = Monitor.getCurrentGlobalMonitor();
		if (currentGlobalMonitor.isMonitoring()) {
			ArrayList<BaseObject> methodCallParametersInArrayListForm = new ArrayList<BaseObject>(Arrays.asList(methodCallParameters));
			sendInformationToMonitor(currentGlobalMonitor, methodCallIdentifier, methodCallParametersInArrayListForm);
		}
	}

	private void sendInformationToMonitor(Monitor currentGlobalMonitor, String methodCallIdentifier, ArrayList<BaseObject> methodCallParameters) {
		String stringDescriptionOfMethodCallParameters = this.serializeMethodCallParametersIntoStringDescription(methodCallParameters);
		String methodCallDescriptionInMonitorFormat = methodCallIdentifier + ":::" + stringDescriptionOfMethodCallParameters;
		currentGlobalMonitor.monitorActionWithDescription(methodCallDescriptionInMonitorFormat);
	}

	private String serializeMethodCallParametersIntoStringDescription(ArrayList<BaseObject> methodCallParameters) {
		String stringDescriptionOfMethodCallParameters = "";
		for (BaseObject methodCallParamter : methodCallParameters) {
			stringDescriptionOfMethodCallParameters += getFormattedDescriptionOfMethodCallParameter(methodCallParamter);
		}
		return stringDescriptionOfMethodCallParameters;
	}

	private String getFormattedDescriptionOfMethodCallParameter(BaseObject methodCallParameter) {
		String methodCallDescriptionString = methodCallParameter.getStringDescriptionOfMonitoredInformation();
		String formattedDescriptionString = "|" + methodCallDescriptionString + "|";
		return formattedDescriptionString;
	}
}