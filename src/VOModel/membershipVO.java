package VOModel;

/**
 * 
 * 会员VO，用于将从Dao层拿来的几个表的数据一起传送
 * */
public class membershipVO {

	private int memberID;
	private int allBook;
	private double allPay;
	public int getAllBook() {
		return allBook;
	}
	public void setAllBook(int allBook) {
		this.allBook = allBook;
	}
	public double getAllPay() {
		return allPay;
	}
	public void setAllPay(double allPay) {
		this.allPay = allPay;
	}
	public int getMemberID() {
		return memberID;
	}
	public void setMemberID(int memberID) {
		this.memberID = memberID;
	}
	
	
	
}
