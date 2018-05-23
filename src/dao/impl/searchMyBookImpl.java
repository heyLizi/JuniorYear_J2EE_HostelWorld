package dao.impl;

import java.sql.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import PersistenceModel.bookHostelBean;
import dao.Service.searchMyBookDao;

public class searchMyBookImpl implements searchMyBookDao{

	private SessionFactory sessionFactory;
	
	@Override
	public List<bookHostelBean> getMyBook(int membership, Date currentDate) {
		// TODO Auto-generated method stub
		Session sess = sessionFactory.openSession();
		
		Transaction tx = sess.beginTransaction();
		
		List<bookHostelBean> list = sess.createQuery("select b from bookHostelBean b where "+
		"b.membershipID = ? and b.startDate >= ?").setParameter(0, membership).setParameter(1, currentDate).list();
		
		System.out.println(list.size());
		
		tx.commit();
		sess.close();
		
		return list;
	}
	
	@Override
	public List<bookHostelBean> getHistoryBook(int membership, Date currentDate) {
		// TODO Auto-generated method stub
		Session sess = sessionFactory.openSession();
		
		Transaction tx = sess.beginTransaction();
		
		List<bookHostelBean> list = sess.createQuery("select b from bookHostelBean b where "+
		"b.membershipID = ? and b.endDate <= ?").setParameter(0, membership).setParameter(1, currentDate).list();
		
		System.out.println(list.size());
		
		tx.commit();
		sess.close();
		
		return list;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}



	
	
}
