package PersistenceModel;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * 审核酒店申请JavaBean
 * */
@Entity
@Table(name="checkapplication")
public class checkapplicationBean implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3611181999304739860L;
	
	@Id
	private int checkID;
	
	private int checkingState;
	private int applyerID;
	private String applyerName;
	private String applyerPhoneNum;
	private int hostelID;
	private String hostelName;
	private String hostelProvince;
	private String hostelCity;
	private String hostelAddress;
	private int singleRoomNum;
	private int standardRoomNum;
	private int suiteRoomNum;
	private String hostelbreifintro;
	public int getCheckID() {
		return checkID;
	}
	public void setCheckID(int checkID) {
		this.checkID = checkID;
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
	public String getApplyerPhoneNum() {
		return applyerPhoneNum;
	}
	public void setApplyerPhoneNum(String applyerPhoneNum) {
		this.applyerPhoneNum = applyerPhoneNum;
	}
	public int getHostelID() {
		return hostelID;
	}
	public void setHostelID(int hostelID) {
		this.hostelID = hostelID;
	}
	public String getHostelName() {
		return hostelName;
	}
	public void setHostelName(String hostelName) {
		this.hostelName = hostelName;
	}
	public String getHostelProvince() {
		return hostelProvince;
	}
	public void setHostelProvince(String hostelProvince) {
		this.hostelProvince = hostelProvince;
	}
	public String getHostelCity() {
		return hostelCity;
	}
	public void setHostelCity(String hostelCity) {
		this.hostelCity = hostelCity;
	}
	public String getHostelAddress() {
		return hostelAddress;
	}
	public void setHostelAddress(String hostelAddress) {
		this.hostelAddress = hostelAddress;
	}
	public int getSingleRoomNum() {
		return singleRoomNum;
	}
	public void setSingleRoomNum(int singleRoomNum) {
		this.singleRoomNum = singleRoomNum;
	}
	public int getStandardRoomNum() {
		return standardRoomNum;
	}
	public void setStandardRoomNum(int standardRoomNum) {
		this.standardRoomNum = standardRoomNum;
	}
	public int getSuiteRoomNum() {
		return suiteRoomNum;
	}
	public void setSuiteRoomNum(int suiteRoomNum) {
		this.suiteRoomNum = suiteRoomNum;
	}
	public String getHostelbreifintro() {
		return hostelbreifintro;
	}
	public void setHostelbreifintro(String hostelbreifintro) {
		this.hostelbreifintro = hostelbreifintro;
	}
	
	
	
	
}
