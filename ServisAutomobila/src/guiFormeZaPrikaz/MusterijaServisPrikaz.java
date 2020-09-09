package guiFormeZaPrikaz;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import guiFromeZaDodavanjeiIzmene.MusterijaDodavanjeIzmene;
import guiFromeZaDodavanjeiIzmene.ServiserForma;
import korisnici.Musterija;
import korisnici.Serviser;
import servis.Automobil;
import servis.Servis;
import util.CitanjeFajlova;

public class MusterijaServisPrikaz extends JFrame {
	private JToolBar mainToolBar = new JToolBar();
	private JButton btnAdd = new JButton();
	private JButton btnEdit = new JButton();
	private JButton btnDelete = new JButton();
	
	private DefaultTableModel tableModel;
	private JTable servisTabela;
	private CitanjeFajlova citanje;
	private Musterija priMusterija;
	private Servis servis;
	
	
	public MusterijaServisPrikaz(CitanjeFajlova citanje,Musterija priMusterija) {
		this.citanje = citanje;
		this.priMusterija = priMusterija;
		setTitle("Servisi");
		setSize(1000, 500);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initGUI();
		initActions(); 
	}
	private void initGUI() {
		ImageIcon addIcon = new ImageIcon(getClass().getResource("/slike/add.gif"));
		btnAdd.setIcon(addIcon);
		
		mainToolBar.add(btnAdd);
		
		add(mainToolBar, BorderLayout.NORTH);
		
		String[] zaglavlja = new String[]{"Auto","Opis"};
		Automobil a1 = citanje.pronadjiVlasnikaAuta(priMusterija);
		System.out.println(a1);
		Servis s1 = citanje.pronadjiServisPoAutu(a1);
		ArrayList<Servis>pronadjeni = new ArrayList<Servis>();
		pronadjeni.add(s1);
		System.out.println(s1);
		Object[][] sadrzaj = new Object[pronadjeni.size()][zaglavlja.length];
		
		for(int i=0; i<pronadjeni.size();i++) {
			Servis s2 = pronadjeni.get(i);
			sadrzaj[i][0] = s2.getAuto().getMarka()+ " "+s2.getAuto().getModel();
			sadrzaj[i][1] = s2.getOpis();
	
		}
		tableModel = new DefaultTableModel(sadrzaj,zaglavlja);
		servisTabela = new JTable(tableModel);
		
		servisTabela.setRowSelectionAllowed(true);
		servisTabela.setColumnSelectionAllowed(false);
		servisTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		servisTabela.setDefaultEditor(Object.class, null);
		servisTabela.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane scrollPane = new JScrollPane(servisTabela);
		add(scrollPane,BorderLayout.CENTER);
	}
	private void initActions() {
		btnDelete.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					int red = servisTabela.getSelectedRow();
					if(red == -1) {
						JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
					}else {
						String opis  = tableModel.getValueAt(red, 1).toString();
						Servis servis = citanje.nadjiServis(opis);
					
						
						int izbor = JOptionPane.showConfirmDialog(null, "Da li ste sigurni da zelite da obrisete servis?", opis + " - Potvrda brisanja", JOptionPane.YES_NO_OPTION);
						if(izbor == JOptionPane.YES_OPTION) {
							servis.setObrisan(true);
							tableModel.removeRow(red);
							citanje.snimiServise();
						}
					}
					
				}
			});
			btnAdd.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					MusterijaDodavanjeIzmene sf = new MusterijaDodavanjeIzmene(citanje,servis,priMusterija );
					sf.setVisible(true);
					
				}
			});
		
		}
		
}
