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

import korisnici.Serviser;
import net.miginfocom.swing.MigLayout;
import servis.Automobil;
import servis.Deo;
import servis.Servis;
import servis.ServisnaKnjizica;
import util.CitanjeFajlova;

public class ServisnaKnjizicaForma extends JFrame {
	
	private JLabel lblId = new JLabel("ID");
	private JTextField txtId = new JTextField(20);
	private JLabel lblAuto= new JLabel("Auto");
	private JComboBox<String>cbAuto= new JComboBox<String>();
	private JLabel lblServis= new JLabel("Servis");
	private JComboBox<String>cbServis= new JComboBox<String>();
	
	private JButton btnOk = new JButton("OK");
	private JButton btnCancel = new JButton("Cancel");
	private CitanjeFajlova citanje;
	public ServisnaKnjizica sKnjizica;
	
	
	public ServisnaKnjizicaForma(CitanjeFajlova citanje,ServisnaKnjizica sKnjizica) {
		this.citanje = citanje;
		this.sKnjizica = sKnjizica;
		if(sKnjizica == null) {
			setTitle("Dodavanje Knjizica");
		}else {
			setTitle("Izmena podataka - "+sKnjizica.getAutomobil().getMarka());
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
			cbServis.addItem(String.valueOf(serviser.getId()));
		}
		
		
		if(sKnjizica != null) {
			popuniPolja();
		}
		
		add(lblId);
		add(txtId);
		add(lblAuto);
		add(cbAuto);
		add(lblServis);
		add(cbServis);
		
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
						Automobil automobil = citanje.pronadjiAutomobil(idAuto);
						String servisKo = cbServis.getSelectedItem().toString();
						Servis servis = citanje.pronadjiServis(servisKo);
						
						ArrayList<Servis>listaServisa = new ArrayList<Servis>();
						listaServisa.add(servis);
						if(sKnjizica == null) {
							ServisnaKnjizica novi = new ServisnaKnjizica(id, automobil, listaServisa, false);
							citanje.dodajSKnjizice(novi);;
						}else {
							sKnjizica.setId(id);
							sKnjizica.setAutomobil(automobil);
							sKnjizica.setListaServisa(listaServisa);
							
									
						}
						citanje.snimiSKnjizice();
						ServisnaKnjizicaForma.this.dispose();
						ServisnaKnjizicaForma.this.setVisible(false);
					}
				} catch (NumberFormatException e1) {
					
					e1.printStackTrace();
				}
				
			}
		});
	}
	private void popuniPolja() {
		txtId.setText(String.valueOf(sKnjizica.getId()));
		
	}
	public boolean validacija() {
		boolean ok = true;
		String poruka = "Molimo popravite greske u unosu:\n";
		if(txtId.getText().trim().equals("")) {
			poruka += "- Unesite id\n";
			ok = false;
		}else if (sKnjizica == null) {
			String id = txtId.getText().trim();
			ServisnaKnjizica pronadjen = citanje.pronanjiKnjizicu(id);
			if(pronadjen != null) {
				poruka += "- Knjizica sa tim id-om vec postoji!\n";
				ok = false;
			}		
		}
		if(ok == false) {
			JOptionPane.showMessageDialog(null, poruka, "Neispravni podaci", JOptionPane.WARNING_MESSAGE);
		}
		return ok;
	}
}
