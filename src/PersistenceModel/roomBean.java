package PersistenceModel;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * 房间JavaBean
 * */
@Entity
@Table(name="room")
public class roomBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -37856550807554351L;
	
	@Id
	private int hostelID;
	
	@Id
	private int roomID;
	
	private int isCheckin;
	
	
	private String roomCategory;
	public int getHostelID() {
		return hostelID;
	}
	public void setHostelID(int hostelID) {
		this.hostelID = hostelID;
	}
	public int getRoomID() {
		return roomID;
	}
	public void setRoomID(int roomID) {
		this.roomID = roomID;
	}
	public String getRoomCategory() {
		return roomCategory;
	}
	public void setRoomCategory(String roomCategory) {
		this.roomCategory = roomCategory;
	}
	public int getIsCheckin() {
		return isCheckin;
	}
	public void setIsCheckin(int isCheckin) {
		this.isCheckin = isCheckin;
	}
	
	

	
	
}
