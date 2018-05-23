package PersistenceModel;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * 
 * 会员JavaBean
 * */
@Entity
@Table(name="membership")
public class membershipBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2973694753085145152L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int membershipID;
	
	
	private String password;
	private int category;
	private String name;
	private String sex;
	private String phoneNum;
	public int getMembershipID() {
		return membershipID;
	}
	public void setMembershipID(int membershipID) {
		this.membershipID = membershipID;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	
	
}
