public class ObjectDescription extends BaseObject {
	private final String description;

	public ObjectDescription(String description) {
		this.description = description;
	} 

	public String getStringDescriptionOfMonitoredInformation() {
		return this.description;
	}

	public static ObjectDescription descriptionOfInt(int integer) {
		return new ObjectDescription(String.valueOf(integer));
	}
}