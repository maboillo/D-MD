package Objects;

import Basics.Item;

public class Dwarf extends Item {

	private String normal = "A Dwarf";
	private String explained = "A strange creature stands before you. Rosy cheeks and tanned skin, robust and muscular,..."
			+ "A dwarf! He smells of cheap booze and looks at you cheekily. He stands on a crumpled package";

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
