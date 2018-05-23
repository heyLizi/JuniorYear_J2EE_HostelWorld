package dao.Service;

import java.util.List;

import PersistenceModel.manageAccountBean;

/**
 * 
 * 酒店经理结算的类
 * */
public interface settlementDao {

	
	/**
	 * 
	 * 得到酒店的经营
	 * */
	public List<manageAccountBean> getInfo();
	
	
	/**
	 * 结算
	 * */
	public void settlement();
	
}
