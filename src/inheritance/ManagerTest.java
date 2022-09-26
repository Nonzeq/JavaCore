package inheritance;

public class ManagerTest {

	public static void main(String[] args) {
		Manager boss = new Manager("Carl Cracker", 80000, 1987, 12, 15);
		boss.setBonus(5000);
		Employee[] staff = new Employee[3];
		
		staff[0] = boss;
		staff[1] = new Employee("Harry Hacker", 50000, 1962, 4, 22);
		staff[2] = new Employee("Joch Butcher", 30000, 1974, 3, 11);
		
		for(Employee e : staff) {
			System.out.println("name: " + e.getname() + ", salary: " + e.getSalary() + ", date: " + e.getHireDay());
		}

	}

}
