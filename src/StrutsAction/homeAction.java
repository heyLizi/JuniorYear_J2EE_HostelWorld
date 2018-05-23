package StrutsAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.opensymphony.xwork2.ActionSupport;

public class homeAction extends ActionSupport implements ServletRequestAware,ServletResponseAware{

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
		
		String id = request.getParameter("id");
		System.out.println(id);
		
		if(id.equals("0")){ //返回主页面
			return "home";
		}
		
		if(id.equals("1")){  //返回注册页面
			return "register";
		}
		
		HttpSession session = request.getSession(false);
		
		if(session==null){
			return "login";
		}
		
		String IID = String.valueOf(session.getAttribute("ID"));
		if(IID.equals("null")){
			System.out.println("wocaonimaye");
			return "login";
		}
		
		
		
		if(id.equals("2")){  //返回登录页面
			return "login";
		}else if(id.equals("3")){  //返回会员卡页面（会员）
			return "cardInfo";
		}else if(id.equals("4")){  //返回酒店信息页面（店家）
			return "hostelInfo";
		}else if(id.equals("5")){  //返回个人页面
			return "personal";
		}else if(id.equals("10")){  //返回酒店申请页面（店家）
			return "hostelApplication";
		}else if(id.equals("11")){  //返回审核酒店列表页面（经理）
			return "getApplication";
		}else if(id.equals("12")){  //返回计划列表页面（店家）
			return "getAllPlan";
		}else if(id.equals("13")){  //返回预订酒店页面（会员）
			return "book";
		}else if(id.equals("14")){  //返回我的订单页面（会员）
			return "mybook";
		}else if(id.equals("15")){  //返回入住页面（店家）
			return "checkin";
		}else if(id.equals("16")){  //返回离宿页面（店家）
			return "checkout";
		}else if(id.equals("17")){  //返回结算页面（经理）
			return "settlement";
		}else if(id.equals("18")){  //返回酒店统计页面（店家）
			return "hostelS";
		}else if(id.equals("19")){  //返回酒店经理统计页面（经理）
			return  "memberS";
		}else if(id.equals("20")){  //返回酒店制定计划页面（店家） --> Lizi新增
			return "makePlan";
		}
		
		return "success";
	}

}
