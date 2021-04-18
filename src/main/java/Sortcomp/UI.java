package Sortcomp;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class UI extends JFrame {
	
	private UIPanel panel;
	
	public UI(String title) {
		super(title);
		
		panel = new UIPanel();
		
		// Layout manager
		setLayout(new BorderLayout());
		
		// Components
		final JTextArea text = new JTextArea();
		
		// Swing components to content pane
		Container c = getContentPane();
		
		c.add(panel, BorderLayout.WEST);
		c.add(text, BorderLayout.CENTER);
	}
}