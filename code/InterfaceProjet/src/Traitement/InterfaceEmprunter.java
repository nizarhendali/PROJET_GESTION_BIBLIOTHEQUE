package Traitement;

public interface InterfaceEmprunter {
	 public String memberEmpruntLiver(int idExL,int idM,String t,int dateret);
		public String memberReturnLiver(int id,int idE);
		public String memberEmpruntCD(int idExCD,int idM,String t,int d);
		public int memberReturnCD(int id,int idE);
		public String memberEmpruntP(int idExP,int idM,String t,int d);
		public int memberReturnP(int id,int idE);
		public String nMemberEmpruntLiver(int idExL,int idM,String t,int d);
		public String nMemberReturnLiver(int id,int idE);
		public String nMemberEmpruntCD(int idExCD,int idM,String t,int d);
		public int nmemberReturnCD(int id,int idE);
		public String nMemberEmpruntP(int idExP,int idM,String t,int d);
		public int nMemberReturnP(int id,int idE);
		

}


