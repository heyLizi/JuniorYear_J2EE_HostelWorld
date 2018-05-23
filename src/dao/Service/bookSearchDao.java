package dao.Service;

import java.sql.Date;
import java.util.List;

import PersistenceModel.releaseInfoBean;

/**
 * 通过地区和日期选择酒店的发布计划
 * */
public interface bookSearchDao {

	
	/**
	 * 拿到对应省市对应日期的计划列表
	 * 
	 * */
	public List<releaseInfoBean> getSpecialPlan(String province,String city,Date bookDate);
	
}
