package korisnici;

import uloge.Pol;

public class Administrator extends Korisnik {
	
	private double plata;
	
	public Administrator() {
		this.plata = 0;
	}

	public Administrator(int id,String ime, String prezime, String jmbg, Pol pol, String adresa, String brojTelefona,
			String korisnickoIme, String lozinka, double plata,boolean obrisan) {
		super(id,ime, prezime, jmbg, pol, adresa, brojTelefona, korisnickoIme, lozinka,obrisan);
		this.plata = plata;
	}

	public double getPlata() {
		return plata;
	}

	public void setPlata(double plata) {
		this.plata = plata;
	}

	@Override
	public String toString() {
		return "Administrator [plata=" + plata + ", id=" + id + ", ime=" + ime + ", prezime=" + prezime + ", jmbg="
				+ jmbg + ", pol=" + pol + ", adresa=" + adresa + ", brojTelefona=" + brojTelefona + ", korisnickoIme="
				+ korisnickoIme + ", lozinka=" + lozinka + "]";
	}

}
