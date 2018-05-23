package dao.impl;

import java.sql.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import PersistenceModel.releaseInfoBean;
import dao.Service.bookSearchDao;

public class bookSearchImpl implements bookSearchDao{

	
	private SessionFactory sessionFactory;
	
	@Override
	public List<releaseInfoBean> getSpecialPlan(String province, String city, Date bookDate) {
		// TODO Auto-generated method stub
		
		Session sess = sessionFactory.openSession();
		
		Transaction tx = sess.beginTransaction();
		
		System.out.println(bookDate.toString());
		
		List<releaseInfoBean> list = sess.createQuery("select r from releaseInfoBean r where "+
		"r.hostelProvince = ? and r.hostelCity = ? and r.startDate <= ? and r.endDate >= ?").setParameter(0, province).setParameter(1, city).setParameter(2, bookDate).setParameter(3, bookDate).list();
		
//		System.out.println(list.size());
		
		tx.commit();
		sess.close();
		
		return list;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	
}
