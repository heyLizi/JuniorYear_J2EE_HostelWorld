package StrutsAction;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.json.JSONObject;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.opensymphony.xwork2.ActionSupport;

import PersistenceModel.hostelBean;
import dao.Service.getHostelInfoDao;
import dao.Service.isApplyingDao;

public class getHostelInfoAction extends ActionSupport implements ServletRequestAware,ServletResponseAware{

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
		
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession(false);
		
		String ID = String.valueOf(session.getAttribute("ID"));
		
		WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
		
		getHostelInfoDao hos = (getHostelInfoDao) ctx.getBean("getHostelInfoImpl");
		isApplyingDao app = (isApplyingDao) ctx.getBean("isApplyingImpl");
		
		JSONObject json = new JSONObject();

		if(app.isApplying(Integer.parseInt(ID))){
			json.put("ing", "ing");
			out.write(json.toString());
			out.close();
			return "success";
		}
		
		hostelBean hoo = hos.getHostelInfo(Integer.parseInt(ID));
		
		if(hoo.getHostelID()==0){
			json.put("fail", "fail");
			out.write(json.toString());
			out.close();
			return "success";
		}
		
		String id = String.valueOf(hoo.getHostelID());
		json.put("hostelID", getStringID(id));
		json.put("hostelName", hoo.getHostelName());
		json.put("hostelProvince", hoo.getHostelProvince());
		json.put("hostelCity", hoo.getHostelCity());
		json.put("hostelAddress", hoo.getHostelAddress());
		json.put("singleRoomNum", hoo.getSingleRoomNum());
		json.put("standardRoomNum", hoo.getStandardRoomNum());
		json.put("suiteRoonNum", hoo.getSuiteRoomNum());
		json.put("hostelbreifintro", hoo.getHostelbreifintro());
		
		out.write(json.toString());
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
