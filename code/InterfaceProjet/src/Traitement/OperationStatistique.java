package Traitement;
import java.sql.*;
public class OperationStatistique {
	Connection conn=Connexion.getConnection();
	public int nbrLivresEmprunterParLesMembres()
	{
		int nbr=0;
	try {
		
		PreparedStatement ps=conn.prepareStatement("select count(IdEmpruntL) from memempruntl");
		ResultSet res = ps.executeQuery();
		if(res.next())
		{
			nbr=res.getInt(1);
		}
		else
			nbr=0;
	}
	catch (Exception e) {
		e.printStackTrace();
	}
	return  nbr;
	}
	
	public int nbrLivresEmprunterParLesNonMembres()
	{
		int nbr=0;
	try {
		
		PreparedStatement ps=conn.prepareStatement("select count(IdEmpruntL) from nmemempruntl");
		ResultSet res = ps.executeQuery();
		if(res.next())
		{
			nbr=res.getInt(1);
		}
		else
			nbr=0;
	}
	catch (Exception e) {
		e.printStackTrace();
	}
	return  nbr;
	}
	
	public int nbrCDsEmprunterParLesMembres()
	{
		int nbr=0;
	try {
		
		PreparedStatement ps=conn.prepareStatement("select count(IdEmpruntCD) from memempruntcd");
		ResultSet res = ps.executeQuery();
		if(res.next())
		{
			nbr=res.getInt(1);
		}
		else
			nbr=0;
	}
	catch(SQLException e) {
		System.out.println(e.getMessage());
	}
	return nbr;
	}
	

	public int nbrCDsEmprunterParLesNonMembres()
	{
		int nbr=0;
	try {
		
		PreparedStatement ps=conn.prepareStatement("select count(IdEmpruntCD) from nmemempruntcd");
		ResultSet res = ps.executeQuery();
		if(res.next())
		{
			nbr=res.getInt(1);
		}
		else
			nbr=0;
	}
	catch (Exception e) {
		e.printStackTrace();
	}
	return  nbr;
		
}
	public int nbrPeriodiquesEmprunterParLesMembres()
	{
		int nbr=0;
	try {
		
		PreparedStatement ps=conn.prepareStatement("select count(IdEmpruntP) from memempruntp");
		ResultSet res = ps.executeQuery();
		if(res.next())
		{
			nbr=res.getInt(1);
		}
		else
			nbr=0;
	}
	catch (Exception e) {
		e.printStackTrace();
	}
	return  nbr;
	}
	
	public int nbrPeriodiquesEmprunterParLesNonMembres()
	{
		int nbr=0;
	try {
		
		PreparedStatement ps=conn.prepareStatement("select count(IdEmpruntP) from nmemempruntp");
		ResultSet res = ps.executeQuery();
		if(res.next())
		{
			nbr=res.getInt(1);
		}
		else
			nbr=0;
	}
	catch (Exception e) {
		e.printStackTrace();
	}
	return  nbr;
	}
	
	public int livresPerdu()
	{
		int nbr=0;
	try {
		
		PreparedStatement ps=conn.prepareStatement("select count(IdEmpruntL) from memempruntl where ADDDATE(dateEmprunt,duree)< CURRENT_TIMESTAMP and dateRetour is null");
		ResultSet res = ps.executeQuery();
		if(res.next())
		{
			nbr+=res.getInt(1);
		}
		
		
		PreparedStatement ps1=conn.prepareStatement("select count(IdEmpruntL) from nmemempruntl where ADDDATE(dateEmprunt,duree)< CURRENT_TIMESTAMP and dateRetour is null");
		ResultSet res1 = ps1.executeQuery();
		if(res1.next())
		{
			nbr+=res1.getInt(1);
		}
		
	}
	catch (Exception e) {
		e.printStackTrace();
	}
	return  nbr;
	}
	
	public int CDsPerdu()
	{
		int nbr=0;
	try {
		
		PreparedStatement ps=conn.prepareStatement("select count(IdEmpruntCD) from memempruntCD where ADDDATE(dateEmprunt,duree)< CURRENT_TIMESTAMP and dateRetour is null");
		ResultSet res = ps.executeQuery();
		if(res.next())
		{
			nbr+=res.getInt(1);
		}
		
		
		PreparedStatement ps1=conn.prepareStatement("select count(IdEmpruntCD) from nmemempruntCD where ADDDATE(dateEmprunt,duree)< CURRENT_TIMESTAMP and dateRetour is null");
		ResultSet res1 = ps1.executeQuery();
		if(res1.next())
		{
			nbr+=res1.getInt(1);
		}
		
	}
	catch (Exception e) {
		e.printStackTrace();
	}
	return  nbr;
	}
	
	public int peridiquePerdu()
	{
		int nbr=0;
	try {
		
		PreparedStatement ps=conn.prepareStatement("select count(IdEmpruntP) from memempruntp where ADDDATE(dateEmprunt,duree)< CURRENT_TIMESTAMP and dateRetour is null");
		ResultSet res = ps.executeQuery();
		if(res.next())
		{
			nbr+=res.getInt(1);
		}
		
		
		PreparedStatement ps1=conn.prepareStatement("select count(IdEmpruntP) from nmemempruntp where ADDDATE(dateEmprunt,duree)< CURRENT_TIMESTAMP and dateRetour is null");
		ResultSet res1 = ps1.executeQuery();
		if(res1.next())
		{
			nbr+=res1.getInt(1);
		}
		
	}
	catch (Exception e) {
		e.printStackTrace();
	}
	return  nbr;
	}
	
	public int nbrTotalDeLivres() {
       try {
		PreparedStatement ps=conn.prepareStatement("select count(IdLivres) from Livres");
		ResultSet res = ps.executeQuery();
		if(res.next())
		{
			return res.getInt(1);
		}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
       return 0;
	}
	public int nbrTotalDeCD() {
	       try {
			PreparedStatement ps=conn.prepareStatement("select count(IdCD) from disqueCompact");
			ResultSet res = ps.executeQuery();
			if(res.next())
			{
				return res.getInt(1);
			}
			}catch(SQLException e) {
				System.out.println(e.getMessage());
			}
	       return 0;
		}
	public int nbrTotalDePeriodiques() {
	       try {
			PreparedStatement ps=conn.prepareStatement("select count(idp) from periodiquesjournaux");
			ResultSet res = ps.executeQuery();
			if(res.next())
			{
				return res.getInt(1);
			}
			}catch(SQLException e) {
				System.out.println(e.getMessage());
			}
	       return 0;
		}
	

}
