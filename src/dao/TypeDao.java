package dao;

import comm.Constant;
import comm.DBHandle;
import vo.Type;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 * 商品类型的增、删、改、查、得到实体提交数据库操作处理类
 * @author overlord
 *
 */
public class TypeDao {
	
	/**
	 * 向数据库增加商品类型
	 * @param model	商品类型实例
	 * @return		添加是否成功：成功增加数据的条目数
	 */
	public String add(Type model){
		String sql="insert into Type (TypeName) values (";
		sql=sql+"'"+model.getTypeName()+"'";
		sql+=");";
		DBHandle dbHandle=new DBHandle();
		String id=null;
		if(dbHandle.executeUpdate(sql)==1){
			id=Constant.getID(dbHandle);
		}
		dbHandle.close();
		return id;
	}
	/**
	 * 从数据库删除商品类型
	 * @param id	要删除的商品类型ID
	 * @return		删除是否成功：成功删除数据的条目数
	 */
	public int del(String id){
		String sql="delete from type where id="+id+";";
		DBHandle dbHandle=new DBHandle();
		int ret=dbHandle.executeUpdate(sql);
		dbHandle.close();
		return ret;
	}
	/**
	 * 修改数据库已有的商品类型
	 * @param model	要更新的商品类型实例（通过此实例ID定位商品类型条目）
	 * @return		修改是否成功：成功修改数据的条目数
	 */
	public int modify(Type model){
		String sql="update Type set";
		sql=sql+" TypeName='"+model.getTypeName()+"'";
		sql=sql+" where id="+model.getId()+"";
		sql+=";";
		DBHandle dbHandle=new DBHandle();
		int ret=dbHandle.executeUpdate(sql);
		dbHandle.close();
		return ret;
	}
	/**
	 * 通过ID，从数据库查询得到商品类型实例
	 * @param id	要查询的商品类型ID
	 * @return		返回查询的商品类型实例：Type类型
	 */
	public Type getModel(String id){
		Type model=new Type();
		try{
			String sql = "select * from type where id="+id+";";
			DBHandle dbHandle = new DBHandle();
			ResultSet res = dbHandle.executeQuery(sql);
			while (res.next()) {
				model.setId(res.getString("id"));
				model.setTypeName(res.getString("TypeName"));
			}
			dbHandle.close();
		} catch (Exception e){
			System.out.println("获取商品类型实例出错！");
		}
		return model;
	}
	/**
	 * 查询数据库的商品类型信息
	 * @param where	查询的条件
	 * @return		查询结果：以List<Type>形式返回
	 */
	public List<Type> query(String where){
		List<Type> li = new ArrayList<Type>();
		try {
			String sql = "select * from type";
			if (where.length() > 0) {
				sql = sql + " where " + where;
			}
			sql += ";";
			DBHandle dbHandle = new DBHandle();
			ResultSet res = dbHandle.executeQuery(sql);
			//Id,TypeName
			while (res.next()) {
				Type type = new Type();
				type.setId(res.getString("Id"));
				type.setTypeName(res.getString("TypeName"));
				li.add(type);
			}
			dbHandle.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}
}
