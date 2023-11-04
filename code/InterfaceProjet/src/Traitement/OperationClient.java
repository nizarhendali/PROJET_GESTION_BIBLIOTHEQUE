package Traitement;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import java.util.*;

public class OperationClient implements InterfaceClient {
	
	
	
	
	
	Connection conn=Connexion.getConnection();
	
	

	
	
	public void ajouterClientN(Client l) {
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement("INSERT INTO nmembre (nom,prenom,tel,ville,email) Values (?,?,?,?,?)");
			ps.setString(1,l.getNom());
			ps.setString(2, l.getPrenom());
			ps.setString(3, l.getTelephone());
			ps.setString(4, l.ville);
			ps.setString(5, l.email);
			
			PreparedStatement pre= conn.prepareStatement("Select id from nmembre where nom=? and prenom=? and tel =? and ville=? and email=?");
			pre.setString(1,l.getNom());
			pre.setString(2, l.getPrenom());
			pre.setString(3, l.getTelephone());
			pre.setString(4, l.ville);
			pre.setString(5, l.email);
			
			if(ps.executeUpdate()!=0) {
				ResultSet rs= pre.executeQuery();
				rs.next();
				JOptionPane.showMessageDialog(null, "Client est ajouté avec succées");
				JOptionPane.showMessageDialog(null,"Client ID :"+rs.getInt(1));
			}
			else
			{
			
				JOptionPane.showMessageDialog(null, "Client n'est pas ajouté");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e);
		}
		
	
		
	}
	
	public void ajouterclient(Client l) {
	
			
		try{
			
			if(l.ville.equalsIgnoreCase("settat"))
			{
				PreparedStatement ps=conn.prepareStatement("INSERT INTO membre (nom,prenom,tel,ville,email,isResidant) Values (?,?,?,?,?,?)");
		
			ps.setString(1,l.getNom());
			ps.setString(2, l.getPrenom());
			ps.setString(3, l.getTelephone());
			ps.setString(4, l.ville);
			ps.setString(5, l.email);
			
			ps.setBoolean(6, true);
			
			if(ps.executeUpdate()!=0) {
				JOptionPane.showMessageDialog(null, "le memnbre est ajouté avec succées");
			}
			else
			{
			
				JOptionPane.showMessageDialog(null, "le client n'est pas ajouté");
			}
			
				
			}
			else
			{
				PreparedStatement ps=conn.prepareStatement("INSERT INTO membre (nom,prenom,tel,ville,email,isResidant) Values (?,?,?,?,?,?)");
				
				ps.setString(1,l.getNom());
				ps.setString(2, l.getPrenom());
				ps.setString(3, l.getTelephone());
				ps.setString(4, l.ville);
				ps.setString(5, l.email);
				ps.setInt(6, 0);
				
				if(ps.executeUpdate()!=0) {
				
					JOptionPane.showMessageDialog(null, "le memnbre est ajouté avec succées");
				}
				else
				{
					
					JOptionPane.showMessageDialog(null, "le client n'est pas ajouté");
				}
				
			}
			
			
			
		}
		catch(SQLException e) {
		
			JOptionPane.showMessageDialog(null, "erreur système  "+e);
		}
		
	}

	
	
	
	
	public void supprimerClient(int id){
		
		try {
			PreparedStatement ps=conn.prepareStatement("Delete from membre where id=?;");
			ps.setInt(1, id);
			
			if(ps.executeUpdate()!=0) {
				JOptionPane.showMessageDialog(null, "Client supprimé");
				
			}
			else
			{
				JOptionPane.showMessageDialog(null, "client non supprimé");
			}
		}
		catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "erreur système "+e);
		}
		
	}
public void supprimerClientN(int id){
		
		try {
			PreparedStatement ps=conn.prepareStatement("Delete from nmembre where id=?;");
			ps.setInt(1, id);
			
			if(ps.executeUpdate()!=0) {
				JOptionPane.showMessageDialog(null, "Client supprimé");
				
			}
			else
			{
				JOptionPane.showMessageDialog(null, "client non supprimé");
			}
		}
		catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "erreur système "+e);
		}
		
	}


	
	
	
	public void modifierClient(Client c) {
		
		
		
		
	
		try {
			
			if(c.getVille().equalsIgnoreCase("settat"))
			{
				PreparedStatement ps=conn.prepareStatement("update membre set nom=? ,prenom=? ,tel=? ,ville=? ,email=? ,isResidant=? where ID=?");
			
				ps.setString(1, c.getNom());
			
				ps.setString(2, c.getPrenom());
			
				ps.setString(3, c.getTelephone());
				
				ps.setString(4, c.getVille());
				
				ps.setString(5, c.getEmail());
			
				ps.setInt(6, 1);
				ps.setInt(7, c.getID());
				
				if(ps.executeUpdate()!=0) {
					System.out.println("Client updated");
				}
				else
				{
					System.out.println("client not updated");
				}
			}
			else
			{
				PreparedStatement ps=conn.prepareStatement("update membre set nom=? ,prenom=? ,tel=? ,ville=? ,email=? ,isResidant=? where ID=?");
				ps.setString(1, c.getNom());
				
				ps.setString(2, c.getPrenom());
			
				ps.setString(3, c.getTelephone());
				
				ps.setString(4, c.getVille());
				
				ps.setString(5, c.getEmail());
			
				ps.setInt(6, 0);
				ps.setInt(7, c.getID());
				
				if(ps.executeUpdate()!=0) {
					JOptionPane.showMessageDialog(null, "Client updated");
					
				}
				else
				{
					JOptionPane.showMessageDialog(null, "client not updated");
				}
			}
		}
		catch(SQLException e) {
			JOptionPane.showMessageDialog(null,"erreur systeme "+e);
		}
		
	}
public void modifierClientN(Client c) {
		
		try {
			
				PreparedStatement ps=conn.prepareStatement("update nmembre set nom=? ,prenom=? ,tel=? ,ville=? ,email=?  where ID=?");
			
				ps.setString(1, c.getNom());
			
				ps.setString(2, c.getPrenom());
			
				ps.setString(3, c.getTelephone());
				
				ps.setString(4, c.getVille());
				
				ps.setString(5, c.getEmail());
			
				
				ps.setInt(6, c.getID());
				
				if(ps.executeUpdate()!=0) {
					JOptionPane.showMessageDialog(null,"Client updated");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "client not updated");
				}
			
		}
		catch(SQLException e) {
			JOptionPane.showMessageDialog(null,"erreur systeme "+e);
		}
		
	}
	public Vector<String> ColNom(){
		Vector<String> col= new Vector<String>();
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement("select * from membre ;");
			ResultSet rs=ps.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			for (int i = 1; i <rsmd.getColumnCount(); i++) {
				col.add(rsmd.getColumnName(i));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return col;
	}
	public Vector<Client> ToutClient() {
		Vector<Client> vectC=new Vector<Client>();
		try {
			PreparedStatement ps=conn.prepareStatement("select * from membre ;");
			
			
			ResultSet rs=ps.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			
			while(rs.next())
			{
				vectC.add(new Client(rs.getInt("ID"),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)));
			}
			
			
			
		}
		catch(SQLException e) {
			System.out.println("erreur système "+e);
		}
		
		return vectC;
		
	}
	public Vector<Client> ToutClientNon() {
		Vector<Client> vectC=new Vector<Client>();
		try {
			PreparedStatement ps=conn.prepareStatement("select * from nmembre ;");
			
			
			ResultSet rs=ps.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			
			while(rs.next())
			{
				vectC.add(new Client(rs.getInt("ID"),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)));
			}
			
			
			
		}
		catch(SQLException e) {
			System.out.println("erreur système "+e);
		}
		
		return vectC;
		
	}
	
	public Client rechercherClient(int id) {
	Client c;
	try {
		PreparedStatement ps=conn.prepareStatement("select * from membre where id=?;");
		
		ps.setInt(1, id);
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			c=new Client(rs.getInt("ID"),rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
			
		
		
		
		return c;
		}
		else {
			JOptionPane.showMessageDialog(null, "aucun client corespendant a cette ID ");
		}
		
			
		
	}
	catch(SQLException e) {
	JOptionPane.showMessageDialog(null,"erreur system "+e);
	}
	
	return null;
	
}
	public Client rechercherClientn(int id) {
		Client c;
		try {
			PreparedStatement ps=conn.prepareStatement("select * from nmembre where id=?;");
			
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				c=new Client(rs.getInt("ID"),rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
				
			
			
			
			return c;
			}
			else {
				JOptionPane.showMessageDialog(null, "aucun client corespendant a cette ID ");
			}
			
				
			
		}
		catch(SQLException e) {
		JOptionPane.showMessageDialog(null,"erreur system "+e);
		}
		
		return null;
		
	}
	





	
	
}
	


