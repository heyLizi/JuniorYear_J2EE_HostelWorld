package dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import PersistenceModel.hostelManagerBean;
import PersistenceModel.hostelownerBean;
import PersistenceModel.membershipBean;
import dao.Service.loginDao;

public class loginImpl implements loginDao{

	private SessionFactory sessionFactory;
	
	@Override
	public boolean judgeMember(int ID,String password) {
		// TODO Auto-generated method stub
		
		Session sess = sessionFactory.openSession();
		
		Transaction tx = sess.beginTransaction();
		
		membershipBean mem = (membershipBean) sess.load(membershipBean.class, ID);
		
		String pass = mem.getPassword();
		
		tx.commit();
		sess.close();
		
		if(pass.equals(password)){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean judgeOwner(int ID,String password) {
		// TODO Auto-generated method stub
		Session sess = sessionFactory.openSession();
		
		Transaction tx = sess.beginTransaction();
		
		hostelownerBean hos = (hostelownerBean) sess.load(hostelownerBean.class, ID);
		
		String pass = hos.getPassword();
		
		tx.commit();
		sess.close();
		
		if(pass.equals(password)){
			return true;
		}else{
			return false;
		}
	}
	
	@Override
	public boolean judgeManager(String ID, String password) {
		// TODO Auto-generated method stub
		Session sess = sessionFactory.openSession();
		
		Transaction tx = sess.beginTransaction();
		
		hostelManagerBean man = (hostelManagerBean) sess.load(hostelManagerBean.class, ID);
		
		String pass = man.getManagerPassword();
		
		tx.commit();
		sess.close();
		
		if(pass.equals(password)){
			return true;
		}else{
			return false;
		}
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	
	

}
