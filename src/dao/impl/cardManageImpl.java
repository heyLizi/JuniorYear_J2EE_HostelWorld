package dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import PersistenceModel.membershipCardBean;
import dao.Service.cardManageDao;

public class cardManageImpl implements cardManageDao{

	private SessionFactory sessionFactory;
	
	@Override
	public void deleteTheCard(int card) {
		// TODO Auto-generated method stub
		
		Session sess = sessionFactory.openSession();
		
		Transaction tx = sess.beginTransaction();
		
		membershipCardBean mem = (membershipCardBean) sess.load(membershipCardBean.class, card);
		
		sess.delete(mem);
		
		tx.commit();
		sess.close();
		
	}

	@Override
	public void updateCard(int card,String bankAccount) {
		// TODO Auto-generated method stub
		Session sess = sessionFactory.openSession();
		
		Transaction tx = sess.beginTransaction();
		
		membershipCardBean mem = (membershipCardBean) sess.load(membershipCardBean.class, card);
		
		mem.setBankAccount(bankAccount);
		
		sess.flush();
		
		tx.commit();
		
		sess.close();
		
		
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	
}
