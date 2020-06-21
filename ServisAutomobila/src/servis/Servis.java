package servis;

import java.sql.Date;
import java.util.ArrayList;

import korisnici.Serviser;

public class Servis {
	
	private int id;
	private Automobil auto;
	private Serviser serviser;
	private Date datum;
	private String opis;
	private ArrayList<Deo>listaDelova;
	private boolean obrisan;
	
	public Servis(int id,Automobil auto, Serviser serviser, Date datum, String opis, ArrayList<Deo> listaDelova,boolean obrisan) {
		super();
		this.id = id;
		this.auto = auto;
		this.serviser = serviser;
		this.datum = datum;
		this.opis = opis;
		this.listaDelova = listaDelova;
		this.obrisan = obrisan;
		
	}
	public boolean isObrisan() {
		return obrisan;
	}

	public void setObrisan(boolean obrisan) {
		this.obrisan = obrisan;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Automobil getAuto() {
		return auto;
	}

	public void setAuto(Automobil auto) {
		this.auto = auto;
	}

	public Serviser getServiser() {
		return serviser;
	}

	public void setServiser(Serviser serviser) {
		this.serviser = serviser;
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public ArrayList<Deo> getListaDelova() {
		return listaDelova;
	}

	public void setListaDelova(ArrayList<Deo> listaDelova) {
		this.listaDelova = listaDelova;
	}


	@Override
	public String toString() {
		return "Servis [id=" + id + ", auto=" + auto + ", serviser=" + serviser + ", datum=" + datum + ", opis=" + opis
				+ ", listaDelova=" + listaDelova + "]";
	}
}
