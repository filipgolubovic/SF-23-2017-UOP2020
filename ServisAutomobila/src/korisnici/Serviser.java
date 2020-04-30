package korisnici;

import uloge.Pol;
import uloge.SpecijalizacijaServisera;

public class Serviser extends Korisnik {
	
	private double plata;
	private SpecijalizacijaServisera specijalizacija;
	
	public Serviser() {
		this.plata = 0;
	}

	public Serviser(int id,String ime, String prezime, String jmbg, Pol pol, String adresa, String brojTelefona,
			String korisnickoIme, String lozinka, double plata, SpecijalizacijaServisera specijalizacija) {
		super(id,ime, prezime, jmbg, pol, adresa, brojTelefona, korisnickoIme, lozinka);
		this.plata = plata;
		this.specijalizacija = specijalizacija;
	}

	public double getPlata() {
		return plata;
	}

	public void setPlata(double plata) {
		this.plata = plata;
	}

	public SpecijalizacijaServisera getSpecijalizacija() {
		return specijalizacija;
	}

	public void setSpecijalizacija(SpecijalizacijaServisera specijalizacija) {
		this.specijalizacija = specijalizacija;
	}

	@Override
	public String toString() {
		return "Serviser [plata=" + plata + ", specijalizacija=" + specijalizacija + ", id=" + id + ", ime=" + ime
				+ ", prezime=" + prezime + ", jmbg=" + jmbg + ", pol=" + pol + ", adresa=" + adresa + ", brojTelefona="
				+ brojTelefona + ", korisnickoIme=" + korisnickoIme + ", lozinka=" + lozinka + "]";
	}

}
