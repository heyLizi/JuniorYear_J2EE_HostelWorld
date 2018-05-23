package PersistenceModel;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * 银行账户JavaBean
 * */
@Entity
@Table(name="bankaccount")
public class bankaccountBean implements Serializable{

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1723537854638746614L;
	
	@Id
	private String bankAccount;
	
	private double balance;
	public String getBankAccount() {
		return bankAccount;
	}
	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
	
}
