package priorityQueue;
import java.util.*;
public class PriorityQueueTest {

	public static void main(String[] args) {
		
		PriorityQueue<GregorianCalendar> pq = new PriorityQueue<>();
		pq.add(new GregorianCalendar(1920, Calendar.DECEMBER, 9));
		pq.add(new GregorianCalendar(1940, Calendar.DECEMBER, 10));
		pq.add(new GregorianCalendar(1910, Calendar.DECEMBER, 22));
		
		System.out.println("Iterating over elements...");
		for(GregorianCalendar date: pq) {
			System.out.println(date.get(Calendar.YEAR));
			
		}
		System.out.println("Removing elents ");
		while (!pq.isEmpty()) {
			System.out.println(pq.remove().get(Calendar.YEAR));
		}
		

	}

}
