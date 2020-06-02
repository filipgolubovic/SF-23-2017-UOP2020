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

import korisnici.Administrator;
import util.CitanjeFajlova;
import slike.*;

public class AdminPikaz extends JFrame {
	private JToolBar mainToolBar = new JToolBar();
	private JButton btnAdd = new JButton();
	private JButton btnEdit = new JButton();
	private JButton btnDelete = new JButton();
	
	private DefaultTableModel tableModel;
	private JTable adminTabela;
	private CitanjeFajlova citanje;
	
	public AdminPikaz(CitanjeFajlova citanje) {
		this.citanje = citanje;
		setTitle("Administratori");
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
		
		String[] zaglavlja = new String[]{"Id","Ime","Prezime","Korisnicko ime","Lozinka","Pol","JMBG","Adresa","Telefon","Plata",};
		ArrayList<Administrator>administratori = CitanjeFajlova.ucitavanjeAdmina();
		Object[][] sadrzaj = new Object[administratori.size()][zaglavlja.length];
		
		for(int i=0; i<administratori.size();i++) {
			Administrator admin = administratori.get(i);
			sadrzaj[i][0] = admin.getId();
			sadrzaj[i][1] = admin.getIme();
			sadrzaj[i][2] = admin.getPrezime();
			sadrzaj[i][3] = admin.getKorisnickoIme();
			sadrzaj[i][4] = admin.getLozinka();
			sadrzaj[i][5] = admin.getPol();
			sadrzaj[i][6] = admin.getJmbg();
			sadrzaj[i][7] = admin.getAdresa();
			sadrzaj[i][8] = admin.getBrojTelefona();
			sadrzaj[i][9] = admin.getPlata();
		}
		tableModel = new DefaultTableModel(sadrzaj,zaglavlja);
		adminTabela = new JTable(tableModel);
		
		adminTabela.setRowSelectionAllowed(true);
		adminTabela.setColumnSelectionAllowed(false);
		adminTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		adminTabela.setDefaultEditor(Object.class, null);
		adminTabela.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane scrollPane = new JScrollPane(adminTabela);
		add(scrollPane,BorderLayout.CENTER);
	}
	private void initActions() {
		
	}
}
