package servis;

import uloge.Marka;
import uloge.Model;

public class Deo {
	
	private int id;
	private Marka marka;
	private Model model;
	private String naziv;
	private double cena;
	
	public Deo(int id,Marka marka, Model model, String naziv, double cena) {
		super();
		this.id = id;
		this.marka = marka;
		this.model = model;
		this.naziv = naziv;
		this.cena = cena;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Marka getMarka() {
		return marka;
	}
	public void setMarka(Marka marka) {
		this.marka = marka;
	}
	public Model getModel() {
		return model;
	}
	public void setModel(Model model) {
		this.model = model;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public double getCena() {
		return cena;
	}
	public void setCena(double cena) {
		this.cena = cena;
	}

	@Override
	public String toString() {
		return "Deo [id=" + id + ", marka=" + marka + ", model=" + model + ", naziv=" + naziv + ", cena=" + cena + "]";
	}
	
}
