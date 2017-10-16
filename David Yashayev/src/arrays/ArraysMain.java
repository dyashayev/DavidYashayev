package arrays;

import java.util.Arrays;

public class ArraysMain {
	
	private String[] testArray;
	private int[] intRay;
	
	public ArraysMain() {
		intRay = new int[90000];
	//	populate(intRay);
	//	checkOccurences(intRay, 3, 18);
		populate1ToN(intRay);
		//swap(intRay, 5, 1);
		shuffle(intRay);
		//Arrays is a utility class
		System.out.println(Arrays.toString(intRay));	
	}
	
	private void shuffle(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			swap(arr,(int)(Math.random()*arr.length), (int)(Math.random()*arr.length));
		}
	}

	private void swap(int[] arr, int item1, int item2) {
		int temp = arr[item1];
		arr[item1] = arr[item2];
		arr[item2] = temp;
	}

	private void populate1ToN(int[] intRay) {
		for(int i = 0; i < intRay.length; i++) {
			intRay[i] = i + 1;
		}
	}

	private void checkOccurences(int[] arr, int start, int end) {
		int[] counter = new int[end-start+1]; 
			for(int value: arr) {
				counter[value-start]++;
			}
			for(int i = 0; i < counter.length; i++) {
				System.out.println("A " + (start+i)+ " was rolled "+ counter[i] + " tiems." );
			}
	}

	private void populate(int[] intRay) {
		for(int i = 0; i < intRay.length; i++) {
			intRay[i] = diceRoll(3);
		}
	}

	public void notes() {
		String[] testArray;
		
			//1. collection o)f primitives or objects
			//2. Special Note: This is the only collection of primitives
			//3. Size cannot be modified
			//4. Elements of an array are REFERENCES to objects.
			//     In other words, changing an element of an array changes
			// 	   the REFERENCE, not the object itself.
			
			//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
			
			//There are two types of constructors, the first we've seen already:
			int[] firstType = {3, 14, -9, 10};
			//this constructor can only be used at the declaration. Error:
			//first Type = {12, 13, 14, ,15};
			
			//2nd type:
			testArray = new String[50];
			//primitive arrays are populated with 0's automatically
			//object arrays are populated with nulls.
			
			//Ways to iterate an array (go thru)
			
			//standard 'for' loop
			for(int i = 0; i < testArray.length; i++){
				System.out.println("The #"+i+" item is: "+ testArray[i]);
			}
			
			// for each loop (useful only when you don't need to keep track of an index)
			for(String value:testArray) {
				//"for each int in testArray..."
				System.out.println(value);
			}
	}
	
	public static void main(String[] args) {
		ArraysMain arrayPractice = new ArraysMain();
	}

	/*
	 Returns the result from rolling "numberOfDice" dice
	 @param numberOfDice
	 @return
	 */
	public int diceRoll(int numberOfDice) {
		int sum = 0;
			for(int i = 0; i < numberOfDice; i++) {
				sum = (int) (sum + 1 + Math.random()*6);
			}
		return sum;
	}
}
