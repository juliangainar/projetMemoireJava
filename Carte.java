package application;

// classe gerant les cartes

public class Carte {

	// attributs
	private int id;
	private String urlImage;
	
	// constructeurs
	public Carte(int id, String urlImage) {
		this.id = id;
		this.urlImage = urlImage;
	}
	
	// accesseurs
	public int getId() {
		return this.id;
	}
	
	public String getUrlImage() {
		return this.urlImage;
	}
	
	// methodes
	
	/**
	 * Verifie si la carte passee est la meme
	 * @params La carte a comparer
	 * @returns boolean
	 * @authors Iulian GAINAR
	 */
	public boolean estMemeCarte(Carte carte) {
		return this.getId() == carte.getId();
	}
	
	
}
