package dao.Service;


/**
 * 
 * 该类是用于登录的类
 * */
public interface loginDao {
	
	/**
	 * 
	 * 判断是否有这个会员
	 * */
	public boolean judgeMember(int ID,String password);
	
	/**
	 * 
	 * 判断是否有这个店家
	 * */
	public boolean judgeOwner(int ID,String password);
	
	/**
	 * 
	 * 判断是否有这个经理
	 * */
	public boolean judgeManager(String ID,String password);
	
}
