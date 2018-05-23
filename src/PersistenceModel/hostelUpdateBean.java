package PersistenceModel;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * 
 * 更新酒店JavaBean
 * */
@Entity
@Table(name="hostelUpdate")
public class hostelUpdateBean implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8376906497273023508L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private int updateID;
	
	
	private int checkingState;
	private int applyerID;
	private String applyerName;
	private String hostelName;
	private String hostelbreif;
	public int getUpdateID() {
		return updateID;
	}
	public void setUpdateID(int updateID) {
		this.updateID = updateID;
	}
	public int getCheckingState() {
		return checkingState;
	}
	public void setCheckingState(int checkingState) {
		this.checkingState = checkingState;
	}
	public int getApplyerID() {
		return applyerID;
	}
	public void setApplyerID(int applyerID) {
		this.applyerID = applyerID;
	}
	public String getApplyerName() {
		return applyerName;
	}
	public void setApplyerName(String applyerName) {
		this.applyerName = applyerName;
	}
	public String getHostelName() {
		return hostelName;
	}
	public void setHostelName(String hostelName) {
		this.hostelName = hostelName;
	}
	public String getHostelbreif() {
		return hostelbreif;
	}
	public void setHostelbreif(String hostelbreif) {
		this.hostelbreif = hostelbreif;
	}
	
	
}
