package buss;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comm.Constant;
import comm.ServletDeal;
import dao.TypeDao;
import vo.Type;

/**
 * Servlet implementation class TypeServlet
 */
@WebServlet("/TypeServlet")
public class TypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TypeServlet() {
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
		
		String operate=request.getParameter("operate");
		if(operate.equals("add")){
			add(request,response);
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

	private void add(HttpServletRequest request,HttpServletResponse response) {
		Type model=dealInputModel(request);
		String id=new TypeDao().add(model);
		try {
			if(id!=null){
				String hint="添加商品类型\\\""+model.getTypeName()+"\\\"成功，分配的编号："+id;
				ServletDeal.popupHintAndRedict(response, hint, "./TypeServlet?operate=query");
			} else {
				response.sendRedirect("./Type/typeAdd_err.jsp");
			}
		} catch (Exception e) {
			System.out.println("add的response跳转页面出错");
		}
	}
	
	private void del(HttpServletRequest request, HttpServletResponse response) {
		String id=request.getParameter("id");
		int ret=new TypeDao().del(id);
		try {
			if (ret == 1) {
				String hint=id+"号商品类型删除成功！";
				ServletDeal.popupHintAndRedict(response, hint, "./TypeServlet?operate=query");
			} else {
				ServletDeal.popupHintAndRedict(response, "删除失败！", "./TypeServlet?operate=query");
			}
		} catch (Exception e) {
			System.out.println("del的response跳转页面出错");
		}
	}
	
	private void modify(HttpServletRequest request, HttpServletResponse response) {
		Type model=dealInputModel(request);
		int ret=new TypeDao().modify(model);
		try{
			if(ret==1){
				ServletDeal.popupHintAndRedict(response, "修改商品类型成功！", "./TypeServlet?operate=query");
			} else {
				response.sendRedirect("./Type/typeModify_err.jsp");
			}
		} catch (Exception e){
			System.out.println("modify跳转页面出错");
		}
	}

	private void getModel(HttpServletRequest request,HttpServletResponse response) {
		Type model=new TypeDao().getModel(request.getParameter("id"));
		request.getSession().setAttribute("SelectedTypeInfo", model);
		request.getSession().setAttribute("clear","SelectedTypeInfo");
		try{
			response.sendRedirect(modelSendURL(request));
		}catch(Exception e){
			System.out.println("获取model跳转页面异常");
		}
	}

	private void query(HttpServletRequest request, HttpServletResponse response) {
		ServletDeal.clearSession(request);
		List<Type> li=new TypeDao().query("");
		try{
			if (li.size()>0) {
				request.getSession().setAttribute("TypeList", li);
				request.getSession().setAttribute("clear", "TypeList");
				response.sendRedirect("./Type/typeList.jsp");
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
	private Type dealInputModel(HttpServletRequest request){
		Type model=new Type();
		model.setTypeName(request.getParameter("typeName"));
		if(!request.getParameter("operate").equals("add")){
			model.setId(request.getParameter("id"));
		}
		return model;
	}
	
	/**
	 * 获取实体之后要重定向的地址处理
	 * @param request
	 * @return
	 */
	private String modelSendURL(HttpServletRequest request){
		String page=request.getParameter("page");
		String url="";
		if("detail".equals(page)){
			url="./Type/typeDetail.jsp";
		} else if("modify".equals(page)){
			url="./Type/typeModify.jsp";
		}
		return url;
	}
}
