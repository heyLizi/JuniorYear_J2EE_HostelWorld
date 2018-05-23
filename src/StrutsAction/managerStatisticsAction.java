package StrutsAction;

import java.util.List;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.opensymphony.xwork2.ActionSupport;

import VOModel.hostelInVO;
import VOModel.membershipVO;
import dao.Service.managerStatisticsDao;

public class managerStatisticsAction extends ActionSupport implements ServletRequestAware,ServletResponseAware{

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
		
		managerStatisticsDao man = (managerStatisticsDao) ctx.getBean("managerStatisticsImpl");
		
		List<hostelInVO> hos = man.getHostelIn();
		List<membershipVO> mem = man.getMembership();
		double all = man.getNowBalance();
		
		JSONObject result = new JSONObject();
		JSONArray array1 = new JSONArray();
		JSONArray array2 = new JSONArray();
		
		for(int i = 0 ; i <hos.size();i++){
			JSONObject temp = new JSONObject();
			temp.put("single",hos.get(i).getSingle());
			temp.put("standard", hos.get(i).getStandard());
			temp.put("suite", hos.get(i).getSuite());
			temp.put("balance",hos.get(i).getBalance());
			String id = String.valueOf(hos.get(i).getBalance());
			temp.put("hostelID",getStringID(id));
			array1.put(temp);
		}
		
		for(int i = 0 ; i <mem.size();i++){
			JSONObject temp = new JSONObject();
			String id = String.valueOf(mem.get(i).getMemberID());
			temp.put("memberID",getStringID(id));
			temp.put("allBook",mem.get(i).getAllBook());
			temp.put("allPay", mem.get(i).getAllPay());
			array2.put(temp);
		}
		
		result.put("hostel", array1);
		result.put("member", array2);
		result.put("all", all);
		
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
