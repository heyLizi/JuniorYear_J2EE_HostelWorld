package StrutsAction;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.json.JSONObject;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.opensymphony.xwork2.ActionSupport;

import PersistenceModel.checkapplicationBean;
import dao.impl.checkApplicationImpl;

public class getAppInfoAction extends ActionSupport implements ServletRequestAware,ServletResponseAware{

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
		
		response.setCharacterEncoding("UTF-8");	
		response.setContentType("text/html;charset=UTF-8");
		
		WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
		
		PrintWriter out = response.getWriter();
		
		checkApplicationImpl get = (checkApplicationImpl) ctx.getBean("checkApplicationImpl");
		
		String checkID = request.getParameter("checkID");
		
		checkapplicationBean check = get.getApplicationInfo(Integer.parseInt(checkID));
		
		JSONObject temp = new JSONObject();
		
		temp.put("checkID", check.getCheckID());
		
		String id =String.valueOf(check.getApplyerID());
		temp.put("ApplyerID",getStringID(id));
		temp.put("ApplyerName", check.getApplyerName());
		temp.put("PhoneNum", check.getApplyerPhoneNum());
		temp.put("hostelName", check.getHostelName());
		temp.put("province", check.getHostelProvince());
		temp.put("city", check.getHostelCity());
		temp.put("address", check.getHostelAddress());
		temp.put("single", check.getSingleRoomNum());
		temp.put("standard", check.getStandardRoomNum());
		temp.put("suite", check.getSuiteRoomNum());
		temp.put("breif", check.getHostelbreifintro());
		
		out.write(temp.toString());
		out.close();
		
		return "success";
	}
	
	public String getStringID(String id){
		String result = id;
		for(int i=id.length();i<7;i++){
			result = "0"+result;
		}
		return result;
	}

}
