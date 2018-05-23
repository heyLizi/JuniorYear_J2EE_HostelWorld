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

import dao.Service.rechargeDao;

public class rechargeAction extends ActionSupport implements ServletRequestAware,ServletResponseAware{

	
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
		
		HttpSession session = request.getSession(false);
		
		System.out.println("运行到这里了吗");
		
		String ID = String.valueOf(session.getAttribute("ID"));
		
		System.out.println("拿到ID了吗"+ID);
		
		String rechargeNum = request.getParameter("recharge");
		
		System.out.println("拿到充值的钱了吗"+rechargeNum);
		
		rechargeDao recharge = (rechargeDao) ctx.getBean("rechargeImpl");
		
		System.out.println("拿到这个类了吗"+recharge.toString());
		
		recharge.recharge(Integer.valueOf(ID),Double.parseDouble(rechargeNum));
		
		System.out.println("运行到这里了吗4");
		
		out.write("success");
		out.close();
		
		return "success";
	}
	

}



//recharge = (rechargeDao) ctx.getBean("rechargeImpl");

//recharge.recharge(1, "123456", 2564.1);

//creditsManageDao cre = (creditsManageDao) ctx.getBean("creditsManageImpl");
//cre.checkCredits(1);
//cre.exchangeCredits(1);

//hostelApplicationDao hos = (hostelApplicationDao) ctx.getBean("hostelApplicationImpl");
//hos.applyHostel(1, "杨三洋的店", "江苏省", "南京市", "鼓楼区", 10, 5, 2, "杨三洋将提供最好的服务");

//checkApplicationDao check = (checkApplicationDao) ctx.getBean("checkApplicationImpl");
//check.getApplicationList();
//check.checkApplication(1, 2);

//releasePlanDao release = (releasePlanDao) ctx.getBean("releasePlanImpl");
//release.isConflict(new Date(System.currentTimeMillis()), 1);
//DateFormat dateFormate = new SimpleDateFormat("yyyy-MM-dd");
//Date startDate = new Date(dateFormate.parse("2017-04-03").getTime()); 
//Date endDate = new Date(dateFormate.parse("2017-04-05").getTime());
//release.releasePlan("牛批牛批三洋牛批", 1,"杨三洋的店","江苏省","南京市", 123.5, 234.5, 345.5,startDate,endDate);

//bookSearchDao book = (bookSearchDao) ctx.getBean("bookSearchImpl");
//DateFormat dateFormate = new SimpleDateFormat("yyyy-MM-dd");
//Date startDate = new Date(dateFormate.parse("2017-04-04").getTime()); 
//book.getSpecialPlan("江苏省", "南京市", startDate);

//checkRoomDao check = (checkRoomDao) ctx.getBean("checkRoomImpl");
//DateFormat dateFormate = new SimpleDateFormat("yyyy-MM-dd");
//Date startDate = new Date(dateFormate.parse("2017-03-16").getTime()); 
//System.out.println(check.checkRoom(1, "suiteRoom", startDate));

//bookRoomDao book = (bookRoomDao) ctx.getBean("bookRoomImpl");
//DateFormat dateFormate = new SimpleDateFormat("yyyy-MM-dd");
//Date startDate = new Date(dateFormate.parse("2017-03-19").getTime()); 
//Date endDate = new Date(dateFormate.parse("2017-03-22").getTime()); 
//book.bookRoom(new Date(System.currentTimeMillis()), 1, 1, "suiteRoom", 123.5, startDate, endDate);

//searchMyBookDao search = (searchMyBookDao) ctx.getBean("searchMyBookImpl");
//search.getMyBook(1, new Date(System.currentTimeMillis()));

//cancelBookDao cancel = (cancelBookDao) ctx.getBean("cancelBookImpl");
//cancel.cancelBook(3);

//hostelSearchBookDao hostel = (hostelSearchBookDao) ctx.getBean("hostelSearchBookImpl");
//hostel.getHostelBook(1, 1);

//inORoutDao in = (inORoutDao) ctx.getBean("inORoutImpl");
//in.checkin(1, 1, "singleRoom", new Date(System.currentTimeMillis()));
//in.checkout(1, 1);