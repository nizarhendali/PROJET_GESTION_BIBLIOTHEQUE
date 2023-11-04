package Traitement;


import java.sql.*;

import javax.swing.JOptionPane;

public class OperationLogin {
	Connection conn=Connexion.getConnection();
	
	public boolean getUser(String login,String password) {
		
		try {
			PreparedStatement pre= conn.prepareStatement("Select * from bibliothecaire where email=? and motdepasse=? ");
			pre.setString(1, login);
			pre.setString(2, password);
			ResultSet rs=pre.executeQuery();
			if(rs.next()) return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean MotDePasse(String nom ,String prenom,String email,String pass ) {
		
		try {
			PreparedStatement pre =conn.prepareStatement("Select * from bibliothecaire where nom=? and prenom= ? and email=?");
			pre.setString(1, nom);
			pre.setString(2, prenom);
			pre.setString(3, email);
			ResultSet rs=pre.executeQuery();
			if(rs.next()) {
				
				rs.first();
				
				PreparedStatement pre1=conn.prepareStatement("update bibliothecaire set motdepasse=? where ID=?");
				pre1.setString(1, pass);
				pre1.setInt(2,rs.getInt(1));
				if(pre1.executeUpdate() >0)return true;
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e);
		
		}
		
		
		return false;
	}
	

}
