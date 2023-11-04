package Traitement;

import java.util.Vector;

public interface InterfaceClient {
	public abstract void ajouterclient(Client l);
	public abstract void supprimerClient(int id);
	public abstract void modifierClient(Client c);
	
	public abstract Client rechercherClient(int id);

}
