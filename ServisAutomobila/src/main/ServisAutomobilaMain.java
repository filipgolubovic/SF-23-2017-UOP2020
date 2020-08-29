package main;


import java.io.ObjectInputStream.GetField

;
import java.util.ArrayList;
import java.util.Scanner;

import org.omg.CORBA.CTX_RESTRICT_SCOPE;


import gui.Prijava;
import korisnici.Musterija;
import servis.Automobil;
import servis.Servis;
import servis.ServisnaKnjizica;
import util.CitanjeFajlova;



public class ServisAutomobilaMain {

	public static void main(String[] args) {
		CitanjeFajlova citanje = new CitanjeFajlova();
		citanje.ucitavanjeAdmina();
		citanje.ucitajMusterije();
		citanje.ucitajAutomobile();
		citanje.ucitajServisere();
		citanje.ucitajServise();
		citanje.ucitajSKnjizice();
		citanje.ucitajDelove();
		
		
		
		
		
		Prijava prijavaProzor = new Prijava(citanje);
		prijavaProzor.setVisible(true);
	}
}


