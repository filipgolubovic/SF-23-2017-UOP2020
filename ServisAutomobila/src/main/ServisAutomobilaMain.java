package main;

import korisnici.Administrator;
import korisnici.Musterija;
import korisnici.Serviser;
import uloge.Pol;
import uloge.SpecijalizacijaServisera;

public class ServisAutomobilaMain {

	public static void main(String[] args) {
		Serviser serviser1 = new Serviser("Petar", "Petrovic", "1705889922234",Pol.M , "Cara Lazara 92", "0645789898", "pera", "123", 10000, SpecijalizacijaServisera.Autoelektricar);
		System.out.println(serviser1);
		Musterija musterija1 = new Musterija("Jasna", "Markovic", "1789889922234",Pol.Z , "Knez Mihajlova 14", "0665777898", "mare", "1234", 14);
		System.out.println(musterija1);
		Administrator admin1 = new Administrator("Filip", "Golubovic", "1888998800025",Pol.M , "Narodnog Fronta 32", "0654777898", "fica", "12345", 20000);
		System.out.println(admin1);
	}
	

}
