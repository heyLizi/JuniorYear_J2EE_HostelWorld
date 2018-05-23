package PersistenceModel;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * 
 * 经理账户JavaBean
 * */
@Entity
@Table(name="manageAccount")
public class manageAccountBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2148070979151832714L;
	
	@Id
	private int hostelID;
	
	
	private double hostelIncome;
	public int getHostelID() {
		return hostelID;
	}
	public void setHostelID(int hostelID) {
		this.hostelID = hostelID;
	}
	public double getHostelIncome() {
		return hostelIncome;
	}
	public void setHostelIncome(double hostelIncome) {
		this.hostelIncome = hostelIncome;
	}
	
	

}
