package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import korisnici.Administrator;
import korisnici.Musterija;
import korisnici.Serviser;
import servis.Automobil;
import uloge.Marka;
import uloge.Model;
import uloge.Pol;
import uloge.SpecijalizacijaServisera;
import uloge.VrstaGoriva;

public class CitanjeFajlova {
	public static ArrayList<Administrator>ucitavanjeAdmina(){
		ArrayList<Administrator>administratori = new ArrayList<Administrator>();
		try {
			File file = new File("src/fajlovi/administratori.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while((line = reader.readLine()) !=null) {
				String[]lineSplit = line.split("\\|");
				
				int id = Integer.parseInt(lineSplit[0]);
				String ime = lineSplit[1];
				String prezime = lineSplit[2];
				String korIme = lineSplit[3];
				String lozinka = lineSplit[4];
				int indeksPola = Integer.parseInt(lineSplit[5]);
				Pol pol = Pol.values()[indeksPola];
				String jmbg = lineSplit[6];
				String adresa = lineSplit[7];
				String broj = lineSplit[8];
				Double plata = Double.parseDouble(lineSplit[9]);
				Administrator admin = new Administrator(id, ime, prezime, jmbg, pol, adresa, broj, korIme, lozinka, plata);
				administratori.add(admin);
			
			}
			reader.close();
			
		} catch (IOException e) {
			System.out.println("Greska prilikom citanja iz fajla!");
		}
		return administratori;
	}
	public static ArrayList<Automobil>ucitajAutomobile(){
		ArrayList<Automobil>automobili = new ArrayList<Automobil>();
		try {
			File file = new File("src/fajlovi/automobili.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while((line = reader.readLine()) !=null) {
				String[]lineSplit = line.split("\\|");
				
				int id = Integer.parseInt(lineSplit[0]);
				int indexVlasnika = Integer.parseInt(lineSplit[1]);
				
				
				Musterija vlasnik = new Musterija(); 
				indexVlasnika = vlasnik.getId();
				
				int indexModela = Integer.parseInt(lineSplit[2]);
				Model model = Model.values()[indexModela];
				int indexMarke = Integer.parseInt(lineSplit[3]);
				Marka marka = Marka.values()[indexModela];
				int godiste = Integer.parseInt(lineSplit[4]);
				String konjaza = lineSplit[5];
				String kubikaza = lineSplit[6];
				int indexGoriva = Integer.parseInt(lineSplit[7]);
				VrstaGoriva gorivo = VrstaGoriva.values()[indexGoriva];
				
				Automobil auto = new Automobil(id, vlasnik, marka, model, godiste, konjaza, kubikaza, gorivo);
				automobili.add(auto);
			}
			reader.close();
		}
			
		 catch (IOException e) {
			System.out.println("Greska prilikom citanja iz falja!");
		}
		return automobili;
	}
	public static ArrayList<Musterija>ucitajMusterije(){
		ArrayList<Musterija>musterije = new ArrayList<Musterija>();
		try {
			File file = new File("src/fajlovi/musterije.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while((line = reader.readLine()) !=null) {
				String[]lineSplit = line.split("\\|");
				
				int id = Integer.parseInt(lineSplit[0]);
				String ime = lineSplit[1];
				String prezime = lineSplit[2];
				String korIme = lineSplit[3];
				String lozinka = lineSplit[4];
				int indexPola = Integer.parseInt(lineSplit[5]);
				Pol pol = Pol.values()[indexPola];
				String jmbg = lineSplit[6];
				String adresa = lineSplit[7];
				String brojTelefona = lineSplit[8];
				int brojBodova = Integer.parseInt(lineSplit[9]);
				
				Musterija musterija = new Musterija(id, ime, prezime, jmbg, pol, adresa, brojTelefona, korIme, lozinka, brojBodova);
				musterije.add(musterija);
			}
			reader.close();
		}
		 catch (IOException e) {
			System.out.println("Greska prilikom citanja iz falja!");
		}
		return musterije;
	}
	public static ArrayList<Serviser>ucitajServisere(){
		ArrayList<Serviser>serviseri = new ArrayList<Serviser>();
		try {
			File file = new File("src/fajlovi/serviseri.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while((line = reader.readLine()) !=null) {
				String[]lineSplit = line.split("\\|");
				
				int id = Integer.parseInt(lineSplit[0]);
				String ime = lineSplit[1];
				String prezime = lineSplit[2];
				String korIme = lineSplit[3];
				String lozinka = lineSplit[4];
				int indexPola = Integer.parseInt(lineSplit[5]);
				Pol pol = Pol.values()[indexPola];
				String jmbg = lineSplit[6];
				String adresa = lineSplit[7];
				String brojTelefona = lineSplit[8];
				Double plata = Double.parseDouble(lineSplit[9]);
				int indexSpecijalizacije = Integer.parseInt(lineSplit[10]);
				SpecijalizacijaServisera specijalizacija = SpecijalizacijaServisera.values()[indexSpecijalizacije];
				
				Serviser serviser = new Serviser(id, ime, prezime, jmbg, pol, adresa, brojTelefona, korIme, lozinka, plata, specijalizacija);
				serviseri.add(serviser);
				
			}
			reader.close();
		}
		 catch (IOException e) {
			System.out.println("Greska prilikom citanja iz falja!");
		}
		return serviseri;
	}
	
}