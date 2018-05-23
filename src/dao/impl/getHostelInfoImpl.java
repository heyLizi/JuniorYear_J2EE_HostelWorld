package dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import PersistenceModel.hostelBean;
import dao.Service.getHostelInfoDao;

public class getHostelInfoImpl implements getHostelInfoDao{

	private SessionFactory sessionFactory;
	private hostelBean hostelInfo;
	
	
	@Override
	public hostelBean getHostelInfo(int hostelID) {
		// TODO Auto-generated method stub
		
		Session sess = sessionFactory.openSession();
		
		Transaction tx = sess.beginTransaction();
		
		try{
			hostelBean hos = (hostelBean) sess.load(hostelBean.class, hostelID);
			
			hostelInfo.setHostelID(hos.getHostelID());
			hostelInfo.setHostelName(hos.getHostelName());
			hostelInfo.setHostelProvince(hos.getHostelProvince());
			hostelInfo.setHostelCity(hos.getHostelCity());
			hostelInfo.setHostelAddress(hos.getHostelAddress());
			hostelInfo.setSingleRoomNum(hos.getSingleRoomNum());
			hostelInfo.setStandardRoomNum(hos.getStandardRoomNum());
			hostelInfo.setSuiteRoomNum(hos.getSuiteRoomNum());
			hostelInfo.setHostelbreifintro(hos.getHostelbreifintro());
		}catch(Exception e){
			hostelInfo.setHostelID(0);
		}
		
		tx.commit();
		sess.close();
		
		
		return hostelInfo;
	}


	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	public void setHostelInfo(hostelBean hostelInfo) {
		this.hostelInfo = hostelInfo;
	}

	
	
}
