package PersistenceModel;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * 发布信息JavaBean
 * */
@Entity
@Table(name="releaseInfo")
public class releaseInfoBean implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3365383535948046650L;
	
	@Id
	private int releaseID;
	
	
	private String releaseName;
	private int hostelID;
	private String hostelName;
	private String hostelProvince;
	private String hostelCity;
	private double singleRoom;
	private double standardRoom;
	private double suiteRoom;
	private Date startDate;
	private Date endDate;
	public int getReleaseID() {
		return releaseID;
	}
	public void setReleaseID(int releaseID) {
		this.releaseID = releaseID;
	}
	public String getReleaseName() {
		return releaseName;
	}
	public void setReleaseName(String releaseName) {
		this.releaseName = releaseName;
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
	public double getSingleRoom() {
		return singleRoom;
	}
	public void setSingleRoom(double singleRoom) {
		this.singleRoom = singleRoom;
	}
	public double getStandardRoom() {
		return standardRoom;
	}
	public void setStandardRoom(double standardRoom) {
		this.standardRoom = standardRoom;
	}
	public double getSuiteRoom() {
		return suiteRoom;
	}
	public void setSuiteRoom(double suiteRoom) {
		this.suiteRoom = suiteRoom;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	
	
}
