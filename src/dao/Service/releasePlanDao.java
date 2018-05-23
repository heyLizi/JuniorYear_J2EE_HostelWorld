package dao.Service;

import java.sql.Date;

/**
 * 
 * 作者：yg
 * 该类主要负责  酒店 的发布计划
 * */
public interface releasePlanDao {

	
	/**
	 * 
	 * 该方法主要是判断新发布计划的日期与之前计划日期是否冲突;
	 * 参数为：新发布计划的开始日期
	 * 酒店的ID
	 * */
	public boolean isConflict(Date startDate,int hostelID);
	
	/**
	 * 
	 * 该方法用于计划未冲突时，将计划信息写入数据库中
	 * 参数为：发布名称
	 * 酒店ID
	 * 单间价格
	 * 标间价格
	 * 套件价格
	 * 开始日期（Date）
	 * 结束日期（Date）
	 * */
	public void releasePlan(String releaseName,int hostelID,String hostelName,
			String hostelProvince,String hostelCity,double singleRoom,
			double standardRoom,double suiteRoom,Date startDate,Date endDate);
	
}
