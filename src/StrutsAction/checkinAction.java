package StrutsAction;

import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.opensymphony.xwork2.ActionSupport;

import PersistenceModel.bookHostelBean;
import dao.Service.checkRoomDao;
import dao.Service.inORoutDao;

public class checkinAction extends ActionSupport implements ServletRequestAware,ServletResponseAware{

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
		
		String bookID = request.getParameter("bookID");
		
		inORoutDao in = (inORoutDao) ctx.getBean("inORoutImpl");
		
		if(bookID==null){
			String category = request.getParameter("category");
			String cost = request.getParameter("cash");
			String hostelID = String.valueOf(request.getSession(false).getAttribute("ID"));
			String room = "";
			
			if(category.equals("0")){
				room = "singleRoom";
			}else if(category.equals("1")){
				room = "standardRoom";
			}else{
				room = "suiteRoom";
			}
			
			System.out.println(room);
			checkRoomDao check = (checkRoomDao) ctx.getBean("checkRoomImpl");
			
			if(!check.checkRoom(Integer.parseInt(hostelID), room, new Date(System.currentTimeMillis()))){
				out.write("fail");
				out.close();
				return "success";
			}
			
			int roomNum = in.noneMemberCheckin(Integer.parseInt(hostelID),room,Double.valueOf(cost));
			
			out.write(String.valueOf(roomNum));
			out.close();
			return "success";
			
		}else{
			
			bookHostelBean bookHostel = in.getBills(Integer.parseInt(bookID));
			int roomNum =  in.checkin(bookHostel.getHostelID(), bookHostel.getMembershipID(),
					bookHostel.getRoomCategory(), bookHostel.getStartDate(), bookHostel.getEndDate());
			
			out.write(String.valueOf(roomNum));
			out.close();
			return "success";
			
		}
	}

}
