package Traitement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Vector;

import javax.swing.JOptionPane;

public class OperationEmprunter implements InterfaceEmprunter{
	Connection conn=Connexion.getConnection();
	OperationEstDisponible d=new OperationEstDisponible();
	public Vector<Emprunter> afficherCD()
	{
		Vector<Emprunter> info = new Vector<Emprunter>();
		
	try {
		
		PreparedStatement ps=conn.prepareStatement("Select * from memempruntcd ");
		ResultSet res = ps.executeQuery();
	
		while(res.next())
		{
			
		
			info.add(new Emprunter(res.getInt(1),res.getInt(2),res.getInt(3),res.getString(4),res.getString(5),res.getString(6),res.getInt(7)));
			
		}
		return info;
	}
	catch (Exception e) {
		e.printStackTrace();
	}
	return null;
	}
	public Vector<Emprunter> afficherP()
	{
		Vector<Emprunter> info = new Vector<Emprunter>();
		
	try {
		
		PreparedStatement ps=conn.prepareStatement("Select * from memempruntp ");
		ResultSet res = ps.executeQuery();
	
		while(res.next())
		{
			
		
			info.add(new Emprunter(res.getInt(1),res.getInt(2),res.getInt(3),res.getString(4),res.getString(5),res.getString(6),res.getInt(7)));
			
		}
		return info;
	}
	catch (Exception e) {
		e.printStackTrace();
	}
	return null;
	}
	public Vector<Emprunter> afficherLivren()
	{
		Vector<Emprunter> info = new Vector<Emprunter>();
		
	try {
		
		PreparedStatement ps=conn.prepareStatement("Select * from nmemempruntl");
		ResultSet res = ps.executeQuery();
	
		while(res.next())
		{
			
		
			info.add(new Emprunter(res.getInt(1),res.getInt(2),res.getInt(3),res.getString(4),res.getString(5),res.getString(6),res.getInt(7)));
			
		}
		return info;
	}
	catch (Exception e) {
		e.printStackTrace();
	}
	return null;
	}
	public Vector<Emprunter> afficherCDn()
	{
		Vector<Emprunter> info = new Vector<Emprunter>();
		
	try {
		
		PreparedStatement ps=conn.prepareStatement("Select * from nmemempruntcd ");
		ResultSet res = ps.executeQuery();
	
		while(res.next())
		{
			
		
			info.add(new Emprunter(res.getInt(1),res.getInt(2),res.getInt(3),res.getString(4),res.getString(5),res.getString(6),res.getInt(7)));
			
		}
		return info;
	}
	catch (Exception e) {
		e.printStackTrace();
	}
	return null;
	}
	public Vector<Emprunter> afficherPn()
	{
		Vector<Emprunter> info = new Vector<Emprunter>();
		
	try {
		
		PreparedStatement ps=conn.prepareStatement("Select * from nmemempruntp ");
		ResultSet res = ps.executeQuery();
	
		while(res.next())
		{
			
		
			info.add(new Emprunter(res.getInt(1),res.getInt(2),res.getInt(3),res.getString(4),res.getString(5),res.getString(6),res.getInt(7)));
			
		}
		return info;
	}
	catch (Exception e) {
		e.printStackTrace();
	}
	return null;
	}
	public Vector<Emprunter> afficherLivre()
	{
		Vector<Emprunter> info = new Vector<Emprunter>();
		
	try {
		
		PreparedStatement ps=conn.prepareStatement("Select * from memempruntl");
		ResultSet res = ps.executeQuery();
	
		while(res.next())
		{
			
		
			info.add(new Emprunter(res.getInt(1),res.getInt(2),res.getInt(3),res.getString(4),res.getString(5),res.getString(6),res.getInt(7)));
			
		}
		return info;
	}
	catch (Exception e) {
		e.printStackTrace();
	}
	return null;
	}

	/*************************************************************************************************************************/
	/*************************************************************************************************************************/

	public String memberEmpruntLiver(int idExL,int idM,String t,int duree)
	{
		int res=0;
		
		
			
	try {
		
		String sql="INSERT INTO memempruntl(IDExemplaireL,ID,dateEmprunt,Duree,type)"
				+ "values(?,?,NOW(),?,?);";
		PreparedStatement prepState= conn.prepareStatement(sql);
		
		prepState.setInt(1,idExL);
		prepState.setInt(2,idM );
		
		prepState.setInt(3, duree);
		prepState.setString(4,t);
		PreparedStatement pre=conn.prepareStatement("UPDATE exemplairelivre set statu='nDispo' where idExemplaireL=?");
		pre.setInt(1,idExL);
		if(!d.MembreplusDe5(idM)){
			if(d.livreEstDisponible1(idExL)) {
				res=prepState.executeUpdate();
				pre.executeUpdate();
				return ""+res+" ligne(s) affectee(s)";
			}
			else {
				JOptionPane.showMessageDialog(null, "aucun Livre disponible");
			}
			
		}
		else {
			JOptionPane.showMessageDialog(null,"vous avez plus de 5 Resevtion,Louer..");
		}

		 
		
		
		
	}
	catch (Exception e) {
		e.printStackTrace();
	}
		
		return "";	
	}

	/*************************************************************************************************************************/
	/*************************************************************************************************************************/
	
	public String memberReturnLiver(int id,int idE)
	{
		String t="";
		Date date= new Date();
		long time = date.getTime();
		Timestamp sqlDate  = new Timestamp(time);

		
	try {
		PreparedStatement prepState= conn.prepareStatement("update memempruntl set dateRetour=NOW() where ID=? and idExemplaireL=? and dateRetour is null;");
		
		prepState.setInt(1,id );
		prepState.setInt(2,idE );
		PreparedStatement pre=conn.prepareStatement("update exemplairelivre set statu='Dispo' where idExemplaireL=?");
		pre.setInt(1,idE);
		pre.executeUpdate();
		int res=prepState.executeUpdate();
		t=res+" ligne(s) affectee(s)";
	}
	catch (Exception e) {
		JOptionPane.showMessageDialog(null, e);
	}
	return t;
	}

	/*************************************************************************************************************************/
	/*************************************************************************************************************************/
	public String memberEmpruntCD(int idExCD,int idM,String t,int duree)
	{
		String r="";
		Date date= new Date();
		long time = date.getTime();
		Timestamp sqlDate  = new Timestamp(time);
		
		
	try {
		String sql="INSERT INTO memempruntcd(IDExemplaireCD,dateEmprunt,ID,duree,type)"
				+ "values(?,NOW(),?,?,?);";
		PreparedStatement prepState= conn.prepareStatement(sql);
		prepState.setInt(1,idExCD);
		prepState.setInt(2,idM );
		prepState.setInt(3,duree);
		prepState.setString(4,t);
		PreparedStatement prep= conn.prepareStatement("UPDATE exemplairecd set statu='nDispo' where idExemplaireCD=?");
		prep.setInt(1, idExCD);
		if(!d.MembreplusDe5(idM)) {
			if(d.CDEstDisponible(idExCD)) {
				int res=prepState.executeUpdate();
				prep.executeUpdate();
				return r=res+" ligne(s) affectee(s)";
			}
			else JOptionPane.showMessageDialog(null, "aucun CD disponibe");
			
			
		}
		else JOptionPane.showMessageDialog(null,"vous avez plus de 5 Resevtion,Louer..");
		
		
		
	}
	catch (Exception e) {
		JOptionPane.showMessageDialog(null, e);
	}
		
		return r;
	}
	

	/*************************************************************************************************************************/
	/*************************************************************************************************************************/

	
	public int memberReturnCD(int id,int idE)
	{
		int res=0;
		Date date= new Date();
		long time = date.getTime();
		Timestamp sqlDate  = new Timestamp(time);

		
	try {
		PreparedStatement prepState= conn.prepareStatement("update memempruntcd set dateRetour=? where ID=? and idExemplaireCD=? and dateRetour is null;");
		prepState.setTimestamp(1,sqlDate );
		prepState.setInt(2,id );
		prepState.setInt(3,idE );
		PreparedStatement prep= conn.prepareStatement("UPDATE exemplairecd set statu='Dispo' where idExemplaireCD=?");
		prep.setInt(1, idE);
		 res=prepState.executeUpdate();
		 prep.executeUpdate();
		
		
		
	}
	catch (Exception e) {
		e.printStackTrace();
	}
	return res;
	}

	/*************************************************************************************************************************/
	/*************************************************************************************************************************/
	public String memberEmpruntP(int idExP,int idM,String t,int duree)
	{
		String r="";
		Date date= new Date();
		long time = date.getTime();
		Timestamp sqlDate  = new Timestamp(time);
		
		
	try {
		String sql="INSERT INTO memempruntp(idExemolaireP,ID,dateEmprunt,type,duree) values (?,?,NOW(),?,?)";
		PreparedStatement prepState= conn.prepareStatement(sql);
		prepState.setInt(1,idExP);
		prepState.setInt(2,idM );
		
		prepState.setString(3,t);
		prepState.setInt(4, duree);
		
		PreparedStatement pre=conn.prepareStatement("UPDATE exemplaireperiodiquesj set statu='nDispo' where idExemplairep=?");
		pre.setInt(1,idExP);
		if(!d.MembreplusDe5(idM)) {
			if(d.PEstDisponible(idExP)) {
	int res=prepState.executeUpdate();
	pre.executeUpdate();
	r=res+"ligne(s) affectee(s)";
	return r;
		}
else {
	return "aucune Document Disponible";
}
		}else JOptionPane.showMessageDialog(null,"vous avez plus de 5 Resevtion,Louer..");

	}
	catch (Exception e) {
		e.printStackTrace();
	}
		
		return r;
		
	}

	public int memberReturnP(int id,int idE)
	{
		int res=0;
		Date date= new Date();
		long time = date.getTime();
		Timestamp sqlDate  = new Timestamp(time);

		
	try {
		PreparedStatement pre=conn.prepareStatement("UPDATE exemplaireperiodiquesj set statu='Dispo' where idExemplaireP=?");
		pre.setInt(1,idE);
		PreparedStatement prepState= conn.prepareStatement("update memempruntp set dateRetour=? where ID=? and idExemolaireP=? and dateRetour is null;");
		prepState.setTimestamp(1,sqlDate );
		prepState.setInt(2,id );
		prepState.setInt(3,idE );
	   res=prepState.executeUpdate();
	   
	   pre.executeUpdate();
		
	}
	catch (Exception e) {
		e.printStackTrace();
	}
	return res;
	}
	/*************************************************************************************************************************/
	/*************************************************************************************************************************/
	public String nMemberEmpruntLiver(int idExL,int idM,String t ,int duree)
	{

		int res=0;
		
		
		
		try {
			
			String sql="INSERT INTO nmemempruntl(IDExemplaireL,ID,dateEmprunt,Duree,type)"
					+ "values(?,?,NOW(),?,?);";
			PreparedStatement prepState= conn.prepareStatement(sql);
			
			prepState.setInt(1,idExL);
			prepState.setInt(2,idM );
			
			prepState.setInt(3, duree);
			prepState.setString(4,t);
			PreparedStatement pre=conn.prepareStatement("UPDATE exemplairelivre set statu='nDispo' where idExemplaireL=?");
			pre.setInt(1,idExL);
			if(!d.NonMembreplusDe5(idM)) {
				if(d.livreEstDisponible1(idExL)) {
		res=prepState.executeUpdate();
		pre.executeUpdate();
		return ""+res+" ligne(s) affectee(s)";
	}
	else {
		JOptionPane.showMessageDialog(null, "aucun Livre disponible");
	}
			}else JOptionPane.showMessageDialog(null,"vous avez plus de 5 Resevtion,Louer..");
	
			 
			
			
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
			
			return "";	
	}
	
	public String nMemberReturnLiver(int id,int idE)
	{
		
		String t="";
		Date date= new Date();
		long time = date.getTime();
		Timestamp sqlDate  = new Timestamp(time);

		
	try {
		PreparedStatement prepState= conn.prepareStatement("update nmemempruntl set dateRetour=NOW() where ID=? and idExemplaireL=? and dateRetour is null;");
		
		prepState.setInt(1,id );
		prepState.setInt(2,idE );
		PreparedStatement pre=conn.prepareStatement("update exemplairelivre set statu='Dispo' where idExemplaireL=?");
		pre.setInt(1,idE);
		pre.executeUpdate();
		int res=prepState.executeUpdate();
		t=res+" ligne(s) affectee(s)";
	}
	catch (Exception e) {
		JOptionPane.showMessageDialog(null, e);
	}
	return t;
	}


	/*************************************************************************************************************************/
	/*************************************************************************************************************************/
	public String nMemberEmpruntCD(int idExCD,int idM,String t,int duree)
	{
		
		String r="";
		Date date= new Date();
		long time = date.getTime();
		Timestamp sqlDate  = new Timestamp(time);
		
		
	try {
		String sql="INSERT INTO nmemempruntcd(IDExemplaireCD,dateEmprunt,ID,duree,type)"
				+ "values(?,NOW(),?,?,?);";
		PreparedStatement prepState= conn.prepareStatement(sql);
		prepState.setInt(1,idExCD);
		prepState.setInt(2,idM );
		prepState.setInt(3,duree);
		prepState.setString(4,t);
		PreparedStatement prep= conn.prepareStatement("UPDATE exemplairecd set statu='nDispo' where idExemplaireCD=?");
		prep.setInt(1, idExCD);
		if(!d.NonMembreplusDe5(idM)) {
			if(d.CDEstDisponible(idExCD)) {
			int res=prepState.executeUpdate();
			prep.executeUpdate();
			return r=res+" ligne(s) affectee(s)";
		}
		else JOptionPane.showMessageDialog(null, "aucun CD disponibe");
		} else JOptionPane.showMessageDialog(null,"vous avez plus de 5 Resevtion,Louer..");
		
		
		
		
	}
	catch (Exception e) {
		JOptionPane.showMessageDialog(null, e);
	}
		
		return r;
	}
	public int nmemberReturnCD(int id,int idE)
	{
		
		int res=0;
		Date date= new Date();
		long time = date.getTime();
		Timestamp sqlDate  = new Timestamp(time);

		
	try {
		PreparedStatement prepState= conn.prepareStatement("update nmemempruntcd set dateRetour=? where ID=? and idExemplaireCD=? and dateRetour is null;");
		prepState.setTimestamp(1,sqlDate );
		prepState.setInt(2,id );
		prepState.setInt(3,idE );
		PreparedStatement prep= conn.prepareStatement("update exemplairecd set statu='Dispo' where idExemplaireCD=?");
		prep.setInt(1, idE);
		prep.executeUpdate();
		 res=prepState.executeUpdate();
		
		
		
	}
	catch (Exception e) {
		e.printStackTrace();
	}
	return res;
	}
	/*************************************************************************************************************************/
	/*************************************************************************************************************************/
	public String nMemberEmpruntP(int idExP,int idM,String t,int duree)
	{
		
		String r="";
		Date date= new Date();
		long time = date.getTime();
		Timestamp sqlDate  = new Timestamp(time);
		
		
	try {
		String sql="INSERT INTO nmemempruntp(idExemplaireP,ID,dateEmprunt,type,duree)"
				+ "values(?,?,NOW(),?,?);";
		PreparedStatement prepState= conn.prepareStatement(sql);
		prepState.setInt(1,idExP);
		prepState.setInt(2,idM );
		
		prepState.setString(3,t);
		prepState.setInt(4, duree);
		
		PreparedStatement pre=conn.prepareStatement("UPDATE exemplaireperiodiquesj set statu='nDispo' where idExemplairep=?");
		pre.setInt(1,idExP);
		if(!d.NonMembreplusDe5(idM)) {
			if(d.PEstDisponible(idExP)) {
				int res=prepState.executeUpdate();
				pre.executeUpdate();
				r=res+"ligne(s) affectee(s)";
				return r;
					}
			else {
				return "aucune Document Disponible";
			}
		} else JOptionPane.showMessageDialog(null,"vous avez plus de 5 Resevtion,Louer..");

	}
	catch (Exception e) {
		e.printStackTrace();
	}
		
		return r;
	}
	
	public int nMemberReturnP(int id,int idE)
	{
		
		
		int res=0;
		Date date= new Date();
		long time = date.getTime();
		Timestamp sqlDate  = new Timestamp(time);

		
	try {
		PreparedStatement pre=conn.prepareStatement("UPDATE exemplaireperiodiquesj set statu='Dispo' where idExemplaireP=?");
		pre.setInt(1,idE);
		PreparedStatement prepState= conn.prepareStatement("update nmemempruntp set dateRetour=? where ID=? and idExemplaireP=? and dateRetour is null;");
		prepState.setTimestamp(1,sqlDate );
		prepState.setInt(2,id );
		prepState.setInt(3,idE );
	   res=prepState.executeUpdate();
	  
	   pre.executeUpdate();
		
	}
	catch (Exception e) {
		e.printStackTrace();
	}
	return res;
	}
	
	
}
