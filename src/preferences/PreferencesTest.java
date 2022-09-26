package preferences;

import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.prefs.Preferences;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.filechooser.FileNameExtensionFilter;

public class PreferencesTest {

	public static void main(String[] args) {
		
		EventQueue.invokeLater(() -> {
			PreferencesFrame frame = new PreferencesFrame();

			frame.setDefaultCloseOperation(PreferencesFrame.exit());
			frame.setVisible(true);

			
		});
	}

}

class PreferencesFrame extends JFrame {

	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 300;
	
	
	private Preferences root = Preferences.userRoot();
	private Preferences node = root.node("JavaCore");

	public PreferencesFrame() {
		int left = node.getInt("left", 0);
		int top = node.getInt("top", 0);
		int width = node.getInt("width", PreferencesFrame.DEFAULT_WIDTH);
		int heigth = node.getInt("height", PreferencesFrame.DEFAULT_HEIGHT);
		setBounds(left, top, width, heigth);
		final JFileChooser chooser = new JFileChooser();
		chooser.setCurrentDirectory(new File("."));
		chooser.setFileFilter(new FileNameExtensionFilter("XML files", "xml"));

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		JMenu menu = new JMenu("File");
		menuBar.add(menu);

		JMenuItem exportItem = new JMenuItem("Export Preferences");

		menu.add(exportItem);
		exportItem.addActionListener(event -> {
			if (chooser.showSaveDialog(PreferencesFrame.this) == JFileChooser.APPROVE_OPTION) {
				try {
					savePreferences();
					OutputStream out = new FileOutputStream(chooser.getSelectedFile());
					node.exportSubtree(out);
					out.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		JMenuItem importItem = new JMenuItem("Import preferences");
		menu.add(importItem);
		importItem.addActionListener(event -> {
			if (chooser.showOpenDialog(PreferencesFrame.this) == JFileChooser.APPROVE_OPTION) {
				try {
					InputStream in = new FileInputStream(chooser.getSelectedFile());
					Preferences.importPreferences(in);
//					this.setBounds(0,0,400,400);
					in.close();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		JMenuItem exitItem = new JMenuItem("Exit");
		menu.add(exitItem);
		exitItem.addActionListener(event -> {
			savePreferences();
			System.exit(0);
		});
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent  e ) {
				savePreferences();
                System.exit(0);
			}
		});
		

	}

	public void savePreferences() {
		node.putInt("left", this.getX());
		node.putInt("top", this.getY());
		node.putInt("width", this.getWidth());
		node.putInt("height", this.getHeight());
		node.put("title", this.getTitle());
	}
	
	public static int exit() {
		
		return JFrame.EXIT_ON_CLOSE;
	}

}