package inheritance;

import java.io.Serializable;
import java.time.*;

public class Employee implements Serializable {
	private String name;
	private double salary;
	private LocalDate hireDay;
	
	
	public Employee(
			String name, double salary, int year, int month, int day) {
		this.name = name;
		this.salary = salary;
		this.hireDay = LocalDate.of(year, month, day);
		
	}
	
	public String toString() {
		return this.name + " " + this.salary;
	}
	
	public String getname() {
		return name;
	}
	
	public double getSalary() {
		return salary;
	}
	
	public LocalDate getHireDay() {
		return hireDay;
	}
	
	public void raiseSalaty(double percent) {
		double raise = salary * percent / 100;
		salary += raise;
	}
}
