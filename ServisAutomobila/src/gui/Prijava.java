package gui;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

public class Prijava extends JFrame {

	private JLabel lblKorIme = new JLabel("Korisnicko ime");
	private JTextField txtKorIme = new JTextField(20);
	private JLabel lblLozinka = new JLabel("Lozinka");
	private JPasswordField pfLozinka = new JPasswordField(20);
	private JButton btnPrijava = new JButton("Prijava");
	private JButton btnIzlaz = new JButton("Izlaz");
	
	public Prijava() {
		setTitle("Prijava korisnika");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		initGUI();
		pack();
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				Object[]opcije = {"Da","Ne","Nazad"};
				Prijava prijava = new Prijava();
				int izbor = JOptionPane.showOptionDialog(prijava, "Da li zelite da izadjete?", "Izlaz",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcije,opcije[0]);
				if(izbor==JOptionPane.YES_OPTION) {
					Prijava.this.setVisible(false);
					Prijava.this.dispose();
				}
			}
			
		});
	}
	
	public void initGUI() {
		MigLayout mig = new MigLayout("wrap 2","[][]","[][]20[]");
		setLayout(mig);
		
		add(lblKorIme);
		add(txtKorIme);
		add(lblLozinka);
		add(pfLozinka);
		add(new JLabel());
		add(btnPrijava,"split 2");
		add(btnIzlaz);
		
		
	}
	
}
