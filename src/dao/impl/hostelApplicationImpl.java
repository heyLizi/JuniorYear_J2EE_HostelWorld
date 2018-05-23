package dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import PersistenceModel.checkapplicationBean;
import PersistenceModel.hostelownerBean;
import PersistenceModel.roomBean;
import dao.Service.hostelApplicationDao;

public class hostelApplicationImpl implements hostelApplicationDao{

	
	private SessionFactory sessionFactory;
	private checkapplicationBean checkapplication;
	
	@Override
	public void applyHostel(int applyerID, String hostelName, String hostelProvince, String hostelCity,
			String hostelAddress, int singleRoomNum, int standardRoomNum, int suiteRoomNum, String hostelbreifintro) {
		// TODO Auto-generated method stub
		
		Session sess1 = sessionFactory.openSession();
		
		hostelownerBean hostelowner = (hostelownerBean) sess1.load(hostelownerBean.class, applyerID);
		String applyerName = hostelowner.getOwnerName();
		String applyerPhoneNum = hostelowner.getPhoneNum();
		
		sess1.close();
		
		checkapplication.setCheckingState(0);
		checkapplication.setApplyerID(applyerID);
		checkapplication.setApplyerName(applyerName);
		checkapplication.setApplyerPhoneNum(applyerPhoneNum);
		checkapplication.setHostelID(applyerID);
		checkapplication.setHostelName(hostelName);
		checkapplication.setHostelProvince(hostelProvince);
		checkapplication.setHostelCity(hostelCity);
		checkapplication.setHostelAddress(hostelAddress);
		checkapplication.setSingleRoomNum(singleRoomNum);
		checkapplication.setStandardRoomNum(standardRoomNum);
		checkapplication.setSuiteRoomNum(suiteRoomNum);
		checkapplication.setHostelbreifintro(hostelbreifintro);
		
		Session sess2 = sessionFactory.openSession();
		
		Transaction tx = sess2.beginTransaction();
//		
		sess2.save(checkapplication);
//		
		tx.commit();
//		
		sess2.close();
//		sessionFactory.close();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void setCheckapplication(checkapplicationBean checkapplication) {
		this.checkapplication = checkapplication;
	}

	
	
}
