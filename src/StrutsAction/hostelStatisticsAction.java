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

import PersistenceModel.bookHostelBean;
import dao.Service.hostelStatisticsDao;

public class hostelStatisticsAction extends ActionSupport implements ServletRequestAware,ServletResponseAware{

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
		
		hostelStatisticsDao statistics = (hostelStatisticsDao) ctx.getBean("hostelStatisticsImpl");
		
		String hostelID = String.valueOf(request.getSession(false).getAttribute("ID"));
		
		List<bookHostelBean> list = statistics.getAllBills(Integer.parseInt(hostelID));
		
		JSONObject result = new JSONObject();
		JSONArray array = new JSONArray();
		
		for(int i = 0 ; i <list.size();i++){
			JSONObject temp = new JSONObject();
			temp.put("bookID", list.get(i).getBookID());
			temp.put("bookTime", list.get(i).getBookTime().toLocalDate());
			String id = String.valueOf(list.get(i).getHostelID());
			temp.put("hostelID",getStringID(id));
			temp.put("category", list.get(i).getRoomCategory());
			temp.put("cost", list.get(i).getCost());
			temp.put("startDate", list.get(i).getStartDate().toString());
			temp.put("endDate", list.get(i).getEndDate().toString());
			array.put(temp);
		}
		
		int[] temp = statistics.getNowCheckIn(Integer.parseInt(hostelID));
		
		double balance = statistics.getNowBalance(Integer.parseInt(hostelID));
		
		result.put("single", temp[0]);
		result.put("standard", temp[1]);
		result.put("suite", temp[2]);
		result.put("balance", balance);
		result.put("list", array);
		
		out.write(result.toString());
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
