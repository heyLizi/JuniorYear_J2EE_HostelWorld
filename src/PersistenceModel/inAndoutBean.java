package PersistenceModel;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



/**
 * 
 * 出入住JavaBean
 * */
@Entity
@Table(name="inandout")
public class inAndoutBean implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1424580264799252986L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int inID;
	
	private int hostelID;
	private int membershipID;
	private Date checkinDate;
	private int roomID;
	public int getInID() {
		return inID;
	}
	public void setInID(int inID) {
		this.inID = inID;
	}
	public int getHostelID() {
		return hostelID;
	}
	public void setHostelID(int hostelID) {
		this.hostelID = hostelID;
	}
	public int getMembershipID() {
		return membershipID;
	}
	public void setMembershipID(int membershipID) {
		this.membershipID = membershipID;
	}
	public Date getCheckinDate() {
		return checkinDate;
	}
	public void setCheckinDate(Date checkinDate) {
		this.checkinDate = checkinDate;
	}
	public int getRoomID() {
		return roomID;
	}
	public void setRoomID(int roomID) {
		this.roomID = roomID;
	}
	
	
	
}
