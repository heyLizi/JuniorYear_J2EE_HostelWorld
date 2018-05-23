package StrutsAction;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.opensymphony.xwork2.ActionSupport;

import dao.impl.checkApplicationImpl;

public class checkApplicationAction extends ActionSupport implements ServletRequestAware,ServletResponseAware{
	
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
		
		String check = request.getParameter("isPass");
		String id = request.getParameter("check");
		
		PrintWriter out = response.getWriter();
		
//		System.out.println(check);
		
		checkApplicationImpl get = (checkApplicationImpl) ctx.getBean("checkApplicationImpl");
		
		if(check.equals("yes")){
			get.checkApplication(Integer.parseInt(id), 2);
			out.write("success");
			out.close();
		}else{
			get.checkApplication(Integer.parseInt(id), 1);
			out.write("fail");
			out.close();
		}
		
		return "success";
	}

}
