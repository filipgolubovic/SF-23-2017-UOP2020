package main;

import java.sql.Date
;
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

public class ServisAutomobilaMain {

	public static void main(String[] args) {
		
		Serviser serviser1 = new Serviser(3,"Petar", "Petrovic", "1705889922234",Pol.M , "Cara Lazara 92", "0645789898", "pera", "123", 10000, SpecijalizacijaServisera.Automehanicar);
		
		Musterija musterija1 = new Musterija(2,"Jasna", "Markovic", "1789889922234",Pol.Z , "Knez Mihajlova 14", "0665777898", "mare", "1234", 14);
		
		Administrator admin1 = new Administrator(1,"Filip", "Golubovic", "1888998800025",Pol.M , "Narodnog Fronta 32", "0654777898", "fica", "12345", 20000);
		
		Automobil auto1 = new Automobil(1,musterija1, Marka.AUDI, Model.R8, 2015, "200ks", "2000ccm", VrstaGoriva.Benzin);
		
		Deo deo = new Deo(3,Marka.AUDI, Model.R8, "Kocnice", 20000);
		ArrayList<Deo>listaDelovaAudi = new ArrayList<Deo>();
	
		Date datum = new Date(2020, 6, 17);
		
		Servis servis1 = new Servis(1,auto1, serviser1, datum, "Promena kocnica", listaDelovaAudi);
		
		
		ArrayList<Servis>listaServisa = new ArrayList<Servis>();
		listaServisa.add(servis1);
		
		ServisnaKnjizica sKnjizica1 = new ServisnaKnjizica(1,auto1, listaServisa);
		
		
		System.out.println(sKnjizica1);
	}
}
	


