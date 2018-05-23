package dao.impl;

import java.sql.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import PersistenceModel.bookHostelBean;
import dao.Service.hostelSearchBookDao;

public class hostelSearchBookImpl implements hostelSearchBookDao{

	private SessionFactory sessionFactory;
	
	@Override
	public List<bookHostelBean> getHostelBook(int hostelID, int membershipID) {
		// TODO Auto-generated method stub
		
		Session sess = sessionFactory.openSession();
		
		Transaction tx = sess.beginTransaction();
		
		List<bookHostelBean> list = sess.createQuery("select b from bookHostelBean b where "+
		"b.hostelID = ? and b.membershipID = ? and b.startDate >= ?").setParameter(0, hostelID).setParameter(1, membershipID).setParameter(2, new Date(System.currentTimeMillis())).list();
		
		tx.commit();
		sess.close();
//		System.out.println(list.get(0).getRoomCategory());
		return list;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	
}
