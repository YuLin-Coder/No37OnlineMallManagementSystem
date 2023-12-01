package comm;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 常量储存类
 * @author overlord
 *
 */
public class Constant {
	//字符集设置相关方法
	public static final String CHARSET="utf-8";
	public static final String CONTENTHEAD="text/html;charset=utf-8";

	/**
	 * 获取新增行自动分配ID的常用方法
	 * @param dbHandle 已插入数据的数据库对象
	 * @return
	 */
	public static String getID(DBHandle dbHandle){
		ResultSet res = dbHandle.executeQuery("select last_insert_id();");
		String id=null;
		try {
			res.next();
			id=res.getString(1);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("获取新增行id的sql方法异常");
		}
		return id;
	}
}
