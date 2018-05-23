package dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import PersistenceModel.releaseInfoBean;
import dao.Service.getAllPlanDao;

public class getAllPlanImpl implements getAllPlanDao{
	
	private SessionFactory sessionFactory;

	@Override
	public List<releaseInfoBean> getAllPlan(int HostelID) {
		// TODO Auto-generated method stub
		
		Session sess = sessionFactory.openSession();
		
		Transaction tx = sess.beginTransaction();
		
		List<releaseInfoBean> list = sess.createQuery("select r from releaseInfoBean r where "+
		"r.hostelID = ? order by r.endDate desc").setParameter(0, HostelID).list();
		
		tx.commit();
		sess.close();
		
		return list;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	

}
