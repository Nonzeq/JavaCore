package inheritance;

public class Manager extends Employee{
	
	private double bonus;
	private Employee secretary;
	
	public Manager(String name, double salary, int year, int month, int day) {
		super(name, salary, year, month, day);
		bonus = 0;
	}
	
	public String toString() {
		return super.toString() + " " + this.secretary;
	}
	
	public double getSalary() {
		return super.getSalary() + bonus;
	}
	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
	
	public void setSecretary(Employee e) {
		this.secretary = e;
	}
}
