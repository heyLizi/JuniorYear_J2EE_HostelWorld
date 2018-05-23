package StrutsAction;

import java.io.PrintWriter;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.opensymphony.xwork2.ActionSupport;

import PersistenceModel.releaseInfoBean;
import dao.Service.bookRoomDao;
import dao.Service.checkRoomDao;
import dao.Service.getSpecialPlanDao;

public class bookAction extends ActionSupport implements ServletRequestAware,ServletResponseAware{

	private HttpServletRequest request;
	private HttpServletResponse response;
	
	
	
	@Override
	public void setServletResponse(HttpServletResponse response) {
		// TODO Auto-generated method stub
		this.response = response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
	}
	
	public String execute() throws Exception{
		
		WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
		
		PrintWriter out = response.getWriter();
		
		String membershipID = String.valueOf(request.getSession(false).getAttribute("ID")); 
		
		String planID = request.getParameter("planID");
		String categoryCount = request.getParameter("category");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");

		
		DateFormat dateFormate = new SimpleDateFormat("yyyy-MM-dd");
		Date start = new Date(dateFormate.parse(startDate).getTime()); 
		Date end = new Date(dateFormate.parse(endDate).getTime()); 
		Date now = new Date(System.currentTimeMillis());
		
		int days =  (int)((end.getTime()-start.getTime())/ (3600*24*1000));
		
		getSpecialPlanDao spe = (getSpecialPlanDao) ctx.getBean("getSpecialPlanImpl");
		
		releaseInfoBean re = spe.getSpecialPlan(Integer.parseInt(planID));
		
		bookRoomDao book = (bookRoomDao) ctx.getBean("bookRoomImpl");
		
		checkRoomDao check = (checkRoomDao) ctx.getBean("checkRoomImpl");
		
		Date startTest = new Date(dateFormate.parse(startDate).getTime()); 
		
		double cost = 0;
		
		String roomCategory = "";
		if(categoryCount.equals("0")){
			roomCategory = "singleRoom";
			cost = re.getSingleRoom() * (days+1);
		}else if(categoryCount.equals("1")){
			roomCategory = "standardRoom";
			cost = re.getStandardRoom() * (days+1);
		}else{
			roomCategory = "suiteRoom";
			cost = re.getSuiteRoom() * (days+1);
		}
		
		if(!check.checkAuth(Integer.parseInt(membershipID))){
			out.write("failf");
			out.close();
			return "success";
		}
		
		
		while(startTest.compareTo(end)<=0){
			if(check.checkRoom(re.getHostelID(), roomCategory, startTest)){
				
			}else{
				out.write(startTest.toString());
				out.close();
				return "success";
			}
			
			startTest = DateAdd(startTest);
		}
		
		if(!check.checkBalance(Integer.parseInt(membershipID), cost)){
			out.write("fail");
			out.close();
			return "success";
		}
		
		
		book.bookRoom(now, Integer.parseInt(membershipID), re.getHostelID(), 
				roomCategory, cost, start, end);
		
		out.write("success");
		out.close();
		
		return "success";
	}
	
	public Date DateAdd(Date date){
		
		Calendar   calendar   =   new   GregorianCalendar();
		calendar.setTime(date);
		calendar.add(calendar.DATE, 1);
		java.util.Date temp = calendar.getTime();
		
		java.sql.Date result = new Date(temp.getTime());
		
		return result;
	}

}
