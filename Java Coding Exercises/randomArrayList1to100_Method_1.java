package javaCodingExercises;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * @author Mr.B
 *
 */
public class randomArrayList1to100_Method_1 {
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
	 * @return 
	 */
	// Method to find the index of an element in the randomArrayList
	public static int IndexOfElement(int[] a, int target)
	{
		for (int i = 0; i < a.length; i++)
		{
			if (a[i] == target) {
				return i;
			}
		}

		return -1;
	}

	//

	public static void checkIfaNumberIsInTheArray() {
		//Creating a list of random number from 1-100
		int[]randomArrayList= new int[10];
		for (int i=0;i<10;i++) {
			randomArrayList[i]=(int)(1+Math.random()*100);
//			System.out.println(randomArrayList[i]);
		}
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the Number to see if it's in the Array");
		int flag=0;
		for(int j=5;j>0;j--) {
			int guessedNumber=scan.nextInt();
			for(int i = 0; i < 10; i++)
			{
				if(randomArrayList[i] == guessedNumber)
				{
					flag=1;
					break;
				}
				else
				{
					flag=0;
				}
			}
			if(flag==1) {
				System.out.println(guessedNumber+" was found in the array at index: " + IndexOfElement(randomArrayList, guessedNumber));
				break;
			}else if(j>0) {
				System.out.println(guessedNumber+" was not found in the array -- TRY AGAIN! ");
				System.out.println("you have "+(j-1)+" tries left");
				System.out.println("***********************************");
				continue;
			}

		}
		if(flag==0) {
			for(int i = 0; i < 10; i++) {
				System.out.println(randomArrayList[i]);
			}
		}
	}



	public static void main(String[] args) {

		//Invoking the Method checkIfaNumberIsInTheArray, to interact with the customer.
		checkIfaNumberIsInTheArray();
	}
}
