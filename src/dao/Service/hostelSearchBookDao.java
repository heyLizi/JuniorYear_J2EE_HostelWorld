package dao.Service;

import java.util.List;

import PersistenceModel.bookHostelBean;

/**
 * 
 * 该类用于 酒店通过酒店ID和会员iD查询到自己酒店的预订订单
 * */
public interface hostelSearchBookDao {

	
	/**
	 * 该方法是得到酒店的特定会员的预订订单
	 * 通过预订订单进行入住手续
	 * 参数：
	 * 酒店ID
	 * 会员ID
	 * 
	 * */
	public List<bookHostelBean> getHostelBook(int hostelID,int membershipID);
	
	
}
