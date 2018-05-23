package dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import PersistenceModel.hostelManagerBean;
import PersistenceModel.hostelownerBean;
import PersistenceModel.membershipBean;
import dao.Service.getUserInfoDao;

public class getUserInfoImpl implements getUserInfoDao{
	
	private SessionFactory sessionFactory;
	private membershipBean membership;
	private hostelownerBean hostelowner;
	private hostelManagerBean hostelManager;

	@Override
	public membershipBean getMember(int ID) {
		// TODO Auto-generated method stub
		
		Session sess = sessionFactory.openSession();
		
		Transaction tx = sess.beginTransaction();
		
		membershipBean mem = (membershipBean) sess.load(membershipBean.class, ID);
		
		membership.setMembershipID(mem.getMembershipID());
		membership.setPassword(mem.getPassword());
		membership.setName(mem.getName());
		membership.setSex(mem.getSex());
		membership.setPhoneNum(mem.getPhoneNum());
		membership.setCategory(mem.getCategory());
		tx.commit();
		sess.close();
		
		return membership;
	}

	@Override
	public hostelownerBean getOwner(int ID) {
		// TODO Auto-generated method stub
		
		Session sess = sessionFactory.openSession();
		
		Transaction tx = sess.beginTransaction();
		
		hostelownerBean hos = (hostelownerBean) sess.load(hostelownerBean.class, ID);
		
		hostelowner.setCategory(hos.getCategory());
		hostelowner.setHostelownerID(hos.getHostelownerID());
		hostelowner.setOwnerName(hos.getOwnerName());
		hostelowner.setOwnerSex(hos.getOwnerSex());
		hostelowner.setPassword(hos.getPassword());
		hostelowner.setPhoneNum(hos.getPhoneNum());
		
		tx.commit();
		sess.close();
		
		return hostelowner;
	}
	
	@Override
	public hostelManagerBean getManager(String ID) {
		// TODO Auto-generated method stub
		Session sess = sessionFactory.openSession();
		
		Transaction tx = sess.beginTransaction();
		
		hostelManagerBean man = (hostelManagerBean) sess.load(hostelManagerBean.class, ID);
		hostelManager.setManagerID(man.getManagerID());
		hostelManager.setManagerPassword(man.getManagerPassword());
		hostelManager.setManagerName(man.getManagerName());
		hostelManager.setManagerSex(man.getManagerSex());
		hostelManager.setManagerPhone(man.getManagerPhone());
		hostelManager.setCategory(man.getCategory());
		tx.commit();
		sess.close();
		return hostelManager;
	}
	

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void setMembership(membershipBean membership) {
		this.membership = membership;
	}

	public void setHostelowner(hostelownerBean hostelowner) {
		this.hostelowner = hostelowner;
	}

	public void setHostelManager(hostelManagerBean hostelManager) {
		this.hostelManager = hostelManager;
	}


	

}
