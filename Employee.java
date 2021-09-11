package MortgageCalculator;

public class Employee {
	private int baseSalary;
	private int hourlyRate;
	
	public static int numberOfEmployees;
	
	public Employee(int baseSalary) {
		this(baseSalary,0);
	}
	
	public Employee(int baseSalary, int hourlyRate) {
		setBaseSalary(baseSalary);
		setHourlyRate(hourlyRate);
		numberOfEmployees++;
	}
	
	public static void printNumberOfEmployees() {
		System.out.println(numberOfEmployees);
	}
	
	
	public int calculateWage(int extraHours) {
		return baseSalary + (hourlyRate * extraHours);
	}
	
	public int calculateWage() {
		return calculateWage(0);
	}
	
	private int getHourlyRate() {
		return hourlyRate;
	}

	public void setHourlyRate(int hourlyRate) {
		if(hourlyRate < 0)
			throw new IllegalArgumentException("Hourly Rate cannot be 0 or less");
		this.hourlyRate = hourlyRate;
	}
	
	public void setBaseSalary(int baseSalary) {
		if(baseSalary <= 0) 
			throw new IllegalArgumentException("Salary cannot be 0 or less");
		this.baseSalary = baseSalary;
	}
	private int getBaseSalary() {
		return baseSalary;
	}
	
	
}
