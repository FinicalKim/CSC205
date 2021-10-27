import java.util.Scanner;
import java.util.Random;

public class review {
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Please enter a Seed:");
		int seed = input.nextInt();
		
		System.out.println("Please enter the size of the array:");
		int size = input.nextInt();
		
		while(size <= 1) {
			System.out.println("Please enter a value greate than 1:");
			size = input.nextInt();
			
			int[] array = new int[size];
			Random generator = new Random();
			for(int i = 0; i < array.length; i++) {
				array[i] = generator.nextInt(9);
			}
			
			int option;
			do {
				
				
				System.out.println("\nPlease choose an option:");
					System.out.println("1. Print the array");
					System.out.println("2. Find the average");
					System.out.println("3. Find the largest element");
					System.out.println("4. Count how many times 3 occurred");
					System.out.println("5. Count how many elements are less than half of the first element");
					System.out.println("6. Find how many times numbers repeat consecutively");
					System.out.println("7. Swap the first and last elements");
					System.out.println("8. Exit");
				
				option = input.nextInt();
				switch(option)
				{
				case 1:
					System.out.print("\nArray: ");
					for(int i = 0;i < array.length;i++ ) {
						System.out.println(array[i] + " ");
					}
					
				case 2:
					
					
					
				case 3:
					
					
				case 4:
					
					
				case 5:
					
					
				case 6:
					
					
				case 7:
					
					
					
					
				case 8:
					break;
					
				default:
					System.out.println("\nIllegal option, try again");
				
				
				
				}
			}while(option != 8);
			
			
			
			
			
			
		}
		
		
	}
	

}
