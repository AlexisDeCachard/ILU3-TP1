package cartes;

import java.util.Iterator;

public class JeuDeCartes {
	private Configuration[] configuration = {new Configuration(new Borne(25), 10),new Configuration(new Borne(50), 10),new Configuration(new Borne(75), 10),new Configuration(new Borne(100), 12),
			new Configuration(new Borne(200), 4), new Configuration(new Parade(Type.FEU), 14),new Configuration(new Parade(Type.ESSENCE),6), new Configuration(new Parade(Type.CREVAISON), 6),
			new Configuration(new Parade(Type.ACCIDENT), 6), new Configuration(new Attaque(Type.FEU), 5),new Configuration(new Attaque(Type.ESSENCE),3),
			new Configuration(new Attaque(Type.CREVAISON), 3), new Configuration(new Attaque(Type.ACCIDENT), 3), new Configuration(new Botte(Type.FEU), 1),
			new Configuration(new Botte(Type.ESSENCE),1), new Configuration(new Botte(Type.CREVAISON), 1), new Configuration(new Botte(Type.ACCIDENT), 1)};
	
	public void affichageJeu() {
		for (int i = 0; i < configuration.length; i++) {
			Configuration config = configuration[i];
			Cartes carte= config.getCarte();
			System.out.println(config.getNbExemplaires() + " " + carte);
		}
	}



private static class Configuration{
	private Cartes carte;
	private int nbExemplaires;
	
	public Configuration(Cartes carte, int nbExemplaires) {
		super();
		this.carte = carte;
		this.nbExemplaires = nbExemplaires;
	}
	public Cartes getCarte() {
		return carte;
	}
	public int getNbExemplaires() {
		return nbExemplaires;
	}
	
	
	
}

}
