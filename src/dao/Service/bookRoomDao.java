package dao.Service;

import java.sql.Date;

/**
 * 
 * 该接口是预订酒店的类
 * */
public interface bookRoomDao {

	
	/**
	 * 
	 * 预订酒店的方法
	 * 参数为：
	 * 预定时间
	 * 会员ID
	 * 酒店ID
	 * 房间类型
	 * 花费
	 * 预订开始日期
	 * 预订结束日期
	 * */
	public void bookRoom(Date bookTime,int membershipID,int hostelID,String roomCategory,double cost,Date startDate,Date endDate);
	
}
