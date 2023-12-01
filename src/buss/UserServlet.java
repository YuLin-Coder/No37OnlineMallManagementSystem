package buss;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.Type;
import vo.User;
import comm.Constant;
import comm.ServletDeal;
import dao.TypeDao;
import dao.UserDao;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置字符集
				request.setCharacterEncoding(Constant.CHARSET);
				response.setContentType(Constant.CONTENTHEAD);
				//判断执行何种操作
				String operate=request.getParameter("operate");
				if(operate.equals("add")){
					add(request,response);
				}else if(operate.equals("login")){
					login(request,response);
				}else if(operate.equals("del")){
					del(request,response);
				}else if(operate.equals("modify")){
					modify(request,response);
				}else if(operate.equals("getModel")){
					getModel(request,response);
				}else if(operate.equals("query")){
					query(request,response);
				}
	}

	private void add(HttpServletRequest request, HttpServletResponse response) {
		User model=dealInputModel(request);
		String id=new UserDao().add(model);
		try{
			if(id!=null){
				String hint="用户\\\""+model.getUsername()+"\\\"注册成功，分配的编号是："+id;
				ServletDeal.popupHintAndRedict(response, hint, "./User/login.jsp");
			} else {
				ServletDeal.popupHintAndRedict(response, "注册失败，请重新注册", "./User/register.jsp");
			}
		} catch (Exception e){
			System.out.println("register提示并跳转异常");
		}
	}

	private void login(HttpServletRequest request, HttpServletResponse response) {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String where="username='"+username+"'";
		List<User> li=new UserDao().query(where);
		try{
//		if(!li.isEmpty()){
//			request.getSession().setAttribute("loginUserinfo", li.get(0));
//			ServletDeal.popupHintAndRedict(response, "登陆成功！", "./MainFrame/homepage.jsp");
//		} else {
//			ServletDeal.popupHintAndRedict(response, "登陆出错，请重新登陆", "./User/login.jsp");
//		}
			String errUrl="./User/login.jsp";
			if(li.isEmpty()){
				ServletDeal.popupHintAndRedict(response, "用户名输入错误，请重新登录！", errUrl);
				return;
			}
			for(int i=0;i<li.size();i++){
				if(li.get(i).getPassword().equals(password)){
					request.getSession().setAttribute("loginUserinfo", li.get(i));
					ServletDeal.popupHintAndRedict(response, "登录成功！", "./MainFrame/homepage.jsp");
					return;
				}
			}
			ServletDeal.popupHintAndRedict(response, "密码输入错误，请重新登录！", errUrl);
		}catch(Exception e){
			System.out.println("login跳转异常");
		}
	}

	private void del(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void modify(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void getModel(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void query(HttpServletRequest request, HttpServletResponse response) {
		ServletDeal.clearSession(request);
		List<User> li=new UserDao().query("");
		try{
			if (li.size()>0) {
				request.getSession().setAttribute("UserList", li);
				request.getSession().setAttribute("clear", "UserList");
				response.sendRedirect("./User/userList.jsp");
			} else {
				ServletDeal.popupHintAndRedict(response, "查询商品类型列表出错！", "../MainFrame/welcom.jsp");
			}
		}catch(Exception e){
			System.out.println("query的response跳转页面出错");
		}
	}

	/**
	 * 处理从页面传入的实例参数并设置返回一个实例
	 * @param request
	 * @return
	 */
	private User dealInputModel(HttpServletRequest request){
		User model=new User();
		model.setCity(request.getParameter("city"));
		model.setUsername(request.getParameter("username"));
		model.setRealname(request.getParameter("realname"));
		model.setPassword(request.getParameter("password"));
		model.setAddress(request.getParameter("address"));
		model.setPapersNO(request.getParameter("papersNO"));
		model.setPapersType(request.getParameter("papersType"));
		model.setSex(request.getParameter("sex"));
		model.setNumber(request.getParameter("number"));
		model.setAddTime(request.getParameter("addTime"));
		model.setUserType(request.getParameter("userType"));
		model.setEmail(request.getParameter("email"));
		return model;
	}
}
