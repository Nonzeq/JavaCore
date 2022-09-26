package bounce;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class BallComponent extends JPanel{
	

	private static final int DEFAULT_WIDTH = 650;
	private static final int DEFAULT_HEIGTH = 350;
	
	private java.util.List<Ball> balls = new ArrayList<>();
	
	public void add(Ball b) {
		b.setColor(getColor());
		this.balls.add(b);
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		//g2.setColor(getColor());
		for(Ball b: this.balls) {
			g2.setBackground(getColor());
			g2.setColor(b.color);
			g2.fill(b.getShape());
		}
		Toolkit.getDefaultToolkit().sync();
		
	}
	public Dimension getPreferredSize() {
		return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGTH);
	}
	public static Color getColor() {
		List<Color> colors = new ArrayList<>();
		colors.add(Color.BLACK);
		colors.add(Color.ORANGE);
		colors.add(Color.RED);
		double i = Math.random();
		if (i < 0.3)
			return colors.get(1);
		else if(i < 0.6 && i > 0.3)
			return colors.get(2);
		else
			return colors.get(0);
	}
	
	public void removeBalls() {
		balls.removeAll(balls);
	}
}
