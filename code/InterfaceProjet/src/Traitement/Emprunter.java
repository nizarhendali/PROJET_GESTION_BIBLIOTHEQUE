package Traitement;

public class Emprunter {
	private int id,idex,idcli,duree;
	private String date , datere,type;
	public Emprunter(int id, int idex, int idcli, String date, String datere,String t,int d) {
		super();
		this.id = id;
		this.idex = idex;
		this.idcli = idcli;
		this.date = date;
		this.datere = datere;
		this.type=t;
		this.setDuree(d);
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Emprunter [id=" + id + ", idex=" + idex + ", idcli=" + idcli + ", date=" + date + ", datere=" + datere
				+ ", type=" + type + "]";
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the idex
	 */
	public int getIdex() {
		return idex;
	}
	/**
	 * @param idex the idex to set
	 */
	public void setIdex(int idex) {
		this.idex = idex;
	}
	/**
	 * @return the idcli
	 */
	public int getIdcli() {
		return idcli;
	}
	/**
	 * @param idcli the idcli to set
	 */
	public void setIdcli(int idcli) {
		this.idcli = idcli;
	}
	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}
	/**
	 * @return the datere
	 */
	public String getDatere() {
		return datere;
	}
	/**
	 * @param datere the datere to set
	 */
	public void setDatere(String datere) {
		this.datere = datere;
	}
	public int getDuree() {
		return duree;
	}
	public void setDuree(int duree) {
		this.duree = duree;
	}

}
