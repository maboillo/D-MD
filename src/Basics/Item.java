package Basics;

import java.util.HashMap;

public class Item {

	private String explained;
    private String normal;
    private String smell;
    private String feel;
    private String hear;
    private boolean alive;
    private int weight;
    private String details1;
    private String details2;
    
    HashMap<String, String> items = new HashMap<String, String>();
    
    public void itemList() {}

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

	public String getSmell() {
		return smell;
	}

	public void setSmell(String smell) {
		this.smell = smell;
	}

	public String getFeel() {
		return feel;
	}

	public void setFeel(String feel) {
		this.feel = feel;
	}

	public String getHear() {
		return hear;
	}

	public void setHear(String hear) {
		this.hear = hear;
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getDetails1() {
		return details1;
	}

	public void setDetails1(String details1) {
		this.details1 = details1;
	}

	public String getDetails2() {
		return details2;
	}

	public void setDetails2(String details2) {
		this.details2 = details2;
	}
    
}
