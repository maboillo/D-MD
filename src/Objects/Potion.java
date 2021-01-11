package Objects;

import Basics.Item;

public class Potion extends Item {
	
	private String normal = "A potion";
	private String explained = "A potion with a pink color that does not stop shining";

	public String getExplained() {
		return explained;
	}

	public void setExplained(String explained) {
		this.explained = explained;
	}

	public String getNormal() {
		return normal;
	}

	public void setNormal(String normal) {
		this.normal = normal;
	}
}
