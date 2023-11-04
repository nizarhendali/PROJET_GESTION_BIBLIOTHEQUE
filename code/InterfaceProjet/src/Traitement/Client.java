package Traitement;

public class Client {

	private int ID ;
	private String nom;
	private String prenom ;
	private String telephone;
	public String ville ;
	public String email;
	
	
public Client(int ID,String nom, String prenom, String telephone, String ville,String email) {
		
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.ville= ville;
		this.email = email;
		this.ID=ID;
		
	}


	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public void affiche(){
		System.out.println("Client [ nom=" + nom + ", prenom=" + prenom + ", telephone=" + telephone +", ville="+ville+ ", email="
				+ email + "]");
	}
	
}

