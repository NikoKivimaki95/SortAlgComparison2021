package Sortcomp;

import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;

class Application {
    public static void main(String args[]) {
    	
    	SwingUtilities.invokeLater(new Runnable() {
    		public void run() {
    			JFrame frame = new UI("Algoritmien vertailu");
    	        frame.setSize(320, 610);
    	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	        frame.setVisible(true);
    	        frame.setResizable(false);
    		}
    	});
    }
}