package dao.impl;

import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import PersistenceModel.bookHostelBean;
import PersistenceModel.hostelAccountBean;
import PersistenceModel.inAndoutBean;
import PersistenceModel.roomBean;
import dao.Service.inORoutDao;

public class inORoutImpl implements inORoutDao{

	private SessionFactory sessionFactory;
	private bookHostelBean bookHostel;
	
	@Override
	public int checkin(int hostelID, int membershipID,String roomCategory,Date inDate,Date endDate) {
		// TODO Auto-generated method stub
		
		Session sess = sessionFactory.openSession();
		Transaction tx = sess.beginTransaction();
		List<roomBean> list = sess.createQuery("select r from roomBean r where "+
		"r.hostelID = ? and r.roomCategory = ? and r.isCheckin = 0").setParameter(0, hostelID).setParameter(1, roomCategory).list();
		int roomNom = list.get(0).getRoomID();
		roomBean room = list.get(0);
		room.setIsCheckin(1);
		sess.update(room);
		tx.commit();
		sess.close();
		
		Session sess3 = sessionFactory.openSession();
		Transaction tx2 = sess3.beginTransaction();
		
		Date startDate = inDate;
		
		while(startDate.compareTo(endDate)<=0){
			System.out.println(startDate.toString());
			inAndoutBean inAndout = new inAndoutBean();
			inAndout.setHostelID(hostelID);
			inAndout.setMembershipID(membershipID);
			inAndout.setCheckinDate(startDate);
			inAndout.setRoomID(roomNom);
			sess3.save(inAndout);
			
			startDate = DateAdd(startDate);
		}
		tx2.commit();
		sess3.close();
		
		return roomNom;
	}

	@Override
	public void checkout(int hostelID,int roomID) {
		// TODO Auto-generated method stub
		
		Session sess = sessionFactory.openSession();
		Transaction tx = sess.beginTransaction();
		List<roomBean> list = sess.createQuery("select r from roomBean r where "+
		"r.hostelID = ? and r.roomID = ?").setParameter(0, hostelID).setParameter(1, roomID).list();
		
		roomBean room = list.get(0);
		room.setIsCheckin(0);
		sess.update(room);
		tx.commit();
		sess.close();
		
		
	}
	

	@Override
	public bookHostelBean getBills(int bookID) {
		// TODO Auto-generated method stub
		
		Session sess = sessionFactory.openSession();
		Transaction tx = sess.beginTransaction();
		
		bookHostelBean book = (bookHostelBean) sess.load(bookHostelBean.class, bookID);
		
		bookHostel.setBookID(book.getBookID());
		bookHostel.setBookTime(book.getBookTime());
		bookHostel.setCost(book.getCost());
		bookHostel.setEndDate(book.getEndDate());
		bookHostel.setHostelID(book.getHostelID());
		bookHostel.setMembershipID(book.getMembershipID());
		bookHostel.setRoomCategory(book.getRoomCategory());
		bookHostel.setStartDate(book.getStartDate());
		
		tx.commit();
		sess.close();
		
		return bookHostel;
	}
	
	@Override
	public int noneMemberCheckin(int hostelID,String roomCategory,double cost) {
		// TODO Auto-generated method stub
		
		Session sess = sessionFactory.openSession();
		Transaction tx = sess.beginTransaction();
		List<roomBean> list = sess.createQuery("select r from roomBean r where "+
		"r.hostelID = ? and r.roomCategory = ? and r.isCheckin = 0").setParameter(0, hostelID).setParameter(1, roomCategory).list();
		int roomNom = list.get(0).getRoomID();
		roomBean room = list.get(0);
		room.setIsCheckin(2);
		sess.update(room);
		
		hostelAccountBean hos = (hostelAccountBean) sess.load(hostelAccountBean.class, hostelID);	
		double temp = hos.getHostelBalance();
		hos.setHostelBalance(temp+cost);
		sess.update(hos);
				
		tx.commit();
		sess.close();
		
		
		return roomNom;
	}
	
	

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public void setBookHostel(bookHostelBean bookHostel) {
		this.bookHostel = bookHostel;
	}

	public Date DateAdd(Date date){
		
		Calendar   calendar   =   new   GregorianCalendar();
		calendar.setTime(date);
		calendar.add(calendar.DATE, 1);
		java.util.Date temp = calendar.getTime();
		
		java.sql.Date result = new Date(temp.getTime());
		
		return result;
	}



}
