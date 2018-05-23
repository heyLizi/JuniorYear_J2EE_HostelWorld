package dao.impl;

import java.sql.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import PersistenceModel.bookHostelBean;
import PersistenceModel.hostelBean;
import PersistenceModel.membershipBean;
import PersistenceModel.membershipCardBean;
import dao.Service.checkRoomDao;

public class checkRoomImpl implements checkRoomDao{
	
	private SessionFactory sessionFactory;

	@Override
	public boolean checkRoom(int hostelID, String roomCategory, Date currentDate) {
		// TODO Auto-generated method stub
		Session sess = sessionFactory.openSession();
		
		Transaction tx = sess.beginTransaction();
		
		//这儿还要再加
		List<bookHostelBean> list = sess.createQuery("select b from bookHostelBean b where "+
		"b.hostelID = ? and b.roomCategory = ? and b.startDate <= ? and b.endDate >= ?").setParameter(0, hostelID).setParameter(1, roomCategory).setParameter(2, currentDate).setParameter(3, currentDate).list();
		
		int roomNum = list.size();
		//这是获得当前时间点有多少人订了什么种类的房间的数量
		hostelBean hostel = (hostelBean) sess.load(hostelBean.class, hostelID);
		int roomAll = 0;
		if(roomCategory=="singleRoom"){
			roomAll = hostel.getSingleRoomNum();
		}else if(roomCategory=="standardRoom"){
			roomAll = hostel.getStandardRoomNum();
		}else{
			roomAll = hostel.getSuiteRoomNum();
		}
		
		
		tx.commit();
		sess.close();
		//这里写上比较的代码
		if(roomNum<=roomAll){
			return true;
		}else{
			return false;
		}

	}
	
	@Override
	public boolean checkBalance(int membershipID, double cost) {
		// TODO Auto-generated method stub
		
		Session sess = sessionFactory.openSession();
		
		Transaction tx = sess.beginTransaction();
		
		membershipCardBean card = (membershipCardBean) sess.load(membershipCardBean.class, membershipID);
		
		double balance = card.getBanlance();
		
		tx.commit();
		sess.close();
		
		if(balance<cost){
			return false;
		}
		return true;
	}
	
	@Override
	public boolean checkAuth(int membershipID) {
		// TODO Auto-generated method stub
		Session sess = sessionFactory.openSession();
		
		Transaction tx = sess.beginTransaction();
		
		membershipCardBean card = (membershipCardBean) sess.load(membershipCardBean.class, membershipID);
		
		int au = card.getQualification();
		
		tx.commit();
		sess.close();
		
		if(au==2){
			return true;
		}
		return false;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}




	
}
