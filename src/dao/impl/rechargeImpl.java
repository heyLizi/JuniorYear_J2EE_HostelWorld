package dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import PersistenceModel.bankaccountBean;
import PersistenceModel.membershipCardBean;
import dao.Service.rechargeDao;

public class rechargeImpl implements rechargeDao{
	
	private SessionFactory sessionFactory;

	/*
	 * 
	 * 这个地方还要增加一些代码
	 * 就是判断 如果激活态是0那么就要充值1000才能激活
	 * 如果是1 ，那么久判断余额是否大于0，如果大于0就激活
	 * 如果是2，那么什么都不做
	 * 0 = 未激活
	 * 1 = 暂停
	 * 2 = 激活
	 * */
	@Override
	public void recharge(int membershipCardID, double rechargeNum) {
		// TODO Auto-generated method stub
		Session sess = sessionFactory.openSession();
		
		membershipCardBean membership = (membershipCardBean) sess.load(membershipCardBean.class, membershipCardID);
		
		int state = membership.getQualification();
		
		double membershipBalance = membership.getBanlance()+rechargeNum;
		if(state == 0){
			if(rechargeNum>=1000){
				membership.setQualification(2);
			}
		}else if(state == 1){
			if(membershipBalance>=0){
				membership.setQualification(2);
			}
		}
		membership.setBanlance(membershipBalance);
		
		Transaction tx = sess.beginTransaction();
		sess.flush();
		tx.commit();
		sess.close();
//		sessionFactory.close();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
}
