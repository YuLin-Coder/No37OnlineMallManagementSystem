package comm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBHandle {
	//声明私有静态常量：数据库连接位置、登录名、密码、驱动名
	final private String URL="jdbc:mysql://localhost:3306/no37_onlinestore?characterEncoding=utf-8";
	final private String LOGIN="root";
	final private String PASSWORD="123456";
	final private String DRIVERNAME="com.mysql.jdbc.Driver";
	//声明私有静态属性：数据库连接、sql语句执行对象、查询结果集
	private Connection conn;
	private Statement st;
	private ResultSet rs;
	
	//建立连接
	/**
	 * 数据库连接
	 */
	public void getConnection(){
		try {
			Class.forName(DRIVERNAME); // 第一步:加载驱动程序
			conn = DriverManager.getConnection(URL, LOGIN, PASSWORD);// 第二步:创建一个数据库连接
			System.out.println("获取数据库连接成功！");
		}catch(Exception e){
			System.out.println("执行getConnection()方法出错：");
			e.printStackTrace();
		}
	}
	
	//执行SQL insert/update/delete
	/**
	 * 数据库增加/删除/修改
	 * @param sql
	 * @return 受影响行数：-1 异常
	 */
	public int executeUpdate(String sql){
		int ret=0;
		try{
			if(conn==null){
				getConnection();
			}
			if(st==null)
			{
				st=conn.createStatement();
			}
			System.out.println("=================="+sql);
			ret=st.executeUpdate(sql);
		}catch(Exception e){
			System.out.println("执行executeUpdate(sql)方法出错："+sql);
			e.printStackTrace();
			ret=-1;
		}
		return ret;
	}
	
	//执行查询	 select
	
	/**
	 * 数据库查询
	 * @param sql
	 */
	public ResultSet executeQuery(String sql){
		try{
			if(conn==null){
				getConnection();
			}
			if(st==null)
			{
				st=conn.createStatement();
			}
			System.out.println("=================="+sql);
			rs=st.executeQuery(sql);
		}catch(Exception e){
			System.out.println("执行executeQuery(String sql)方法出错："+sql);
			e.printStackTrace();
		}
                return rs;
	}
	
	//关闭连接
	/**
	 * 数据库关闭
	 */
	public void close(){
		try {
		if (rs!=null){
			rs.close();
		}
		if (st!=null){
			st.close();
		}
		if (conn!=null){
			conn.close();
		}}
		catch(Exception e){
			System.out.println("执行close()方法出错：");
			e.printStackTrace();
		}
	}

}
