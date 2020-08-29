package guiFromeZaDodavanjeiIzmene;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import korisnici.Musterija;
import korisnici.Serviser;
import net.miginfocom.swing.MigLayout;
import servis.Automobil;
import servis.Deo;
import servis.Servis;
import uloge.Marka;
import uloge.Model;
import uloge.VrstaGoriva;
import util.CitanjeFajlova;

public class ServisForma extends JFrame {
	private JLabel lblId = new JLabel("ID");
	private JTextField txtId = new JTextField(20);
	
	private JLabel lblAuto= new JLabel("Auto");
	private JComboBox<String>cbAuto= new JComboBox<String>();
	private JLabel lblServiser= new JLabel("Serviser");
	private JComboBox<String>cbServiser = new JComboBox<String>();
	
	private JLabel lblOpis = new JLabel("Opis");
	private JTextField txtOpis = new JTextField(20);
	private JLabel lblDatum = new JLabel("Datum");
	private JTextField txtDatum = new JTextField(20);


	private JButton btnOk = new JButton("OK");
	private JButton btnCancel = new JButton("Cancel");
	
	private CitanjeFajlova citanje;
	private Servis servis;
	private Automobil auto;
	private Serviser serviser;
	
	public ServisForma(CitanjeFajlova citanje,Servis servis) {
		this.citanje = citanje;
		this.servis = servis;
		if(servis == null) {
			setTitle("Dodavanje delova");
		}else {
			setTitle("Izmena podataka - "+servis.getOpis());
		}
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initGUI();
		initActions();
		setResizable(false);
		pack();
	}
	private void initGUI() {
		MigLayout layout = new MigLayout("wrap 2","[][]","[][][][]20[]");
		setLayout(layout);
		
		for (Automobil auto : citanje.sviNeobrisaniAutomobili()) {
			cbAuto.addItem(String.valueOf(auto.getId()));
		}
		for (Serviser serviser : citanje.sviNeobrisaniServiseri()) {
			cbServiser.addItem(String.valueOf(serviser.getIme().concat(serviser.getPrezime())));
		}
		
		
		if(servis != null) {
			popuniPolja();
		}
		
		add(lblId);
		add(txtId);
		add(lblAuto);
		add(cbAuto);
		add(lblServiser);	
		add(cbServiser);
		add(lblOpis);	
		add(txtOpis);
		add(new JLabel());
		add(btnOk,"split 2");
		add(btnCancel);
		
	}
	private void initActions() {
		btnOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if(validacija()) {
						String id = txtId.getText().trim();
						String idAuto = cbAuto.getSelectedItem().toString();
						
						String serviserKo = cbServiser.getSelectedItem().toString();
						String serviserKo2 = citanje.pronadjiIdPoImenuiPServiser(serviserKo);
						Automobil automobil = citanje.pronadjiAutomobil(idAuto);
						Serviser serviser = citanje.pronadjiServisera(serviserKo2);
						String opis = txtOpis.getText().trim();					
						Date datum = new Date(2019, 12, 1);
						ArrayList<Deo>listaDelova = new ArrayList<Deo>();
						
						if(servis == null) {
							Servis novi = new Servis(id, automobil, serviser, datum, opis, listaDelova, false);
							citanje.dodajServis(novi);
						}else {
							servis.setId(id);
							servis.setAuto(automobil);
							servis.setServiser(serviser);
							servis.setDatum(datum);
							servis.setOpis(opis);;		
						}
						citanje.snimiServise();
						ServisForma.this.dispose();
						ServisForma.this.setVisible(false);
					}
				} catch (NumberFormatException e1) {
					
					e1.printStackTrace();
				}
				
			}
		});
	}
	private void popuniPolja() {
		txtId.setText(String.valueOf(servis.getId()));
		txtOpis.setText(servis.getOpis());	
		//cbAuto.setSelectedItem(this.auto.getMarka());
		//cbServiser.setSelectedItem(serviser.getKorisnickoIme());
		
		
	}
	public boolean validacija() {
		boolean ok = true;
		String poruka = "Molimo popravite greske u unosu:\n";
		if(txtId.getText().trim().equals("")) {
			poruka += "- Unesite id\n";
			ok = false;
		}else if (servis == null) {
			String id = txtId.getText().trim();
			Servis pronadjen = citanje.pronadjiServis(id);
			if(pronadjen != null) {
				poruka += "- Servis sa tim id-om vec postoji!\n";
				ok = false;
			}		
		}
	
		if(txtOpis.getText().trim().equals("")) {
			poruka += "- Unesite opis\n";
			ok = false;
	
		}
		
		
		if(ok == false) {
			JOptionPane.showMessageDialog(null, poruka, "Neispravni podaci", JOptionPane.WARNING_MESSAGE);
		}
		return ok;
	}
}
