package gui;

import javax.swing.JFrame;
import javax.swing.JMenuBar;

import korisnici.Musterija;
import korisnici.Serviser;
import util.CitanjeFajlova;

public class ServiserPocetna extends JFrame {
	private JMenuBar mainMenu = new JMenuBar();
	
	private CitanjeFajlova citanje;
	private Serviser prijavljeniServiser;
	
	
	public ServiserPocetna(CitanjeFajlova citanje,Serviser prijavljeniServiser) {
		this.citanje = citanje;
		this.prijavljeniServiser = prijavljeniServiser;
		setTitle("Prijavljen korisnik: "+prijavljeniServiser.getIme()+" "+prijavljeniServiser.getPrezime());
		setSize(500, 500);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		initMenu();
	}
	public void initMenu() {
		setJMenuBar(mainMenu);
	}
}
