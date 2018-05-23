package dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import PersistenceModel.hostelownerBean;
import PersistenceModel.membershipBean;
import dao.Service.signUpDao;

public class signUpImpl implements signUpDao{
	
	private SessionFactory sessionFactory;
	private membershipBean membership;
	private hostelownerBean hostelowner;

	@Override
	public int signUp(int category,String password,String name,String sex,String phoneNum) {
		// TODO Auto-generated method stub
		String ID = "0";
		if(category==0){
			membership.setCategory(category);
			membership.setPassword(password);
			membership.setName(name);
			membership.setSex(sex);
			membership.setPhoneNum(phoneNum);
			
			Session sess = sessionFactory.openSession();
			
			Transaction tx = sess.beginTransaction();
			
			sess.save(membership);
			ID = membership.getMembershipID()+"";
			
			tx.commit();

			sess.close();
			
//			sessionFactory.close();
		}else{
			hostelowner.setCategory(category);
			hostelowner.setPassword(password);
			hostelowner.setOwnerName(name);
			hostelowner.setOwnerSex(sex);
			hostelowner.setPhoneNum(phoneNum);
			
			Session sess = sessionFactory.openSession();
			
			Transaction tx = sess.beginTransaction();
			
			sess.save(hostelowner);
			ID = hostelowner.getHostelownerID()+"";
//			System.out.println("看看能不能拿到这个ID："+hostelowner.getHostelownerID());
			
			tx.commit();

			sess.close();
			
//			sessionFactory.close();
		}
		return Integer.parseInt(ID);
		
	}

	public void setMembership(membershipBean membership) {
		this.membership = membership;
	}

	public void setHostelowner(hostelownerBean hostelowner) {
		this.hostelowner = hostelowner;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	
	
}
