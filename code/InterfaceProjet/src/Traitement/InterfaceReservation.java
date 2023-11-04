package Traitement;

public interface InterfaceReservation {
	void supprimerResLivre(int idMembre,String nomDeLivre);
	void ajouterResCD(int idMembre,String titre);
	void supprimerResCD(int id);
	
	boolean existeReservationL(int idMembre,int idLivres);
	boolean existeReservationCD(int idMembre, int idCD);
}
