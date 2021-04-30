package javaCodingExercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * @author Mr.B
 *
 */
public class randomArrayList1to100_Method_2 {
	/**
	 *--> This Method will create an array of 10 random numbers between 1-100. 
	 *--> The program will ask the user to guess a number that is in the array.
	 *--> If the user guesses correctly, then a message is printed saying 
	 *    “guessedNumber was found in the array at index: indexValue”. 
	 *--> If not the user have a maximum of 5 tries to guess a number in the array. 
	 *--> Each time the user guesses an incorrect number (a number not in the array) 
	 *    they are presented with the following message: 
	 *    “guessedNumber was not found in the array – TRY AGAIN!”. 
	 *    and also telling the user how many tries they have left. 
	 *    Once the 5 tries have been used a message should be printed saying 
	 *    “The Array Contains the following numbers:” along with the array of numbers. 
	 *--> Concept Utilized Java: Arrays, Loops, Conditionals, simple logic and Scanner Class, Random Numbers
	 */
static int x=10;
static int numberOfTries=5;

	private static void checkIfaNumberIsInTheArray() {
		//Creating a list of random number from 1-100
		List<Integer> randomArrayList= new ArrayList<Integer>();
		for (int i=0;i<x;i++) {
			int randomNumber = (int)(1+Math.random()*100);
			randomArrayList.add(randomNumber);
		}

		/**
		 * -->Ask the user to guess a number from 1-100 and check if its in the list of random numbers
		 *    and accessing the List
		 *    where the user has 5 attempts to guess the number in the list
		 */
//				System.out.println(randomArrayList);
		Scanner scan= new Scanner(System.in);
		System.out.println("Enter the Number to see if it's in the Array");

		for(int j=numberOfTries;j>0;j--) {
			int userNumberGuesses= scan.nextInt();
			if(randomArrayList.contains(userNumberGuesses)){
				System.out.println(userNumberGuesses+" was found in the array at index: " + randomArrayList.indexOf(userNumberGuesses));
			}else if(j>0){
				System.out.println(userNumberGuesses+" was not found in the array -- TRY AGAIN! ");
				System.out.println("you have "+(j-1)+" tries left");
				System.out.println("***********************************");
			}
		}
		System.out.print("The Array Contains the following numbers: \n"+randomArrayList);
	}

	public static void main(String[] args) {

		//Invoking the Method checkIfaNumberIsInTheArray, to interact with the customer.
		checkIfaNumberIsInTheArray();
	}
}
