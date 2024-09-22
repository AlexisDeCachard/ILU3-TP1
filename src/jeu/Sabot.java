package jeu;

import cartes.*;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Sabot implements Iterator<Cartes>{
	private Cartes[] pioche;
	private int nbCartes;
	private Iterator<Cartes> iterateur=new Iterateur();

	public Sabot(int nbCartesMaxPioche) {
		this.pioche=new Cartes[nbCartesMaxPioche];
		nbCartes = 0;
	}
	
	public boolean estVide() {
		return nbCartes==0;
	}
	
	public void ajouterCarte(Cartes carte) {
		if (nbCartes==pioche.length){
			throw new ArrayIndexOutOfBoundsException ("La pioche est déjà complète");
		} else {
			pioche[nbCartes]=carte;
			nbCartes++;
		}
	}
	
	public Cartes piocher() {
		Cartes recup = iterateur.next();
		iterateur.remove();
		return recup;
	}
	
	private class Iterateur implements Iterator<Cartes> {
		private int indiceIterateur = 0;
		private boolean nextEffectue = false;
		private int nombreOperationsRef = 0;
		private int nombreOperations = 0;
		
		@Override
		public boolean hasNext() {
			return indiceIterateur < nbCartes;
		}

		@Override
		public Cartes next() {
			if (hasNext()) {
				Cartes recup = pioche[indiceIterateur];
				indiceIterateur++;
				nextEffectue = true;
				return recup;
			} else {
				throw new NoSuchElementException("Il n y a plus de carte apres");
			}
		}

		@Override
		public void remove() {
			verificationConcurrence();
			if (nbCartes < 1 || !nextEffectue) {
				throw new IllegalStateException("Il n y a pas de carte a supprimer");
			} else {
				for (int i = indiceIterateur - 1; i < nbCartes-1; i++) {
					pioche[i] = pioche[i + 1];
				}
				nextEffectue = false;
				indiceIterateur--;
				nbCartes--;
				nombreOperationsRef++; 
				nombreOperations++;
			}
		}
		
		private void verificationConcurrence(){
			if (nombreOperations != nombreOperationsRef) {
				throw new ConcurrentModificationException();
			}
		}
	}

	@Override
	public boolean hasNext() {
		return iterateur.hasNext();
	}

	@Override
	public Cartes next() {
		return iterateur.next();
	}
}
