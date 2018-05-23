package dao.Service;

import PersistenceModel.membershipCardBean;

/**
 * 
 * 该接口用于得到会员卡信息
 * */
public interface getCardInfoDao {

	public membershipCardBean getCardInfo(int membershipID);
	
}
