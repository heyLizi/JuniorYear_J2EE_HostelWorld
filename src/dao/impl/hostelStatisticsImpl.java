package dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import PersistenceModel.bookHostelBean;
import PersistenceModel.hostelAccountBean;
import PersistenceModel.roomBean;
import dao.Service.hostelStatisticsDao;

public class hostelStatisticsImpl implements hostelStatisticsDao{

	private SessionFactory sessionFactory;
	
	@Override
	public List<bookHostelBean> getAllBills(int hostelID) {
		// TODO Auto-generated method stub
		
		Session sess = sessionFactory.openSession();
		
		Transaction tx = sess.beginTransaction();
		
		List<bookHostelBean> list = sess.createQuery("select b from bookHostelBean b where "+
		"b.hostelID = ?").setParameter(0, hostelID).list();
		
		tx.commit();
		sess.close();
		
		return list;
	}

	@Override
	public int[] getNowCheckIn(int hostelID) {
		// TODO Auto-generated method stub
		
		Session sess = sessionFactory.openSession();
		
		Transaction tx = sess.beginTransaction();
		
		List<roomBean> list1 = sess.createQuery("select r from roomBean r where "+
		"r.roomCategory = ? and r.isCheckin <> ? and r.hostelID = ?").setParameter(0, "singleRoom").setParameter(1, 0).setParameter(2, hostelID).list();
		
		List<roomBean> list2 = sess.createQuery("select r from roomBean r where "+
		"r.roomCategory = ? and r.isCheckin <> ? and r.hostelID = ?").setParameter(0, "standardRoom").setParameter(1, 0).setParameter(2, hostelID).list();
		
		List<roomBean> list3 = sess.createQuery("select r from roomBean r where "+
		"r.roomCategory = ? and r.isCheckin <> ? and r.hostelID = ?").setParameter(0, "suiteRoom").setParameter(1, 0).setParameter(2, hostelID).list();
		
		int[] result = new int[3];
		
		result[0] = list1.size();
		result[1] = list2.size();
		result[2] = list3.size();
		
		tx.commit();
		sess.close();
		
		return result;
	}

	@Override
	public double getNowBalance(int hostelID) {
		// TODO Auto-generated method stub
		Session sess = sessionFactory.openSession();
		
		Transaction tx = sess.beginTransaction();
		
		hostelAccountBean hos = (hostelAccountBean) sess.load(hostelAccountBean.class, hostelID);
		
		double result = hos.getHostelBalance();
		
		tx.commit();
		
		sess.close();
		
		return result;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	
}
