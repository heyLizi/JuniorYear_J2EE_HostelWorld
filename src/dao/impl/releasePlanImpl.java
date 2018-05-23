package dao.impl;

import java.sql.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import PersistenceModel.releaseInfoBean;
import dao.Service.releasePlanDao;

public class releasePlanImpl implements releasePlanDao{
	
	private SessionFactory sessionFactory;
	private releaseInfoBean releaseInfo;

	@Override
	public boolean isConflict(Date startDate,int hostelID) {
		// TODO Auto-generated method stub
		
		Session sess = sessionFactory.openSession();
		
		Transaction tx = sess.beginTransaction();
		
		List<releaseInfoBean> releaseInfo = sess.createQuery("select r from releaseInfoBean r where "+
		"r.hostelID = ? order by r.endDate desc").setParameter(0, hostelID).list();
		
		if(releaseInfo.size()==0){
			return true;
		}
		
		Date endDate = releaseInfo.get(0).getEndDate();
		
		System.out.println("开始日期"+startDate.toString());
		System.out.println("结束日期"+endDate.toString());
		
		int result = startDate.compareTo(endDate); //把申请的开始日期，和已经发布计划的最后结束日期比较
		
//		System.out.println(releaseInfo.get(0).getEndDate()+"   "+releaseInfo.get(0).getReleaseName()+" 比较大小 "+result);
		
		tx.commit();
		sess.close();
		
		if(result<=0){
			return false;
		}else{
			return true;
		}
	}

	@Override
	public void releasePlan(String releaseName, int hostelID,String hostelName,String hostelProvince,
			String hostelCity,double singleRoom, double standardRoom, double suiteRoom,
			Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		
		Session sess = sessionFactory.openSession();
		
		releaseInfo.setReleaseName(releaseName);
		releaseInfo.setHostelID(hostelID);
		releaseInfo.setHostelName(hostelName);
		releaseInfo.setHostelProvince(hostelProvince);
		releaseInfo.setHostelCity(hostelCity);
		releaseInfo.setSingleRoom(singleRoom);
		releaseInfo.setStandardRoom(standardRoom);
		releaseInfo.setSuiteRoom(suiteRoom);
		releaseInfo.setStartDate(startDate);
		releaseInfo.setEndDate(endDate);
		
		Transaction tx = sess.beginTransaction();
		
		sess.save(releaseInfo);
		
		tx.commit();
		
		sess.close();
		
//		sessionFactory.close();  //这个东西最好别关。。关了就找不到了
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void setReleaseInfo(releaseInfoBean releaseInfo) {
		this.releaseInfo = releaseInfo;
	}
	
	

}
