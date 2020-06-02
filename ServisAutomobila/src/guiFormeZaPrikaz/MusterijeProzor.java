package guiFormeZaPrikaz;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import korisnici.Musterija;
import slike.*;
import util.CitanjeFajlova;

public class MusterijeProzor extends JFrame {
	
	private JToolBar mainToolBar = new JToolBar();
	private JButton btnAdd = new JButton();
	private JButton btnEdit = new JButton();
	private JButton btnDelete = new JButton();
	
	private DefaultTableModel tableModel;
	private JTable musterijeTabela;
	private CitanjeFajlova citanje;
	
	public MusterijeProzor(CitanjeFajlova citanje) {
		this.citanje = citanje;
		setTitle("Musterije");
		setSize(1000, 500);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initGUI();
		initActions(); 
	}
	private void initGUI() {
		ImageIcon addIcon = new ImageIcon(getClass().getResource("/slike/add.gif"));
		btnAdd.setIcon(addIcon);
		ImageIcon editIcon = new ImageIcon(getClass().getResource("/slike/edit.gif"));
		btnEdit.setIcon(editIcon);
		ImageIcon deleteIcon = new ImageIcon(getClass().getResource("/slike/remove.gif"));
		btnDelete.setIcon(deleteIcon);
		
		mainToolBar.add(btnAdd);
		mainToolBar.add(btnEdit);
		mainToolBar.add(btnDelete);
		add(mainToolBar, BorderLayout.NORTH);
		
		String[] zaglavlja = new String[]{"Id","Ime","Prezime","Korisnicko ime","Lozinka","Pol","JMBG","Adresa","Telefon","Bodovi",};
		ArrayList<Musterija>musterije = CitanjeFajlova.ucitajMusterije();
		Object[][] sadrzaj = new Object[musterije.size()][zaglavlja.length];
		
		for(int i=0; i<musterije.size();i++) {
			Musterija musterija = musterije.get(i);
			sadrzaj[i][0] = musterija.getId();
			sadrzaj[i][1] = musterija.getIme();
			sadrzaj[i][2] = musterija.getPrezime();
			sadrzaj[i][3] = musterija.getKorisnickoIme();
			sadrzaj[i][4] = musterija.getLozinka();
			sadrzaj[i][5] = musterija.getPol();
			sadrzaj[i][6] = musterija.getJmbg();
			sadrzaj[i][7] = musterija.getAdresa();
			sadrzaj[i][8] = musterija.getBrojTelefona();
			sadrzaj[i][9] = musterija.getBrojBodova();
		}
		tableModel = new DefaultTableModel(sadrzaj,zaglavlja);
		musterijeTabela = new JTable(tableModel);
		
		musterijeTabela.setRowSelectionAllowed(true);
		musterijeTabela.setColumnSelectionAllowed(false);
		musterijeTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		musterijeTabela.setDefaultEditor(Object.class, null);
		musterijeTabela.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane scrollPane = new JScrollPane(musterijeTabela);
		add(scrollPane,BorderLayout.CENTER);
	}
	private void initActions() {
		
	}
}
