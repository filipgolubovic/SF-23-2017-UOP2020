package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import korisnici.Administrator;
import korisnici.Musterija;
import korisnici.Serviser;
import servis.Automobil;
import servis.Deo;
import servis.Servis;
import servis.ServisnaKnjizica;

public class PisanjeFajlova {
	public void snimiAutobobile() {
		try {
			ArrayList<Automobil>automobili = CitanjeFajlova.ucitajAutomobile();
			File file = new File("src/fajlovi/automobili.txt");
			String content = "";
			for (Automobil auto : automobili) {
				content += auto.getId() + "|" + auto.getVlasnik() + "|"
						+ auto.getMarka() + "|" + auto.getModel()+ "|"
						+ auto.getGodiste() + "|" + auto.getSnagaMotora() + "|" + auto.getZapreminaMotora() + "|" + auto.getVrstaGoriva() + "\n";
			}
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(content);
			writer.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja automobila.");
		}
	}
	public void snimiMusterije() {
		try {
			ArrayList<Musterija>musterije = CitanjeFajlova.ucitajMusterije();
			File file = new File("src/fajlovi/musterije.txt");
			String content = "";
			for (Musterija musterija : musterije) {
				content += musterija.getId() + "|" + musterija.getIme() + "|"
						+ musterija.getPrezime() + "|" + musterija.getKorisnickoIme()+ "|"
						+ musterija.getLozinka() + "|" + musterija.getPol() + "|" + musterija.getJmbg() + "|" + musterija.getAdresa() + "|" + musterija.getBrojTelefona()+ "|" + musterija.getBrojBodova()+ "\n";
			}
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(content);
			writer.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja musterija.");
		}
	}
	public void snimiAdmine() {
		try {
			ArrayList<Administrator>administratori = CitanjeFajlova.ucitavanjeAdmina();
			File file = new File("src/fajlovi/administratori.txt");
			String content = "";
			for (Administrator admin : administratori) {
				content += admin.getId() + "|" + admin.getIme() + "|"
						+ admin.getPrezime() + "|" + admin.getKorisnickoIme()+ "|"
						+ admin.getLozinka() + "|" + admin.getPol() + "|" + admin.getJmbg() + "|" + admin.getAdresa() + "|" + admin.getBrojTelefona()+ "|" + admin.getPlata()+ "\n";
			}
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(content);
			writer.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja admina.");
		}
	}
	public void snimiServisere() {
		try {
			ArrayList<Serviser>serviseri = CitanjeFajlova.ucitajServisere();
			File file = new File("src/fajlovi/serviseri.txt");
			String content = "";
			for (Serviser serviser : serviseri) {
				content += serviser.getId() + "|" + serviser.getIme() + "|"
						+ serviser.getPrezime() + "|" + serviser.getKorisnickoIme()+ "|"
						+ serviser.getLozinka() + "|" + serviser.getPol() + "|" + serviser.getJmbg() + "|" + serviser.getAdresa() + "|" + serviser.getBrojTelefona()+ "|" + serviser.getPlata()+"|" + serviser.getSpecijalizacija()+ "\n";
			}
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(content);
			writer.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja servisera.");
		}
	}
	public void snimiDelove() {
		try {
			ArrayList<Deo>delovi = CitanjeFajlova.ucitajDelove();
			File file = new File("src/fajlovi/delovi.txt");
			String content = "";
			for (Deo deo : delovi) {
				content += deo.getId() + "|" + deo.getMarka()+ "|"
						+ deo.getModel() + "|" + deo.getNaziv()+ "|"
						+ deo.getCena()+ "\n";
			}
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(content);
			writer.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja delova.");
		}
	}
	public void snimiServise() {
		try {
			ArrayList<Servis>servisi = CitanjeFajlova.ucitajServise();
			File file = new File("src/fajlovi/servis.txt");
			String content = "";
			for (Servis servis : servisi) {
				content += servis.getId() + "|" + servis.getAuto()+ "|"
						+ servis.getServiser() + "|" + servis.getDatum()+ "|"
						+ servis.getOpis()+"|" + servis.getListaDelova()+ "\n";
			}
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(content);
			writer.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja servisa.");
		}
	}
	public void snimiSKnjizice() {
		try {
			ArrayList<ServisnaKnjizica>sKnjizice = CitanjeFajlova.ucitajSKnjizice();
			File file = new File("src/fajlovi/servisnaKnjizica.txt");
			String content = "";
			for (ServisnaKnjizica sKnjizica : sKnjizice) {
				content += sKnjizica.getId() + "|" + sKnjizica.getAutomobil()+ "|"
						+ sKnjizica.getListaServisa() +
						"\n";
			}
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(content);
			writer.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja servisnih knjizica.");
		}
	}
	
	
}

