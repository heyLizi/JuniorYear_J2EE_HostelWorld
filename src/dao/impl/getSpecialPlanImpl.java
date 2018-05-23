package dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import PersistenceModel.releaseInfoBean;
import dao.Service.getSpecialPlanDao;

public class getSpecialPlanImpl implements getSpecialPlanDao{

	private SessionFactory sessionFactory;
	private releaseInfoBean releaseInfo;
	
	@Override
	public releaseInfoBean getSpecialPlan(int planID) {
		// TODO Auto-generated method stub
		
		Session sess = sessionFactory.openSession();
		
		Transaction tx = sess.beginTransaction();
		
		releaseInfoBean re = (releaseInfoBean) sess.load(releaseInfoBean.class, planID);
		
		releaseInfo.setEndDate(re.getEndDate());
		releaseInfo.setHostelCity(re.getHostelCity());
		releaseInfo.setHostelID(re.getHostelID());
		releaseInfo.setHostelName(re.getHostelName());
		releaseInfo.setHostelProvince(re.getHostelProvince());
		releaseInfo.setReleaseID(re.getReleaseID());
		releaseInfo.setReleaseName(re.getReleaseName());
		releaseInfo.setSingleRoom(re.getSingleRoom());
		releaseInfo.setStandardRoom(re.getStandardRoom());
		releaseInfo.setStartDate(re.getStartDate());
		releaseInfo.setSuiteRoom(re.getSuiteRoom());
		
		tx.commit();
		sess.close();
		
		
		return releaseInfo;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void setReleaseInfo(releaseInfoBean releaseInfo) {
		this.releaseInfo = releaseInfo;
	}

	
}
