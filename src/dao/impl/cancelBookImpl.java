package dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import PersistenceModel.bookHostelBean;
import PersistenceModel.manageAccountBean;
import PersistenceModel.membershipCardBean;
import dao.Service.cancelBookDao;

public class cancelBookImpl implements cancelBookDao{

	private SessionFactory sessionFactory;
	
	@Override
	public void cancelBook(int bookID) {
		// TODO Auto-generated method stub
		
		Session sess = sessionFactory.openSession();
		
		Transaction tx = sess.beginTransaction();
		
		bookHostelBean book = (bookHostelBean) sess.load(bookHostelBean.class, bookID);
		
		int membership = book.getMembershipID();
		int hostelID = book.getHostelID();
		double cost = book.getCost();
		
		sess.delete(book);
		
		tx.commit();
		
		sess.close();
		
		
		Session sess1 = sessionFactory.openSession();
		
		Transaction tx1 = sess1.beginTransaction();
		
		membershipCardBean card = (membershipCardBean) sess1.load(membershipCardBean.class, membership);
		double now = card.getBanlance();
		double cc = cost*getDiscount(card.getAuthority());
		card.setBanlance(now+cc);
		double pay = card.getTotalPay();
		card.setTotalPay(pay-cc);
		card.setAuthority(getAuthority(card.getTotalPay()));
		int credits = card.getCredits();
		card.setCredits(credits-(int)(cost/10));
		
		manageAccountBean man = (manageAccountBean) sess1.load(manageAccountBean.class, hostelID);
		double temp = man.getHostelIncome();
		man.setHostelIncome(temp-cost);
		
		sess1.flush();
		tx1.commit();
		sess1.close();
		
	}
	
	public int getAuthority(double pay){
		if(pay>=10000){
			return 5;
		}else if(pay>=5000){
			return 4;
		}else if(pay>=3000){
			return 3;
		}else if(pay>=1000){
			return 2;
		}else if(pay>=500){
			return 1;
		}
		return 0;
	}
	
	public double getDiscount(int authority){
		switch (authority) {
		case 0:
			return 1;
		case 1:
			return 0.95;
		case 2:
			return 0.9;
		case 3:
			return 0.85;
		case 4:
			return 0.8;
		case 5:
			return 0.75;
		default:
			return 1;
		}
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	

}
