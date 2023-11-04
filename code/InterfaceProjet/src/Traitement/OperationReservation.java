package Traitement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JOptionPane;
public class OperationReservation implements InterfaceReservation {

	

	Connection conn= Connexion.getConnection();
	OperationEstDisponible o =new OperationEstDisponible();
	
public void ajouterResLivre(int idMembre,String nomDeLivre) {
		
	//String nom="antigone";
	
	
	
	
		try {
    		PreparedStatement ps=conn.prepareStatement("SELECT IDLIVRES FROM LIVRES WHERE TITRE=?" );
    		ps.setString(1,nomDeLivre);
    		ResultSet rs=ps.executeQuery();
    		rs.next();
    		int res=rs.getInt(1);
    		if(!o.MembreplusDe5(idMembre)) {
    			if(existeReservationL(idMembre, res))
        		{
        			JOptionPane.showMessageDialog(null,"la reservation existe deja");
        			
        		}else {
        			rs.close();
           		 PreparedStatement ps1=conn.prepareStatement("INSERT INTO MEMRESERVEL (ID,IDLIVRES,DATE,titre) VALUES(?,?,NOW(),?)");
           		ps1.setInt(1, idMembre);
           		
           		ps1.setInt(2,res);
           		ps1.setString(3, nomDeLivre);
           		int i=ps1.executeUpdate();
           		
           		 if(i!=0) {
           		JOptionPane.showMessageDialog(null,"Reservation ajouté");
           		}
           		else
           		{
           			JOptionPane.showMessageDialog(null,"Reservation non ajouté");
           		} 
           		
           	    }
    		}else JOptionPane.showMessageDialog(null,"Vous avez plus de 5 Reservation,Louer..");
    		 
    		}
    		
    	catch(SQLException e) {
    	//	System.out.println(e);
    		JOptionPane.showMessageDialog(null,e);
    	}
	}
	
	 public Vector<Reservation> listReservation(){
		 Vector<Reservation> info= new Vector<Reservation>();
		 
		 
		 try {
			PreparedStatement pre=conn.prepareStatement("SELECT * FROM memreservel");
			ResultSet rs=pre.executeQuery();
			while(rs.next()) {
			
				info.add(new Reservation(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getDate(4),rs.getDate(5),rs.getString(6)));
			}
			return info;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,e);
		}
		 
		 return null;
		 
	 } 
	 public Vector<Reservation> listReservationCD(){
		 Vector<Reservation> info= new Vector<Reservation>();
		 
		 
		 try {
			PreparedStatement pre=conn.prepareStatement("SELECT * FROM membrereservecd");
			ResultSet rs=pre.executeQuery();
			while(rs.next()) {
			
				info.add(new Reservation(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getDate(4),rs.getDate(5),rs.getString(6)));
			}
			return info;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,e);
		}
		 
		 return null;
		 
	 }
	 public Vector<Reservation> listReservationLivreNon(){
		 Vector<Reservation> info= new Vector<Reservation>();
		 
		 
		 try {
			PreparedStatement pre=conn.prepareStatement("SELECT * FROM nmemreservel");
			ResultSet rs=pre.executeQuery();
			while(rs.next()) {
			
				info.add(new Reservation(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getDate(4),rs.getDate(5),rs.getString(6)));
			}
			return info;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,e);
		}
		 
		 return null;
		 
	 }
	 public Vector<Reservation> listReservationCDNon(){
		 Vector<Reservation> info= new Vector<Reservation>();
		 
		 
		 try {
			PreparedStatement pre=conn.prepareStatement("SELECT * FROM nmembrereservecd");
			ResultSet rs=pre.executeQuery();
			while(rs.next()) {
			
				info.add(new Reservation(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getDate(4),rs.getDate(5),rs.getString(6)));
			}
			return info;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,e);
		}
		 
		 return null;
		 
	 }
	public void supprimerResLivre(int idMembre,String nomDeLivre) {

		try {
    		PreparedStatement ps=conn.prepareStatement("SELECT IDLIVRES FROM LIVRES WHERE TITRE=? ");
    		ps.setString(1,nomDeLivre);
    		ResultSet rs=ps.executeQuery();
    		rs.next();
    		PreparedStatement ps1=conn.prepareStatement("DELETE FROM MEMRESERVEL WHERE  ID = ? AND IDLIVRES=? ");
    		ps1.setInt(1, idMembre);
    		ps1.setInt(2,rs.getInt(1));
    		int i=ps1.executeUpdate();
    		if(i!=0) {
    			JOptionPane.showMessageDialog(null,"Reservation non supprimé");
    			
    		}
    		else
    		{
    			JOptionPane.showMessageDialog(null,"Reservation non supprimé");
    		}
    	    }
    	catch(SQLException e) {
    		JOptionPane.showMessageDialog(null,e);
    	}
	}
	public void supprimerResLivreNon(int idMembre,String nomDeLivre) {

		try {
    		PreparedStatement ps=conn.prepareStatement("SELECT IDLIVRES FROM LIVRES WHERE TITRE=? ");
    		ps.setString(1,nomDeLivre);
    		ResultSet rs=ps.executeQuery();
    		rs.next();
    		PreparedStatement ps1=conn.prepareStatement("DELETE FROM NMEMRESERVEL WHERE  ID = ? AND IDLIVRES=? ");
    		ps1.setInt(1, idMembre);
    		ps1.setInt(2,rs.getInt(1));
    		int i=ps1.executeUpdate();
    		if(i!=0) {
    			JOptionPane.showMessageDialog(null,"Reservation non supprimé");
    			
    		}
    		else
    		{
    			JOptionPane.showMessageDialog(null,"Reservation non supprimé");
    		}
    	    }
    	catch(SQLException e) {
    		JOptionPane.showMessageDialog(null,e);
    	}
	}
	 
	public void ajouterResCD(int idMembre,String titre) {
		
		try {
    		PreparedStatement ps=conn.prepareStatement("SELECT IDCD FROM DISQUECOMPACT WHERE TITRE=? ");
    		ps.setString(1,titre);
    		ResultSet rs=ps.executeQuery();
    		rs.next();
    		int res=rs.getInt(1);
    		if(!o.MembreplusDe5(idMembre)) {
    			if(existeReservationL(idMembre, res))
        		{
        			JOptionPane.showMessageDialog(null,"la reservation existe deja");
        			
        		}
        		else {
        			rs.close();
            		PreparedStatement ps1=conn.prepareStatement("INSERT INTO membrereservecd (ID,idCD,DATE,titre) VALUES(?,?,NOW(),?)");
            		ps1.setInt(1, idMembre);
            		ps1.setInt(2,res);
            		ps1.setString(3, titre);
            		int i= ps1.executeUpdate();
            		
            		if(i!=0) {
            			JOptionPane.showMessageDialog(null,"res cd ajouté");
            		}
            		else
            		{
            			JOptionPane.showMessageDialog(null,"res cd non ajouté");
            		}
        		}
    		}else JOptionPane.showMessageDialog(null,"Vous avez plus de 5 Reservation,Louer..");
    		
    		
    	    }
    	catch(SQLException e) {
    		JOptionPane.showMessageDialog(null,e);
    	}
	}
	public void supprimerResCD(int id) {
 
		try {
    		;
    		//System.out.println(rs.getInt(1));
    		PreparedStatement ps1=conn.prepareStatement("DELETE FROM membrereservecd WHERE  IDR = ? ");
    		ps1.setInt(1, id);
    		
    		int i =ps1.executeUpdate();
    		if(i!=0) {
    			JOptionPane.showMessageDialog(null,"res cd supprimé");
    		}
    		else
    		{
    			JOptionPane.showMessageDialog(null,"res cd non supprimé");
    		}
    	    
    	    }
    	catch(SQLException e) {
    		JOptionPane.showMessageDialog(null,e);
    	}
	}
	public void supprimerResCDNon(int id) {
		 
		try {
    		;
    		//System.out.println(rs.getInt(1));
    		PreparedStatement ps1=conn.prepareStatement("DELETE FROM nmembrereservecd WHERE  IDR = ? ");
    		ps1.setInt(1, id);
    		
    		int i =ps1.executeUpdate();
    		if(i!=0) {
    			JOptionPane.showMessageDialog(null,"res cd supprimé");
    		}
    		else
    		{
    			JOptionPane.showMessageDialog(null,"res cd non supprimé");
    		}
    	    
    	    }
    	catch(SQLException e) {
    		JOptionPane.showMessageDialog(null,e);
    	}
	}
	public void ajouterResLivreNon(int idMembre,String nomDeLivre) {
		
		//String nom="antigone";
		
		
		
		
			try {
	    		PreparedStatement ps=conn.prepareStatement("SELECT IDLIVRES FROM LIVRES WHERE TITRE=?" );
	    		ps.setString(1,nomDeLivre);
	    		ResultSet rs=ps.executeQuery();
	    		rs.next();
	    		int res=rs.getInt(1);
	    		if(!o.NonMembreplusDe5(idMembre)) {
	    			if(existeReservationLNon(idMembre, res))
	        		{
	        			JOptionPane.showMessageDialog(null,"la reservation existe deja");
	        			
	        		}else {
	        			rs.close();
	           		 PreparedStatement ps1=conn.prepareStatement("INSERT INTO NMEMRESERVEL (ID,IDLIVRES,DATE,titre) VALUES(?,?,NOW(),?)");
	           		ps1.setInt(1, idMembre);
	           		
	           		ps1.setInt(2,res);
	           		ps1.setString(3,nomDeLivre);
	           		int i=ps1.executeUpdate();
	           		
	           		 if(i!=0) {
	           		JOptionPane.showMessageDialog(null,"Reservation ajouté");
	           		}
	           		else
	           		{
	           			JOptionPane.showMessageDialog(null,"Reservation non ajouté");
	           		} 
	           		
	           	    }
	    		}else JOptionPane.showMessageDialog(null,"Vous avez plus de 5 Reservation,Louer..");
	    		 
	    		}
	    		
	    	catch(SQLException e) {
	    	//	System.out.println(e);
	    		JOptionPane.showMessageDialog(null,e);
	    	}
		}
	
public void ajouterResCDNon(int idMembre,String titre) {
		
		try {
    		PreparedStatement ps=conn.prepareStatement("SELECT IDCD FROM DISQUECOMPACT WHERE TITRE=? ");
    		ps.setString(1,titre);
    		ResultSet rs=ps.executeQuery();
    		rs.next();
    		int res=rs.getInt(1);
    		if(!o.NonMembreplusDe5(idMembre)) {
    			if(existeReservationLNon(idMembre, res))
        		{
        			JOptionPane.showMessageDialog(null,"la reservation existe deja");
        			
        		}
        		else {
        			rs.close();
            		PreparedStatement ps1=conn.prepareStatement("INSERT INTO nmembrereservecd (ID,idCD,DATE,titre) VALUES(?,?,NOW(),?)");
            		ps1.setInt(1, idMembre);
            		ps1.setInt(2,res);
            		ps1.setString(3, titre);
            		int i= ps1.executeUpdate();
            		
            		if(i!=0) {
            			JOptionPane.showMessageDialog(null,"res cd ajouté");
            		}
            		else
            		{
            			JOptionPane.showMessageDialog(null,"res cd non ajouté");
            		}
        		}
    		}else JOptionPane.showMessageDialog(null,"Vous avez plus de 5 Reservation,Louer..");
    		
    		
    	    }
    	catch(SQLException e) {
    		JOptionPane.showMessageDialog(null,e);
    	}
	}
	
	 
	
	
	public boolean existeReservationL(int idMembre,int idLivres) {
		boolean test= false;
		try {
			
    		PreparedStatement ps=conn.prepareStatement(" SELECT IDLIVRES FROM MEMRESERVEL WHERE ID =? and idlivres=? and (dateNotification is null or ADDDATE(dateNotification,3)>Now()) ");
    		ps.setInt(1,idMembre);
    		ps.setInt(2, idLivres);
    		ResultSet rs=ps.executeQuery();
    		if(rs.next()) {
    			
    				test=true;
    		}
		}
		catch(SQLException e) {
    		System.out.println(e.getMessage());
    	}
		return test;
	}
	public boolean existeReservationLNon(int idMembre,int idLivres) {
		boolean test= false;
		try {
			
    		PreparedStatement ps=conn.prepareStatement(" SELECT IDLIVRES FROM NMEMRESERVEL WHERE ID =? and idlivres=? and (dateNotification is null or ADDDATE(dateNotification,3)>Now()) ");
    		ps.setInt(1,idMembre);
    		ps.setInt(2, idLivres);
    		ResultSet rs=ps.executeQuery();
    		if(rs.next()) {
    			
    				test=true;
    		}
		}
		catch(SQLException e) {
    		System.out.println(e.getMessage());
    	}
		return test;
	}
	public boolean existeReservationCD(int idMembre,int idCD) {
		try {
    		PreparedStatement ps=conn.prepareStatement(" SELECT IDCD FROM MEMRESERVECD WHERE ID =?");
    		ps.setInt(1,idMembre);
    		ResultSet rs=ps.executeQuery();
    		while(rs.next()) {
    			if(rs.getInt(1)==idCD)
    				return true;
    		}
		}
		catch(SQLException e) {
    		System.out.println(e.getMessage());
    	}
		return false;
	}
	
	



}
