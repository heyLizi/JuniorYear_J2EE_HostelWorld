package StrutsAction;

import java.io.PrintWriter;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
import dao.Service.bookSearchDao;

public class searchPlanAction extends ActionSupport implements ServletResponseAware,ServletRequestAware{

	private HttpServletResponse response;
	private HttpServletRequest request;
	
	
	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		// TODO Auto-generated method stub
		this.response = response;
	}
	
	public String execute() throws Exception{
		
		response.setCharacterEncoding("UTF-8");	
		response.setContentType("text/html;charset=UTF-8");
		
		WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
		
		PrintWriter out = response.getWriter();
		
		String province = request.getParameter("province");
		String city = request.getParameter("city");
		String date = request.getParameter("start");
		
		System.out.println(province+city+date);
		
		bookSearchDao ser = (bookSearchDao) ctx.getBean("bookSearchImpl");
		
		DateFormat dateFormate = new SimpleDateFormat("yyyy-MM-dd");
		Date startDate = new Date(dateFormate.parse(date).getTime()); 
		
		List<releaseInfoBean> list = ser.getSpecialPlan(province, city, startDate);
		
		JSONArray array = new JSONArray();
		
		if(list.size()==0){
//			JSONObject temp = new JSONObject();
//			temp.put("fail", "fail");
			out.write("fail");
			out.close();
			return "success";
		}
		
		for(int i = 0 ; i <list.size();i++){
			JSONObject temp = new JSONObject();
			temp.put("releaseID", list.get(i).getReleaseID());
			temp.put("releaseName", list.get(i).getReleaseName());
			
			String id = String.valueOf(list.get(i).getHostelID());
			temp.put("hostelID",getStringID(id));
			temp.put("hostelName", list.get(i).getHostelName());
			temp.put("hostelProvince", list.get(i).getHostelProvince());
			temp.put("hostelCity", list.get(i).getHostelCity());
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
	
	
	public String getStringID(String id){
		String result = id;
		for(int i=id.length();i<7;i++){
			result = "0"+result;
		}
		return result;
	}

}
