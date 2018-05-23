package dao.Service;

import java.util.List;

import PersistenceModel.checkapplicationBean;

/**
 * 
 * 作者：yg
 * 该接口是审核接口
 * */
public interface checkApplicationDao {

	/**
	 * checking为0时，表示该申请还未审核
	 * 返回一个未审核列表;
	 * */
	public List<checkapplicationBean> getApplicationList();
	
	/**
	 * 
	 * 通过一个checkID拿到对应的 申请酒店的详细信息
	 * */
	public checkapplicationBean getApplicationInfo(int checkID);
	
	
	/**
	 * 
	 * 通过checkID和result来决定到底是审核通过还是不通过
	 * result为1时不通过
	 * result为2时通过
	 * */
	public void checkApplication(int checkID,int result);
}
