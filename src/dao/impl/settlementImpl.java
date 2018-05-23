package dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import PersistenceModel.hostelAccountBean;
import PersistenceModel.manageAccountBean;
import dao.Service.settlementDao;

public class settlementImpl implements settlementDao{
	
	private SessionFactory sessionFactory;

	@Override
	public List<manageAccountBean> getInfo() {
		// TODO Auto-generated method stub
		
		
		Session sess = sessionFactory.openSession();
		
		Transaction tx = sess.beginTransaction();
		
		List<manageAccountBean> list = sess.createQuery("select m from manageAccountBean m").list();
		
		tx.commit();
		sess.close();
		
		return list;
	}

	@Override
	public void settlement() {
		// TODO Auto-generated method stub
		
		Session sess = sessionFactory.openSession();
		
		Transaction tx = sess.beginTransaction();
		
		List<manageAccountBean> list = sess.createQuery("select m from manageAccountBean m").list();
		
		for(int i = 0;i<list.size();i++){
			hostelAccountBean hos = (hostelAccountBean) sess.load(hostelAccountBean.class, list.get(i).getHostelID());
			double temp = hos.getHostelBalance();
			hos.setHostelBalance(temp+list.get(i).getHostelIncome());
			list.get(i).setHostelIncome(0.0);
		}
		
		sess.flush();
		tx.commit();
		sess.close();
		
		
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	
}
