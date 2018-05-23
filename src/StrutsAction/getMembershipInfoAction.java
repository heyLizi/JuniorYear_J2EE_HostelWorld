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

import PersistenceModel.hostelManagerBean;
import PersistenceModel.hostelownerBean;
import PersistenceModel.membershipBean;
import dao.Service.getUserInfoDao;

public class getMembershipInfoAction extends ActionSupport implements ServletRequestAware,ServletResponseAware{

	private HttpServletResponse response;
	private HttpServletRequest request;
	
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
		getUserInfoDao getInfo = (getUserInfoDao) ctx.getBean("getUserInfoImpl");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession(false);
		
		String ID = String.valueOf(session.getAttribute("ID"));
		String category = String.valueOf(session.getAttribute("category"));
		
		System.out.println("ID:"+ID+"  种类:"+category);
		
		if(category.equals("0")){
			membershipBean mem = getInfo.getMember(Integer.parseInt(ID));
			JSONObject result = new JSONObject();
			String id = String.valueOf(mem.getMembershipID());
			result.put("ID", getStringID(id));
			result.put("Name", mem.getName());
			result.put("Sex", mem.getSex());
			result.put("Num", mem.getPhoneNum());
			result.put("category", category);
			out.write(result.toString());
			out.close();
			return "success";
		}else if(category.equals("1")){
			hostelownerBean hos = getInfo.getOwner(Integer.parseInt(ID));
			JSONObject result = new JSONObject();
			String id = String.valueOf(hos.getHostelownerID());
			result.put("ID", getStringID(id));
			result.put("Name", hos.getOwnerName());
			result.put("Sex", hos.getOwnerSex());
			result.put("Num", hos.getPhoneNum());
			result.put("category", category);
			out.write(result.toString());
			out.close();
			return "success";
		}else{
			hostelManagerBean man = getInfo.getManager(ID);
			JSONObject result = new JSONObject();
			String id = String.valueOf(man.getManagerID());
			result.put("ID", getStringID(id));
			result.put("Name", man.getManagerName());
			result.put("Sex", man.getManagerSex());
			result.put("Num", man.getManagerPhone());
			result.put("category", category);
			out.write(result.toString());
			out.close();
			return "success";
		}
	}
	
	public String getStringID(String id){
		String result = id;
		for(int i=id.length();i<7;i++){
			result = "0"+result;
		}
		return result;
	}

}
