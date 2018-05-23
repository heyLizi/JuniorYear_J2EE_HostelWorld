package dao.Service;


/**
 * 
 * 会员卡管理
 * 包括  取消资格 和 修改卡信息（银行账号）
 * */
public interface cardManageDao {
	
	public void deleteTheCard(int card);
	
	public void updateCard(int card,String bankAccount);

}
