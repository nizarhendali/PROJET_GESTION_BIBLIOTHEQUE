package Traitement;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Vector;

import javax.swing.JOptionPane;


public class OperationDocument implements InterfaceDocument {
	

	
	

		Connection conn=Connexion.getConnection();
		Statement st;
		
		
		public void AjouterLivre(Livre L) {
			int idL=0;
			try
		
			{	
				 
				
				PreparedStatement prepState= conn.prepareStatement("INSERT INTO livres (titre,auteur,categorie,nbrExemplaire)"
						+ "values(?,?,?,?);");
				
				prepState.setString(1,L.getTitre());
				prepState.setString(2,L.getAuteur());
				prepState.setString(3,L.getCategorie());
				prepState.setInt(4,L.getNbreExemplaire());
				int res=prepState.executeUpdate();
				PreparedStatement ps= conn.prepareStatement("select idLivres from livres where titre=?");
				ps.setString(1,L.getTitre());
				ResultSet rs=ps.executeQuery();
				
				if(rs.next())
					
				   idL=rs.getInt(1);
				System.out.println(idL);
				for(int i=0;i<L.getNbreExemplaire();i++) {
				    ajouterExemplaireLivre(idL);
				  //  SupprimerExemplaireLivre(idL);
				
				}
			
			}
		 catch(SQLException e)
			{
			 JOptionPane.showMessageDialog(null, e.getMessage());
			}
		}

		public void ajouterExemplaireLivre(int id) {
			try
			{
				
	            st = conn.createStatement();
	           int r= st.executeUpdate("insert into exemplairelivre (idLivres,statu) values("+id+",'Dispo')");
	           System.out.println(r+" ligne ajouter");
			}
		catch(SQLException e)
			{
				System.out.println(e.getMessage());
			}
			

		}
		
		public void SupprimerExemplaireLivre(int id) {
			try
			{
				
				 
				Statement st= conn.createStatement();
	            int i = st.executeUpdate(" update livres set nbrExemplaire = nbrExemplaire-1 where idLivres ="+id);
	            
	            System.out.println(i+" Supprimer");
			}
		catch(SQLException e)
			{
				System.out.println(e.getMessage());
			}
		
		
		}
		
		
		
		public ResultSet afficherExemplaireL() {
			try 
			{
				
				PreparedStatement ps=conn.prepareStatement("select * from exemplairelivre");
				ResultSet resultat = ps.executeQuery();
				return resultat;
			}
			catch (Exception e) 
			{
				e.printStackTrace();
			}
			return null;
		}


		

		public void SupprimerLivre(int id) {
			
		
			try
			{
				Statement st1=conn.createStatement();
				int j = st1.executeUpdate(" delete from exemplairelivre  where idLivres ="+id);
				Statement st = conn.createStatement();
	            int i = st.executeUpdate(" delete from livres  where idLivres ="+id);
	        if(i!=0) {
	        	JOptionPane.showMessageDialog(null, "Livre supprimer");
	        }    
	        else {
	        	JOptionPane.showMessageDialog(null, "Livre non supprimer");
	        }
			    
			}
		catch(SQLException e)
			{
				System.out.println(e.getMessage());
			}
		
		
		}

		

		
		


		
		
		

		

		
		

		
		
				
				
				//Selectionner livre ===>> afficher livre ayant id ?
				public ResultSet SelectionnerLIVRE(int id) 
				{
					try
			        {
			       	   
						 
			            Statement st = conn.createStatement();          
			            String req = "select * from livres where IDLivres ="+id;
			            ResultSet resultat = st.executeQuery(req);
			            return resultat;
			            
			        }catch(SQLException exc)
			        {
			       	 System.out.println(exc.getMessage());
			        }
			             
					return null;
			             
					
				}
				
				
				
				
				
				
				//modifier livre
				public void modifierLivre(Livre L) {

					try
					{
						 
						Statement st = conn.createStatement();
						int res = st.executeUpdate("UPDATE  livres SET titre =  '"  +L.getTitre()+"' , auteur = '" + L.getAuteur()+ "', categorie= '" +L.getCategorie() +" ',nbrExemplaire=" + L.getNbreExemplaire()  +" where IDLivres =" + L.getIdLivres()+"");
						if(res!=0) {
							JOptionPane.showMessageDialog(null,"periodique modifier");
							
						}
						else
						{
							JOptionPane.showMessageDialog(null,"periodique non modifier");
						}
					}catch(SQLException e)
					{
						JOptionPane.showMessageDialog(null,e.getMessage());
					}
			          
				}
				
				
			
				public Vector<Livre> afficherTtL() {
					Vector<Livre> livres= new Vector<Livre>();
					
					try {
						
						PreparedStatement ps=conn.prepareStatement("select * from livres order by titre");
						ResultSet res = ps.executeQuery();
						while(res.next()) {
							livres.add(new Livre(res.getString("titre"),res.getString("auteur"),res.getString("categorie"),res.getInt("nbrExemplaire"),res.getInt("idLivres")));//String titre, String auteur, String categorie, int i;
						}
						return livres;
					}
					catch (Exception e) {
					JOptionPane.showMessageDialog(null, e);
					}
					return null;
				}
				
				
				// periodiiiique
				
				
				
				
				public void AjouterPeriodique(Periodique p) {
					int idp=0;
					try
				
					{	
						 
						PreparedStatement ps= conn.prepareStatement("INSERT INTO periodiquesjournaux (titre,DateEdition,periodicite,nbrExemplaire)"
								+ "values(?,?,?,?);");
						
						ps.setString(1,p.getTitre());
						ps.setString(2,p.getDateEdition());
						ps.setString(3,p.getPeriodicite());
						ps.setInt(4,p.getNbreExemplaire());
						int res=ps.executeUpdate();
						PreparedStatement ps1= conn.prepareStatement("select idp from periodiquesjournaux where titre=?");
						ps1.setString(1,p.getTitre());
						ResultSet rs=ps1.executeQuery();
						
						if(rs.next())
						   idp=rs.getInt(1);
						for(int i=0;i<p.getNbreExemplaire();i++) {
						this.ajouterExemplairePeriodique(idp);
						}
					} catch(SQLException e) {
						JOptionPane.showMessageDialog(null,e);
					}
						
				}

				
			
				public void SupprimerPeriodique(int id) {
					try
					{
						
						 
						Statement st = conn.createStatement();
						
			            int i = st.executeUpdate(" update periodiquesjournaux set nbrExemplaire = 0 where idp ="+id);
			            
			            if(i!=0) {
			            	JOptionPane.showMessageDialog(null, "periodique supprimé");
							
						}
						else
						{
							JOptionPane.showMessageDialog(null, "periodique non supprimé");
						}
					   
					}
				catch(SQLException e)
					{
						System.out.println(e.getMessage());
					}
				}

				
				
				
				
				public void ajouterExemplairePeriodique(int id) {
					try
					{
						
						 
			            Statement st = conn.createStatement();
			          int res=  st.executeUpdate("insert into exemplaireperiodiquesj (idp,statu) values("+id+",'Dispo')");
			          if(res!=0) {
							System.out.println("ajout exempl periodique");
							
						}
						else
						{
							System.out.println("periodique non modifier");
						}
					}
				catch(SQLException e)
					{
						System.out.println(e.getMessage());
					}
					
				}
				
				
				
				//Selectionner periodique===>> afficher periodique ayant id ?
				public ResultSet SelectionnerPeriodique(int id) 
				{
					try
			        {
			       	   
						 
			            Statement st = conn.createStatement();          
			            String req = "select * from peridiquesjournaux where idp  ="+id;
			            ResultSet resultat = st.executeQuery(req);
			            return resultat;
			            
			        }catch(SQLException exc)
			        {
			       	 System.out.println(exc.getMessage());
			        }
			             
					return null;
				
				}
				
				
				
				
				
				//supprimer exemplaire periodique
				public void supprimerExemplairePeriodique(int id)
				{
					try
						{
							
							 
							Statement st = conn.createStatement();
							
				            int i = st.executeUpdate(" update peridiquesjournaux set nbrExemplaire = nbrExemplaire-1 where idp ="+id);
				            
				            if(i!=0) {
								System.out.println("periodique modifier");
								
							}
							else
							{
								System.out.println("periodique non modifier");
							}
						    
						}
					catch(SQLException e)
						{
							System.out.println(e.getMessage());
						}
					

				}
				
				
				
				public Vector<Periodique> afficherTtP() {
					Vector<Periodique> pds= new Vector<Periodique>();
					try 
					{
						
						Statement ps=conn.createStatement();
						ResultSet rs = ps.executeQuery("select * from periodiquesjournaux order by titre");//String text,java.sql.Date date ,String text1,int i,int id
						while(rs.next()) {
							SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
							String date = dateFormat.format(rs.getDate("DateEdition"));
							pds.add(new  Periodique(rs.getString("titre"),date,rs.getString("periodicite"),rs.getInt("nbrExemplaire"),rs.getInt("idp")));
						}
						
						return pds;
					}
					catch (Exception e) 
					{
						JOptionPane.showMessageDialog(null, e);
						
					}
					return null;
				}
				
				//modifier periodique
				public void modifierPeriodique(Periodique p) {

					try
					{
						 
						PreparedStatement st = conn.prepareStatement("UPDATE  periodiquesjournaux SET titre = ?, DateEdition = ?, periodicite = ? ,nbrExemplaire = ? where idp=?");
						st.setString(1, p.getTitre());
						st.setString(2,p.getDateEdition());
						st.setString(3, p.getPeriodicite());
						st.setInt(4, p.getNbreExemplaire());
						st.setInt(5, p.getId());
						
					
						
						
						int res = st.executeUpdate();
						
						
						if(res!=0) {
						
							JOptionPane.showMessageDialog(null, "periodique non modifier");	
						}
						else
						{
							JOptionPane.showMessageDialog(null, "periodique non modifier");	
						}
						
					}catch(SQLException e)
					{
						System.out.println(e.getMessage());
					}
			         
				}
						
				
				
				public ResultSet afficherExemplaireP() {
					
					try 
					{
						
						PreparedStatement ps=conn.prepareStatement("select * from exemplaireperiodiquesj");
						ResultSet resultat = ps.executeQuery();
						return resultat;
					}
					catch (Exception e) 
					{
						e.printStackTrace();
					}
					return null;
				}
				
				
				
				
				
				
				
				
				
				
				
				//    cd:
				
				// Supprimer CD
				
							public void  SupprimerCD(int id)
							{
							 try
								{
								 	 
								 Statement st= conn.createStatement();
									
						            int i = st.executeUpdate(" update disquecompact set nbrExemplaire = 0 where idCD ="+id);
						            if(i!=0)
							          {
							        	JOptionPane.showMessageDialog(null, "cd supprimé");
							          }
							          else
							          {
							        	  JOptionPane.showMessageDialog(null, "cd supprimé");
							          }
								}
							 catch(SQLException e)
								{
									System.out.println(e.getMessage());
								}
							}
				
				//Supprimer exemplaire cd
				public void supprimerExemplaireCD(int id)
				{
					try
						{
							
							 
							Statement st = conn.createStatement();
							
				            int i = st.executeUpdate(" update disquecompact set nbrExemplaire = nbrExemplaire-1 where idCD ="+id);
				            if(i!=0)
					          {
					        	  System.out.println("exemplaire supprimé");
					          }
					          else
					          {
					        	  System.out.println("exemplaire non supprimé");
					          }
						}
					catch(SQLException e)
						{
							System.out.println(e.getMessage());
						}
					
					
				}
			    
				
				//Ajouter exemplaire cd
				public void ajouterExemplaireCD(int id)
				{
					try
						{
							
							 
				            Statement st= conn.createStatement();
				          int i=  st.executeUpdate("insert into exemplairecd (idCD,statu) values("+id+",'Dispo')");
				          if(i!=0)
				          {
				        	  System.out.println("ajouté");
				          }
				          else
				          {
				        	  System.out.println(" pas ajouté");
				          }
						   
						}
					catch(SQLException e)
						{
							System.out.println(e.getMessage());
						}
					
					
				}
				
				
				
				//modifier cd
				public void modifierCD(Disquecompact d) {
					try
					{
						 
						
						PreparedStatement st = conn.prepareStatement("UPDATE  disquecompact SET titre = ? , nbrExemplaire= ? , auteur = ? , langue = ? , datePub = ? where idCD = ?");
						
						st.setString(1, d.getTitre());
						st.setInt(2, d.getNbrExp());
						st.setString(3, d.getAuteur());
						st.setString(4, d.getLangue());
						st.setString(5, d.getDatePub());
						st.setInt(6, d.getId());
						
						int a=st.executeUpdate();
						if(a!=0)
						{
							JOptionPane.showMessageDialog(null, "CD est modifier");
						}
						else
						{
							JOptionPane.showMessageDialog(null, "le cd n'est pas modifié");	
						}
						
					}catch(SQLException e)
					{
						System.out.println(e.getMessage());
					}
			          

				}
				
				
				

				//Selectionner disque compact ===>> afficher cd ayant id ?
				public ResultSet SelectionnerCD(int id) 
				{
					try
			        {
			       	   
						 
			            Statement st = conn.createStatement();          
			         ResultSet   resultat = st.executeQuery("select * from disquecompact where idCD  ="+id);
			            return resultat;
			            
			        }catch(SQLException exc)
			        {
			       	 System.out.println(exc.getMessage());
			        }
			             
					return null;
				             
						
					}
				
				public ResultSet afficherExemplaireCD() {
					try 
					{
						
						PreparedStatement ps=conn.prepareStatement("select * from exemplairecd");
						ResultSet resultat = ps.executeQuery();
						return resultat;
					}
					catch (Exception e) 
					{
						e.printStackTrace();
					}
					return null;
				}
				
				
				
				public Vector<Disquecompact> afficherTtCD() {
					Vector<Disquecompact> cds= new Vector<Disquecompact>();
					
					try {
						 
						Statement ps=conn.createStatement();
						ResultSet rs = ps.executeQuery("select * from disquecompact order by titre");
						while(rs.next()) {
							cds.add(new  Disquecompact(rs.getString("titre"),rs.getInt("nbrexemplaire"),rs.getString("auteur"),rs.getString("langue"),rs.getString("datePub"),rs.getInt("idCD")));//String titre, int nbrExp, String auteur, String langue, int datePub,int id)
							
						}
						return cds;
						
					}
					catch (Exception e) {
						JOptionPane.showConfirmDialog(null, e)
						;
					}
					
					return null;
				}

				//Ajouter cd
						public int  AjouterCD(Disquecompact cd)
						{
							int idcd=0;
						     try
								{
						    	 
						    	 	 
						    	 String sql="INSERT INTO disquecompact (titre,nbrExemplaire,auteur,langue,datePub)"
											+ "values(?,?,?,?,?);";
									PreparedStatement prepState= conn.prepareStatement(sql);
									
									prepState.setString(1,cd.getTitre());
									prepState.setInt(2,cd.getNbrExp());
									prepState.setString(3,cd.getAuteur());
									prepState.setString(4,cd.getLangue());
									prepState.setString(5,cd.getDatePub());
									int res=prepState.executeUpdate();
							
									PreparedStatement ps= conn.prepareStatement("select idCD from disquecompact where titre=?");
									ps.setString(1,cd.getTitre());
									ResultSet rs=ps.executeQuery();
									
									if(rs.next())
									   idcd=rs.getInt(1);
									for(int i=0;i<cd.getNbrExp();i++) {
									this.ajouterExemplaireCD(idcd);
									}
									return res;
								}
						     catch(SQLException e)
								{
									System.out.println(e.getMessage());
								}
						     return 0;
						}
						

	}



