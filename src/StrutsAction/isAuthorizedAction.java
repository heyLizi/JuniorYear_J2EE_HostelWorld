package StrutsAction;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;

public class isAuthorizedAction extends ActionSupport implements ServletRequestAware,ServletResponseAware{

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
		
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession(false);
		
		if(session==null){
			out.write("fail");
			out.close();
			return "success";
		}
		
		String IID = String.valueOf(session.getAttribute("ID"));
		
		
		if(IID.equals("null")){
			out.write("fail");
			out.close();
			return "success";
		}
		
		out.write("success");
		out.close();
		
		return "success";
	}

}
