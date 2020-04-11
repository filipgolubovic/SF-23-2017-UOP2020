package servis;

import korisnici.Musterija;
import uloge.Marka;
import uloge.Model;
import uloge.VrstaGoriva;

public class Automobil {
	
	private Musterija vlasnik;
	private Marka marka;
	private Model model;
	private int godiste;
	private String snagaMotora;
	private String zapreminaMotora;
	private VrstaGoriva vrstaGoriva;
	
	public Automobil(Musterija vlasnik, Marka marka, Model model, int godiste, String snagaMotora,
			String zapreminaMotora, VrstaGoriva vrstaGoriva) {
		super();
		this.vlasnik = vlasnik;
		this.marka = marka;
		this.model = model;
		this.godiste = godiste;
		this.snagaMotora = snagaMotora;
		this.zapreminaMotora = zapreminaMotora;
		this.vrstaGoriva = vrstaGoriva;
	}

	public Musterija getVlasnik() {
		return vlasnik;
	}

	public void setVlasnik(Musterija vlasnik) {
		this.vlasnik = vlasnik;
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

	public int getGodiste() {
		return godiste;
	}

	public void setGodiste(int godiste) {
		this.godiste = godiste;
	}

	public String getSnagaMotora() {
		return snagaMotora;
	}

	public void setSnagaMotora(String snagaMotora) {
		this.snagaMotora = snagaMotora;
	}

	public String getZapreminaMotora() {
		return zapreminaMotora;
	}

	public void setZapreminaMotora(String zapreminaMotora) {
		this.zapreminaMotora = zapreminaMotora;
	}

	public VrstaGoriva getVrstaGoriva() {
		return vrstaGoriva;
	}

	public void setVrstaGoriva(VrstaGoriva vrstaGoriva) {
		this.vrstaGoriva = vrstaGoriva;
	}

	@Override
	public String toString() {
		return "Automobil [vlasnik=" + vlasnik + ", marka=" + marka + ", model=" + model + ", godiste=" + godiste
				+ ", snagaMotora=" + snagaMotora + ", zapreminaMotora=" + zapreminaMotora + ", vrstaGoriva="
				+ vrstaGoriva + "]";
	}
	
	

	
}
