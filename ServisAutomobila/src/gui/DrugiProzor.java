package gui;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class DrugiProzor extends JFrame {
	public DrugiProzor() {
		setTitle("Drugi prozor");
		setSize(500, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setResizable(false);
		
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				Object[]opcije = {"Da","Ne","Nazad"};
				DrugiProzor dprozor = new DrugiProzor();
				int izbor = JOptionPane.showOptionDialog(dprozor, "Da li zelite da izadjete?", "Izlaz",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcije,opcije[0]);
				if(izbor==JOptionPane.YES_OPTION) {
					DrugiProzor.this.setVisible(false);
					DrugiProzor.this.dispose();
				}
			}
			
			
		});
	}
}
