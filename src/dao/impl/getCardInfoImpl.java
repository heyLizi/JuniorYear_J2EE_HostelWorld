package dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import PersistenceModel.hostelownerBean;
import PersistenceModel.membershipBean;
import PersistenceModel.membershipCardBean;
import dao.Service.getCardInfoDao;
import dao.Service.getUserInfoDao;

public class getCardInfoImpl implements getCardInfoDao{
	
	private SessionFactory sessionFactory;
	private membershipCardBean membershipCard;



	@Override
	public membershipCardBean getCardInfo(int membershipID) {
		// TODO Auto-generated method stub
		
		Session sess = sessionFactory.openSession();
		
		Transaction tx = sess.beginTransaction();
		
		try{
			membershipCardBean mem = (membershipCardBean) sess.load(membershipCardBean.class, membershipID);
			
			membershipCard.setMembershipID(mem.getMembershipID());
			membershipCard.setQualification(mem.getQualification());
			membershipCard.setBankAccount(mem.getBankAccount());
			membershipCard.setBanlance(mem.getBanlance());
			membershipCard.setStartDate(mem.getStartDate());
			membershipCard.setEndDate(mem.getEndDate());
			membershipCard.setTotalPay(mem.getTotalPay());
			membershipCard.setAuthority(mem.getAuthority());
			membershipCard.setCredits(mem.getCredits());
		}catch(Exception e){
			membershipCard.setMembershipID(0);
		}
		
		tx.commit();
		sess.close();
		
		return membershipCard;
	}
	

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	public void setMembershipCard(membershipCardBean membershipCard) {
		this.membershipCard = membershipCard;
	}


}
