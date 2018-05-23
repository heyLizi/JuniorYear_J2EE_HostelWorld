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

import PersistenceModel.hostelUpdateBean;
import dao.Service.checkUpdateDao;

public class getUpdateAcrion extends ActionSupport implements ServletRequestAware,ServletResponseAware{

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
		
		checkUpdateDao check = (checkUpdateDao) ctx.getBean("checkUpdateImpl");
		
		List<hostelUpdateBean> list = check.getApplicationList();
		
		JSONArray array = new JSONArray();
		
		for(int i = 0 ; i <list.size();i++){
			JSONObject temp = new JSONObject();
			temp.put("updateID", list.get(i).getUpdateID());
			
			String id = String.valueOf(list.get(i).getApplyerID());
			temp.put("ApplyerID",getStringID(id));
			temp.put("ApplyerName", list.get(i).getApplyerName());
			temp.put("hostelName", list.get(i).getHostelName());
			temp.put("breif", list.get(i).getHostelbreif());
			array.put(temp);
		}
		
		out.write(array.toString());
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
