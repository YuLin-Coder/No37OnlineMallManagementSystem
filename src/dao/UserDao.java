package dao;

import comm.Constant;
import comm.DBHandle;
import vo.User;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 * 用户的增、删、改、查、得到实体提交数据库操作处理类
 * @author overlord
 *
 */
public class UserDao {
	
	/**
	 * 向数据库增加用户
	 * @param model	用户实例
	 * @return		添加是否成功：成功增加数据的条目数
	 */
	public String add(User model){
		String sql="insert into User (city,username,realname,password,address,papersNO,papersType,sex,number,addTime,userType,email) values (";
		sql=sql+"'"+model.getCity()+"'";
		sql=sql+",'"+model.getUsername()+"'";
		sql=sql+",'"+model.getRealname()+"'";
		sql=sql+","+model.getPassword()+"";
		sql=sql+",'"+model.getAddress()+"'";
		sql=sql+","+model.getPapersNO()+"";
		sql=sql+",'"+model.getPapersType()+"'";
		sql=sql+",'"+model.getSex()+"'";
		sql=sql+",'"+model.getNumber()+"'";
		sql=sql+",'"+model.getAddTime()+"'";
		sql=sql+",'"+model.getUserType()+"'";
		sql=sql+",'"+model.getEmail()+"'";
		sql+=");";
		DBHandle dbHandle=new DBHandle();
		int ret=dbHandle.executeUpdate(sql);
		String id=null;
		if(ret==1){
			id=Constant.getID(dbHandle);
		}
		dbHandle.close();
		return id;
	}
	/**
	 * 从数据库删除用户
	 * @param id	要删除的用户ID
	 * @return		删除是否成功：成功删除数据的条目数
	 */
	public int del(String id){
		String sql="delete from user where id="+id+";";
		DBHandle dbHandle=new DBHandle();
		int ret=dbHandle.executeUpdate(sql);
		dbHandle.close();
		return ret;
	}
	/**
	 * 修改数据库已有的用户
	 * @param model	要更新的用户实例（通过此实例ID定位用户条目）
	 * @return		修改是否成功：成功修改数据的条目数
	 */
	public int modify(User model){
		String sql="update User set";
		sql=sql+" city='"+model.getCity()+"',";
		sql=sql+"username='"+model.getUsername()+"',";
		sql=sql+"realname='"+model.getRealname()+"',";
		sql=sql+"password='"+model.getPassword()+"',";
		sql=sql+"address='"+model.getAddress()+"',";
		sql=sql+"papersNO='"+model.getPapersNO()+"',";
		sql=sql+"papersType='"+model.getPapersType()+"',";
		sql=sql+"sex='"+model.getSex()+"',";
		sql=sql+"number='"+model.getNumber()+"',";
		sql=sql+"addTime='"+model.getAddTime()+"',";
		sql=sql+"userType='"+model.getUserType()+"',";
		sql=sql+"email='"+model.getEmail()+"'";
		sql=sql+" where id="+model.getId();
		sql+=";";
		DBHandle dbHandle=new DBHandle();
		int ret=dbHandle.executeUpdate(sql);
		dbHandle.close();
		return ret;
	}
	/**
	 * 通过ID，从数据库查询得到用户实例
	 * @param id	要查询的用户ID
	 * @return		返回查询的用户实例：User类型
	 */
	public User getModel(String id){
		User model=new User();
		try{
			String sql = "select * from user where id="+id+";";
			DBHandle dbHandle = new DBHandle();
			ResultSet res = dbHandle.executeQuery(sql);
			dbHandle.close();
			while (res.next()) {
				model.setId(res.getString("id"));
				model.setId(res.getString("city"));
				model.setId(res.getString("username"));
				model.setId(res.getString("realname"));
				model.setId(res.getString("password"));
				model.setId(res.getString("address"));
				model.setId(res.getString("papersNO"));
				model.setId(res.getString("papersType"));
				model.setId(res.getString("sex"));
				model.setId(res.getString("number"));
				model.setId(res.getString("addTime"));
				model.setId(res.getString("userType"));
				model.setId(res.getString("email"));
			}
		} catch (Exception e){
			System.out.println("获取用户实例出错！");
		}
		return model;
	}
	/**
	 * 查询数据库的用户信息
	 * @param where	查询的条件
	 * @return		查询结果：以List<User>形式返回
	 */
	public List<User> query(String where){
		List<User> li = new ArrayList<User>();
		try {
			String sql = "select * from user";
			if (where.length() > 0) {
				sql = sql + " where " + where;
			}
			sql += ";";
			DBHandle dbHandle = new DBHandle();
			ResultSet res = dbHandle.executeQuery(sql);
			while (res.next()) {
				User model = new User();
				model.setId(res.getString("id"));
				model.setCity(res.getString("city"));
				model.setUsername(res.getString("username"));
				model.setRealname(res.getString("realname"));
				model.setPassword(res.getString("password"));
				model.setAddress(res.getString("address"));
				model.setPapersNO(res.getString("papersNO"));
				model.setPapersType(res.getString("papersType"));
				model.setSex(res.getString("sex"));
				model.setNumber(res.getString("number"));
				model.setAddTime(res.getString("addTime"));
				model.setUserType(res.getString("userType"));
				model.setEmail(res.getString("email"));
				li.add(model);
			}
			dbHandle.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("List形式返回用户查询出错");
		}
		return li;
	}
}
