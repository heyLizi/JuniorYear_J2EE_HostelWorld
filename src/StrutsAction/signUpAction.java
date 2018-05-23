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

import PersistenceModel.hostelownerBean;
import PersistenceModel.membershipBean;
import dao.Service.getUserInfoDao;
import dao.Service.signUpDao;

public class signUpAction extends ActionSupport implements ServletRequestAware,ServletResponseAware{

	private HttpServletRequest request;
	private HttpServletResponse response;
	private signUpDao signUpDao;
	
	
	@Override
	public void setServletResponse(HttpServletResponse response) {
		// TODO Auto-generated method stub
		this.response = response;
	}

	@Override
	public void setServletRequest(HttpServletRequest requset) {
		// TODO Auto-generated method stub
		this.request = requset;
	}

	public String execute() throws Exception{
		WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
		
		PrintWriter out = response.getWriter();
		
		signUpDao = (signUpDao)ctx.getBean("signUpImpl"); 
		
		int category = 0;
		int ID = 0;
		
		String categoryString = request.getParameter("optionsRadios1");
		if(categoryString.equals("我要开店")){
			category = 1;
		}
		
		String password = request.getParameter("password1");
		String userName = request.getParameter("Name");
		String userSex = request.getParameter("optionsRadios");
		String phoneNum = request.getParameter("PhoneNum");
		ID = signUpDao.signUp(category,password,userName,userSex,phoneNum);
		
		request.getSession().setAttribute("ID", ID);
		request.getSession().setAttribute("category", category);
		
//		getUserInfoDao getInfo = (getUserInfoDao) ctx.getBean("getUserInfoImpl");
//		if(category==0){
//			membershipBean mem = getInfo.getMember(ID);
//			JSONObject result = new JSONObject();
//			result.put("memberID", mem.getMembershipID());
//			result.put("memberName", mem.getName());
//			System.out.println(mem.getName());
//			result.put("memberSex", mem.getSex());
//			result.put("memberPhoneNum", mem.getPhoneNum());
//			out.write(result.toString());
//			out.close();
//			return "success";
//		}else{
//			hostelownerBean hos = getInfo.getOwner(ID);
//			JSONObject result = new JSONObject();
//			result.put("ownerID", hos.getHostelownerID());
//			result.put("ownerName", hos.getOwnerName());
//			result.put("ownerSex", hos.getOwnerSex());
//			result.put("ownerPhoneNum", hos.getPhoneNum());
//			out.write(result.toString());
//			out.close();
//			return "success";
//		}
		
		out.write("success");
		out.close();
		
		return "success";
//		signUpDao.signUp(1,"123456","杨三洋","男","18260095267");//这只是测试！！！！
	}

}
