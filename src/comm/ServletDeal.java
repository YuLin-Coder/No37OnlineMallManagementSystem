package comm;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDeal {
	/**
	 * 设置弹出提示并跳转的方法
	 * @param response
	 * @param hint	弹出提示的内容
	 * @param url	跳转地址
	 */
	public static void popupHintAndRedict(HttpServletResponse response,String hint,String url){
		PrintWriter pw;
		try {
			pw = response.getWriter();
			pw.println("<script type=\"text/javascript\">");
			pw.println("alert(\""+hint+"\");");
			pw.println("window.location=\""+url+"\";");
			pw.println("</script>");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("弹出提示并跳转页面出错");
		}
	}
	
	/**
	 * 提交查询页面的时候清除已过期的session存储属性
	 * @param request
	 */
	public static void clearSession(HttpServletRequest request){
		String clear=(String)request.getSession().getAttribute("clear");
		if(clear!=null){
			request.getSession().removeAttribute(clear);
			request.getSession().removeAttribute("clear");
		}
	}
	

}
