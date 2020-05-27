package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class MojPrviProzor extends JFrame {
	
	public MojPrviProzor() {
		setTitle("Moj prvi prozor");
		setSize(500,500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setResizable(false);
		initMenu();
		
		JButton btnOk = new JButton("Drugi prozor");
		add(btnOk,BorderLayout.SOUTH);
		btnOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DrugiProzor drugi = new DrugiProzor();
				drugi.setVisible(true);
				
				
			}
		});
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				Object[]opcije = {"Da","Ne","Nazad"};
				DrugiProzor dprozor = new DrugiProzor();
				int izbor = JOptionPane.showOptionDialog(dprozor, "Da li zelite da izadjete?", "Izlaz",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcije,opcije[0]);
				if(izbor==JOptionPane.YES_OPTION) {
					MojPrviProzor.this.setVisible(false);
					MojPrviProzor.this.dispose();
				}
			}
			
		});
		
	}
	private void initMenu() {
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu fileMenu = new JMenu("File");
		menuBar.add(fileMenu);
		
		JMenuItem openMenu = new JMenuItem("Open..");
		fileMenu.add(openMenu);
		
		JMenu insertMenu = new JMenu("Insert");
		fileMenu.add(insertMenu);
		
		JMenuItem fromFileItem = new JMenuItem("From file..");
		insertMenu.add(fromFileItem);
		
		JMenuItem fromURLItem = new JMenuItem("From URL..");
		insertMenu.add(fromURLItem);
	}
}
