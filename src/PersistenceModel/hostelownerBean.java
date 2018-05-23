package PersistenceModel;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



/**
 * 
 * 店家JavaBean
 * */
@Entity
@Table(name="hostelowner")
public class hostelownerBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8503051901292263169L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private int hostelownerID;
	
	private String password;
	private int category;
	private String ownerName;
	private String ownerSex;
	private String phoneNum;
	public int getHostelownerID() {
		return hostelownerID;
	}
	public void setHostelownerID(int hostelownerID) {
		this.hostelownerID = hostelownerID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getOwnerSex() {
		return ownerSex;
	}
	public void setOwnerSex(String ownerSex) {
		this.ownerSex = ownerSex;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	
	
	
}
