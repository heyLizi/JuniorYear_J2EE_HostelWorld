package StrutsAction;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.opensymphony.xwork2.ActionSupport;

import PersistenceModel.checkapplicationBean;
import dao.impl.checkApplicationImpl;

public class getApplicationAction extends ActionSupport implements ServletRequestAware,ServletResponseAware{

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
		
		List<checkapplicationBean> list = get.getApplicationList();
		
		JSONArray array = new JSONArray();
		
		for(int i = 0 ; i <list.size();i++){
			JSONObject temp = new JSONObject();
			temp.put("checkID", list.get(i).getCheckID());
			temp.put("ApplyerID", list.get(i).getApplyerID());
			temp.put("ApplyerName", list.get(i).getApplyerName());
			temp.put("PhoneNum", list.get(i).getApplyerPhoneNum());
			temp.put("hostelName", list.get(i).getHostelName());
			temp.put("province", list.get(i).getHostelProvince());
			temp.put("city", list.get(i).getHostelCity());
			temp.put("address", list.get(i).getHostelAddress());
			temp.put("single", list.get(i).getSingleRoomNum());
			temp.put("standard", list.get(i).getStandardRoomNum());
			temp.put("suite", list.get(i).getSuiteRoomNum());
			temp.put("breif", list.get(i).getHostelbreifintro());
			array.put(temp);
		}
		
		out.write(array.toString());
		out.close();
		
		return "success";
	}

}
