package Traitement;

import java.sql.Date;

public class Reservation {
private int id,idex,idcli;
private String titre;
public Reservation(int id, int idex, int idcli, Date dateR, Date dateNo,String t) {
	super();
	this.id = id;
	this.idex = idex;
	this.idcli = idcli;
	this.dateR = dateR;
	this.dateNo = dateNo;
	this.titre=t;
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
 * @return the dateR
 */
public Date getDateR() {
	return dateR;
}
/**
 * @param dateR the dateR to set
 */
public void setDateR(Date dateR) {
	this.dateR = dateR;
}
/**
 * @return the dateNo
 */
public Date getDateNo() {
	return dateNo;
}
/**
 * @param dateNo the dateNo to set
 */
public void setDateNo(Date dateNo) {
	this.dateNo = dateNo;
}
@Override
public String toString() {
	return "Reservation [id=" + id + ", idex=" + idex + ", idcli=" + idcli + ", dateR=" + dateR + ", dateNo=" + dateNo
			+ "]";
}
public String getTitre() {
	return titre;
}
public void setTitre(String titre) {
	this.titre = titre;
}
private Date dateR,dateNo;


}
