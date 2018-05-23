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

import dao.Service.hostelApplicationDao;

public class hostelApplicationAction extends ActionSupport implements ServletRequestAware,ServletResponseAware{

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
		
		hostelApplicationDao hostel = (hostelApplicationDao) ctx.getBean("hostelApplicationImpl");
		
		HttpSession sess = request.getSession(false);
		String ID = String.valueOf(sess.getAttribute("ID"));
		String name = request.getParameter("hostelName");
		String province = request.getParameter("province");
		String city = request.getParameter("city");
		String address = request.getParameter("address");
		int single = Integer.parseInt(request.getParameter("singleNum")); 
		int standard = Integer.parseInt(request.getParameter("standardNum"));
		int suite = Integer.parseInt(request.getParameter("suiteNum"));
		String breif = request.getParameter("breifIntro");
		
		hostel.applyHostel(Integer.parseInt(ID), name, province, city, address, single, standard, suite, breif);
		
		out.write("success");
		out.close();
		
		return "success";
	}
}
