package dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Expression;

import PersistenceModel.checkapplicationBean;
import PersistenceModel.hostelAccountBean;
import PersistenceModel.hostelBean;
import PersistenceModel.manageAccountBean;
import PersistenceModel.roomBean;
import dao.Service.checkApplicationDao;

public class checkApplicationImpl implements checkApplicationDao{

	private SessionFactory sessionFactory;
	private List<checkapplicationBean> checklist;
	private hostelBean hostel;
	private manageAccountBean manageAccount;
	private hostelAccountBean hostelAccount;
	
	@Override
	public List<checkapplicationBean> getApplicationList() {
		// TODO Auto-generated method stub
		
		Session sess = sessionFactory.openSession();
		Criteria criteria = sess.createCriteria(checkapplicationBean.class);
		criteria.add(Expression.eq("checkingState", 0));
		checklist = criteria.list();
		System.out.println(checklist.get(0).getApplyerName());
		return checklist;
	}

	@Override
	public checkapplicationBean getApplicationInfo(int checkID) {
		// TODO Auto-generated method stub
		
		Session sess = sessionFactory.openSession();
		
		checkapplicationBean check = (checkapplicationBean) sess.load(checkapplicationBean.class, checkID);
		System.out.println(check.getApplyerName());
		
		sess.close();
		return check;
	}

	@Override
	public void checkApplication(int checkID, int result) {
		// TODO Auto-generated method stub
		Session sess = sessionFactory.openSession();
		
		checkapplicationBean check = (checkapplicationBean) sess.load(checkapplicationBean.class, checkID);
		
		check.setCheckingState(result);

		Transaction tx = sess.beginTransaction();
		sess.flush();
		tx.commit();
		
		
		int applyerID = check.getApplyerID();
		String hostelName = check.getHostelName();
		String hostelProvince = check.getHostelProvince();
		String hostelCity = check.getHostelCity();
		String hostelAddress = check.getHostelAddress();
		int singleRoomNum  = check.getSingleRoomNum();
		int standardRoomNum = check.getStandardRoomNum();
		int suiteRoomNum = check.getSuiteRoomNum();
		String hostelbreifintro = check.getHostelbreifintro();
		sess.close();
		
		if(result==2){
			//通过后 将hostel写进数据库
			Session sess2 = sessionFactory.openSession();
			hostel.setHostelID(applyerID);
			hostel.setHostelName(hostelName);
			hostel.setHostelProvince(hostelProvince);
			hostel.setHostelCity(hostelCity);
			hostel.setHostelAddress(hostelAddress);
			hostel.setSingleRoomNum(singleRoomNum);
			hostel.setStandardRoomNum(standardRoomNum);
			hostel.setSuiteRoomNum(suiteRoomNum);
			hostel.setHostelbreifintro(hostelbreifintro);
			Transaction tx1 = sess2.beginTransaction();
			sess2.save(hostel);
			tx1.commit();
			sess2.close();
		}

		if(result==2){

			Session sess3 = sessionFactory.openSession();
			
			Transaction tx2 = sess3.beginTransaction();
			
			for(int i = 0 ; i < singleRoomNum;i++){
				roomBean room = new roomBean();
				room.setHostelID(applyerID);
				room.setRoomID(i);
				room.setIsCheckin(0);
				room.setRoomCategory("singleRoom");
				sess3.save(room);
			}
			for(int i = singleRoomNum ; i < standardRoomNum+singleRoomNum;i++){
				roomBean room = new roomBean();
				room.setHostelID(applyerID);
				room.setRoomID(i);
				room.setIsCheckin(0);
				room.setRoomCategory("standardRoom");
				sess3.save(room);
			}
			for(int i = singleRoomNum+standardRoomNum ; i <singleRoomNum+standardRoomNum+suiteRoomNum;i++){
				roomBean room = new roomBean();
				room.setHostelID(applyerID);
				room.setRoomID(i);
				room.setIsCheckin(0);
				room.setRoomCategory("suiteRoom");
				sess3.save(room);
			}
			
			tx2.commit();
			
			sess3.close();
		}
		
		if(result==2){
			Session sess4 = sessionFactory.openSession();
			
			manageAccount.setHostelID(applyerID);
			manageAccount.setHostelIncome(0.0);
			
			hostelAccount.setHostelID(applyerID);
			hostelAccount.setHostelBalance(0.0);
			
			Transaction tx3 = sess4.beginTransaction();
			sess4.save(manageAccount);
			sess4.save(hostelAccount);
			tx3.commit();
			sess4.close();
		}
//		sessionFactory.close();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void setHostel(hostelBean hostel) {
		this.hostel = hostel;
	}

	public void setManageAccount(manageAccountBean manageAccount) {
		this.manageAccount = manageAccount;
	}

	public void setHostelAccount(hostelAccountBean hostelAccount) {
		this.hostelAccount = hostelAccount;
	}
	
	

}
