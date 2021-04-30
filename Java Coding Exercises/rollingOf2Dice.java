package javaCodingExercises;

/**
 * @author Birhanu
 *
 */
public class rollingOf2Dice {
	
	/*
	 * --> The Following Method will simulate the rolling of 2 dice, that will return a random number 
	 *     between 1 and 6. 
	 * --> When we Call the method twice, we will get 2 randum numbers representing the sides of the dice and 
	 * 	   the method return the sum of each side.  
	 * --> Concept Utilized Java Methods, Variables, Data Types
	 */
public static void rollingDice() {
	int firstDiceRolling,secondDiceRolling, total;
	firstDiceRolling=(int) (1+Math.random()*6);
	secondDiceRolling=(int) (1+Math.random()*6);
	total=firstDiceRolling+secondDiceRolling;
	System.out.println("Roll #1: "+firstDiceRolling);
	System.out.println("Roll #2: "+secondDiceRolling);
	System.out.println("The Total is: "+total);
}
	
public static void main(String[] args) {
	//calling the method to Utilize the rolling Dice 
	rollingDice();
}
	
}
