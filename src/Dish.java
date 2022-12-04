package assignment_6;

public class Dish {
	// Data fields.
	private String dishName;
	private int dishType;
	private int dishPrice;
	
	
	// Constructors
	
	public Dish () {dishName = ""; } // Default Constructor
	
	// Constructor with initial values.
	public Dish (String dishName, int dishType, int dishPrice) {
		this.dishName = dishName;
		this.dishType = dishType;
		this.dishPrice = dishPrice;
		
	}
	
	// Getters
	
	/**
	 * Returns the dish name of the dish
	 * @return: name of dish
	 */
	public String getDishName() { return dishName; }
	
	/**
	 * Returns the type of dish (integer).
	 * @return: type of dish
	 */
	public int getDishType() { return dishType; }
	
	/**
	 * returns the dish price
	 * @return: dish price
	 */
	public int getDishPrice() { return dishPrice; }
	
	
	// Setters
	
	/**
	 * Updates the name of dish
	 * @param dishName: updated name of dish
	 */
	public void setDishName(String dishName) { this.dishName = dishName; }
	
	/**
	 * Updates the dish type
	 * @param dishType: updated dish type with an integer(0-2).
	 */
	public void setDishType(int dishType) { this.dishType = dishType; }
	
	/**
	 * Updates the dish price
	 * @param dishPrice: updated dish price
	 */
	public void setDishPrice(int dishPrice) { this.dishPrice = dishPrice; }
	
	// Methods
	
	
	/**
	 * Customizes the output format of the dish.
	   @return: a string representing the output format of the dish.
	 */
	@Override
	public String toString() { return String.format("%s ($%d)", dishName, dishPrice).trim(); }
	
	
}
