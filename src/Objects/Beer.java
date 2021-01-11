package Objects;

import Basics.Item;

public class Beer extends Item {

	private String normal = "A beer";
	private String explained = "A malt beer. How delicious!";

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
