package dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import PersistenceModel.checkapplicationBean;
import dao.Service.isApplyingDao;

public class isApplyingImpl implements isApplyingDao{

	private SessionFactory sessionFactory;
	
	@Override
	public boolean isApplying(int hostelID) {
		// TODO Auto-generated method stub
		
		Session sess = sessionFactory.openSession();
		
		Transaction tx = sess.beginTransaction();
		
		List<checkapplicationBean> list = sess.createQuery("select c from checkapplicationBean c where "+
		"c.applyerID = ? and checkingState = ?").setParameter(0, hostelID).setParameter(1, 0).list();
		
		tx.commit();
		sess.close();
		
		if(list.size()>0){
			return true;
		}else{
			return false;
		}
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	
}
