package jeu;

import cartes.Cartes;

public class Sabot {
	private Cartes[] pioche;
	private int nbCartes;

	public Sabot(Cartes[] pioche) {
		this.pioche=pioche;
		nbCartes = pioche.length;
	}
	
	public boolean estVide() {
		return nbCartes==0;
	}
	
	public void ajouterCarte(Cartes carte) {
		if (nbCartes==pioche.length){
			
		} else {
			pioche[nbCartes]=carte;
		}
	}
}
