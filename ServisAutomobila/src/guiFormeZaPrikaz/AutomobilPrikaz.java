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
import slike.*;

import servis.Automobil;
import util.CitanjeFajlova;

public class AutomobilPrikaz extends JFrame {
	private JToolBar mainToolBar = new JToolBar();
	private JButton btnAdd = new JButton();
	private JButton btnEdit = new JButton();
	private JButton btnDelete = new JButton();
	
	private DefaultTableModel tableModel;
	private JTable autoTabela;
	private CitanjeFajlova citanje;
	
	public AutomobilPrikaz(CitanjeFajlova citanje) {
		this.citanje = citanje;
		setTitle("Automobili");
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
		
		String[] zaglavlja = new String[]{"Id","Vlasnik","Marka","Model","Godiste","Snaga motora","Zapremina motora","Vrsta goriva"};
		ArrayList<Automobil>automobili = CitanjeFajlova.ucitajAutomobile();
		Object[][] sadrzaj = new Object[automobili.size()][zaglavlja.length];
		
		for(int i=0; i<automobili.size();i++) {
			Automobil auto = automobili.get(i);
			sadrzaj[i][0] = auto.getId();
			sadrzaj[i][1] = auto.getVlasnik().getIme()+" "+auto.getVlasnik().getPrezime();
			sadrzaj[i][2] = auto.getMarka();
			sadrzaj[i][3] = auto.getModel();
			sadrzaj[i][4] = auto.getGodiste();
			sadrzaj[i][5] = auto.getSnagaMotora();
			sadrzaj[i][6] = auto.getZapreminaMotora();
			sadrzaj[i][7] = auto.getVrstaGoriva();
			
		}
		tableModel = new DefaultTableModel(sadrzaj,zaglavlja);
		autoTabela = new JTable(tableModel);
		
		autoTabela.setRowSelectionAllowed(true);
		autoTabela.setColumnSelectionAllowed(false);
		autoTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		autoTabela.setDefaultEditor(Object.class, null);
		autoTabela.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane scrollPane = new JScrollPane(autoTabela);
		add(scrollPane,BorderLayout.CENTER);
	}
	private void initActions() {
		
	}
}
