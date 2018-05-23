package dao.Service;


/**
 * 作者：yg
 * 负责积分的查询和积分的兑换
 * 积分兑换为全部兑换
 * 
 * */
public interface creditsManageDao {
	
	
	/**
	 * 查询积分，参数为会员卡编号
	 * */
	public int checkCredits(int membershipCardID);
	
	
	/**
	 * 兑换积分，参数为会员卡编号
	 * */
	public void exchangeCredits(int membershipCardID);

}
