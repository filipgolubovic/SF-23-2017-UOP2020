package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import guiFormeZaPrikaz.AdminPikaz;
import guiFormeZaPrikaz.AutomobilPrikaz;
import guiFormeZaPrikaz.DeloviPrikaz;
import guiFormeZaPrikaz.KnjizicePrikaz;
import guiFormeZaPrikaz.MusterijeProzor;
import guiFormeZaPrikaz.ServiseriPrikaz;
import guiFormeZaPrikaz.ServisiPrikaz;
import korisnici.Administrator;
import util.CitanjeFajlova;

public class GlavniProzor extends JFrame {
	private JMenuBar mainMenu = new JMenuBar();
	private JMenu servisMeni = new JMenu("Auto servis");
	private JMenuItem autoItem = new JMenuItem("Automobili");
	private JMenuItem servisItem = new JMenuItem("Servisi");
	private JMenuItem deloviItem = new JMenuItem("Delovi");
	private JMenuItem knjiziceItem = new JMenuItem("Servisne Knjizice");
	
	private JMenu korisniciMenu = new JMenu("Korisnici");
	private JMenuItem adminItem = new JMenuItem("Admini");
	private JMenuItem musterijaItem = new JMenuItem("Musterije");
	private JMenuItem serviserItem = new JMenuItem("Serviseri");
	
	private CitanjeFajlova citanje;
	private Administrator prijavljenAdmin;
	
	public GlavniProzor(CitanjeFajlova citanje,Administrator prijavljenAdmin) {
		this.citanje = citanje;
		this.prijavljenAdmin = prijavljenAdmin;
		setTitle("Prijavljen korisnik: "+prijavljenAdmin.getIme()+" "+prijavljenAdmin.getPrezime());
		setSize(500, 500);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		initMenu();
		initActions();
	}
	
	private void initMenu() {
		setJMenuBar(mainMenu);
		mainMenu.add(servisMeni);
		mainMenu.add(korisniciMenu);
		servisMeni.add(autoItem);
		servisMeni.add(servisItem);
		servisMeni.add(deloviItem);
		servisMeni.add(knjiziceItem);
		korisniciMenu.add(adminItem);
		korisniciMenu.add(musterijaItem);
		korisniciMenu.add(serviserItem);
		
	}
	private void initActions() {
		musterijaItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				MusterijeProzor mp = new MusterijeProzor(citanje);
				mp.setVisible(true);
			}
		} );
		adminItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				AdminPikaz ap = new AdminPikaz(citanje);
				ap.setVisible(true);
				
			}
		});
		serviserItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ServiseriPrikaz sp = new ServiseriPrikaz(citanje);
				sp.setVisible(true);
				
			}
		});
		autoItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				AutomobilPrikaz ap = new AutomobilPrikaz(citanje);
				ap.setVisible(true);
				
			}
		});
		deloviItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DeloviPrikaz dp = new DeloviPrikaz(citanje);
				dp.setVisible(true);
				
			}
		});
		servisItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ServisiPrikaz sp = new ServisiPrikaz(citanje);
				sp.setVisible(true);
				
			}
		});
		knjiziceItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				KnjizicePrikaz kp = new KnjizicePrikaz(citanje);
				kp.setVisible(true);
				
			}
		});
	}
}
