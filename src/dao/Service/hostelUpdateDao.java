package dao.Service;


/**
 * 
 * 酒店修改信息申请
 * */
public interface hostelUpdateDao {

	/**
	 * 
	 * 申请酒店的方法
	 * 参数：
	 * 申请人ID
	 * 酒店名
	 * 酒店简介
	 * 
	 * */
	public void applyHostel(int applyerID,String hostelName,String hostelbreifintro);
	
}
