package dao.Service;

import java.util.List;

import PersistenceModel.hostelUpdateBean;

/**
 * 
 * 作者：yg
 * 该接口是修改酒店审核接口
 * */
public interface checkUpdateDao {
	
	/**
	 * checking为0时，表示该申请还未审核
	 * 返回一个未审核列表;
	 * */
	public List<hostelUpdateBean> getApplicationList();
	
	
	/**
	 * 
	 * 通过checkID和result来决定到底是审核通过还是不通过
	 * result为1时不通过
	 * result为2时通过
	 * */
	public void checkApplication(int checkID,int result);

}
