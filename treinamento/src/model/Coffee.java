package model;

public class Coffee {
	private int coffeeId;
	private String coffeeName;
	
	public Coffee() {
		super();
	}

	public Coffee(int coffeeId, String coffeeName) {
		super();
		this.coffeeId = coffeeId;
		this.coffeeName = coffeeName;
	}

	public int getCoffeeId() {
		return coffeeId;
	}

	public void setCoffeeId(int coffeeId) {
		this.coffeeId = coffeeId;
	}

	public String getCoffeeName() {
		return coffeeName;
	}

	public void setCoffeeName(String coffeeName) {
		this.coffeeName = coffeeName;
	}
}
