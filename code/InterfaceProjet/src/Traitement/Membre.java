package Traitement;

public class Membre extends Client {
	private boolean isResidant;
	private int fraixInscription;
	
	public Membre(int ID,String nom,String prenom,String tel,String ville,String email )
	{
		super(ID,nom,prenom,tel,ville,email);
		this.setResidant();
		
		this.fraixInscription = 0;
	}

	public boolean isResidant()
	{
		return isResidant;
	}

	public void setResidant() 
	{
		if(getVille().equalsIgnoreCase("settat"))
		{
			this.isResidant = true;
		}
		else
		 this.isResidant = false;
	}

	

	
	
	public int getFraixInscription() 
	{
		return fraixInscription;
	}

	public void setFraixInscription(int fraixInscription) 
	{
		this.fraixInscription = fraixInscription;
	}

	public void affiche()
	{
		System.out.println("Membre = \n id : "+this.getID()+" ,\n nom : "+this.getNom()+" ,\n prenom : "+this.getPrenom()+" ,\n telephone : "+this.getTelephone()+" ,\n ville : "+this.getVille()+" ,\n email : "+this.getEmail()+" ,\n isResidant :"+this.isResidant()+" ,\n fraix d'inscription : "+this.inscriptionMembre()+" .");
	}
	
	public int inscriptionMembre() 
	{
		if(this.isResidant == true)
		{
			this.fraixInscription = 0;
			
		}
		else
		{
			this.fraixInscription = 100;
		}
		return fraixInscription;
		
	}

}
