package PersistenceModel;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * 会员卡JavaBean
 * */
@Entity
@Table(name="membershipcard")
public class membershipCardBean implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = -3420358189504975572L;
	
	@Id
	private int membershipID;
	
	private int qualification;
	private String bankAccount;
	private double banlance;
	private Date startDate;
	private Date endDate;
	private double totalPay;
	private int authority;
	private int credits;
	public int getMembershipID() {
		return membershipID;
	}
	public void setMembershipID(int membershipID) {
		this.membershipID = membershipID;
	}
	public int getQualification() {
		return qualification;
	}
	public void setQualification(int qualification) {
		this.qualification = qualification;
	}
	public String getBankAccount() {
		return bankAccount;
	}
	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}
	public double getBanlance() {
		return banlance;
	}
	public void setBanlance(double banlance) {
		this.banlance = banlance;
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
	public double getTotalPay() {
		return totalPay;
	}
	public void setTotalPay(double totalPay) {
		this.totalPay = totalPay;
	}
	public int getAuthority() {
		return authority;
	}
	public void setAuthority(int authority) {
		this.authority = authority;
	}
	public int getCredits() {
		return credits;
	}
	public void setCredits(int credits) {
		this.credits = credits;
	}
	
	
	
}
