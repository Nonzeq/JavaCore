package bounce;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BounceFrame extends JFrame {

	private BallComponent comp;
	public static final int STEPS = 3000;
	public static final int DELAY = 10;

	public BounceFrame() {

		this.comp = new BallComponent();
		add(comp, BorderLayout.CENTER);
		JPanel buttonPanel = new JPanel();
		addButton(buttonPanel, "Start", event -> addBall());
		addButton(buttonPanel, "Remove balls", event -> removeBalls());
		addButton(buttonPanel, "Close", event -> System.exit(0));
		add(buttonPanel, BorderLayout.SOUTH);
		this.pack();

	}

	public void addButton(Container c, String title, ActionListener listener) {
		JButton button = new JButton(title);
		c.add(button);
		button.addActionListener(listener);
	}

	public void addBall() {
		Ball ball = new Ball();
		comp.add(ball);
		Runnable run = () -> {
			try {
	
				for (int i = 1; i <= STEPS; i++) {
					ball.move(comp.getBounds());
					comp.repaint();
					Thread.sleep(BounceFrame.DELAY);
				}
			} catch (InterruptedException e) {
				System.out.println(e.getStackTrace());

			}

		};
		Thread t = new Thread(run);
		t.start();
	}
	
	public void removeBalls() {
		System.out.println("Remove");
		comp.removeBalls();
	}

}
