package lambda;


import java.util.*;
import javax.swing.*;
import javax.swing.Timer;



public class LambdaTimerTest {
	public static void main(String[] args) {
		
		String[] planets = new String[] {"Mercury", "Venus", "Earth",
				"Mars", "Jupiter", "Saturn", "Uranus", "Nempune"};
		System.out.println(Arrays.toString(planets));
		System.out.println("Sordet in dictionary order:");
		Arrays.sort(planets);
		System.out.println(Arrays.toString(planets));
		System.out.println("Sorted by length:");
		Arrays.sort(planets, (String first, String second) -> first.length() - second.length());
		System.out.println(Arrays.toString(planets));
		
		Timer t = new Timer(5000,event -> 
			System.out.println("The time is " + new Date()));
		t.start();
		
		JOptionPane.showMessageDialog(null, "Quit program?");
		System.exit(0);
	}
}
