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

import korisnici.Musterija;
import korisnici.Serviser;
import net.miginfocom.swing.MigLayout;
import uloge.Pol;
import uloge.SpecijalizacijaServisera;
import util.CitanjeFajlova;

public class ServiserForma extends JFrame {
	private JLabel lblId = new JLabel("Id");
	private JTextField txtId = new JTextField(20);
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
	
	private JLabel lblSpecijalizacija = new JLabel("Specijalizacija");
	private JComboBox<SpecijalizacijaServisera>cbSpec = new JComboBox<SpecijalizacijaServisera>(SpecijalizacijaServisera.values());
	
	private JButton btnOk = new JButton("OK");
	private JButton btnCancel = new JButton("Cancel");
	
	private CitanjeFajlova citanje;
	private Serviser serviser;
	
	public ServiserForma(CitanjeFajlova citanje,Serviser serviser) {
		this.citanje = citanje;
		this.serviser = serviser;
		if(serviser == null) {
			setTitle("Dodavanje servisera");
		}else {
			setTitle("Izmena podataka - "+serviser.getKorisnickoIme());
		}
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initGUI();
		initActions();
		setResizable(false);
		pack();
	}
	private void initGUI() {
		MigLayout layout = new MigLayout("wrap 2","[][]","[][][][][][][][][]20[]");
		setLayout(layout);
		
		if(serviser != null) {
			popuniPolja();
		}
		add(lblId);
		add(txtId);
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
		add(lblSpecijalizacija);
		add(cbSpec);
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
					String id = txtId.getText().trim(); 
					String ime = txtIme.getText().trim();
					String prezime = txtPrezime.getText().trim();
					String korisnickoIme = txtKorIme.getText().trim();
					String lozinka = new String(pfLozinka.getPassword()).trim();
					String jmbg = txtJmbg.getText().trim();
					String adresa = txtAdresa.getText().trim();
					String telefon = txtTelefon.getText().trim();
					Double plata = Double.parseDouble(txtPlata.getText().trim());
					SpecijalizacijaServisera spec = (SpecijalizacijaServisera)cbSpec.getSelectedItem();
					Pol pol = (Pol)cbPol.getSelectedItem();
					
					if(serviser == null) {
						Serviser novi = new Serviser(id, ime, prezime, jmbg, pol, adresa, telefon, korisnickoIme, lozinka, plata, spec, false);
						citanje.dodajServisera(novi);
					}else {
						serviser.setId(id);
						serviser.setIme(ime);
						serviser.setPrezime(prezime);
						serviser.setKorisnickoIme(korisnickoIme);
						serviser.setLozinka(lozinka);
						serviser.setPol(pol);
						serviser.setJmbg(jmbg);
						serviser.setAdresa(adresa);
						serviser.setSpecijalizacija(spec);
						
					}
					citanje.snimiServisere();
					ServiserForma.this.dispose();
					ServiserForma.this.setVisible(false);
				}
				
			}
		});
	}
	private void popuniPolja() {
		txtId.setText(serviser.getId());
		txtIme.setText(serviser.getIme());
		txtPrezime.setText(serviser.getPrezime());
		txtKorIme.setText(serviser.getKorisnickoIme());
		pfLozinka.setText(serviser.getLozinka());
		txtJmbg.setText(serviser.getJmbg());
		txtAdresa.setText(serviser.getAdresa());
		txtTelefon.setText(serviser.getBrojTelefona());
		txtPlata.setText(Double.toString(serviser.getPlata()));
		cbPol.setSelectedItem(serviser.getPol());
		cbSpec.setSelectedItem(serviser.getSpecijalizacija());
	}
	public boolean validacija() {
		boolean ok = true;
		String poruka = "Molimo popravite greske u unosu:\n";
		if(txtId.getText().trim().equals("")) {
			poruka += "- Unesite id\n";
			ok = false;
		}else if (serviser == null) {
			String id = txtId.getText().trim();
			Serviser pronadjen = citanje.pronadjiServisera(id);
			if(pronadjen != null) {
				poruka += "- Serviser sa tim id-om vec postoji!\n";
				ok = false;
			}		
		}

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
		}else if(serviser == null){
			String korIme = txtKorIme.getText().trim();
			Serviser pronadjeni = citanje.nadjiServisera(korIme);
			if(pronadjeni != null) {
				poruka += "- Serviser sa tim korisnickim imenom vec postoji!\n";
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
