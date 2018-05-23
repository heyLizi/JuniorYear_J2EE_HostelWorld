package dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Expression;

import PersistenceModel.hostelBean;
import PersistenceModel.hostelUpdateBean;
import dao.Service.checkUpdateDao;

public class ckeckUpdateImpl implements checkUpdateDao{
	
	private SessionFactory sessionFactory;
	private List<hostelUpdateBean> checklist;

	@Override
	public List<hostelUpdateBean> getApplicationList() {
		// TODO Auto-generated method stub
		Session sess = sessionFactory.openSession();
		Criteria criteria = sess.createCriteria(hostelUpdateBean.class);
		criteria.add(Expression.eq("checkingState", 0));
		checklist = criteria.list();
		System.out.println(checklist.get(0).getApplyerName());
		return checklist;
	}

	@Override
	public void checkApplication(int checkID, int result) {
		// TODO Auto-generated method stub
		
		Session sess = sessionFactory.openSession();
		Transaction tx = sess.beginTransaction();
		
		hostelUpdateBean hos = (hostelUpdateBean) sess.load(hostelUpdateBean.class, checkID);
		
		hos.setCheckingState(result);
		if(result==2){
			hostelBean hostel = (hostelBean) sess.load(hostelBean.class, hos.getApplyerID());
			
			hostel.setHostelName(hos.getHostelName());
			hostel.setHostelbreifintro(hos.getHostelbreif());
			
			sess.update(hostel);

		}
		
		sess.flush();
		tx.commit();
		sess.close();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	
}
