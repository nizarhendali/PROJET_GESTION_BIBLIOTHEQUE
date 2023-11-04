package Traitement;
import java.sql.*;
import java.util.Vector;

import javax.swing.JOptionPane;

public class OperationAmende {
	
	public static void main(String []args) {
		OperationAmende o= new OperationAmende();
		
	}
	Connection conn=Connexion.getConnection();
	
	public Vector<Object> amendMemberLivre(int id,int idE)
	{
		Vector<Object> info =new Vector<Object>();
		
	
		Date date;
		int amendFD=0,amendR=0;
		try {
			
			PreparedStatement ps0=conn.prepareStatement("select DATEDIFF(now(),dateEmprunt),Duree,dateEmprunt,now() from memempruntl \r\n"
					+ "where ID=? and idExemplaireL=?  and dateRetour is null and type='location'\r\n"
					+ "");
			ps0.setInt(1,id);
			ps0.setInt(2,idE);
			ResultSet res0=ps0.executeQuery();
			int d=0;
			int x=0;
			if(res0.next())
			{res0.first();
			if(res0.getInt(2)>res0.getInt(1)) {x=0; d=res0.getInt(1);}
			else {x=res0.getInt(1)-res0.getInt(2);d=res0.getInt(2);}
		
			 //JOptionPane.showMessageDialog(null, "Vous Devez payer "+d*5+" DH. Et aussi "+x*10+" DH. Pour le retard du "+(res0.getInt(1)-res0.getInt(2)+"\n JOURS"));	
			PreparedStatement ps=conn.prepareStatement("select nom , prenom from membre where ID=?");
				ps.setInt(1, id);
				ResultSet rs=ps.executeQuery();
				rs.next();
				info.add(rs.getString(1));
				info.add(rs.getString(2));
				PreparedStatement ps1=conn.prepareStatement("select idLivres from exemplairelivre where idExemplaireL=?");
				ps1.setInt(1, idE);
				ResultSet rs1=ps1.executeQuery();
				rs1.next();
				PreparedStatement ps2=conn.prepareStatement("select titre from livres where idLivres=?");
				ps2.setInt(1, rs1.getInt(1));
				ResultSet rs2=ps2.executeQuery();
				rs2.next();
				info.add(rs2.getString(1));
				info.add(x);
				info.add(d);
				info.add(res0.getString(3));
				info.add(res0.getString(4));
				
			
				return info	;
			}
			
			
			
			
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public Vector<Object> amendMemberCD(int id,int idE)
	{
		Vector<Object> info =new Vector<Object>();
		
	
		Date date;
		int amendFD=0,amendR=0;
		try {
			
			PreparedStatement ps0=conn.prepareStatement("select DATEDIFF(now(),dateEmprunt),Duree,dateEmprunt,now() from memempruntcd \r\n"
					+ "where ID=? and idExemplaireCD=?  and dateRetour is null and type='location'\r\n"
					+ "");
			ps0.setInt(1,id);
			ps0.setInt(2,idE);
			ResultSet res0=ps0.executeQuery();
			int d=0;
			int x=0;
			if(res0.next())
			{res0.first();
			if(res0.getInt(2)>res0.getInt(1)) {x=0; d=res0.getInt(1);}
			else {x=res0.getInt(1)-res0.getInt(2);d=res0.getInt(2);}
		
			 //JOptionPane.showMessageDialog(null, "Vous Devez payer "+d*5+" DH. Et aussi "+x*10+" DH. Pour le retard du "+(res0.getInt(1)-res0.getInt(2)+"\n JOURS"));	
			PreparedStatement ps=conn.prepareStatement("select nom , prenom from membre where ID=?");
				ps.setInt(1, id);
				ResultSet rs=ps.executeQuery();
				rs.next();
				info.add(rs.getString(1));
				info.add(rs.getString(2));
				PreparedStatement ps1=conn.prepareStatement("select idCD from exemplairecd where idExemplaireCD=?");
				ps1.setInt(1, idE);
				ResultSet rs1=ps1.executeQuery();
				rs1.next();
				PreparedStatement ps2=conn.prepareStatement("select titre from disquecompact where idCD=?");
				ps2.setInt(1, rs1.getInt(1));
				ResultSet rs2=ps2.executeQuery();
				rs2.next();
				info.add(rs2.getString(1));
				info.add(x);
				info.add(d);
				info.add(res0.getString(3));
				info.add(res0.getString(4));
				
			
				return info	;
			}
			
			
			
			
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public Vector<Object> amendMemberP(int id,int idE)
	{
		Vector<Object> info =new Vector<Object>();
		
	
		Date date;
		int amendFD=0,amendR=0;
		try {
			
			PreparedStatement ps0=conn.prepareStatement("select DATEDIFF(now(),dateEmprunt),Duree,dateEmprunt,now() from memempruntp \r\n"
					+ "where ID=? and idExemplaireP=?  and dateRetour is null and type='location'\r\n"
					+ "");
			ps0.setInt(1,id);
			ps0.setInt(2,idE);
			ResultSet res0=ps0.executeQuery();
			int d=0;
			int x=0;
			if(res0.next())
			{res0.first();
			if(res0.getInt(2)>res0.getInt(1)) {x=0; d=res0.getInt(1);}
			else {x=res0.getInt(1)-res0.getInt(2);d=res0.getInt(2);}
		
			 //JOptionPane.showMessageDialog(null, "Vous Devez payer "+d*5+" DH. Et aussi "+x*10+" DH. Pour le retard du "+(res0.getInt(1)-res0.getInt(2)+"\n JOURS"));	
			PreparedStatement ps=conn.prepareStatement("select nom , prenom from membre where ID=?");
				ps.setInt(1, id);
				ResultSet rs=ps.executeQuery();
				rs.next();
				info.add(rs.getString(1));
				info.add(rs.getString(2));
				PreparedStatement ps1=conn.prepareStatement("select idp from exemplaireperiodiquesj where idExemplaireP=?");
				ps1.setInt(1, idE);
				ResultSet rs1=ps1.executeQuery();
				rs1.next();
				PreparedStatement ps2=conn.prepareStatement("select titre from periodiquesjournaux where idp=?");
				ps2.setInt(1, rs1.getInt(1));
				ResultSet rs2=ps2.executeQuery();
				rs2.next();
				info.add(rs2.getString(1));
				info.add(x);
				info.add(d);
				info.add(res0.getString(3));
				info.add(res0.getString(4));
				
			
				return info	;
			}
			
			
			
			
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public Vector<Object> amendNonMemberLivre(int id,int idE)
	{
		Vector<Object> info =new Vector<Object>();
		
	
		Date date;
		int amendFD=0,amendR=0;
		try {
			
			PreparedStatement ps0=conn.prepareStatement("select DATEDIFF(now(),dateEmprunt),Duree,dateEmprunt,now() from nmemempruntl \r\n"
					+ "where ID=? and idExemplaireL=?  and dateRetour is null and type='location'\r\n"
					+ "");
			ps0.setInt(1,id);
			ps0.setInt(2,idE);
			ResultSet res0=ps0.executeQuery();
			int d=0;
			int x=0;
			if(res0.next())
			{res0.first();
			if(res0.getInt(2)>res0.getInt(1)) {x=0; d=res0.getInt(1);}
			else {x=res0.getInt(1)-res0.getInt(2);d=res0.getInt(2);}
		
			 //JOptionPane.showMessageDialog(null, "Vous Devez payer "+d*5+" DH. Et aussi "+x*10+" DH. Pour le retard du "+(res0.getInt(1)-res0.getInt(2)+"\n JOURS"));	
			PreparedStatement ps=conn.prepareStatement("select nom , prenom from nmembre where ID=?");
				ps.setInt(1, id);
				ResultSet rs=ps.executeQuery();
				rs.next();
				info.add(rs.getString(1));
				info.add(rs.getString(2));
				PreparedStatement ps1=conn.prepareStatement("select idLivres from exemplairelivre where idExemplaireL=?");
				ps1.setInt(1, idE);
				ResultSet rs1=ps1.executeQuery();
				rs1.next();
				PreparedStatement ps2=conn.prepareStatement("select titre from livres where idLivres=?");
				ps2.setInt(1, rs1.getInt(1));
				ResultSet rs2=ps2.executeQuery();
				rs2.next();
				info.add(rs2.getString(1));
				info.add(x);
				info.add(d);
				info.add(res0.getString(3));
				info.add(res0.getString(4));
				
			
				return info	;
			}
			
			
			
			
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public Vector<Object> amendNonMemberCD(int id,int idE)
	{
		Vector<Object> info =new Vector<Object>();
		
	
		Date date;
		int amendFD=0,amendR=0;
		try {
			
			PreparedStatement ps0=conn.prepareStatement("select DATEDIFF(now(),dateEmprunt),Duree,dateEmprunt,now() from nmemempruntcd \r\n"
					+ "where ID=? and idExemplaireCD=?  and dateRetour is null and type='location'\r\n"
					+ "");
			ps0.setInt(1,id);
			ps0.setInt(2,idE);
			ResultSet res0=ps0.executeQuery();
			int d=0;
			int x=0;
			if(res0.next())
			{res0.first();
			if(res0.getInt(2)>res0.getInt(1)) {x=0; d=res0.getInt(1);}
			else {x=res0.getInt(1)-res0.getInt(2);d=res0.getInt(2);}
		
			 //JOptionPane.showMessageDialog(null, "Vous Devez payer "+d*5+" DH. Et aussi "+x*10+" DH. Pour le retard du "+(res0.getInt(1)-res0.getInt(2)+"\n JOURS"));	
			PreparedStatement ps=conn.prepareStatement("select nom , prenom from nmembre where ID=?");
				ps.setInt(1, id);
				ResultSet rs=ps.executeQuery();
				rs.next();
				info.add(rs.getString(1));
				info.add(rs.getString(2));
				PreparedStatement ps1=conn.prepareStatement("select idCD from exemplairecd where idExemplaireCD=?");
				ps1.setInt(1, idE);
				ResultSet rs1=ps1.executeQuery();
				rs1.next();
				PreparedStatement ps2=conn.prepareStatement("select titre from disquecompact where idCD=?");
				ps2.setInt(1, rs1.getInt(1));
				ResultSet rs2=ps2.executeQuery();
				rs2.next();
				info.add(rs2.getString(1));
				info.add(x);
				info.add(d);
				info.add(res0.getString(3));
				info.add(res0.getString(4));
				
			
				return info	;
			}
			
			
			
			
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public Vector<Object> amendNonMemberP(int id,int idE)
	{
		Vector<Object> info =new Vector<Object>();
		
	
		Date date;
		int amendFD=0,amendR=0;
		try {
			
			PreparedStatement ps0=conn.prepareStatement("select DATEDIFF(now(),dateEmprunt),Duree,dateEmprunt,now() from nmemempruntp \r\n"
					+ "where ID=? and idExemplaireP=?  and dateRetour is null and type='location'\r\n"
					+ "");
			ps0.setInt(1,id);
			ps0.setInt(2,idE);
			ResultSet res0=ps0.executeQuery();
			int d=0;
			int x=0;
			if(res0.next())
			{res0.first();
			if(res0.getInt(2)>res0.getInt(1)) {x=0; d=res0.getInt(1);}
			else {x=res0.getInt(1)-res0.getInt(2);d=res0.getInt(2);}
		
			 //JOptionPane.showMessageDialog(null, "Vous Devez payer "+d*5+" DH. Et aussi "+x*10+" DH. Pour le retard du "+(res0.getInt(1)-res0.getInt(2)+"\n JOURS"));	
			PreparedStatement ps=conn.prepareStatement("select nom , prenom from nmembre where ID=?");
				ps.setInt(1, id);
				ResultSet rs=ps.executeQuery();
				rs.next();
				info.add(rs.getString(1));
				info.add(rs.getString(2));
				PreparedStatement ps1=conn.prepareStatement("select idp from exemplaireperiodiquesj where idExemplaireP=?");
				ps1.setInt(1, idE);
				ResultSet rs1=ps1.executeQuery();
				rs1.next();
				PreparedStatement ps2=conn.prepareStatement("select titre from periodiquesjournaux where idp=?");
				ps2.setInt(1, rs1.getInt(1));
				ResultSet rs2=ps2.executeQuery();
				rs2.next();
				info.add(rs2.getString(1));
				info.add(x);
				info.add(d);
				info.add(res0.getString(3));
				info.add(res0.getString(4));
				
			
				return info	;
			}
			
			
			
			
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
