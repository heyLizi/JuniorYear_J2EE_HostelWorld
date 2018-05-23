package dao.impl;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import PersistenceModel.bookHostelBean;
import PersistenceModel.manageAccountBean;
import PersistenceModel.membershipCardBean;
import dao.Service.bookRoomDao;

public class bookRoomImpl implements bookRoomDao{

	private SessionFactory sessionFactory;
	private bookHostelBean bookHostel;
	
	@Override
	public void bookRoom(Date bookTime, int membershipID, int hostelID, String roomCategory, double cost,
			Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		
		bookHostel.setBookTime(bookTime);
		bookHostel.setMembershipID(membershipID);
		bookHostel.setHostelID(hostelID);
		bookHostel.setRoomCategory(roomCategory);
		bookHostel.setCost(cost);
		bookHostel.setStartDate(startDate);
		bookHostel.setEndDate(endDate);
		
		
		Session sess = sessionFactory.openSession();
		
		Transaction tx = sess.beginTransaction();
		
		sess.save(bookHostel);
		
		tx.commit();
		
		sess.close();
		
		
		Session sess2 = sessionFactory.openSession();
		Transaction tx2 = sess2.beginTransaction();
		
		membershipCardBean mem = (membershipCardBean) sess2.load(membershipCardBean.class, membershipID);
		int auth = mem.getAuthority();
		double temp = mem.getBanlance();
		double cc = cost*getDiscount(mem.getAuthority());
		mem.setBanlance(temp-cc);
		double pay = mem.getTotalPay();
		mem.setTotalPay(pay+cc);
		mem.setAuthority(getAuthority(mem.getTotalPay()));
		int credits = mem.getCredits();
		mem.setCredits(credits+(int)(cost/10));
		
		manageAccountBean man = (manageAccountBean) sess2.load(manageAccountBean.class, hostelID);
		double temp1 = man.getHostelIncome();
		man.setHostelIncome(temp1+cost);
		
		sess2.flush();
		tx2.commit();
		sess2.close();
		
		
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

	public void setBookHostel(bookHostelBean bookHostel) {
		this.bookHostel = bookHostel;
	}

	
	
}
