package dao.Service;

import java.util.List;

import PersistenceModel.releaseInfoBean;

/**
 * 
 * 得到本酒店的所有计划
 * */
public interface getAllPlanDao {

	/**
	 * 通过酒店ID拿到所有的计划
	 * 
	 * 
	 * */
	public List<releaseInfoBean> getAllPlan(int HostelID);
	
}
