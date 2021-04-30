package javaCodingExercises;

public class HRProgramADDNewEmployees extends HRProgramToOnBoardNewEmployees{
	public static HRProgramToOnBoardNewEmployees hr= new HRProgramToOnBoardNewEmployees();

	

	public static void main(String[] args) {
		/*
		 * This Method extends "HRProgramToOnBoardNewEmployees.class" and 
		 * This Method is used to create (add) new employees and display their relevant details.
		 */
		HRProgramADDNewEmployees newEmployee=new HRProgramADDNewEmployees();
		newEmployee.addEmployee("Birhanu Sendek", 101, "Engineer");
		newEmployee.addEmployee("Nathan Maki", 201,"Sales");
		newEmployee.addEmployee("Markan Nat", 301, "Finance");
		newEmployee.addEmployee("John King", 301, "Accounting");


	}

}
