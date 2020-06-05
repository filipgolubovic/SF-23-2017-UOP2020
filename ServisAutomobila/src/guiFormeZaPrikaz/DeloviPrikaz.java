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

import servis.Deo;
import slike.*;
import util.CitanjeFajlova;

public class DeloviPrikaz extends JFrame {
	private JToolBar mainToolBar = new JToolBar();
	private JButton btnAdd = new JButton();
	private JButton btnEdit = new JButton();
	private JButton btnDelete = new JButton();
	
	private DefaultTableModel tableModel;
	private JTable deloviTabela;
	private CitanjeFajlova citanje;

	public DeloviPrikaz(CitanjeFajlova citanje) {
		this.citanje = citanje;
		setTitle("Delovi");
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
		
		String[] zaglavlja = new String[]{"Id","Marka","Model","Naziv","Cena"};
		ArrayList<Deo>delovi = CitanjeFajlova.ucitajDelove();
		Object[][] sadrzaj = new Object[delovi.size()][zaglavlja.length];
		
		for(int i=0; i<delovi.size();i++) {
			Deo deo = delovi.get(i);
			sadrzaj[i][0] = deo.getId();
			sadrzaj[i][1] = deo.getMarka();
			sadrzaj[i][2] = deo.getModel();
			sadrzaj[i][3] = deo.getNaziv();
			sadrzaj[i][4] = deo.getCena();
		
		}
		tableModel = new DefaultTableModel(sadrzaj,zaglavlja);
		deloviTabela = new JTable(tableModel);
		
		deloviTabela.setRowSelectionAllowed(true);
		deloviTabela.setColumnSelectionAllowed(false);
		deloviTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		deloviTabela.setDefaultEditor(Object.class, null);
		deloviTabela.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane scrollPane = new JScrollPane(deloviTabela);
		add(scrollPane,BorderLayout.CENTER);
	}
	private void initActions() {
		
	}
}
