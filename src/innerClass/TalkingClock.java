package innerClass;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

public class TalkingClock {
	
	
	private int interval;
	private boolean beep;
	
	
	public TalkingClock(int interval, boolean beep) {
		this.interval = interval;
		this.beep = beep;
		
	}
	
	public void start() {
		ActionListener listener = new TimerPrinter();
		Timer t = new Timer(this.interval, listener);
		t.start();
	}
	
	public class TimerPrinter implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			System.out.println("At the tone , the time is " + new Date());
			if(beep) {
				Toolkit.getDefaultToolkit().beep();
			}
			
		}
	}
}
