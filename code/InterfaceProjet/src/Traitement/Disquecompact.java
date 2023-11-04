package Traitement;

import java.sql.Date;

public class Disquecompact {
	private int id;
	private String titre;
	private int nbrExp;
	private String  auteur ; 
	private String langue;
	private String datePub ;
	
	
	
	public Disquecompact(String titre, int nbrExp, String auteur, String langue, String datePub,int id) {
		
		this.titre = titre;
		this.nbrExp = nbrExp;
		this.auteur = auteur;
		this.langue = langue;
		this.datePub = datePub;
		this.id=id;
	}
	
	public String getLangue() {
		return langue;
	}

	public void setLangue(String langue) {
		this.langue = langue;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public int getNbrExp() {
		return nbrExp;
	}
	public void setNbrExp(int nbrExp) {
		this.nbrExp = nbrExp;
	}
	public String getAuteur() {
		return auteur;
	}
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	public String getDatePub() {
		return datePub;
	}
	public void setDatePub(String datePub) {
		this.datePub = datePub;
	}
}
