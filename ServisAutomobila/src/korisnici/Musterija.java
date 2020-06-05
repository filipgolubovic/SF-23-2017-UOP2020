package korisnici;

import uloge.Pol;

public class Musterija extends Korisnik {
	
	private int brojBodova;
	
	public Musterija() {
		this.brojBodova = 0;
	}

	public Musterija(int id,String ime, String prezime, String jmbg, Pol pol, String adresa, String brojTelefona,
			String korisnickoIme, String lozinka, int brojBodova,boolean obrisan) {
		super(id, ime, prezime, jmbg, pol, adresa, brojTelefona, korisnickoIme, lozinka, obrisan);
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
		return "Musterija [brojBodova=" + brojBodova + ", id=" + id + ", ime=" + ime + ", prezime=" + prezime
				+ ", jmbg=" + jmbg + ", pol=" + pol + ", adresa=" + adresa + ", brojTelefona=" + brojTelefona
				+ ", korisnickoIme=" + korisnickoIme + ", lozinka=" + lozinka + "]";
	}
}
