package dao.impl;


import java.sql.Date;
import java.util.Calendar;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import PersistenceModel.membershipCardBean;
import dao.Service.membershipCardDao;

public class membershipCardImpl implements membershipCardDao{
	
	private SessionFactory sessionFactory;
	private membershipCardBean membershipCard;

	@Override
	public void signUpCard(int membershipID, String bankAccount) {
		// TODO Auto-generated method stub
		Date date = new Date(System.currentTimeMillis());
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.YEAR, 1);
		Date date1 = new Date(c.getTimeInMillis());
		
		membershipCard.setMembershipID(membershipID);
		membershipCard.setQualification(0);
		membershipCard.setBankAccount(bankAccount);
		membershipCard.setBanlance(0.0);
		membershipCard.setStartDate(date);
		membershipCard.setEndDate(date1);
		membershipCard.setTotalPay(0.0);
		membershipCard.setAuthority(0);
		membershipCard.setCredits(0);
		
		Session sess = sessionFactory.openSession();
		
		Transaction tx = sess.beginTransaction();
		
		sess.save(membershipCard);
		
		tx.commit();

		sess.close();
		
//		sessionFactory.close();
		
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void setMembershipCard(membershipCardBean membershipCard) {
		this.membershipCard = membershipCard;
	}
	
	

}
