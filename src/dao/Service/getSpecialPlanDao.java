package dao.Service;

import PersistenceModel.releaseInfoBean;

/**
 * 
 * 通过计划编号得到具体的计划
 * */
public interface getSpecialPlanDao {

	
	public releaseInfoBean getSpecialPlan(int planID);
	
}
