package servis;

import korisnici.Musterija;
import uloge.Marka;
import uloge.Model;
import uloge.VrstaGoriva;

public class Automobil {
	
	private int id;
	private Musterija vlasnik;
	private Marka marka;
	private Model model;
	private int godiste;
	private String snagaMotora;
	private String zapreminaMotora;
	private VrstaGoriva vrstaGoriva;
	private boolean obrisan;
	
	public Automobil() {
		this.id = 0;
		this.vlasnik = new Musterija();
		this.marka = Marka.AUDI;
		this.model = Model.R8;
		this.godiste = 0;
		this.snagaMotora = "";
		this.zapreminaMotora = "";
		this.vrstaGoriva = VrstaGoriva.Benzin;
		this.obrisan = false;
	}
	
	public Automobil(int id,Musterija vlasnik, Marka marka, Model model, int godiste, String snagaMotora,
			String zapreminaMotora, VrstaGoriva vrstaGoriva, boolean obrisan) {
		super();
		this.id = id;
		this.vlasnik = vlasnik;
		this.marka = marka;
		this.model = model;
		this.godiste = godiste;
		this.snagaMotora = snagaMotora;
		this.zapreminaMotora = zapreminaMotora;
		this.vrstaGoriva = vrstaGoriva;
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
		return "Automobil [id=" + id + ", vlasnik=" + vlasnik + ", marka=" + marka + ", model=" + model + ", godiste="
				+ godiste + ", snagaMotora=" + snagaMotora + ", zapreminaMotora=" + zapreminaMotora + ", vrstaGoriva="
				+ vrstaGoriva + "]";
	}

}
