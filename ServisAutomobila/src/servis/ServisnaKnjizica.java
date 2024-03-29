package servis;

import java.util.ArrayList;

public class ServisnaKnjizica {
	
	private String id;
	private Automobil automobil;
	private boolean obrisan;
	ArrayList<Servis>listaServisa;
	
	public ServisnaKnjizica(String id,Automobil automobil, ArrayList<Servis> listaServisa,boolean obrisan) {
		super();
		this.id = id;
		this.automobil = automobil;
		this.listaServisa = listaServisa;
		this.obrisan = obrisan;
	}
	public boolean isObrisan() {
		return obrisan;
	}

	public void setObrisan(boolean obrisan) {
		this.obrisan = obrisan;
	}

	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public Automobil getAutomobil() {
		return automobil;
	}

	public void setAutomobil(Automobil automobil) {
		this.automobil = automobil;
	}

	public ArrayList<Servis> getListaServisa() {
		return listaServisa;
	}

	public void setListaServisa(ArrayList<Servis> listaServisa) {
		this.listaServisa = listaServisa;
	}


	@Override
	public String toString() {
		return "ServisnaKnjizica [id=" + id + ", automobil=" + automobil + ", listaServisa=" + listaServisa + "]";
	}

}
