package assignment_6;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Program {
	
	/**
	 * Sets the dishType to 0, 1, or 2 by what word is stored in the dishTypeString.
	 * @param dishTypeString: Contains a string such as Appetizer, Entree, or Dessert.
	 * @return: dishType as an integer to be used for the Object Dish.
	 */
	public static int dishStringConvert(String dishTypeString) {
		int dishType;
		if (dishTypeString.equals("Appetizer")) {
			dishType = 0;
		}
		else if (dishTypeString.equals("Entree")) {
			dishType = 1;
		}
		else {
			dishType = 2;
		}
		return dishType;
	}
	
	
	// I added this because the scanner and writer has a "leak". A yellow line underneath the variable. This got rid of it. No issues with the program.
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		
		// Open input and output files.
		FileInputStream inputFile = new FileInputStream("dishes.txt");
		Scanner scanner = new Scanner(inputFile);
		FileOutputStream outputFile = new FileOutputStream("menu.txt");
		PrintWriter writer = new PrintWriter(outputFile);
		
		
		// Create multiple array lists to store dish type: appetizers, entrees, and desserts.
		ArrayList<Dish> appetizers = new ArrayList<>();
		ArrayList<Dish> entrees = new ArrayList<>();
		ArrayList<Dish> desserts = new ArrayList<>();
		
		// Loop through input file and store values.
		
		while (scanner.hasNextLine()) {
			int dishType;
			String dishTypeString = scanner.next();
			int dishPrice = scanner.nextInt();
			String dishName = scanner.nextLine();
			
			// Sets the dishType to 0, 1, or 2 by what word is stored in the dishTypeString.
			dishType = dishStringConvert(dishTypeString);
			
			// Create an object using the dishName, dishType, and dishPrice read in.
			Dish dishes = new Dish(dishName, dishType, dishPrice);
			
			// Store the object into the correct array via dishType.
			if (dishes.getDishType() == 0) {
				appetizers.add(dishes);
			}
			else if (dishes.getDishType() == 1) {
				entrees.add(dishes);
			}
			else {
				desserts.add(dishes);
			}
			
		}		
		
		// Write to the output file in the correct format
		int i;
		writer.println("Menu\n");
		
		writer.println("Appetizer\n");
		
		// Loop through the appetizer list to print the elements into the menu output file.
		for (i = 0; i < appetizers.size(); ++i) {
			writer.println(appetizers.get(i));
		}
		
		writer.println("\nEntree\n");
		
		for (i = 0; i < entrees.size(); ++i) {
			writer.println(entrees.get(i));
		}
		
		writer.println("\nDessert\n");
		
		for (i = 0; i < desserts.size(); ++i) {
			writer.println(desserts.get(i));
		}
		
		// Close input and output files.
		writer.close();
		outputFile.close();
		scanner.close();
		inputFile.close();
		
		
	}
}
