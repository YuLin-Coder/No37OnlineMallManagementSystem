package buss;

import comm.Constant;
import comm.ServletDeal;
import dao.GoodsDao;
import vo.Goods;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * Servlet implementation class GoodsServlet
 */
@WebServlet("/GoodsServlet")
public class GoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoodsServlet() {
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
		Goods model=dealInputModel(request);
		String id=new GoodsDao().add(model);
		try {
			if(!("").equals(id)){
				String hint ="商品\\\""+model.getGoodsname()+"\\\"添加成功，分配的商品编号为："+id;
				ServletDeal.popupHintAndRedict(response, hint, "./Goods/goodsAdd.jsp");
			} else {
				response.sendRedirect("./Goods/goodsAdd_err.jsp");
			}
		} catch (Exception e) {
			System.out.println("add页面输出跳转方法出错");
			e.printStackTrace();
		}
	}

	private void del(HttpServletRequest request, HttpServletResponse response) {
		String id=request.getParameter("id");
		int ret=new GoodsDao().del(id);
		if(ret==1){
			String hint=id+"号商品已删除!";
			ServletDeal.popupHintAndRedict(response, hint, "./GoodsServlet?operate=query");
		} else {
			ServletDeal.popupHintAndRedict(response, "删除操作失败！", "./GoodsServlet?operate=query");
		}
	}

	private void modify(HttpServletRequest request, HttpServletResponse response) {
		Goods model=dealInputModel(request);
		int ret=new GoodsDao().modify(model);
		try{
			if(ret==1){
				ServletDeal.popupHintAndRedict(response, "修改商品信息成功！", "./GoodsServlet?operate=query&clear=SelectedGoodsInfo");
			} else {
				response.sendRedirect("./Goods/goodsModify_err.jsp");
			}
		} catch (Exception e){
			System.out.println("modify的response跳转页面出错");
		}
	}

	private void getModel(HttpServletRequest request,HttpServletResponse response) {
		Goods model=new GoodsDao().getModel(request.getParameter("id"));
		request.getSession().setAttribute("SelectedGoodsInfo", model);
		request.getSession().setAttribute("clear", "SelectedGoodsInfo");
		try {
			response.sendRedirect(modelSendURL(request));
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("getModel的response跳转页面出错");
		}
	}

	private void query(HttpServletRequest request, HttpServletResponse response) {
		ServletDeal.clearSession(request);
		List<Goods> li=new GoodsDao().query("");
		request.getSession().setAttribute("GoodsList", li);
		request.getSession().setAttribute("clear", "GoodsList");
		try{
			if (li.size()>0) {
				response.sendRedirect("./Goods/goodsList.jsp");
			} else {
				response.getWriter().print("查询失败");
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
	private Goods dealInputModel(HttpServletRequest request){
		Goods model=new Goods();
		model.setGoodsname(request.getParameter("goodsname"));
		model.setSummary(request.getParameter("summary"));
		model.setBrand(request.getParameter("brand"));
		model.setPlace(request.getParameter("place"));
		model.setPrice(request.getParameter("price"));
		model.setDiscount(request.getParameter("discount"));
		model.setPicPath(request.getParameter("picPath"));
		model.setTypeId(request.getParameter("typeId"));
		model.setAddDate((new Timestamp(new Date().getTime())).toString());
		model.setGoodssum(request.getParameter("goodssum"));
		if(!request.getParameter("operate").equals("add")){
			model.setGoodsid(request.getParameter("goodsid"));
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
			url="./Goods/goodsDetail.jsp";
		} else if("modify".equals(page)){
			url="./Goods/goodsModify.jsp";
		}
		return url;
	}

	
}
