package Traitement;

import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class Connexion {

	
	private static java.sql.Connection conn;
	
	static {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/bibliothèque_municipale";
		conn = DriverManager.getConnection(url,"root","");
		
		}
		catch(Exception e){ 
			JOptionPane.showMessageDialog(null,"Erreur lors du chargement du Driver:"+e);
			
		}
		
		
	}
	public static java.sql.Connection getConnection()
	{
		return conn;
		
	}
}
