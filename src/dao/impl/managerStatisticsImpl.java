package dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import PersistenceModel.bookHostelBean;
import PersistenceModel.hostelAccountBean;
import PersistenceModel.hostelBean;
import PersistenceModel.manageAccountBean;
import PersistenceModel.membershipCardBean;
import PersistenceModel.roomBean;
import VOModel.hostelInVO;
import VOModel.membershipVO;
import dao.Service.managerStatisticsDao;

public class managerStatisticsImpl implements managerStatisticsDao{
	
	private SessionFactory sessionFactory;

	@Override
	public List<hostelInVO> getHostelIn() {
		// TODO Auto-generated method stub
		
		Session sess = sessionFactory.openSession();
		
		Transaction tx = sess.beginTransaction();
		
		List<hostelBean> list0 = sess.createQuery("select h from hostelBean h").list();
		
		ArrayList<hostelInVO>  result = new ArrayList<hostelInVO>();
		
		for(int i = 0 ; i < list0.size();i++){
			List<roomBean> list1 = sess.createQuery("select r from roomBean r where "+
			"r.roomCategory = ? and r.isCheckin <> ? and r.hostelID = ?").setParameter(0, "singleRoom").setParameter(1, 0).setParameter(2, list0.get(i).getHostelID()).list();
					
			List<roomBean> list2 = sess.createQuery("select r from roomBean r where "+
			"r.roomCategory = ? and r.isCheckin <> ? and r.hostelID = ?").setParameter(0, "standardRoom").setParameter(1, 0).setParameter(2, list0.get(i).getHostelID()).list();
					
			List<roomBean> list3 = sess.createQuery("select r from roomBean r where "+
			"r.roomCategory = ? and r.isCheckin <> ? and r.hostelID = ?").setParameter(0, "suiteRoom").setParameter(1, 0).setParameter(2, list0.get(i).getHostelID()).list();
			
			hostelAccountBean hos = (hostelAccountBean) sess.load(hostelAccountBean.class, list0.get(i).getHostelID());
			
			hostelInVO h = new hostelInVO();
			h.setHostelID(hos.getHostelID());
			h.setSingle(list1.size());
			h.setStandard(list2.size());
			h.setSuite(list3.size());
			h.setBalance(hos.getHostelBalance());
			
			result.add(h);
		}
		
		
		tx.commit();
		sess.close();

		
		return result;
	}

	@Override
	public List<membershipVO> getMembership() {
		// TODO Auto-generated method stub
		
		Session sess = sessionFactory.openSession();
		
		Transaction tx = sess.beginTransaction();
		
		List<membershipCardBean> list0 = sess.createQuery("select m from membershipCardBean m").list();
		
		ArrayList<membershipVO> result = new ArrayList<membershipVO>();
		
		for(int i =0;i<list0.size();i++){
			List<bookHostelBean> list1 = sess.createQuery("select b from bookHostelBean b where "+
		"b.membershipID = ?").setParameter(0, list0.get(i).getMembershipID()).list();
			
			membershipVO temp = new membershipVO();
			
			temp.setMemberID(list0.get(i).getMembershipID());
			temp.setAllBook(list1.size());
			temp.setAllPay(list0.get(i).getTotalPay());
			
			result.add(temp);
		}
		
		tx.commit();
		sess.close();
		
		return result;
	}

	@Override
	public double getNowBalance() {
		// TODO Auto-generated method stub
		Session sess = sessionFactory.openSession();
		
		Transaction tx = sess.beginTransaction();
		
		List<manageAccountBean> list = sess.createQuery("select m from manageAccountBean m").list();
		
		double result = 0.0;
		
		for(int i = 0 ; i <list.size();i++){
			result+=list.get(i).getHostelIncome();
		}
		
		
		return result;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	
}
