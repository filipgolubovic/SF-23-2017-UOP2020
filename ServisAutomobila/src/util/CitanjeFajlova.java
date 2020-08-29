package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import korisnici.Administrator;
import korisnici.Musterija;
import korisnici.Serviser;
import servis.Automobil;
import servis.Deo;
import servis.Servis;
import servis.ServisnaKnjizica;
import uloge.Marka;
import uloge.Model;
import uloge.Pol;
import uloge.SpecijalizacijaServisera;
import uloge.VrstaGoriva;

public class CitanjeFajlova {
	
	private ArrayList<Musterija>musterije;
	private ArrayList<Automobil>automobili;
	private ArrayList<Administrator>administratori;
	private ArrayList<Serviser>serviseri;
	private ArrayList<Servis>servisi;
	private ArrayList<Deo>delovi;
	private ArrayList<ServisnaKnjizica>sKnjizice;
	
	public CitanjeFajlova() {
		this.musterije = new ArrayList<Musterija>();
		this.automobili = new ArrayList<Automobil>();
		this.administratori = new ArrayList<Administrator>();
		this.serviseri = new ArrayList<Serviser>();
		this.servisi = new ArrayList<Servis>();
		this.delovi = new ArrayList<Deo>();
		this.sKnjizice = new ArrayList<ServisnaKnjizica>();
	}
	
	
	public ArrayList<Administrator> ucitavanjeAdmina(){
		
		try {
			File file = new File("src/fajlovi/administratori.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while((line = reader.readLine()) !=null) {
				String[]lineSplit = line.split("\\|");
				
				String id = lineSplit[0];
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
				boolean obrisan = Boolean.parseBoolean(lineSplit[10]);
				Administrator admin = new Administrator(id, ime, prezime, jmbg, pol, adresa, broj, korIme, lozinka, plata,obrisan);
				administratori.add(admin);
			
			}
			reader.close();
			
		} catch (IOException e) {
			System.out.println("Greska prilikom citanja iz fajla!");
		}catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return administratori;
		
	}
	public ArrayList<Automobil>ucitajAutomobile(){
		
		try {
			
			File file = new File("src/fajlovi/automobili.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while((line = reader.readLine()) !=null) {
				String[]lineSplit = line.split("\\|");
				
				String id = lineSplit[0];
				String idVlasnika = lineSplit[1];
				Musterija vlasnik =(Musterija) pronadjiMusteriju(idVlasnika);

				int indexModela = Integer.parseInt(lineSplit[2]);
				Model model = Model.values()[indexModela];
				int indexMarke = Integer.parseInt(lineSplit[3]);
				Marka marka = Marka.values()[indexMarke];
				int godiste = Integer.parseInt(lineSplit[4]);
				String konjaza = lineSplit[5];
				String kubikaza = lineSplit[6];
				int indexGoriva = Integer.parseInt(lineSplit[7]);
				VrstaGoriva gorivo = VrstaGoriva.values()[indexGoriva];
				boolean obrisan = Boolean.parseBoolean(lineSplit[8]);
				
				Automobil auto = new Automobil(id, vlasnik, marka, model, godiste, konjaza, kubikaza, gorivo,obrisan);
				if(vlasnik != null) {
					auto.setVlasnik(vlasnik);
				}
				
				automobili.add(auto);
			}
			reader.close();
		}
			
		 catch (IOException e) {
			System.out.println("Greska prilikom citanja iz falja!");
		}catch(NumberFormatException n) {
			n.printStackTrace();
		}
		return automobili;
	}
	public ArrayList<Musterija>ucitajMusterije(){
		
		try {
			File file = new File("src/fajlovi/musterije.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while((line = reader.readLine()) !=null) {
				String[]lineSplit = line.split("\\|");
				
				String id = lineSplit[0];
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
				boolean obrisan = Boolean.parseBoolean(lineSplit[10]);
				
				Musterija musterija = new Musterija(id, ime, prezime, jmbg, pol, adresa, brojTelefona, korIme, lozinka, brojBodova, obrisan);
				musterije.add(musterija);
				
				
			}
			reader.close();
		}
		 catch (IOException e) {
			System.out.println("Greska prilikom citanja iz falja!");
		}catch (NumberFormatException e) {
			System.out.println("Neka greska");
		}
		return musterije;
	}
	public ArrayList<Serviser>ucitajServisere(){
		
		try {
			File file = new File("src/fajlovi/serviseri.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while((line = reader.readLine()) !=null) {
				String[]lineSplit = line.split("\\|");
				
				String id = lineSplit[0];
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
				boolean obrisan = Boolean.parseBoolean(lineSplit[11]);
				SpecijalizacijaServisera specijalizacija = SpecijalizacijaServisera.values()[indexSpecijalizacije];
				
				Serviser serviser = new Serviser(id, ime, prezime, jmbg, pol, adresa, brojTelefona, korIme, lozinka, plata, specijalizacija,obrisan);
				serviseri.add(serviser);
				
			}
			reader.close();
		}
		 catch (IOException e) {
			System.out.println("Greska prilikom citanja iz falja!");
		}catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return serviseri;
	}
	public  ArrayList<Deo>ucitajDelove(){
		
		try {
			File file = new File("src/fajlovi/delovi.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while((line = reader.readLine()) !=null) {
				String[]lineSplit = line.split("\\|");
				
				String id = lineSplit[0];
				int indexModela = Integer.parseInt(lineSplit[1]);
				Model model = Model.values()[indexModela];
				int indexMarke = Integer.parseInt(lineSplit[2]);
				Marka marka = Marka.values()[indexMarke];
				String naziv = lineSplit[3];
				Double cena = Double.parseDouble(lineSplit[4]);
				boolean obrisan = Boolean.parseBoolean(lineSplit[5]);
				
				Deo deo = new Deo(id, marka, model, naziv, cena,obrisan);
				delovi.add(deo);
				
			}
			reader.close();
		}
		 catch (IOException e) {
			System.out.println("Greska prilikom citanja iz falja!");
		}catch (NumberFormatException n) {
			n.printStackTrace();
		}
		return delovi;
	}
	public ArrayList<ServisnaKnjizica>ucitajSKnjizice(){
		
		try {
			File file = new File("src/fajlovi/servisnaKnjizica.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while((line = reader.readLine()) !=null) {
				String[]lineSplit = line.split("\\|");
				
				String id = lineSplit[0];
				String indexAuta = lineSplit[1];
				Automobil auto = (Automobil)pronadjiAutomobil(indexAuta);
				ArrayList<Servis>servisi = new ArrayList<Servis>();
				boolean obrisan = Boolean.parseBoolean(lineSplit[2]);
				ServisnaKnjizica knjizica = new ServisnaKnjizica(id, auto, servisi,obrisan);
				if(auto!=null) {
					knjizica.setAutomobil(auto);
				}
				sKnjizice.add(knjizica);
				
				
				
			}
			reader.close();
		}
		 catch (IOException e) {
			System.out.println("Greska prilikom citanja iz falja!");
		}
		return sKnjizice;
		
	}
	public ArrayList<Servis>ucitajServise(){
		
		try {
			File file = new File("src/fajlovi/servis.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while((line = reader.readLine()) !=null) {
				String[]lineSplit = line.split("\\|");
				
				String id = lineSplit[0];
				String indexAuta = lineSplit[1];
				Automobil auto =(Automobil) pronadjiAutomobil(indexAuta);
				String indexServisera = lineSplit[2];
				Serviser serviser = (Serviser)pronadjiServisera(indexServisera);
				String opis = lineSplit[4];
				Date datum = new Date(2020, 11, 12);
				ArrayList<Deo>delovi = new ArrayList<Deo>();
				boolean obrisan = Boolean.parseBoolean(lineSplit[5]);
				Servis servis = new Servis(id, auto, serviser, datum, opis, delovi,obrisan);
				if(auto==null) {
					servis.setAuto(auto);
				}
				if(serviser!=null) {
					servis.setServiser(serviser);
				}
				servisi.add(servis);
			}
			reader.close();
		}
		 catch (IOException e) {
			System.out.println("Greska prilikom citanja iz falja!");
		}catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return servisi;
	}
	public Administrator pronadjiAdmina(String id) {	
		for (Administrator admin : this.sviNeobrisaniAdmini()) {
			if(admin.getId().equals(id)) {
				return admin;
			}
		}return null;
	}


	
	public Musterija pronadjiMusteriju(String id) {
		for (Musterija musterija : this.sviNeobrisaneMusterije()) {
			if(musterija.getId().equals(id)) {
				return musterija;
			}
		}return null;
	}
	public Automobil pronadjiAutomobil(String id) {
		for (Automobil automobil : this.sviNeobrisaniAutomobili()) {
			if(automobil.getId().equals(id)) {
				return automobil;
			}
		}
		return null;
	
	}
	
	public Serviser pronadjiServisera(String id) {	
		for (Serviser servis : serviseri) {
			if(servis.getId().equals(id)) {
				return servis;
			}
		}return null;
	}
	public Deo pronadjiDeo(String id) {
		for (Deo deo : delovi) {
			if(deo.getId().equals(id)) {
				return deo;
			}
		}return null;
	}
	public Servis pronadjiServis(String id) {
		for (Servis servis : servisi) {
			if(servis.getId().equals(id)) {
				return servis;
			}
		}return null;
	}
	
	
	public Musterija loginM(String korIme, String lozinka) {
		
		for (Musterija musterija : musterije) {
			if(musterija.getKorisnickoIme().equalsIgnoreCase(korIme) && musterija.getLozinka().equalsIgnoreCase(lozinka)) {
				return musterija;
			}
		}
		return null;
	}
	public Administrator loginA(String korIme, String lozinka) {
		;
		for (Administrator admin : administratori) {
			if(admin.getKorisnickoIme().equalsIgnoreCase(korIme) && admin.getLozinka().equalsIgnoreCase(lozinka)) {
				return admin;
			}
		}
		return null;
	}
	public Serviser loginS(String korIme, String lozinka) {
		;
		for (Serviser serviser : serviseri) {
			if(serviser.getKorisnickoIme().equalsIgnoreCase(korIme) && serviser.getLozinka().equalsIgnoreCase(lozinka)) {
				return serviser;
			}
		}
		return null;
	}
	public Musterija nadjiMusteriju(String korisnickoIme) {	
		for (Musterija musterija : musterije) {
			if (musterija.getKorisnickoIme().equals(korisnickoIme)) {
				return musterija;
			}
		}
		return null;
	}
	public Administrator nadjiAdmina(String korisnickoIme) {	
		for (Administrator admin : administratori) {
			if (admin.getKorisnickoIme().equals(korisnickoIme)) {
				return admin;
			}
		}
		return null;
	}
	public Serviser nadjiServisera(String korisnickoIme) {	
		for (Serviser serviser : serviseri) {
			if (serviser.getKorisnickoIme().equals(korisnickoIme)) {
				return serviser;
			}
		}
		return null;
	}
	public Automobil nadjiAuto(String snaga) {	
		for (Automobil auto : automobili) {
			if (auto.getSnagaMotora().equals(snaga)) {
				return auto;
			}
		}
		return null;
	}
	public Deo nadjiDeo(String naziv) {	
		for (Deo deo : delovi) {
			if (deo.getNaziv().equals(naziv)) {
				return deo;
			}
		}
		return null;
	}
	public Servis nadjiServis(String opis) {	
		for (Servis servis : servisi) {
			if (servis.getOpis().equals(opis)) {
				return servis;
			}
		}
		return null;
	}

	public void snimiAutobobile() {
		try {
			
			File file = new File("src/fajlovi/automobili.txt");
			String content = "";
			for (Automobil auto : automobili) {
						content += auto.getId() + "|" + auto.getVlasnik().getId() + "|" + auto.getMarka().ordinal()
								+ "|" + auto.getModel().ordinal() + "|" + auto.getGodiste() + "|"
								+ auto.getSnagaMotora() + "|" + auto.getZapreminaMotora() + "|"
								+ auto.getVrstaGoriva().ordinal() + "|" + auto.isObrisan() + "\n";
			}
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(content);
			writer.close();
		
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja automobila.");
		}catch (NullPointerException e) {
			e.printStackTrace();
		}
	}

	public void snimiMusterije() {
		try {
			
			File file = new File("src/fajlovi/musterije.txt");
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			String content = "";
			for (Musterija musterija : musterije) {
				content += musterija.getId() + "|" + musterija.getIme() + "|"
						+ musterija.getPrezime() + "|" + musterija.getKorisnickoIme()+ "|"
						+ musterija.getLozinka() + "|" + musterija.getPol().ordinal() + "|" + musterija.getJmbg() + 
						"|" + musterija.getAdresa() + "|" + musterija.getBrojTelefona()+ "|" + musterija.getBrojBodova()+"|" + musterija.isObrisan()+ "\n";
			}
			
			writer.write(content);
			
			writer.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja musterija.");
			e.printStackTrace();
		}
	}
	public void snimiAdmine() {
		try {
		
			File file = new File("src/fajlovi/administratori.txt");
			String content = "";
			for (Administrator admin : administratori) {
				content += admin.getId() + "|" + admin.getIme() + "|"
						+ admin.getPrezime() + "|" + admin.getKorisnickoIme()+ "|"
						+ admin.getLozinka() + "|" + admin.getPol().ordinal() + "|" + admin.getJmbg() + "|" + admin.getAdresa() + "|" + admin.getBrojTelefona()+ "|" + admin.getPlata()+"|"+admin.isObrisan()+ "\n";
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
			
			File file = new File("src/fajlovi/serviseri.txt");
			String content = "";
			for (Serviser serviser : serviseri) {
				content += serviser.getId() + "|" + serviser.getIme() + "|"
						+ serviser.getPrezime() + "|" + serviser.getKorisnickoIme()+ "|"
						+ serviser.getLozinka() + "|" + serviser.getPol().ordinal() + "|" + serviser.getJmbg() + "|" + serviser.getAdresa() + "|" + serviser.getBrojTelefona()+ "|" + serviser.getPlata()+"|" + serviser.getSpecijalizacija().ordinal()+"|"+ serviser.isObrisan()+"\n";
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
	
			File file = new File("src/fajlovi/delovi.txt");
			String content = "";
			for (Deo deo : delovi) {
				content += deo.getId() + "|" + deo.getMarka().ordinal()+ "|"
						+ deo.getModel().ordinal() + "|" + deo.getNaziv()+ "|"
						+ deo.getCena()+"|"+ deo.isObrisan()+ "\n";
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
			
			File file = new File("src/fajlovi/servis.txt");
			String content = "";
			for (Servis servis : servisi) {
				content += servis.getId() + "|" + servis.getAuto().getId()+ "|"
						+ servis.getServiser().getId() + "|" + servis.getDatum()+ "|"
						+ servis.getOpis()+"|" + servis.getListaDelova()+"|"+ servis.isObrisan() +  "\n";
			}
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(content);
			writer.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja servisa.");
		}catch (NullPointerException e) {
			e.printStackTrace();
		}
	}
	public void snimiSKnjizice() {
		try {
			
			File file = new File("src/fajlovi/servisnaKnjizica.txt");
			String content = "";
			for (ServisnaKnjizica sKnjizica : sKnjizice) {
				content += sKnjizica.getId() + "|" + sKnjizica.getAutomobil()+ "|"
						+ sKnjizica.getListaServisa() + "|"+sKnjizica.isObrisan()+
						"\n";
			}
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(content);
			writer.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja servisnih knjizica.");
		}
	}
	
	public void dodajMusteriju(Musterija musterija) {	
		this.musterije.add(musterija);
	}
	public void dodajAdmina(Administrator admin) {	
		this.administratori.add(admin);
	}
	public void dodajServisera(Serviser serviser) {	
		this.serviseri.add(serviser);
	}
	public void dodajAutomobil(Automobil auto) {	
		this.automobili.add(auto);
	}
	public void dodajDeo(Deo deo) {	
		this.delovi.add(deo);
	}
	public void dodajServis(Servis servis) {	
		this.servisi.add(servis);
	}
	public void dodajSKnjizice(ServisnaKnjizica sknjizica) {	
		this.sKnjizice.add(sknjizica);
	}
	public ArrayList<Musterija> sviNeobrisaneMusterije() {
		ArrayList<Musterija> neobrisani = new ArrayList<Musterija>();
		for (Musterija musterija : musterije) {
			if(!musterija.isObrisan()) {
				neobrisani.add(musterija);
			}
		}
		return neobrisani;

	
	}
	public ArrayList<Administrator> sviNeobrisaniAdmini() {
		ArrayList<Administrator> neobrisani = new ArrayList<Administrator>();
		for (Administrator admin : administratori) {
			if(!admin.isObrisan()) {
				neobrisani.add(admin);
			}
		}
		return neobrisani;

	
	}
	public ArrayList<Serviser> sviNeobrisaniServiseri() {
		ArrayList<Serviser> neobrisani = new ArrayList<Serviser>();
		for (Serviser serviser : serviseri) {
			if(!serviser.isObrisan()) {
				neobrisani.add(serviser);
			}
		}
		return neobrisani;

	
	}
	public ArrayList<Automobil> sviNeobrisaniAutomobili() {
		ArrayList<Automobil> neobrisani = new ArrayList<Automobil>();
		for (Automobil auto : automobili) {
			if(!auto.isObrisan()) {
				neobrisani.add(auto);
			}
		}
		return neobrisani;

	
	}
	public ArrayList<Deo> sviNeobrisaniDelovi() {
		ArrayList<Deo> neobrisani = new ArrayList<Deo>();
		for (Deo deo : delovi) {
			if(!deo.isObrisan()) {
				neobrisani.add(deo);
			}
		}
		return neobrisani;
	}
	public ArrayList<Servis> sviNeobrisaniServisi() {
		ArrayList<Servis> neobrisani = new ArrayList<Servis>();
		for (Servis servis : servisi) {
			if(!servis.isObrisan()) {
				neobrisani.add(servis);
			}
		}
		return neobrisani;
	}
	public ArrayList<ServisnaKnjizica> sviNeobrisaneSKnjizice() {
		ArrayList<ServisnaKnjizica> neobrisani = new ArrayList<ServisnaKnjizica>();
		for (ServisnaKnjizica knjizica : sKnjizice) {
			if(!knjizica.isObrisan()) {
				neobrisani.add(knjizica);
			}
		}
		return neobrisani;
	}

	public Musterija pronadjiVlasnika(Automobil a) {
		for (Musterija musterija : musterije) {
			if (a.getVlasnik().getId().equals(musterija.getId())) {
				return musterija;
			}
		}
		return null;
	}
	public Musterija pronadjiMusterijuIme(String ime) {
		for (Musterija musterija : musterije) {
			if (musterija.getIme().equals(ime) ) {
				return musterija;
			}
		}
		return null;
	}
	public Automobil pronadjiAuto(Servis s) {
		for (Automobil automobil : this.sviNeobrisaniAutomobili()) {
			if (s.getAuto().getId().contains(automobil.getId())) {
				return automobil;
			}
		}
		return null;
	}
	public String pronadjiIdPoImenuiP(String imeIPrezime) {
		for(Musterija musterija : sviNeobrisaneMusterije()) {
			String postojeceImeIprezime = musterija.getIme().concat(musterija.getPrezime()).toLowerCase();
			if(imeIPrezime.toLowerCase().equals(postojeceImeIprezime)) {
				return musterija.getId();
			}
			
		}return null;
	}
	public String pronadjiIdPoImenuiPServiser(String imeIPrezime) {
		for(Serviser serviser : sviNeobrisaniServiseri()) {
			String postojeceImeIprezime = serviser.getIme().concat(serviser.getPrezime()).toLowerCase();
			if(imeIPrezime.toLowerCase().equals(postojeceImeIprezime)) {
				return serviser.getId();
			}
			
		}return null;
	}
	
	
}

	
