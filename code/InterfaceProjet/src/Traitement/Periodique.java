package Traitement;


import java.sql.Date;
public class Periodique {
	private int id;
	private String titre;
	private String dateEdition;
	private String periodicite;
	private int nbreExemplaire;
	public Periodique(String text,String date ,String text1,int i,int id) {
		
		this.titre=text;
		this.dateEdition=date ;
		this.periodicite=text1;
		this.nbreExemplaire=i;
		this.id=id;
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
	public String getDateEdition() {
		return dateEdition;
	}
	public void setDateEdition(String dateEdition) {
		this.dateEdition = dateEdition;
	}
	public String getPeriodicite() {
		return periodicite;
	}
	public void setCategorie(String periodicite) {
		this.periodicite = periodicite;
	}
	public int getNbreExemplaire() {
		return nbreExemplaire;
	}
	public void setNbreExemplaire(int nbreExemplaire) {
		this.nbreExemplaire = nbreExemplaire;
	}
}
