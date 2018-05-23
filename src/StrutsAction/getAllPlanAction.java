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

import PersistenceModel.releaseInfoBean;
import dao.Service.getAllPlanDao;

public class getAllPlanAction extends ActionSupport implements ServletRequestAware,ServletResponseAware{

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
		
		getAllPlanDao get = (getAllPlanDao) ctx.getBean("getAllPlanImpl");
		
		String id = String.valueOf(request.getSession(false).getAttribute("ID"));
		
		List<releaseInfoBean> list = get.getAllPlan(Integer.parseInt(id));
		
		JSONArray array = new JSONArray();
		
		for(int i = 0 ; i <list.size();i++){
			JSONObject temp = new JSONObject();
			temp.put("releaseID", list.get(i).getReleaseID());
			temp.put("releaseName", list.get(i).getReleaseName());
			temp.put("single", list.get(i).getSingleRoom());
			temp.put("standard", list.get(i).getStandardRoom());
			temp.put("suite", list.get(i).getSuiteRoom());
			temp.put("startDate", list.get(i).getStartDate().toString());
			temp.put("endDate", list.get(i).getEndDate().toString());
			array.put(temp);
		}
		
		out.write(array.toString());
		out.close();
		
		return "success";
	}

}
