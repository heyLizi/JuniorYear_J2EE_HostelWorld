package dao.Service;

import java.util.List;

import PersistenceModel.bookHostelBean;

/**
 * 
 * 有关酒店统计信息的类！！！
 * 
 * */
public interface hostelStatisticsDao {

	
	/**
	 * 
	 * 得到酒店所有订单的类
	 * 
	 * */
	public List<bookHostelBean> getAllBills(int hostelID);
	
	/**
	 * 
	 * 当前入住信息
	 * */
	public int[] getNowCheckIn(int hostelID);
	
	
	/**
	 * 
	 * 得到当前酒店的财务信息
	 * */
	public double getNowBalance(int hostelID);
	
}
