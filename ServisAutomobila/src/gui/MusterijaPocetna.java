package gui;

import javax.swing.JFrame;
import javax.swing.JMenuBar;

import korisnici.Musterija;
import util.CitanjeFajlova;

public class MusterijaPocetna extends JFrame {
	
	private JMenuBar mainMenu = new JMenuBar();
	
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
	}
	public void initMenu() {
		setJMenuBar(mainMenu);
	}
}
