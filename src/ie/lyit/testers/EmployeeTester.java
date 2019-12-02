package ie.lyit.testers;

import ie.lyit.bank.Date;
import ie.lyit.bank.Employee;
import ie.lyit.bank.Name;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class EmployeeTester {
	
	Employee emp1;
	Employee emp2;
	Employee emp3;
	
	@Before
	public void setUp() {
		// Construct three employee objects for testing 
		
	emp1 = new Employee(new Name("Mr","Eric","Cartman"), new Date(12, 10, 1988), new Date(21, 11, 2019), 50000.0);
	emp2 = new Employee(new Name("Mr","Stan","Smith"), new Date(24, 10, 1988), new Date(24, 11, 2019), 75000.0);
	emp3 = new Employee(new Name("Mr","Bill","Davies"), new Date(12, 10, 1988), new Date(21, 11, 2019), 60000.0);
	
	}
	
	@Test
	public void testEmployee() {                   // Testing Employee Constructor
		
		assertEquals(new Name("Mr","Eric","Cartman"), emp1.getName());
		assertEquals(new Date(12, 10, 1988), emp1.getDateOfBirth());
		assertEquals(new Date(21, 11, 2019), emp1.getStartDate());
		assertEquals(50000.0, emp1.getSalary(), 0.001);
			
	}
	
	@Test
	public void testSetName() {                         // Testing setName method
		
		Name name1 = new Name("Mr","David","Cartmen");
		
		emp1.setName(name1);
		assertEquals(name1, emp1.getName());
		
	}
	
	@Test
	public void testSetDateOfBirth() {                         // Testing setDateOfBirth method
		
		Date testDate = new Date(12, 10, 1992);
		
		emp1.setDateOfBirth(testDate);
		assertEquals(testDate, emp1.getDateOfBirth());
		
	}
	
	@Test
	public void testSetStartDate() {                         // Testing setStartDate method
		
		Date testDate2 = new Date(03, 12, 2019);
		
		emp1.setStartDate(testDate2);
		assertEquals(testDate2, emp1.getStartDate());
		
	}
	
	@Test
	public void testSetSalary() {                         // Testing setSalary method
		
		double testSalary = 100000.0;
		
		emp1.setSalary(testSalary);
		assertTrue(emp1.getSalary()==100000.0);
		
	}
	
	@Test
	public void testToString() {                        // Testing Employee's toString method
		
		// Check emp2’s toString() returns "Mr Stan Smith,24/10/1988, Start Date: 24/11/2019, Salary: 75000.0, Number: 2"
		assertEquals(emp2.toString(), "Mr Stan Smith,24/10/1988, Start Date: 24/11/2019, Salary: 75000.0, Number: 2");
		
		// Check emp3’s toString() returns "Mr Bill Davies,12/10/1988, Start Date: 21/11/2019, Salary: 50000.0, Number: 3"
		assertEquals(emp3.toString(), "Mr Bill Davies,12/10/1988, Start Date: 21/11/2019, Salary: 60000.0, Number: 3");
	}
	
	@Test
	public void testIncrementSalary() throws Exception {               // Testing Increment Salary
		double testSalaryInc = 20000.0;
		try {
		emp3.incrementSalary(testSalaryInc);
		assertTrue(emp3.getSalary()==80000.0);
		}catch(Exception e) {
			throw new Exception("Enter Increment Amount to Large!");
		}
	}
	
	@Test
	public void testIncrementSalary2() throws Exception {            // Testing Increment Salary with negative result and catch error
		double testSalaryInc = 200000.0;
		try {
		emp3.incrementSalary(testSalaryInc);
		assertFalse(emp3.getSalary()==260000.0);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	@Test 
	public void testCalculateWage() {                   // Testing calculateWage method
		
		assertTrue(emp3.calculateWage(0.05)==4997.5);
	}
	

}
