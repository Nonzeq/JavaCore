package treeSet;
import java.util.*;



public class Item implements Comparable<Item>{
	
	private String description;
	private int partNumber;
	
	public Item(String desc, int num) {
		this.description = desc;
		this.partNumber = num;
	}
	
	
	public String getDescription() {
		return this.description;
	}
	public String toString() {
		return "[description " + this.description + ", partBumber=" + this.partNumber + "]";
		
	}
	public boolean equals(Object otherObj) {
		if(this == otherObj) return true;
		if(otherObj == null) return false;
		if(getClass() != otherObj.getClass()) return false;
		Item other = (Item) otherObj;
		return Objects.equals(this.description, other.description) && this.partNumber == other.partNumber;
		
	}
	public int hashCode() {
		return Objects.hash(this.description, this.partNumber);
	}
	
	public int compareTo(Item other) {
		int diff = Integer.compare(this.partNumber, other.partNumber);
		return diff != 0 ? diff : this.description.compareTo(other.description);
	}
}
