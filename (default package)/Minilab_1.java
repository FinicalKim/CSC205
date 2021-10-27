/*
Description: This is a program to analyze numbers and find if they are in-between certain thresholds
and have a counter for arithmetic operation as well as values inputed.
*/
import java.util.Scanner;
public class Minilab_1 {

	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);
		
		//Local variables
		
			//Enter a double
		double decimal = 0;
		
			//Test case for values over half count
		double hCount = 0;
		
			//Initializing counter for double values greater than half of six
		int halfSix = 0;
		
			//Counter for double values
		int dCount = -1;
		
			//Counter for how many values are a multiple of integer
		int multiples = 0;
				
			//Counter for values in between 0 and testRange constant
		int inbetween = 0;
		
			//Constant 5
		final int TEST_RANGE = 5;
		
			//Initializing variable to calculate the difference between inputs of integer & decimal
		double difference = 0;
		
		
			//Enter an int value
		System.out.println("Please enter a non-zero integer");
			int integer = input.nextInt();
		
			//Loop to ensure value does not equal 0
		while( integer == 0 ) {
			System.out.println("Number cannot be zero; please reenter");
				integer = input.nextInt();
		}
		
			//Value half of integer
		hCount = (double) (integer /2.0) ;
		
			//input a value of double type
		while(decimal >= 0) {
			System.out.println("Please enter doubles to analyze (negative to stop)");
				decimal = input.nextDouble();
			
				//Counter for double values
			dCount++;
			
				//Checks if double value is greater than half the first integer value
			if(decimal > hCount) { 
				halfSix++;}
				
				//Check if double value is a multiple of integer
			if (decimal >= 0 && decimal % integer == 0) {
				multiples++;}
			
				//Checks the difference calculated by inputs integer & decimal
			if(decimal >= 0) {
				difference = Math.abs((double) (integer - decimal));
				if ( 0 <= difference && difference <= TEST_RANGE) 
					inbetween++;}
		}
		
			//Output window
		System.out.println("How many doubles were analyzed? " + dCount);
		System.out.println("How many are greater than half of " + integer + "? " + halfSix);
		System.out.println("How many are multiples of " + integer + "? " + multiples);
		System.out.println("How many are within " + TEST_RANGE + " of "+ integer + "? "  + inbetween);
		
	}
		
}
