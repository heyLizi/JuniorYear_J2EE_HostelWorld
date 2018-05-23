package dao.Service;

import java.sql.Date;
import java.util.List;

import PersistenceModel.bookHostelBean;

/**
 * 
 * 该接口主要是查询用户自己的预订订单
 * 
 * */
public interface searchMyBookDao {

	
	/**
	 * 
	 * 根据用户的membershipID去的到会员所有的订单
	 * */
	public List<bookHostelBean> getMyBook(int membership,Date currentDate);
	
	
	/**
	 * 
	 * 根据用户的membershipID拿到会员的历史订单
	 * */
	
	public List<bookHostelBean> getHistoryBook(int membership,Date currentDate);
	
	
}
