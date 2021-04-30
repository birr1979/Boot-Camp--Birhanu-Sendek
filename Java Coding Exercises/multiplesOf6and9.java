package javaCodingExercises;
/**
 * 
 * @author Birhanu
 *
 */

public class multiplesOf6and9 {

	/*
	 * --> This Method is a non-static method that returns ‘Bubble’ for multiples of 6 and ‘Race’ for multiples of 9. 
	 *     For numbers which are multiples of both 6 & 9, return ‘BubbleRace’. 
	 *     For numbers that are neither multiples of 6 nor multiples of 9, return the input number. 
	 * --> Concept utilized Java Methods, Classes, Objects, Operators
	 */
static String returnResult="";

	public String multiplesOf6and9(int x){
		if (x%6==0&&x%9==0) {
			returnResult="BubbleRace";
			System.out.println(returnResult+" " +x+ "--> Multiple of 6 & 9");
		}
		else if (x%6==0) {
			returnResult="Bubble";
			System.out.println(returnResult+" "+ x+"--> Multiple of 6");
		}
		else if (x%9==0) {
			returnResult="Race";
			System.out.println(returnResult+" "+x+"--> Multiple of 9");
		}

		else {
			System.out.println(x+" --> Not multiple of 6 or 9" );
		}
		return returnResult;
	}


}
