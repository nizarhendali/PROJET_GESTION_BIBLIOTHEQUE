package Traitement;

public class Livre {
	private int idLivres;
	private String titre;
	private String auteur;
	private String categorie;
	private int nbreExemplaire;
	

	public Livre(String titre, String auteur, String categorie, int i,int id) {
		//this.idLivres=idl;
		this.titre=titre;
		this.auteur=auteur;
		this.categorie=categorie;
		this.nbreExemplaire=i;
		this.idLivres=id;
		
	}

	public int getIdLivres() {
		return idLivres;
	}

	public void setIdLivres(int idLivres) {
		this.idLivres = idLivres;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public int getNbreExemplaire() {
		return nbreExemplaire;
	}

	public void setNbreExemplaire(int nbreExemplaire) {
		this.nbreExemplaire = nbreExemplaire;
	}
}
