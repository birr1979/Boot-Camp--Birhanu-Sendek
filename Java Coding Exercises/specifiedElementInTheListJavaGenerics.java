package javaCodingExercises;

import java.util.ArrayList;
/**
 * 
 * @author Birhanu
 *
 */

public class specifiedElementInTheListJavaGenerics {
	/*
	 * -->This method returns the specified element of a list. 
	 * -->If the provided index exceeds the list size, then it returns -1. 
	 * -->The lists could contain values of any type. 
	 * -->Using the this method created bellow we can display a value from each of the lists. 
	 * -->Test the method to verify that -1 is returned when the index provided exceeds the size of the list. 
	 * -->Concept utilized Java Generics.(The method can be public or private based on the necessity of the implementation)
	 */

	private static ArrayList<?> getListElement(ArrayList<?> myList, int index) {
		//This Method returns the specified element of the list in a given index and if the index is out of bound it returns -1.
		try 
		{
			System.out.println(myList.get(index));
		}
		catch(IndexOutOfBoundsException e) {
			System.out.println("-1");
		}
		return myList;
	}

	public static void main(String[] args) {
		//String List 
		ArrayList<String> myStringList=new ArrayList<String>();
		myStringList.add("Selenium");
		myStringList.add("Java");
		myStringList.add("TestNG");
		myStringList.add("Cucumber");

		//Integer List
		ArrayList<Integer> myIntegerList=new ArrayList<Integer>();
		myIntegerList.add(100);
		myIntegerList.add(20);
		myIntegerList.add(501);

		//Double List
		ArrayList<Double> myDoubleList=new ArrayList<Double>();
		myDoubleList.add(10.12);
		myDoubleList.add(300.56);
		myDoubleList.add(87.9);

		//Invoking the Generic Method to read the List in the specified Index of the each list written above.
		getListElement(myStringList,2);
		getListElement(myIntegerList,1);
		getListElement(myDoubleList,4);

	}



}
