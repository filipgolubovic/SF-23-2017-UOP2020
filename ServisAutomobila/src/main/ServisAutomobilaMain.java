package main;


import java.util.ArrayList;



import korisnici.Musterija;
import korisnici.Serviser;

import util.CitanjeFajlova;


public class ServisAutomobilaMain {

	public static void main(String[] args) {
		ArrayList<Musterija>ucitaneMusterije = CitanjeFajlova.ucitajMusterije();
		for(Musterija musterija : ucitaneMusterije) {
			System.out.println(musterija);
			
			
		}
		ArrayList<Serviser>ucitaniServiseri = CitanjeFajlova.ucitajServisere();
		for(Serviser serviser : ucitaniServiseri) {
			System.out.println(serviser);
		}
			
	}
	
}
	


