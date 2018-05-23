package StrutsAction;

import java.io.PrintWriter;
import java.sql.Date;
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
import dao.Service.searchMyBookDao;

public class searchMyBookAction extends ActionSupport implements ServletRequestAware,ServletResponseAware{

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
		
		String sign = request.getParameter("sign");
		
		searchMyBookDao search = (searchMyBookDao) ctx.getBean("searchMyBookImpl");
		
		String id = String.valueOf(request.getSession(false).getAttribute("ID"));
		List<bookHostelBean> list;
		if(sign.equals("0")){
			list = search.getMyBook(Integer.parseInt(id), new Date(System.currentTimeMillis()));
		}else{
			list = search.getHistoryBook(Integer.parseInt(id), new Date(System.currentTimeMillis()));
		}
		
		
		
		if(list.size()==0){
			out.write("fail");
			out.close();
			return "success";
		}
		
		JSONArray array = new JSONArray();
		
		for(int i = 0 ; i <list.size();i++){
			JSONObject temp = new JSONObject();
			temp.put("bookID", list.get(i).getBookID());
			temp.put("bookTime", list.get(i).getBookTime().toLocalDate());
			String iid = String.valueOf(list.get(i).getHostelID());
			temp.put("hostelID",getStringID(iid));
			temp.put("category", list.get(i).getRoomCategory());
			temp.put("cost", list.get(i).getCost());
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
