package guiFromeZaDodavanjeiIzmene;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import korisnici.Administrator;
import korisnici.Musterija;
import net.miginfocom.swing.MigLayout;
import uloge.Pol;
import util.CitanjeFajlova;

public class AdminForma extends JFrame {
	private JLabel lblIme = new JLabel("Ime");
	private JTextField txtIme = new JTextField(20);
	private JLabel lblPrezime = new JLabel("Prezime");
	private JTextField txtPrezime = new JTextField(20);
	private JLabel lblKorIme = new JLabel("Korisnicko ime");
	private JTextField txtKorIme = new JTextField(20);
	private JLabel lblLozinka = new JLabel("Lozinka");
	private JPasswordField pfLozinka = new JPasswordField(20);
	private JLabel lblPol = new JLabel("Pol");
	private JComboBox<Pol>cbPol = new JComboBox<Pol>(Pol.values());
	private JLabel lblJmbg = new JLabel("JMBG");
	private JTextField txtJmbg = new JTextField(20);
	private JLabel lblAdresa = new JLabel("Adresa");
	private JTextField txtAdresa = new JTextField(20);
	private JLabel lblBrojTel = new JLabel("Telefon");
	private JTextField txtTelefon = new JTextField(20);
	private JLabel lblPlata = new JLabel("Plata");
	private JTextField txtPlata = new JTextField(20);
	private JButton btnOk = new JButton("OK");
	private JButton btnCancel = new JButton("Cancel");
	
	private CitanjeFajlova citanje;
	private Administrator admin;
	
	public AdminForma(CitanjeFajlova citanje,Administrator admin) {
		this.citanje = citanje;
		this.admin = admin;
		if(admin == null) {
			setTitle("Dodavanje admina");
		}else {
			setTitle("Izmena podataka - " + admin.getKorisnickoIme());
		}
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initGUI();
		initActions();
		setResizable(false);
		pack();
	}
	private void initGUI() {
		MigLayout layout = new MigLayout("wrap 2","[][]","[][][][][][][][]20[]");
		setLayout(layout);
		
		if(admin != null) {
			popuniPolja();
		}
		
		add(lblIme);
		add(txtIme);
		add(lblPrezime);
		add(txtPrezime);
		add(lblKorIme);
		add(txtKorIme);
		add(lblLozinka);
		add(pfLozinka);
		add(lblJmbg);
		add(txtJmbg);
		add(lblAdresa);
		add(txtAdresa);
		add(lblBrojTel);
		add(txtTelefon);
		add(lblPlata);
		add(txtPlata);
		add(lblPol);
		add(cbPol);
		add(new JLabel());
		add(btnOk,"split 2");
		add(btnCancel);
		
	}
	private void initActions() {
		btnOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(validacija()) {
					int id = 0;
					String ime = txtIme.getText().trim();
					String prezime = txtPrezime.getText().trim();
					String korisnickoIme = txtKorIme.getText().trim();
					String lozinka = new String(pfLozinka.getPassword()).trim();
					String jmbg = txtJmbg.getText().trim();
					String adresa = txtAdresa.getText().trim();
					String telefon = txtTelefon.getText().trim();
					Double plata = 20000.0;
					Pol pol = (Pol)cbPol.getSelectedItem();
					
					if(admin == null) {
						Administrator novi = new Administrator(id, ime, prezime, jmbg, pol, adresa, telefon, korisnickoIme, lozinka, plata, false);
						citanje.dodajAdmina(novi);
					}else {
						admin.setIme(ime);
						admin.setPrezime(prezime);
						admin.setKorisnickoIme(korisnickoIme);
						admin.setLozinka(lozinka);
						admin.setPol(pol);
						admin.setJmbg(jmbg);
						admin.setAdresa(adresa);
						admin.setPlata(plata);
						
					}
					citanje.snimiAdmine();
					AdminForma.this.dispose();
					AdminForma.this.setVisible(false);
				}
				
			}
		});
	}
	private void popuniPolja() {
		txtIme.setText(admin.getIme());
		txtPrezime.setText(admin.getPrezime());
		txtKorIme.setText(admin.getKorisnickoIme());
		pfLozinka.setText(admin.getLozinka());
		txtJmbg.setText(admin.getJmbg());
		txtAdresa.setText(admin.getAdresa());
		txtTelefon.setText(admin.getBrojTelefona());
		txtPlata.setText(Double.toString(admin.getPlata()));
		cbPol.setSelectedItem(admin);
	}
	public boolean validacija() {
		boolean ok = true;
		String poruka = "Molimo popravite greske u unosu:\n";
		
		if(txtIme.getText().trim().equals("")) {
			poruka += "- Unesite ime\n";
			ok = false;
		}
		if(txtPrezime.getText().trim().equals("")) {
			poruka += "- Unesite prezime\n";
			ok = false;
		}
		if(txtKorIme.getText().trim().equals("")) {
			poruka += "- Unesite korisnicko ime\n";
			ok = false;
		}else if(admin != null){
			String korIme = txtKorIme.getText().trim();
			Administrator pronadjeni = citanje.nadjiAdmina(korIme);
			if(pronadjeni != null) {
				poruka += "- Musterija sa tim korisnickim imenom vec postoji!\n";
				ok = false;
			}
		}
		if(txtJmbg.getText().trim().equals("")) {
			poruka += "- Unesite jmbg\n";
			ok = false;
		}
		if(txtAdresa.getText().trim().equals("")) {
			poruka += "- Unesite adresu\n";
			ok = false;
		}
		if(txtTelefon.getText().trim().equals("")) {
			poruka += "- Unesite telefon\n";
			ok = false;
		}
		if(txtPlata.getText().trim().equals("")) {
			poruka += "- Unesite platu\n";
			ok = false;
		}
		String sifra = new String(pfLozinka.getPassword()).trim();
		if(sifra.equals("")) {
			poruka += "- Unesite lozinku\n";
			ok = false;
		}
		if(ok == false) {
			JOptionPane.showMessageDialog(null, poruka, "Neispravni podaci", JOptionPane.WARNING_MESSAGE);
		}
		return ok;
		
		
	}

}
