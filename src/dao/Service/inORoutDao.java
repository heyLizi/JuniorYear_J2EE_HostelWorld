package dao.Service;

import java.sql.Date;

import PersistenceModel.bookHostelBean;

/**
 * 
 * 该类主要是办理入住和离宿业务的类
 * */
public interface inORoutDao {
	
	
	/**
	 * 
	 * 办理入住的业务
	 * 参数为：
	 * 酒店ID
	 * 会员ID
	 * 预订房间类型
	 * 入住日期
	 * 
	 * 
	 * 返回房间号
	 * */
	public int checkin(int hostelID,int membershipID,String roomCategory,Date inDate,Date endDate);
	
	
	/**
	 * 
	 * 办理离宿的业务
	 * 参数为：
	 * 酒店ID
	 * 房间ID
	 * */
	public void checkout(int hostelID,int roomID);
	
	
	/**
	 * 
	 * 得到对应的订单编号的   会员ID
	 * 
	 * */
	public bookHostelBean getBills(int bookID);
	
	
	/**
	 * 
	 * 非会员入住
	 * 
	 * */
	public int noneMemberCheckin(int hostelID,String roomCategory,double cost);
}
