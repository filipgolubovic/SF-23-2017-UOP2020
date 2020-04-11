package servis;

import java.util.ArrayList;

public class ServisnaKnjizica {
	
	private Automobil automobil;
	ArrayList<Servis>listaServisa;
	
	public ServisnaKnjizica(Automobil automobil, ArrayList<Servis> listaServisa) {
		super();
		this.automobil = automobil;
		this.listaServisa = listaServisa;
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
		return "ServisnaKnjizica [automobil=" + automobil + ", listaServisa=" + listaServisa + "]";
	}
}
