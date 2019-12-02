package ie.lyit.bank;
import ie.lyit.bank.Date;
import ie.lyit.bank.Person;

public class Employee extends Person {
	
	protected Date startDate;
	protected double salary;
	protected int number;
	protected static int nextNumber = 1;
	
	final double MAXIMUMSALARY = 150000.0;
	
	public Employee() {
		super();
		
		startDate = new Date();
		salary=24000;
		number=nextNumber;
		nextNumber++;
	}
	
	public Employee(Name n, Date dob, Date stDate, double sly) {
		super(n, dob);
		
		startDate=stDate;
		salary=sly;
		number=nextNumber;
		nextNumber++;
	}
	
	@Override
	public String toString(){
		return (super.toString() + ", Start Date: " + this.startDate + ", Salary: " + this.salary + ", Number: " + this.number);
	}
	
	@Override
	public boolean equals(Object obj){
		Employee eObject;
		if (obj instanceof Employee)
			eObject = (Employee)obj;
		else
			return false;
	   
		return(name.equals(eObject.name) &&
			   dateOfBirth.equals(eObject.dateOfBirth) && startDate.equals(eObject.startDate) && this.salary == eObject.salary);
	}

	// Getter and setter methods:
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public int getNumber() {
		return number;
	}
	
	// Method to add a passed in amount to increase an employees salary
	public void incrementSalary(double incrementAmount) throws Exception {
		
		if(this.salary+incrementAmount > 150000.0) {
			throw new Exception("Increment amount to high!");
		}
		else {
			this.salary+=incrementAmount;
		}
	}
	
	// Calculating wage from salary value for a passed in tax percentage
	public double calculateWage(double taxPercentage) {
		double wage=0;

		wage = this.getSalary()/12;
		wage-=(wage*(taxPercentage/100));

		return wage;
	}
		
}
