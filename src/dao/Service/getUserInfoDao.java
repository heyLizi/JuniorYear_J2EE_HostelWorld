package dao.Service;

import PersistenceModel.hostelManagerBean;
import PersistenceModel.hostelownerBean;
import PersistenceModel.membershipBean;

/**
 * 
 * 该接口是用来的得到用户的个人信息
 * */
public interface getUserInfoDao {

	/**
	 * 
	 * 得到会员的个人信息
	 * 参数：会员ID
	 * */
	public membershipBean getMember(int ID);
	
	/**
	 * 
	 * 得到店家的个人信息
	 * 参数：店家ID
	 * */
	public hostelownerBean getOwner(int ID);
	
	/**
	 * 
	 * 得到酒店经理的个人信息
	 * 参数：酒店经理ID
	 * 
	 * */
	public hostelManagerBean getManager(String ID);
}
