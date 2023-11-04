package Traitement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
//import java.util.Scanner;
import java.util.Date;
public class OperationConsultation  {

	Connection conn=Connexion.getConnection();
	//EstDisponible d=new EstDisponible();
	public void afficher()
	{
	try {
		
		PreparedStatement ps=conn.prepareStatement("select * from livres");
		ResultSet res = ps.executeQuery();
		while(res.next())
		{
			System.out.println(res.getInt(1)+" "+res.getString(2)+""+res.getString(3)+" "+res.getString(4)+""+res.getInt(5));
		}
	}
	catch (Exception e) {
		e.printStackTrace();
	}
	}

	/*************************************************************************************************************************/
	/*************************************************************************************************************************/

	public String memberEmpruntLiver(int idExL,int idM,String t)
	{
		int res=0;
		Date date= new Date();
		long time = date.getTime();
		Timestamp sqlDate  = new Timestamp(time);
		
			
	try {
		String sql="INSERT INTO memempruntl(IDExemplaireL,ID,dateEmprunt,type)"
				+ "values(?,?,?,?);";
		PreparedStatement prepState= conn.prepareStatement(sql);
		
		prepState.setInt(1,idExL);
		prepState.setInt(2,idM );
		prepState.setTimestamp(3,sqlDate );
		prepState.setString(4,t);

		 res=prepState.executeUpdate();
		
		
		
	}
	catch (Exception e) {
		e.printStackTrace();
	}
		
		return ""+res+" ligne(s) affectee(s)";	
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
		PreparedStatement prepState= conn.prepareStatement("update memempruntl set dateRetour=? where ID=? and idExemplaireL=? and dateRetour is null;");
		prepState.setTimestamp(1,sqlDate );
		prepState.setInt(2,id );
		prepState.setInt(3,idE );
		int res=prepState.executeUpdate();
		t=res+" ligne(s) affectee(s)";
	}
	catch (Exception e) {
		e.printStackTrace();
	}
	return t;
	}

	/*************************************************************************************************************************/
	/*************************************************************************************************************************/
	public String memberEmpruntCD(int idExCD,int idM,String t)
	{
		String r="";
		Date date= new Date();
		long time = date.getTime();
		Timestamp sqlDate  = new Timestamp(time);
		if(t.equalsIgnoreCase("location") )
		{
		
	try {
		String sql="INSERT INTO memempruntcd(IDExemplaireCD,ID,dateEmprunt,type)"
				+ "values(?,?,?,?);";
		PreparedStatement prepState= conn.prepareStatement(sql);
		prepState.setInt(1,idExCD);
		prepState.setInt(2,idM );
		prepState.setTimestamp(3,sqlDate );
		prepState.setString(4,"Location");
		
		int res=prepState.executeUpdate();
		r=res+" ligne(s) affectee(s)";
		
		
	}
	catch (Exception e) {
		e.printStackTrace();
	}
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
		 res=prepState.executeUpdate();
		
		
		
	}
	catch (Exception e) {
		e.printStackTrace();
	}
	return res;
	}

	/*************************************************************************************************************************/
	/*************************************************************************************************************************/
	public String memberEmpruntP(int idExP,int idM,String t)
	{
		String r="";
		Date date= new Date();
		long time = date.getTime();
		Timestamp sqlDate  = new Timestamp(time);
		if(t.equalsIgnoreCase("consultationsurplace") )
		{
		
	try {
		String sql="INSERT INTO memempruntp(IDExemolaireP,ID,dateEmprunt,type)"
				+ "values(?,?,?,?);";
		PreparedStatement prepState= conn.prepareStatement(sql);
		prepState.setInt(1,idExP);
		prepState.setInt(2,idM );
		prepState.setTimestamp(3,sqlDate );
		prepState.setString(4,"ConsultationSurPlace");
		
		int res=prepState.executeUpdate();
		r=res+"ligne(s) affectee(s)";
		
		
		
	}
	catch (Exception e) {
		e.printStackTrace();
	}
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
		PreparedStatement prepState= conn.prepareStatement("update memempruntp set dateRetour=? where ID=? and idExemolaireP=? and dateRetour is null;");
		prepState.setTimestamp(1,sqlDate );
		prepState.setInt(2,id );
		prepState.setInt(3,idE );
	   res=prepState.executeUpdate();
		
	}
	catch (Exception e) {
		e.printStackTrace();
	}
	return res;
	}
	/*************************************************************************************************************************/
	/*************************************************************************************************************************/
	public void nMemberEmpruntLiver(int idExL,int idM,String t)
	{

	Date date= new Date();
	long time = date.getTime();
	Timestamp sqlDate  = new Timestamp(time);


	try {
	String sql="INSERT INTO nmemempruntl(IDExemplaireL,ID,dateEmprunt,type)"
	+ "values(?,?,?,?);";
	PreparedStatement prepState= conn.prepareStatement(sql);
	prepState.setInt(1,idExL);
	prepState.setInt(2,idM );
	prepState.setTimestamp(3,sqlDate );
	prepState.setString(4,t);



	int res=prepState.executeUpdate();
	System.out.println(""+res+" ligne affectee");


	}
	catch (Exception e) {
	e.printStackTrace();
	}

	}
	
	public void nMemberReturnLiver(int id,int idE)
	{
		
		Date date= new Date();
		long time = date.getTime();
		Timestamp sqlDate  = new Timestamp(time);

		
	try {
		PreparedStatement prepState= conn.prepareStatement("update nmemempruntl set dateRetour=? where ID=? and idExemplaireL=? and dateRetour is null;");
		prepState.setTimestamp(1,sqlDate );
		prepState.setInt(2,id );
		prepState.setInt(3,idE );
		int res=prepState.executeUpdate();
		System.out.println(""+res+" ligne(s) affectee(s)");
		
		
	}
	catch (Exception e) {
		e.printStackTrace();
	}
	}


	/*************************************************************************************************************************/
	/*************************************************************************************************************************/
	public void nMemberEmpruntCD(int idExCD,int idM,String t)
	{
		
		Date date= new Date();
		long time = date.getTime();
		Timestamp sqlDate  = new Timestamp(time);
		if(t.equalsIgnoreCase("location") )
		{
		
	try {
		String sql="INSERT INTO nmemempruntcd(IDExemplaireCD,ID,dateEmprunt,type)"
				+ "values(?,?,?,?);";
		PreparedStatement prepState= conn.prepareStatement(sql);
		prepState.setInt(1,idExCD);
		prepState.setInt(2,idM );
		prepState.setTimestamp(3,sqlDate );
		prepState.setString(4,"Location");
		
		int res=prepState.executeUpdate();
		System.out.println(""+res+" ligne(s) affectee(s)");
		
		
	}
	catch (Exception e) {
		e.printStackTrace();
	}
		}
		else
			System.out.println("non Disponible");
	}
	public void nmemberReturnCD(int id,int idE)
	{
		
		Date date= new Date();
		long time = date.getTime();
		Timestamp sqlDate  = new Timestamp(time);

		
	try {
		PreparedStatement prepState= conn.prepareStatement("update nmemempruntcd set dateRetour=? where ID=? and idExemplaireCD=? and dateRetour is null;");
		prepState.setTimestamp(1,sqlDate );
		prepState.setInt(2,id );
		prepState.setInt(3,idE );
		int res=prepState.executeUpdate();
		System.out.println(""+res+" ligne(s) affectee(s)");
		
		
	}
	catch (Exception e) {
		e.printStackTrace();
	}
	}
	/*************************************************************************************************************************/
	/*************************************************************************************************************************/
	public void nMemberEmpruntP(int idExP,int idM,String t)
	{
		
		Date date= new Date();
		long time = date.getTime();
		Timestamp sqlDate  = new Timestamp(time);
		if(t.equalsIgnoreCase("consultationsurplace") )
		{
		
	try {
		String sql="INSERT INTO nmemempruntp(IDExemplaireP,ID,dateEmprunt,type)"
				+ "values(?,?,?,?);";
		PreparedStatement prepState= conn.prepareStatement(sql);
	
		prepState.setInt(1,idExP);
		prepState.setInt(2,idM );
		prepState.setTimestamp(3,sqlDate );
		prepState.setString(4,"ConsultationSurPlace");
		
		int res=prepState.executeUpdate();
		System.out.println(""+res+" ligne(s) affectee(s)");
		
		
	}
	catch (Exception e) {
		e.printStackTrace();
	}
		}
		else
			System.out.println("non Disponible");
	}
	
	public void nMemberReturnP(int id,int idE)
	{
		
		Date date= new Date();
		long time = date.getTime();
		Timestamp sqlDate  = new Timestamp(time);

		
	try {
		PreparedStatement prepState= conn.prepareStatement("update nmemempruntp set dateRetour=? where ID=? and idExemplaireP=? and dateRetour is null;");
		prepState.setTimestamp(1,sqlDate );
		prepState.setInt(2,id );
		prepState.setInt(3,idE );
		int res=prepState.executeUpdate();
		System.out.println(""+res+" ligne(s) affectee(s)");
		
		
	}
	catch (Exception e) {
		e.printStackTrace();
	}
	}
}
