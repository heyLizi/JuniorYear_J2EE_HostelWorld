package dao.Service;

import PersistenceModel.hostelBean;

/**
 * 
 * 得到酒店的详细信息的接口
 * */
public interface getHostelInfoDao {

	
	/**
	 * 
	 * 得到酒店的详细信息的方法
	 * */
	public hostelBean getHostelInfo(int hostelID);
	
	
}
