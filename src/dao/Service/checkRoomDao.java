package dao.Service;

import java.sql.Date;

/**
 * 
 * 根据Room表来判断所选酒店，对应时间有没有空余房间
 * */
public interface checkRoomDao {

	
	/**
	 * 判断否有空余房间
	 * 参数为：酒店ID，房间种类，当前日期
	 * 返回值：true或者false
	 * */
	public boolean checkRoom(int hostelID,String roomCategory,Date currentDate);
	
	
	/**
	 * 
	 * 判断是否有足够的余额
	 * 参数为：会员卡编号，花费
	 * */
	public boolean checkBalance(int membershipID,double cost);
	
	/**
	 * 
	 * 判断是否有足够的权限去预订酒店
	 * */
	public boolean checkAuth(int membershipID);
}
