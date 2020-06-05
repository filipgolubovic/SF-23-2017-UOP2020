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
import servis.Servis;
import util.CitanjeFajlova;
import slike.*;

public class ServisiPrikaz extends JFrame {

	private JToolBar mainToolBar = new JToolBar();
	private JButton btnAdd = new JButton();
	private JButton btnEdit = new JButton();
	private JButton btnDelete = new JButton();
	
	private DefaultTableModel tableModel;
	private JTable servisiTabela;
	private CitanjeFajlova citanje;
	
	public ServisiPrikaz(CitanjeFajlova citanje) {
		this.citanje = citanje;
		setTitle("Servisi");
		setSize(500, 500);
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
		
		String[] zaglavlja = new String[]{"Id","Marka","Model","Serviser","Datum","Opis","Delovi"};
		ArrayList<Servis>servisi = CitanjeFajlova.ucitajServise();
		Object[][] sadrzaj = new Object[servisi.size()][zaglavlja.length];
		
		for(int i=0; i<servisi.size();i++) {
			Servis servis = servisi.get(i);
			sadrzaj[i][0] = servis.getId();
			sadrzaj[i][1] = servis.getAuto().getMarka();
			sadrzaj[i][2] = servis.getAuto().getModel();
			sadrzaj[i][3] = servis.getServiser().getIme()+" "+servis.getServiser().getPrezime();
			sadrzaj[i][4] = servis.getDatum();
			sadrzaj[i][5] = servis.getOpis();
			sadrzaj[i][6] = servis.getListaDelova();
	
		}
		tableModel = new DefaultTableModel(sadrzaj,zaglavlja);
		servisiTabela = new JTable(tableModel);
		
		servisiTabela.setRowSelectionAllowed(true);
		servisiTabela.setColumnSelectionAllowed(false);
		servisiTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		servisiTabela.setDefaultEditor(Object.class, null);
		servisiTabela.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane scrollPane = new JScrollPane(servisiTabela);
		add(scrollPane,BorderLayout.CENTER);
	}
	private void initActions() {
		
	}
}
