package Traitement;
import java.sql.*;
public class OperationEstDisponible implements InterfaceVerificationDispoDocuments {
	
	Connection conn=Connexion.getConnection();
	
	
	public boolean livreEstDisponible1(int idex) {
		try {
			PreparedStatement pre=conn.prepareStatement("SELECT * FROM exemplairelivre where idExemplaireL=? and statu='Dispo'");
			pre.setInt(1, idex);
			ResultSet rs =pre.executeQuery();
			if(rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	public boolean CDEstDisponible(int id) {
		try {
			PreparedStatement pre=conn.prepareStatement("SELECT * FROM exemplairecd where idExemplaireCD=? and statu='Dispo'");
			pre.setInt(1, id);
			ResultSet rs =pre.executeQuery();
			if(rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public boolean PEstDisponible(int id) {
		try {
			PreparedStatement pre=conn.prepareStatement("SELECT * FROM exemplaireperiodiquesj where idExemplaireP=? and statu='Dispo'");
			pre.setInt(1, id);
			ResultSet rs =pre.executeQuery();
			if(rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public boolean MembreplusDe5(int id ) {
		try {
			PreparedStatement pre = conn.prepareStatement("Select count(*) from memempruntl where ID=? and dateRetour is null");
			PreparedStatement pre1 = conn.prepareStatement("Select count(*) from memempruntcd where ID=? and dateRetour is null");
			PreparedStatement pre2 = conn.prepareStatement("Select count(*) from memempruntp where ID=? and dateRetour is null");
			PreparedStatement pre3 = conn.prepareStatement("Select count(*) from memreservel where ID=?");
			PreparedStatement pre4 = conn.prepareStatement("Select count(*) from membrereservecd where ID=?");
			pre.setInt(1, id);
			pre1.setInt(1, id);
			pre2.setInt(1, id);
			pre3.setInt(1, id);
			pre4.setInt(1, id);
			
			ResultSet rs= pre.executeQuery();
			ResultSet rs1= pre1.executeQuery();
			ResultSet rs2= pre2.executeQuery();
			ResultSet rs3= pre3.executeQuery();
			ResultSet rs4= pre4.executeQuery();
			rs.next();rs1.next();
			rs2.next();rs3.next();
			rs4.next();
			int max = rs.getInt(1)+rs1.getInt(1)+rs2.getInt(1)+rs3.getInt(1)+rs4.getInt(1);
			if(max >=5) {
				return true;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean NonMembreplusDe5(int id ) {
		try {
			PreparedStatement pre = conn.prepareStatement("Select count(*) from nmemempruntl where ID=? and dateRetour is null");
			PreparedStatement pre1 = conn.prepareStatement("Select count(*) from nmemempruntcd where ID=? and dateRetour is null");
			PreparedStatement pre2 = conn.prepareStatement("Select count(*) from nmemempruntp where ID=? and dateRetour is null");
			PreparedStatement pre3 = conn.prepareStatement("Select count(*) from nmemreservel where ID=?");
			PreparedStatement pre4 = conn.prepareStatement("Select count(*) from nmembrereservecd where ID=?");
			pre.setInt(1, id);
			pre1.setInt(1, id);
			pre2.setInt(1, id);
			pre3.setInt(1, id);
			pre4.setInt(1, id);
			
			ResultSet rs= pre.executeQuery();
			ResultSet rs1= pre1.executeQuery();
			ResultSet rs2= pre2.executeQuery();
			ResultSet rs3= pre3.executeQuery();
			ResultSet rs4= pre4.executeQuery();
			rs.next();rs1.next();
			rs2.next();rs3.next();
			rs4.next();
			int max = rs.getInt(1)+rs1.getInt(1)+rs2.getInt(1)+rs3.getInt(1)+rs4.getInt(1);
			if(max >=5) {
				return true;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public boolean liverEstDisponible(String t)
	{
		int r1=0,r2=0,r3=0,id;
		
		try {
			
			PreparedStatement ps0=conn.prepareStatement("SELECT idLivres from livres where titre=?;");
			ps0.setString(1,t);
			ps0.setMaxRows(1);
			ResultSet res0 = ps0.executeQuery();
			if(res0.next())
			{
				
				id=res0.getInt(1);
			PreparedStatement ps1=conn.prepareStatement("SELECT nbrExemplaire from livres where idLivres=?;");
			ps1.setInt(1,id);
			ps1.setMaxRows(1);
			ResultSet res1 = ps1.executeQuery();
			if(res1.next())
				r1=res1.getInt(1);
			else
				r1=0;
			PreparedStatement ps2=conn.prepareStatement("SELECT count(idLivres) from memempruntl MEL,exemplairelivre EXL where MEL.idExemplaireL=EXL.idExemplaireL and EXL.idLivres=? and MEL.dateRetour is null GROUP by EXL.idLivres;");
			ps2.setInt(1,id);
			ps2.setMaxRows(1);
			ResultSet res2 = ps2.executeQuery();
			if(res2.next())
				r2=res2.getInt(1);
			else
				r2=0;
			
			
			PreparedStatement ps3=conn.prepareStatement("SELECT count(idLivres)  from nmemempruntl NMEL,exemplairelivre EXL where NMEL.idExemplaireL=EXL.idExemplaireL and EXL.idLivres=? and NMEL.dateRetour is null GROUP by EXL.idLivres;");
			ps3.setInt(1,id);
			ps3.setMaxRows(1);
			ResultSet res3 = ps3.executeQuery();
			
			if(res3.next())
				r3=res3.getInt(1);
			else
				r3=0;
			
			System.out.println(r1+" "+r2+" "+r3);
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		if(r1-r2-r3>0)
			return true;
			else
			return false;
		
	}
	
	public boolean cdEstDisponible(String t)
	{
		int r1=0,r2=0,r3=0,id;
		
		try {
			
			PreparedStatement ps0=conn.prepareStatement("SELECT idCD from disquecompact where titre=?;");
			ps0.setString(1,t);
			ps0.setMaxRows(1);
			ResultSet res0 = ps0.executeQuery();
			if(res0.next())
			{
				
				id=res0.getInt(1);
			PreparedStatement ps1=conn.prepareStatement("SELECT nbrExemplaire from disquecompact where idCD=?;");
			ps1.setInt(1,id);
			ps1.setMaxRows(1);
			ResultSet res1 = ps1.executeQuery();
			if(res1.next())
				r1=res1.getInt(1);
			else
				r1=0;
			PreparedStatement ps2=conn.prepareStatement("SELECT count(idCD) from memempruntcd MECD,exemplairecd EXCD where MECD.idExemplairecd=EXCD.idExemplairecd and EXCD.idCD=? and MECD.dateRetour is null GROUP by EXCD.idCD;");
			ps2.setInt(1,id);
			ps2.setMaxRows(1);
			ResultSet res2 = ps2.executeQuery();
			if(res2.next())
				r2=res2.getInt(1);
			else
				r2=0;
			
			
			PreparedStatement ps3=conn.prepareStatement("SELECT count(idCD)  from nmemempruntcd NMECD,exemplairecd EXCD where NMECD.idExemplairecd=EXCD.idExemplairecd and EXCD.idCD=? and NMECD.dateRetour is null GROUP by EXCD.idExemplairecd;");
			ps3.setInt(1,id);
			ps3.setMaxRows(1);
			ResultSet res3 = ps3.executeQuery();
			
			if(res3.next())
				r3=res3.getInt(1);
			else
				r3=0;
			
			System.out.println(r1+" "+r2+" "+r3);
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		if(r1-r2-r3>0)
			return true;
			else
			return false;
		
	}



public boolean PEstDisponible(String t)
{
	int r1=0,r2=0,r3=0,id;
	
	try {
		
		PreparedStatement ps0=conn.prepareStatement("SELECT idp from peridiquesjournaux where titre=?;");
		ps0.setString(1,t);
		ps0.setMaxRows(1);
		ResultSet res0 = ps0.executeQuery();
		if(res0.next())
		{
			
			id=res0.getInt(1);
		PreparedStatement ps1=conn.prepareStatement("SELECT nbrExemplaire from peridiquesjournaux where idp=?;");
		ps1.setInt(1,id);
		ps1.setMaxRows(1);
		ResultSet res1 = ps1.executeQuery();
		if(res1.next())
			r1=res1.getInt(1);
		else
			r1=0;
		PreparedStatement ps2=conn.prepareStatement("SELECT count(idp) from memempruntp MEP,exemplaireperiodiquesj EXP where MEP.idExemolaireP=EXP.idExemplaireP and EXP.idp=? and MEP.dateRetour is null GROUP by EXP.idp;");
		ps2.setInt(1,id);
		ps2.setMaxRows(1);
		ResultSet res2 = ps2.executeQuery();
		if(res2.next())
			r2=res2.getInt(1);
		else
			r2=0;
		
		
		PreparedStatement ps3=conn.prepareStatement("SELECT count(idp)  from nmemempruntp NMEP,exemplaireperiodiquesj EXP where NMEP.idExemplaireP=EXP.idExemplaireP and EXP.idp=? and NMEP.dateRetour is null GROUP by EXP.idExemplaireP;");
		ps3.setInt(1,id);
		ps3.setMaxRows(1);
		ResultSet res3 = ps3.executeQuery();
		
		if(res3.next())
			r3=res3.getInt(1);
		else
			r3=0;
		
		System.out.println(r1+" "+r2+" "+r3);
		}
		
	}
	catch (Exception e) {
		e.printStackTrace();
	}
	if(r1-r2-r3>0)
		return true;
		else
		return false;
	
}


public boolean liverEstFD(String  titre)
{
	int r1=0,r2=0,r3=0,id;
	
	try {
		
		PreparedStatement ps0=conn.prepareStatement("SELECT idLivres from livres where titre=?;");
		ps0.setString(1,titre);
		ps0.setMaxRows(1);
		ResultSet res0 = ps0.executeQuery();
		if(res0.next())
		{
			
			id=res0.getInt(1);
		PreparedStatement ps1=conn.prepareStatement("SELECT nbrExemplaire from livres where idLivres=?;");
		ps1.setInt(1,id);
		ps1.setMaxRows(1);
		ResultSet res1 = ps1.executeQuery();
		if(res1.next())
			r1=res1.getInt(1);
		else
			r1=0;
		PreparedStatement ps2=conn.prepareStatement("SELECT count(idLivres) from memempruntl MEL,exemplairelivre EXL where MEL.idExemplaireL=EXL.idExemplaireL and EXL.idLivres=? and MEL.dateRetour is null GROUP by EXL.idLivres;");
		ps2.setInt(1,id);
		ps2.setMaxRows(1);
		ResultSet res2 = ps2.executeQuery();
		if(res2.next())
			r2=res2.getInt(1);
		else
			r2=0;
		
		
		PreparedStatement ps3=conn.prepareStatement("SELECT count(idLivres)  from nmemempruntl NMEL,exemplairelivre EXL where NMEL.idExemplaireL=EXL.idExemplaireL and EXL.idLivres=? and NMEL.dateRetour is null GROUP by EXL.idLivres;");
		ps3.setInt(1,id);
		ps3.setMaxRows(1);
		ResultSet res3 = ps3.executeQuery();
		
		if(res3.next())
			r3=res3.getInt(1);
		else
			r3=0;
		
		
		}
		}
		
	
	catch (Exception e) {
		e.printStackTrace();
	}
	float r=((float)(r1-r2-r3)/r1);
	if(r<0.3)
	{
		System.out.println(r1+" "+r2+" "+r3);
		System.out.println(""+r+"<0.3");
		return true;
	}
	else
	{
		System.out.println(r1+" "+r2+" "+r3);
			System.out.println(""+r+">0.3");
			return false;
	}
		
}

public boolean exLEstDejaEmprunte(int id)
{
	boolean test=false;
	try {
		PreparedStatement p0=conn.prepareStatement("select ID from memempruntl where idExemplaireL=? and dateRetour is null");
		p0.setInt(1, id);
		ResultSet res0=p0.executeQuery();
		if(res0.next())
			test=true;
		PreparedStatement p1=conn.prepareStatement("select ID from nmemempruntl where idExemplaireL=? and dateRetour is null");
		p1.setInt(1, id);
		ResultSet res1=p1.executeQuery();
		if(res1.next())
			test=true;
		
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	return test;
}












public boolean  avezVousDejaEmpruntezCeLiverM(int id,String titre)
{
	boolean test=false;
	int idL;
	try {
		PreparedStatement ps0=conn.prepareStatement("SELECT idLivres from livres where titre=?;");
		ps0.setString(1,titre);
		ps0.setMaxRows(1);
		ResultSet res0 = ps0.executeQuery();
		if(res0.next())
		{
			
			idL=res0.getInt(1);
		PreparedStatement p1=conn.prepareStatement("select MEL.idExemplaireL from memempruntl MEL,exemplairelivre EXL"
				+ " where MEL.idExemplaireL=EXL.idExemplaireL and EXL.idLivres=? and MEL.ID=? and MEL.dateRetour is null ;");
		p1.setInt(1, idL);
		p1.setInt(2, id);
		ResultSet res1 = p1.executeQuery();
		if(res1.next())
		{
			test=true;
		}
		}
		
	}
catch (SQLException e) {
		
		e.printStackTrace();
	}
	
	return test;
}

public boolean  avezVousDejaEmpruntezCeLiverNM(int id,String titre)
{
	boolean test=false;
	int idL;
	try {
		PreparedStatement ps0=conn.prepareStatement("SELECT idLivres from livres where titre=?;");
		ps0.setString(1,titre);
		ps0.setMaxRows(1);
		ResultSet res0 = ps0.executeQuery();
		if(res0.next())
		{
			
			idL=res0.getInt(1);
		PreparedStatement p1=conn.prepareStatement("select NMEL.idExemplaireL from nmemempruntl NMEL,exemplairelivre EXL where NMEL.idExemplaireL=EXL.idExemplaireL and EXL.idLivres=? and NMEL.ID=? and NMEL.dateRetour is null ;");
		p1.setInt(1, idL);
		p1.setInt(2, id);
		ResultSet res1 = p1.executeQuery();
		if(res1.next())
		{
			test=true;
		}
		}
		
		
	}
catch (SQLException e) {
		
		e.printStackTrace();
	}
	
	return test;
}

public boolean exCDEstDejaEmprunte(int id)
{
	boolean test=false;
	try {
		PreparedStatement p0=conn.prepareStatement("select ID from memempruntCD where idExemplaireCD=? and dateRetour is null");
		p0.setInt(1, id);
		ResultSet res0=p0.executeQuery();
		if(res0.next())
			test=true;
		PreparedStatement p1=conn.prepareStatement("select ID from nmemempruntCD where idExemplaireCD=? and dateRetour is null");
		p1.setInt(1, id);
		ResultSet res1=p1.executeQuery();
		if(res1.next())
			test=true;
		
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	return test;
}

public boolean  avezVousDejaEmpruntezCeCDM(int id,String titre)
{
	boolean test=false;
	int idL;
	try {
		PreparedStatement ps0=conn.prepareStatement("SELECT idCD from disquecompact where titre=?;");
		ps0.setString(1,titre);
		ps0.setMaxRows(1);
		ResultSet res0 = ps0.executeQuery();
		if(res0.next())
		{
			System.out.println("aaa");
			idL=res0.getInt(1);
		PreparedStatement p1=conn.prepareStatement("select MECD.idExemplaireCD from memempruntcd MECD,exemplairecd EXCD where MECD.idExemplaireCD=EXCD.idExemplaireCD and EXCD.idCD=? and MECD.ID=? and MECD.dateRetour is null ;");
		p1.setInt(1, idL);
		p1.setInt(2, id);
		ResultSet res1 = p1.executeQuery();
		if(res1.next())
		{
			
			System.out.println("kkkk");
			test=true;
		}
		}
		
		
	}
catch (SQLException e) {
		
		e.printStackTrace();
	}
	
	return test;
}

public boolean  avezVousDejaEmpruntezCeCDNM(int id,String titre)
{
	boolean test=false;
	int idL;
	try {
		PreparedStatement ps0=conn.prepareStatement("SELECT idCD from disquecompact where titre=?;");
		ps0.setString(1,titre);
		ps0.setMaxRows(1);
		ResultSet res0 = ps0.executeQuery();
		if(res0.next())
		{
			
			idL=res0.getInt(1);
		PreparedStatement p1=conn.prepareStatement("select NMECD.idExemplaireCD from nmemempruntcd NMECD,exemplairecd EXCD where NMECD.idExemplaireCD=EXCD.idExemplaireCD and EXCD.idCD=? and NMECD.ID=? and NMECD.dateRetour is null ;");
		p1.setInt(1, idL);
		p1.setInt(2, id);
		ResultSet res1 = p1.executeQuery();
		if(res1.next())
		{
			test=true;
		}
		}
		
		
	}
catch (SQLException e) {
		
		e.printStackTrace();
	}
	
	return test;
}

public boolean exPeriodiqueEstDejaEmprunte(int id)
{
	boolean test=false;
	try {
		PreparedStatement p0=conn.prepareStatement("select ID from memempruntp where idExemolaireP=? and dateRetour is null");
		p0.setInt(1, id);
		ResultSet res0=p0.executeQuery();
		if(res0.next())
			test=true;
		PreparedStatement p1=conn.prepareStatement("select ID from nmemempruntp where idExemplaireP=? and dateRetour is null ");
		p1.setInt(1, id);
		ResultSet res1=p1.executeQuery();
		if(res1.next())
			test=true;
		
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	return test;
}

public boolean  avezVousDejaEmpruntezCePM(int id,String titre)
{
	boolean test=false;
	int idL;
	try {
		PreparedStatement ps0=conn.prepareStatement("SELECT idp from peridiquesjournaux where titre=?;");
		ps0.setString(1,titre);
		ps0.setMaxRows(1);
		ResultSet res0 = ps0.executeQuery();
		if(res0.next())
		{
			
			idL=res0.getInt(1);
		PreparedStatement p1=conn.prepareStatement("select MEP.idExemolaireP from memempruntp MEP,exemplaireperiodiquesj EXP where MEP.idExemolaireP=EXP.idExemplaireP and EXP.idp=? and MEP.ID=? and MEP.dateRetour is null  ;");
		p1.setInt(1, idL);
		p1.setInt(2, id);
		ResultSet res1 = p1.executeQuery();
		if(res1.next())
		{
			test=true;
		}
		}
		
		
	}
catch (SQLException e) {
		
		e.printStackTrace();
	}
	
	return test;
}

public boolean  avezVousDejaEmpruntezCePNM(int id,String titre)
{
	boolean test=false;
	int idL;
	try {
		PreparedStatement ps0=conn.prepareStatement("SELECT idp from peridiquesjournaux where titre=?;");
		ps0.setString(1,titre);
		ps0.setMaxRows(1);
		ResultSet res0 = ps0.executeQuery();
		if(res0.next())
		{
			
			idL=res0.getInt(1);
		PreparedStatement p1=conn.prepareStatement("select NMEP.idExemplaireP from nmemempruntp NMEP,exemplaireperiodiquesj EXP where NMEP.idExemplaireP=EXP.idExemplaireP and EXP.idp=? and NMEP.ID=? and NMEP.dateRetour is null   ;");
		p1.setInt(1, idL);
		p1.setInt(2, id);
		ResultSet res1 = p1.executeQuery();
		if(res1.next())
		{
			test=true;
		}
		}
		
		
	}
catch (SQLException e) {
		
		e.printStackTrace();
	}
	
	return test;
}

public boolean limitDocumentsEmprunteM(int id)
{
	
	int nbrDocumentsEmprunteParM=0;
	try {
		PreparedStatement p0=conn.prepareStatement("select count(ID) from memempruntl where ID=? and dateRetour is null ");
		p0.setInt(1,id);
		ResultSet res0=p0.executeQuery();
		if(res0.next())
			nbrDocumentsEmprunteParM+=res0.getInt(1);
		PreparedStatement p1=conn.prepareStatement("select count(ID) from memempruntcd where ID=? and dateRetour is null  ");
		p1.setInt(1,id);
		ResultSet res1=p1.executeQuery();
		if(res1.next())
			nbrDocumentsEmprunteParM+=res1.getInt(1);
		PreparedStatement p2=conn.prepareStatement("select count(ID) from memempruntp where ID=? and dateRetour is null   ");
		p2.setInt(1,id);
		ResultSet res2=p2.executeQuery();
		if(res2.next())
			nbrDocumentsEmprunteParM+=res2.getInt(1);
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	if(nbrDocumentsEmprunteParM>5)
		return true;
	else
		return false;
}

public boolean limitDocumentsEmprunteNM(int id)
{
	
	int nbrDocumentsEmprunteParM=0;
	try {
		PreparedStatement p0=conn.prepareStatement("select count(ID) from nmemempruntl where ID=? and dateRetour is null ");
		p0.setInt(1,id);
		ResultSet res0=p0.executeQuery();
		if(res0.next())
			nbrDocumentsEmprunteParM+=res0.getInt(1);
		PreparedStatement p1=conn.prepareStatement("select count(ID) from nmemempruntcd where ID=? and dateRetour is null  ");
		p1.setInt(1,id);
		ResultSet res1=p1.executeQuery();
		if(res1.next())
			nbrDocumentsEmprunteParM+=res1.getInt(1);
		PreparedStatement p2=conn.prepareStatement("select count(ID) from nmemempruntp where ID=? and dateRetour is null   ");
		p2.setInt(1,id);
		ResultSet res2=p2.executeQuery();
		if(res2.next())
			nbrDocumentsEmprunteParM+=res2.getInt(1);
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	if(nbrDocumentsEmprunteParM>3)
		return true;
	else
		return false;

}
}
