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
import servis.Automobil;
import uloge.Marka;
import uloge.Model;
import uloge.Pol;
import uloge.VrstaGoriva;
import util.CitanjeFajlova;

public class AutomobilForma extends JFrame {
	private JLabel lblVlasnik = new JLabel("Vlasnik");
	private JTextField txtVlasnik = new JTextField(20);
	private JLabel lblMarka = new JLabel("Marka");
	private JComboBox<Marka>cbMarka = new JComboBox<Marka>(Marka.values());
	private JLabel lblModel = new JLabel("Model");
	private JComboBox<Model>cbModel = new JComboBox<Model>(Model.values());
	private JLabel lblGorivo = new JLabel("Gorivo");
	private JComboBox<VrstaGoriva>cbGorivo = new JComboBox<VrstaGoriva>(VrstaGoriva.values());
	
	private JLabel lblGodiste = new JLabel("Godiste");
	private JTextField txtGodiste = new JTextField(20);

	private JLabel lblSnaga= new JLabel("Snaga");
	private JTextField txtSnaga = new JTextField(20);
	private JLabel lblZapremina = new JLabel("Zapremina");
	private JTextField txtZapremina= new JTextField(20);
	

	private JButton btnOk = new JButton("OK");
	private JButton btnCancel = new JButton("Cancel");
	
	private CitanjeFajlova citanje;
	private Automobil auto;
	private Musterija vlasnik;
	
	public AutomobilForma(CitanjeFajlova citanje,Automobil auto) {
		this.citanje = citanje;
		this.auto = auto;
		if(auto == null) {
			setTitle("Dodavanje automobila");
		}else {
			setTitle("Izmena podataka - "+auto.getMarka()+" "+auto.getModel());
		}
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initGUI();
		initActions();
		setResizable(false);
		pack();
	}
	private void initGUI() {
		MigLayout layout = new MigLayout("wrap 2","[][]","[][][][][][]20[]");
		setLayout(layout);
		
		
		
		
		if(auto != null) {
			popuniPolja();
		}
		
		add(lblVlasnik);
		add(txtVlasnik);
		
		add(lblSnaga);
		add(txtSnaga);
		add(lblGodiste);
		add(txtGodiste);
		add(lblZapremina);	
		add(txtZapremina);
		add(lblGorivo);
		add(cbGorivo);
		add(lblMarka);
		add(cbMarka);
		add(lblModel);
		add(cbModel);
	
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
						int id = Integer.parseInt(txtVlasnik.getText().trim());
						Musterija vlasnik = citanje.pronadjiMusteriju(id);
						Marka marka = (Marka)cbMarka.getSelectedItem();
						Model model = (Model)cbModel.getSelectedItem();
						VrstaGoriva gorivo = (VrstaGoriva)cbGorivo.getSelectedItem();
						
						String snaga = txtSnaga.getText().trim();
						String zapremina = txtZapremina.getText().trim();
						int godiste = Integer.parseInt(txtGodiste.getText().trim());
						
						
						if(auto == null) {
							Automobil novi = new Automobil(id, vlasnik, marka, model, godiste, snaga, zapremina, gorivo, false);
							citanje.dodajAutomobil(novi);
						}else {
							auto.setVlasnik(vlasnik);
							auto.setMarka(marka);
							auto.setModel(model);
							auto.setGodiste(godiste);
							auto.setSnagaMotora(snaga);
							auto.setZapreminaMotora(zapremina);
							auto.setVrstaGoriva(gorivo);
							
							
						}
						citanje.snimiAutobobile();
						AutomobilForma.this.dispose();
						AutomobilForma.this.setVisible(false);
					}
				} catch (NumberFormatException e1) {
					
					e1.printStackTrace();
				}
				
			}
		});
	}
	private void popuniPolja() {
	
		Musterija musterija = citanje.pronadjiVlasnika(auto);
		txtVlasnik.setText(String.valueOf(musterija.getId()));
		cbMarka.setSelectedItem(auto.getMarka());
		cbModel.setSelectedItem(auto.getModel());
		cbGorivo.setSelectedItem(auto.getVrstaGoriva());
		txtSnaga.setText(auto.getSnagaMotora());
		txtZapremina.setText(auto.getZapreminaMotora());
		txtGodiste.setText(String.valueOf(auto.getGodiste())); 
	}
	public boolean validacija() {
		boolean ok = true;
		String poruka = "Molimo popravite greske u unosu:\n";
		
	
		if(txtGodiste.getText().trim().equals("")) {
			poruka += "- Unesite godiste\n";
			ok = false;
	
		}
		if(txtSnaga.getText().trim().equals("")) {
			poruka += "- Unesite snagu\n";
			ok = false;
		}
		if(txtZapremina.getText().trim().equals("")) {
			poruka += "- Unesite zapreminu\n";
			ok = false;
		}
		
		if(ok == false) {
			JOptionPane.showMessageDialog(null, poruka, "Neispravni podaci", JOptionPane.WARNING_MESSAGE);
		}
		return ok;
		
		
		
	
	}
}
