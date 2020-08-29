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
import net.miginfocom.swing.MigLayout;
import servis.Deo;
import uloge.Pol;
import util.CitanjeFajlova;

public class MusterijaForma extends JFrame {
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
	private JLabel lblBodovi = new JLabel("Bodovi");
	private JTextField txtBodovi = new JTextField(20);
	private JButton btnOk = new JButton("OK");
	private JButton btnCancel = new JButton("Cancel");
	
	private CitanjeFajlova citanje;
	private Musterija musterija;
	
	public MusterijaForma(CitanjeFajlova citanje,Musterija musterija) {
		this.citanje = citanje;
		this.musterija = musterija;
		if(musterija == null) {
			setTitle("Dodavanje musterije");
		}else {
			setTitle("Izmena podataka - "+musterija.getKorisnickoIme());
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
		
		if(musterija != null) {
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
		add(lblBodovi);
		add(txtBodovi);
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
					int bodovi = Integer.parseInt(txtBodovi.getText());
					Pol pol = (Pol)cbPol.getSelectedItem();
					
					if(musterija == null) {
						Musterija novi = new Musterija(id, ime, prezime, jmbg, pol, adresa, telefon, korisnickoIme, lozinka, bodovi, false);
						citanje.dodajMusteriju(novi);
					}else {
						musterija.setId(id);
						musterija.setIme(ime);
						musterija.setPrezime(prezime);
						musterija.setKorisnickoIme(korisnickoIme);
						musterija.setLozinka(lozinka);
						musterija.setPol(pol);
						musterija.setJmbg(jmbg);
						musterija.setAdresa(adresa);
						musterija.setBrojBodova(bodovi);
						
					}
					citanje.snimiMusterije();
					MusterijaForma.this.dispose();
					MusterijaForma.this.setVisible(false);
				}
				
			}
		});
	}
	private void popuniPolja() {
		txtId.setText(musterija.getId());
		txtIme.setText(musterija.getIme());
		txtPrezime.setText(musterija.getPrezime());
		txtKorIme.setText(musterija.getKorisnickoIme());
		pfLozinka.setText(musterija.getLozinka());
		txtJmbg.setText(musterija.getJmbg());
		txtAdresa.setText(musterija.getAdresa());
		txtTelefon.setText(musterija.getBrojTelefona());
		txtBodovi.setText(Integer.toString(musterija.getBrojBodova()));
		cbPol.setSelectedItem(musterija.getPol());
	}
	public boolean validacija() {
		boolean ok = true;
		
		String poruka = "Molimo popravite greske u unosu:\n";
		if(txtId.getText().trim().equals("")) {
			poruka += "- Unesite id\n";
			ok = false;
		}else if (musterija == null) {
			String id = txtId.getText().trim();
			Musterija pronadjen = citanje.pronadjiMusteriju(id);
			if(pronadjen != null) {
				poruka += "- Musterija sa tim id-om vec postoji!\n";
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
		}else if(musterija == null){
			String korIme = txtKorIme.getText().trim();
			Musterija pronadjeni = citanje.nadjiMusteriju(korIme);
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
		if(txtBodovi.getText().trim().equals("")) {
			poruka += "- Unesite bodove\n";
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
