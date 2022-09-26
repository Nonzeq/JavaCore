package treeSet;
import java.util.*;
public class TreeSetTest {

	public static void main(String[] args) {
		SortedSet<Item> parts = new TreeSet<>();
		parts.add(new Item("Toaster",1238));
		parts.add(new Item("Widget",1235));
		parts.add(new Item("Modem",1240));
		parts.add(new Item("Phone",1237));
		System.out.println(parts);
		
		NavigableSet<Item> sortByDescription = new TreeSet<>(
				Comparator.comparing(event -> event.getDescription()));
		
		sortByDescription.addAll(parts);
		System.out.println(sortByDescription);

	}

}
