package resource;

import java.awt.*;
import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;

public class ResourceTest{
	
	
	//public static final  Test a = new Test();
	
	
	public static void main(String[] args) {
//		Test a = new Test();
		EventQueue.invokeLater(new Test());

	}
}

class Test implements Runnable{
	
	public void run() {
		JFrame frame = new ResourceTestFrame();
		frame.setTitle("ResourceTest");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);	
	}

}


class ResourceTestFrame extends JFrame {

	private static final int DEFAULT_WIDTH = 500;
	private static final int DEFAULT_HEIGTH = 500;

	public ResourceTestFrame() {
		setSize(ResourceTestFrame.DEFAULT_WIDTH, ResourceTestFrame.DEFAULT_HEIGTH);
		URL aboutURL = getClass().getResource("about.png");
		Image img = new ImageIcon(aboutURL).getImage();
		setIconImage(img);

		JTextArea textarea = new JTextArea();

		InputStream stream = getClass().getResourceAsStream("about.txt");
		try (Scanner in = new Scanner(stream, "UTF-8")) {
			while (in.hasNext()) {
				textarea.append(in.nextLine() + "\n");
			}
		}
		add(textarea);

	}

}
