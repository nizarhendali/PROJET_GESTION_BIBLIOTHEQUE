package Traitement;

public interface InterfaceVerificationDispoDocuments {
	boolean liverEstDisponible(String t);
	//verifier si un Livre Est disponible
	boolean cdEstDisponible(String t);
	//verifier si un CD Est disponible
	boolean PEstDisponible(String t);
	//verifier si un Periodique Est disponible
	boolean liverEstFD(String  titre);
	//verifier si un Livre Est Fortement en demande
	boolean exLEstDejaEmprunte(int id);
	//verifier si un Exemplaire Livre est deja emprunter par un autre
	boolean  avezVousDejaEmpruntezCeLiverM(int id,String titre);
	//verifier si un membre a deja emprunter un exemplaire de ce Liver
	boolean  avezVousDejaEmpruntezCeLiverNM(int id,String titre);
	//verifier si un Non membre a deja emprunter un exemplaire de ce Liver
	boolean exCDEstDejaEmprunte(int id);
	//verifier si un Exemplaire Periodique est deja emprunter par un autre
	boolean  avezVousDejaEmpruntezCeCDM(int id,String titre);
	//verifier si un membre a deja emprunter un exemplaire de ce CD
	boolean  avezVousDejaEmpruntezCeCDNM(int id,String titre);
	//verifier si un non membre a deja emprunter un exemplaire de ce CD
	boolean exPeriodiqueEstDejaEmprunte(int id);
	//verifier si un Exemplaire Periodique est deja emprunter par un autre
	boolean  avezVousDejaEmpruntezCePM(int id,String titre);
	//verifier si un membre a deja emprunter un exemplaire de ce Periodique
	boolean  avezVousDejaEmpruntezCePNM(int id,String titre);
	//verifier si un non membre a deja emprunter un exemplaire de ce Periodique
	boolean limitDocumentsEmprunteM(int id);
	//verifier si un Membre ne depasse pas le nombre de document autoriser
	boolean limitDocumentsEmprunteNM(int id);
	//verifier si un Non Membre ne depasse pas le nombre de document autoriser
}
