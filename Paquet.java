package application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// classe contenant un paquet de cartes

public class Paquet {

	// attributs
	
	private List<Carte> paquet; // paquet contenant des pairs de cartes melangees
	
	// constructeur
	public Paquet() {
		construirePaquet();
	}
	// accesseurs
	public List<Carte> getPaquet(){
		return this.paquet; 
	}
	
	// methodes
	private void construirePaquet() {
		
		// on cree les id's 
		int[] ids = new int[8]; 
		for(int i = 0; i < ids.length; i++) {
			ids[i] = i; 
		}
		// on cree les urls des images
		String[] urlsImage = new String[8];
		for(int i = 0; i < urlsImage.length; i++ ) {
			urlsImage[i] = "/images/carte_" + i + ".png";
		}
		
		// cree les pairs des cartes
		List<Carte> cartes = new ArrayList<>(); 
		for(int id : ids) {
			Carte carte1 = new Carte(id, urlsImage[id]);
			Carte carte2 = new Carte(id, urlsImage[id]);
			paquet.add(carte1);
			paquet.add(carte2); 
		}
		// on melange le paquet
		Collections.shuffle(paquet);
		this.paquet = cartes;
	}
	
	// verifier si paquet est vide
	public boolean getPaquetVide() {
		return this.paquet.isEmpty();
	}
	
	// supprimer les cartes pairs du paquet
	public void supprimerPair(int id) {

		// liste de cartes a eliminer
		List<Carte> cartesAEliminer = new ArrayList();
		
		for(Carte carte : this.paquet) {
			for(Carte autreCarte : this.paquet) {
				if(carte != autreCarte && carte.getId() == autreCarte.getId()) {
					cartesAEliminer.add(carte);
					cartesAEliminer.add(autreCarte);
				}
			}
		}
		this.paquet.removeAll(cartesAEliminer);
	}
}
