package dao.Service;

/**
 * 
 * 作者：yg
 * 申请酒店类
 * 该类将申请信息交于酒店管理员去审核
 * 
 * */
public interface hostelApplicationDao {

	
	/**
	 * 
	 * 申请酒店的方法
	 * 参数：
	 * 申请人ID
	 * 酒店名
	 * 酒店所在省
	 * 酒店所在城市
	 * 酒店所在地址
	 * 酒店单间数量
	 * 酒店标间熟料
	 * 酒店套件数量
	 * 酒店简介
	 * 
	 * */
	public void applyHostel(int applyerID,String hostelName,String hostelProvince,String hostelCity,
			String hostelAddress,int singleRoomNum,int standardRoomNum,int suiteRoomNum,String hostelbreifintro);
	
}
