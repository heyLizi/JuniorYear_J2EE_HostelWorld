package StrutsAction;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.opensymphony.xwork2.ActionSupport;

import dao.Service.hostelUpdateDao;

public class hostelUpdateAction extends ActionSupport implements ServletRequestAware,ServletResponseAware{

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
		WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
		
		PrintWriter out = response.getWriter();
		
		hostelUpdateDao hos = (hostelUpdateDao) ctx.getBean("hostelUpdateImpl");
		
		HttpSession sess = request.getSession(false);
		String ID = String.valueOf(sess.getAttribute("ID"));
		String name = request.getParameter("hostelName");
		String breif = request.getParameter("breifIntro");
		
		hos.applyHostel(Integer.parseInt(ID), name, breif);
		
		out.write("success");
		out.close();
		
		return "success";
	}
	
}
