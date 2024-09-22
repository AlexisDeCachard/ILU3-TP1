package testsFonctionnels;

import jeu.*;
import cartes.*;

public class TestSabot {
	
	public static void main(String[] args) {
		Cartes carte25=new Borne(25);
		int nbCartes = 5;
		Sabot sabot = new Sabot(nbCartes);
		for (int i = 0; i<nbCartes;i++) {
			sabot.ajouterCarte(carte25);
		}
		for (int i=0; i<nbCartes;i++) {
			System.out.println("Tu as pioché " + sabot.piocher() + ".");
		}
	}
}
