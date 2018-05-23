package StrutsAction;

import java.io.PrintWriter;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.opensymphony.xwork2.ActionSupport;

import PersistenceModel.hostelBean;
import dao.Service.getHostelInfoDao;
import dao.Service.releasePlanDao;

public class releasePlanAction extends ActionSupport implements ServletRequestAware,ServletResponseAware{

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
		
		PrintWriter out = response.getWriter();
		
		WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
		
		releasePlanDao re = (releasePlanDao) ctx.getBean("releasePlanImpl");
		getHostelInfoDao get = (getHostelInfoDao) ctx.getBean("getHostelInfoImpl");
		
		String hostelID =String.valueOf(request.getSession(false).getAttribute("ID"));
		
		String planName = request.getParameter("planName");
		String single = request.getParameter("single");
		String standard = request.getParameter("standard");
		String suite = request.getParameter("suite");
		
		String start = request.getParameter("start");
		String end = request.getParameter("end");
		
		hostelBean hos = get.getHostelInfo(Integer.parseInt(hostelID));
		
		DateFormat dateFormate = new SimpleDateFormat("yyyy-MM-dd");
		Date startDate = new Date(dateFormate.parse(start).getTime()); 
		Date endDate = new Date(dateFormate.parse(end).getTime()); 
		
		if(re.isConflict(startDate, Integer.parseInt(hostelID))){
			re.releasePlan(planName, hos.getHostelID(), hos.getHostelName(), hos.getHostelProvince(), hos.getHostelCity(), Double.valueOf(single), Double.valueOf(standard), Double.valueOf(suite), startDate, endDate);
			out.write("success");
			out.close();
			return "success";
		}else{
			out.write("fail");
			out.close();
			return "success";
		}
	}

}
