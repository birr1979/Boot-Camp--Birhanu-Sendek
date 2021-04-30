package javaCodingExercises;

public class HRProgramToOnBoardNewEmployees {
	/**
This Method is an HR program that will on-board new employees (add new employees to the system). 
in this Method all variables (employee’s name, employee’s department ID, employee’s job title, 
employee’s salary, employee’s bonus, employee’s PTO (paid time off)). It must also contain the following methods:
a.	Method to determine the PTO for an employee based on their assigned department ID. 
	Employees of Department 101 (Sales) should be given 8.0 PTO hours. Employees of Department 
201 (Accounting/finance) should be given 12.5 PTO hours. Employees of Department 
301 (Marketing) should be given 16.0 PTO hours. 
	Employees for all other departments should be given 4.0 PTO hours. 
b.	Method to calculate Monthly Pay with Bonus (monthly salary + (monthly salary x bonus)). 
	Monthly pay must be returned.
c.	Each time a new employee is added they must automatically be assigned a name, department ID, and Job Title. 
	This information must be displayed as shown in the screenshot below. 
Additionally, a counter must keep track of the number of employees currently added to the system (during the execution only). 

	 */
	private String employeeName;
	private int departmentID;
	private String employeeJobTitle;
	private  int employeeSalary;
	private double employeeBonus;
	private double PTO;

	//Getters and Setters to access the private variables

	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public int getDepartmentID() {
		return departmentID;
	}
	public void setDepartmentID(int departmentID) {
		this.departmentID = departmentID;
	}
	public String getEmployeeJobTitle() {
		return employeeJobTitle;
	}
	public void setEmployeeJobTitle(String employeeJobTitle) {
		this.employeeJobTitle = employeeJobTitle;
	}
	public int getEmployeeSalary() {
		return employeeSalary;
	}
	public void setEmployeeSalary(int employeeSalary) {
		this.employeeSalary = employeeSalary;
	}
	public double getEmployeeBonus() {
		return employeeBonus;
	}
	public void setEmployeeBonus(double employeeBonus) {
		this.employeeBonus = employeeBonus;
	}
	public double getPTO() {
		return PTO;
	}
	public void setPTO(double pTO) {
		PTO = pTO;
	}


	static HRProgramToOnBoardNewEmployees hr=new HRProgramToOnBoardNewEmployees();

	//Methods to calculate 
	
	//Methods to calculate PTO
	public static double calculatePTO(double departmentID) {
		double employeePTO=hr.getPTO();
		if (departmentID==101) {
			employeePTO=8.0;
		}else if(departmentID==201) {
			employeePTO=12.50;
		}else if(departmentID==301) {
			employeePTO=16.0;
		}
		return employeePTO;
	}
	//method for total monthly salary
	public static double totalMonthlySalary(int DepartmentID) {
		double MonthlyPay=hr.employeeSalary(DepartmentID)+
				(hr.employeeSalary(DepartmentID)*hr.employeeBonus(DepartmentID)/100);
		return MonthlyPay;
	}
	//Method, Counter for each employee added to HR Program
	public static int i=1;
	public static int totalEmployeeAdded() {
		return i++;
	}
	//Method to calculate employee salary
	public static int employeeSalary(int departmentID) {
		int employeeSalary=hr.getEmployeeSalary();
		if(departmentID==101) {
			employeeSalary=10000;
		}else if(departmentID==201) {
			employeeSalary=12000;
		}else if(departmentID==301) {
			employeeSalary=15000;
		}
		return employeeSalary;
	}
	//Method to calculate employee Bonus
	public static double employeeBonus(int departmentID) {
		double employeeBonus=hr.getEmployeeBonus();
		if(departmentID==101) {
			employeeBonus=5.0;
		}else if(departmentID==201) {
			employeeBonus=6.0;
		}else if(departmentID==301) {
			employeeBonus=6.5;
		}
		return employeeBonus;
	}

	//Method, Add New Employees to HR Program
		public void addEmployee(String employeeName, int departmentID, String jobTitle) {
			System.out.println("**** New Employee Created: "+ employeeName+" ****");
			System.out.println("     Added to Department : "+departmentID);
			System.out.println("     Total Employees Now : "+totalEmployeeAdded());
			System.out.println(employeeName+"'s Job Title is: " +jobTitle);
			System.out.println(employeeName+"'s Salary is: "+hr.employeeSalary(departmentID));
			System.out.println(employeeName+"'s Bonus is: "+ hr.employeeBonus(departmentID)+"%");
			System.out.println(employeeName+"'s Total Monthly Pay is: "+hr.totalMonthlySalary(departmentID));
			System.out.println(employeeName+"'s PTO is: "+hr.calculatePTO(departmentID)+"\n");
		
		}
	
}
