package buss;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.Goods;
import vo.Orders;
import comm.Constant;
import comm.ServletDeal;
import dao.GoodsDao;
import dao.OrdersDao;

/**
 * Servlet implementation class OrdersServlet
 */
@WebServlet("/OrdersServlet")
public class OrdersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrdersServlet() {
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
		// 设置字符集
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

	private void add(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
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
		List<Orders> li=new OrdersDao().query("");
		request.getSession().setAttribute("OrdersList", li);
		request.getSession().setAttribute("clear", "OrdersList");
		try{
			if (li.size()>0) {
				response.sendRedirect("./Orders/ordersList.jsp");
			} else {
				response.getWriter().print("查询失败");
			}
		}catch(Exception e){
			System.out.println("query的response跳转页面出错");
		}
	}

}
