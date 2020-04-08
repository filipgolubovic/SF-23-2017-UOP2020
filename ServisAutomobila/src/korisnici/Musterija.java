package korisnici;

import uloge.Pol;

public class Musterija extends Korisnik {
	
	private int brojBodova;
	
	public Musterija() {
		this.brojBodova = 0;
	}

	public Musterija(String ime, String prezime, String jmbg, Pol pol, String adresa, String brojTelefona,
			String korisnickoIme, String lozinka, int brojBodova) {
		super(ime, prezime, jmbg, pol, adresa, brojTelefona, korisnickoIme, lozinka);
		this.brojBodova = brojBodova;
	}

	public int getBrojBodova() {
		return brojBodova;
	}

	public void setBrojBodova(int brojBodova) {
		this.brojBodova = brojBodova;
	}

	@Override
	public String toString() {
		return "Musterija [brojBodova=" + brojBodova + ", ime=" + ime + ", prezime=" + prezime + ", jmbg=" + jmbg
				+ ", pol=" + pol + ", adresa=" + adresa + ", brojTelefona=" + brojTelefona + ", korisnickoIme="
				+ korisnickoIme + ", lozinka=" + lozinka + "]";
	}
	

}
