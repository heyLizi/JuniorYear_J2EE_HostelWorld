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

import PersistenceModel.membershipCardBean;
import dao.Service.getCardInfoDao;

public class getCardInfoAction extends ActionSupport implements ServletRequestAware,ServletResponseAware{
	
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
		
		String ID = String.valueOf(request.getSession(false).getAttribute("ID"));
		
		getCardInfoDao get = (getCardInfoDao) ctx.getBean("getCardInfoImpl");
		membershipCardBean mem = get.getCardInfo(Integer.parseInt(ID));
		JSONObject json = new JSONObject();
		
		if(mem.getMembershipID()==0){
			json.put("fail", "fail");
			out.write(json.toString());
			out.close();
			return "success";
		}
		
		String iid = String.valueOf(mem.getMembershipID());
		json.put("membershipID", getStringID(iid));
		if(mem.getQualification()==2){
			json.put("qualification", "激活");
		}else if(mem.getQualification()==1){
			json.put("qualification", "暂停");
		}else if(mem.getQualification()==0){
			json.put("qualification", "未激活");
		}
		json.put("bankAccount", mem.getBankAccount());
		json.put("banlance", mem.getBanlance());
		json.put("startDate", mem.getStartDate().toString());
		json.put("endDate", mem.getEndDate().toString());
		json.put("totalPay", mem.getTotalPay());
		json.put("authority", mem.getAuthority());
		json.put("credits", mem.getCredits());
		
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
