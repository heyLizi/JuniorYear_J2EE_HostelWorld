package dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import PersistenceModel.membershipCardBean;
import dao.Service.creditsManageDao;

public class creditsManageImpl implements creditsManageDao{

	private SessionFactory sessionFactory;
	
	/*
	 * 查询积分，参数为会员卡ID
	 * 
	 * */
	@Override
	public int checkCredits(int membershipCardID) {
		// TODO Auto-generated method stub
		
		Session sess = sessionFactory.openSession();
		
		membershipCardBean membershipCard = (membershipCardBean) sess.load(membershipCardBean.class, membershipCardID);
		
		int credits = membershipCard.getCredits();
		
		System.out.println("积分是：   "+credits);
		
		sess.close();
		
		return credits;
	}

	
	/*
	 * 兑换积分，参数为会员卡ID
	 * 
	 * */
	@Override
	public void exchangeCredits(int membershipCardID) {
		// TODO Auto-generated method stub
		Session sess = sessionFactory.openSession();
		Transaction tx = sess.beginTransaction();
		
		membershipCardBean membershipCard = (membershipCardBean) sess.load(membershipCardBean.class, membershipCardID);
		
		int credits = membershipCard.getCredits();
		double balance = membershipCard.getBanlance() + credits;
		
		membershipCard.setCredits(0);
		membershipCard.setBanlance(balance);
		
	
		sess.flush();
		tx.commit();
		sess.close();
//		sessionFactory.close();
		
	}


	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	

}
