package StrutsAction;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.opensymphony.xwork2.ActionSupport;

import dao.Service.membershipCardDao;

public class createCardAction extends ActionSupport implements ServletRequestAware,ServletResponseAware{

	private HttpServletRequest request;
	private HttpServletResponse response;
	
	private membershipCardDao membershipCard;
	
	@Override
	public void setServletResponse(HttpServletResponse response) {
		// TODO Auto-generated method stub
		this.response = response;
	}

	@Override
	public void setServletRequest(HttpServletRequest resquest) {
		// TODO Auto-generated method stub
		this.request = resquest;
	}
	
	public String execute() throws Exception{
		WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
		
		PrintWriter out = response.getWriter();
		
		String account = request.getParameter("accountName");
		
		HttpSession session = request.getSession(false);
		
		String ID = String.valueOf(session.getAttribute("ID"));
		
		membershipCard = (membershipCardDao)ctx.getBean("membershipCardImpl");
		
		membershipCard.signUpCard(Integer.parseInt(ID), account);
		
		out.write("success");
		out.close();
		
		return "success";
	}

}
