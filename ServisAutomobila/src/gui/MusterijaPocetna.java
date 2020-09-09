package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import guiFormeZaPrikaz.MusterijaServisPrikaz;
import korisnici.Musterija;
import util.CitanjeFajlova;

public class MusterijaPocetna extends JFrame {
	

	private JMenuBar mainMenu = new JMenuBar();
	private JMenu servisMeni = new JMenu("Auto servis");
	private JMenuItem servisItem = new JMenuItem("Zakazi servis");
	
	private CitanjeFajlova citanje;
	private Musterija prijavljenaMusterija;
	
	
	public MusterijaPocetna(CitanjeFajlova citanje,Musterija prijavljenaMusterija) {
		this.citanje = citanje;
		this.prijavljenaMusterija = prijavljenaMusterija;
		setTitle("Prijavljen korisnik: "+prijavljenaMusterija.getIme()+" "+prijavljenaMusterija.getPrezime());
		setSize(500, 500);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		initMenu();
		initActions();
	}
	public void initMenu() {
		setJMenuBar(mainMenu);
		mainMenu.add(servisMeni);
		servisMeni.add(servisItem);
	}
	public void initActions() {
		servisItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MusterijaServisPrikaz msp = new MusterijaServisPrikaz(citanje,prijavljenaMusterija);
				msp.setVisible(true);
				
			}
		});
	}
}
