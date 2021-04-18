package Sortcomp;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import static javax.swing.JOptionPane.showMessageDialog;

public class UIPanel extends JPanel {
	
	BackEndHandler bh = new BackEndHandler();
	
	ArrayList<JCheckBox> cb = new ArrayList<JCheckBox>();
	public UIPanel() {
		Dimension size = getPreferredSize();
		size.width = 320;
		setPreferredSize(size);
		
		setBorder(BorderFactory.createTitledBorder("Vertaile lajittelualgoritmeja"));
		
		JLabel inputLengthLabel = new JLabel("Syötteen pituus (1 - 100000)");
		
		JTextField inputLengthField = new JTextField(10);
		
		JButton calculate = new JButton("      Laske     ");
		JButton reset = new JButton("Resetoi");
		
		final JTextArea textField = new JTextArea();	
		textField.setEditable(false);
		
		setLayout(new GridBagLayout());
		
		GridBagConstraints g = new GridBagConstraints();
		
		showMessageDialog(null, "Tervetuloa käyttämään lajittelualgoritmien vertailuohjelmaa.\n" 
		+ "Sallitut syötteen pituudet ovat 1-100000.\n" 
		+ "Huom! Mikäli syötteen pituus on suuri, saattaa suorituksessa kestää hetken aikaa."
		,"Algoritmien vertailu", JOptionPane.INFORMATION_MESSAGE);
		
		g.gridx = 0;
        g.gridy = 1;
        
		g.anchor = GridBagConstraints.NORTHWEST;
		
		// CHECKBOXIT
		
		for (int i = 0; i < bh.getAlgorithms().size(); i++){
			cb.add(new JCheckBox(bh.getName(i)));
			add(cb.get(i), g);
			g.gridy++;
		}
        
        // CHECKBOXIT LOPPUU
        
        add(inputLengthLabel, g);
        g.gridy++;
        add(inputLengthField, g);
        g.gridy++;
        add(calculate, g);
        
		g.weighty = 1;
		g.weightx = 1;
		
		add(new JLabel(" "), g);
		
		g.gridy++;
		
		JScrollPane scroll = new JScrollPane (textField);
		scroll.setPreferredSize(new Dimension(300, 300));
		scroll.setBounds(10,60,780,500);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		add(scroll, g);
		
		g.gridy++;
		
		g.anchor = GridBagConstraints.LINE_START;
		
		add(reset, g);

		calculate.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
				int value = Integer.parseInt(inputLengthField.getText());
				int allFalse = 0;
				boolean[] checked = new boolean[cb.size()];
				for(int i = 0; i<cb.size(); i++){
					if (cb.get(i).isSelected()){
						checked[i] = true;
						}
					else{
						checked[i] = false;
						allFalse++;
						}
					}
				if (value > 100000 || value < 1) {
					showMessageDialog(null, "Syötä sallittu arvo (1-100000)."
							,"Virhe!", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					ArrayList<Integer[]> values = new ArrayList<Integer[]>();
					values = bh.runAlgorithms(checked, value);
					String input = "";
					for (int i = 0; i < 3; i++) {
							if (cb.get(i).isSelected()){
								if (values.get(i)[0] == 0) {
									input += bh.getName(i) + " \nComps: >"+Integer.MAX_VALUE;
								}
								else {
									input += bh.getName(i)+": \nComps: "+values.get(i)[0];
								}
								if (values.get(i)[1] == 0) {
									input += ", Swaps: >"+Integer.MAX_VALUE+"\n\n";
								}
								else {
									input += ", Swaps: "+values.get(i)[1];
								}
								input += "\n\n";
							}
						}
					
					if (allFalse == cb.size()) {
						showMessageDialog(null, "Valitse vähintään yksi lajittelualgoritmi."
								,"Virhe!", JOptionPane.INFORMATION_MESSAGE);
					}
					else {
					showMessageDialog(null, input
							,"Tulos syötteen pituudella " +value, JOptionPane.INFORMATION_MESSAGE);
					
					textField.append("Tulos syötteen pituudella " +value +":\n\n" + input + "\n");
					}
				}
				} catch (NumberFormatException ne) {
					showMessageDialog(null, "Syötä sallittu arvo (1-100000)."
							,"Virhe!", JOptionPane.INFORMATION_MESSAGE);
				}
				}
				});
		
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
			}
		});
		}
		}	