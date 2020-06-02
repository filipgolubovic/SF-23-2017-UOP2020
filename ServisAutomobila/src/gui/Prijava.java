package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import korisnici.Administrator;
import korisnici.Musterija;
import net.miginfocom.swing.MigLayout;
import util.CitanjeFajlova;

public class Prijava extends JFrame {

	private JLabel lblDobroDosli = new JLabel("Dobrodosli! Molimo prijavite se.");
	private JLabel lblKorIme = new JLabel("Korisnicko ime");
	private JTextField txtKorIme = new JTextField(20);
	private JLabel lblLozinka = new JLabel("Lozinka");
	private JPasswordField pfLozinka = new JPasswordField(20);
	private JButton btnPrijava = new JButton("Prijava");
	private JButton btnIzlaz = new JButton("Izlaz");
	
	private CitanjeFajlova citanje;
	
	public Prijava(CitanjeFajlova citanje) {
		this.citanje = citanje;
		setTitle("Prijava korisnika");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		initGUI();
		initActions();
		pack();
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				Object[]opcije = {"Da","Ne","Nazad"};
				Prijava prijava = new Prijava(citanje);
				int izbor = JOptionPane.showOptionDialog(prijava, "Da li zelite da izadjete?", "Izlaz",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcije,opcije[0]);
				if(izbor==JOptionPane.YES_OPTION) {
					Prijava.this.setVisible(false);
					Prijava.this.dispose();
				}
			}
			
		});
	}
	
	public void initGUI() {
		MigLayout mig = new MigLayout("wrap 2","[][]","[]10[][]10[]");
		setLayout(mig);
		add(lblDobroDosli,"span 2");
		add(lblKorIme);
		add(txtKorIme);
		add(lblLozinka);
		add(pfLozinka);
		add(new JLabel());
		add(btnPrijava,"split 2");
		add(btnIzlaz);
		
		getRootPane().setDefaultButton(btnPrijava);
	}
	public void initActions() {
		btnIzlaz.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Prijava.this.dispose();
				Prijava.this.setVisible(false);
			}
		});
		btnPrijava.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String korisnickoIme = txtKorIme.getText().trim();
				String sifra = new String(pfLozinka.getPassword()).trim();
				
				if(korisnickoIme.equals("") || sifra.equals("")) {
					JOptionPane.showMessageDialog(null, "Niste uneli sve podatke za prijavu", "Greska",JOptionPane.WARNING_MESSAGE);
					}else{
						Administrator prijavljenA = citanje.loginA(korisnickoIme, sifra);
						Musterija prijavljenM = citanje.loginM(korisnickoIme, sifra);
						if(prijavljenA == null) {
							JOptionPane.showMessageDialog(null, "Pogresni login podaci", "Greska", JOptionPane.WARNING_MESSAGE);
						}else{
							Prijava.this.dispose();
							Prijava.this.setVisible(false);
							GlavniProzor gp = new GlavniProzor(citanje, prijavljenA);
							gp.setVisible(true);
						}
					}
			};
		});
	}
	}

