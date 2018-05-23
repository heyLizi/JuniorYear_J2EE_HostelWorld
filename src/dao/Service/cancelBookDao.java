package dao.Service;


/**
 * 
 * 该接口用户取消用户指定的预订酒店订单
 * */
public interface cancelBookDao {

	/**
	 * 
	 * 用户取消会员预订的订单
	 * */
	public void cancelBook(int bookID);
	
}
