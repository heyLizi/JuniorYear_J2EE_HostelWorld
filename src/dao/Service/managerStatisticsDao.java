package dao.Service;

import java.util.List;

import VOModel.hostelInVO;
import VOModel.membershipVO;

/**
 * 
 * 酒店经理查看统计信息类
 * */
public interface managerStatisticsDao {

	
	
	public List<hostelInVO> getHostelIn();
	
	
	public List<membershipVO> getMembership();
	
	public double getNowBalance();
}
