package StrutsAction;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.opensymphony.xwork2.ActionSupport;

import PersistenceModel.membershipBean;
import dao.Service.loginDao;

public class loginAction extends ActionSupport implements ServletRequestAware,ServletResponseAware{

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
		
		String ID = request.getParameter("ID");
		String password = request.getParameter("password");
		String category = request.getParameter("category");
		
		loginDao login = (loginDao) ctx.getBean("loginImpl");
		if(category.equals("0")){
			if(login.judgeMember(Integer.parseInt(ID), password)){
				request.getSession().setAttribute("ID", ID);
				request.getSession().setAttribute("category", category);
		        out.write("success");
		        out.close();
		        return "success";
			}else{
				out.write("");
				out.close();
				return "fail";
			}
		}else if(category.equals("1")){
			if(login.judgeOwner(Integer.parseInt(ID), password)){
				request.getSession().setAttribute("ID", ID);
				request.getSession().setAttribute("category", category);
		        out.write("success");
		        out.close();
		        return "success";
			}else{
				out.write("");
				out.close();
				return "fail";
			}
		}else{
			if(login.judgeManager(ID, password)){
				request.getSession().setAttribute("ID", ID);
				request.getSession().setAttribute("category", category);
		        out.write("success");
		        out.close();
		        return "success";
			}else{
				out.write("");
				out.close();
				return "fail";
			}
		}
	}
	
}
