package Objects;

import Basics.Item;

public class Barkeeper extends Item {

	private String normal = "Prilf, the bartender.";
	private String explained = "This is the bartender of this cafeteria - Prilf.";
	
	private String details1 = "Seems not to get along too well with the local elves.";

	public String getDetails1() {
		return details1;
	}

	public void setDetails1(String details1) {
		this.details1 = details1;
	}

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
