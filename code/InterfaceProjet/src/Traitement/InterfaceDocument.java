package Traitement;

import java.sql.ResultSet;
import java.util.Vector;

public interface InterfaceDocument {
	public ResultSet  afficherExemplaireL();
	public ResultSet  afficherExemplaireP();
	public ResultSet  afficherExemplaireCD();
	public Vector<Livre> afficherTtL();
	public Vector<Periodique>  afficherTtP();
	public  Vector<Disquecompact>  afficherTtCD();
	
	public void  AjouterLivre(Livre L);
	public void SupprimerLivre(int id);
	public void AjouterPeriodique(Periodique p);
	public void  SupprimerPeriodique(int id);
	public int  AjouterCD(Disquecompact cd);
	public void SupprimerCD(int id);
	public ResultSet SelectionnerLIVRE(int id);
	public ResultSet SelectionnerPeriodique(int id) ;
	public ResultSet SelectionnerCD(int id) ;
	public void ajouterExemplaireLivre(int id);
	public void SupprimerExemplaireLivre(int id);
	public void ajouterExemplairePeriodique(int id);
	public void supprimerExemplairePeriodique(int id);
	public void ajouterExemplaireCD(int id);
	public void supprimerExemplaireCD(int id);
	public void modifierLivre(Livre L);
	public void modifierPeriodique(Periodique L);
	public void modifierCD(Disquecompact L);

}
