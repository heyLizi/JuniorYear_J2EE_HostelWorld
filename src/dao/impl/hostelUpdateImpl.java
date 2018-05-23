package dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import PersistenceModel.hostelUpdateBean;
import PersistenceModel.hostelownerBean;
import dao.Service.hostelUpdateDao;

public class hostelUpdateImpl implements hostelUpdateDao{
	
	private SessionFactory sessionFactory;
	private hostelUpdateBean hostelUpdate;

	@Override
	public void applyHostel(int applyerID, String hostelName, String hostelbreifintro) {
		// TODO Auto-generated method stub
		
		Session sess1 = sessionFactory.openSession();
		
		hostelownerBean hostelowner = (hostelownerBean) sess1.load(hostelownerBean.class, applyerID);
		
		String applyerName = hostelowner.getOwnerName();
		
		sess1.close();
		
		hostelUpdate.setApplyerID(applyerID);
		hostelUpdate.setCheckingState(0);
		hostelUpdate.setApplyerName(applyerName);
		hostelUpdate.setHostelName(hostelName);
		hostelUpdate.setHostelbreif(hostelbreifintro);
		
		Session sess2 = sessionFactory.openSession();
		
		Transaction tx = sess2.beginTransaction();
		
		sess2.save(hostelUpdate);
		
		tx.commit();
//		
		sess2.close();
		
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void setHostelUpdate(hostelUpdateBean hostelUpdate) {
		this.hostelUpdate = hostelUpdate;
	}

	
	
}
