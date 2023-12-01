package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import comm.Constant;
import comm.DBHandle;
import vo.Goods;
/**
 * 商品的增、删、改、查、得到实体提交数据库操作处理类
 * @author overlord
 *
 */
public class GoodsDao {
	
	/**
	 * 向数据库增加商品
	 * @param model	商品实例
	 * @return		添加是否成功：成功增加数据的条目数
	 */
	public String add(Goods model){
		String id=null;
		String sql="insert into Goods (goodsname,summary,brand,place,price,discount,picPath,typeId,addDate,goodssum) values (";
		sql=sql+"'"+model.getGoodsname()+"'";
		sql=sql+",'"+model.getSummary()+"'";
		sql=sql+",'"+model.getBrand()+"'";
		sql=sql+",'"+model.getPlace()+"'";
		sql=sql+","+model.getPrice();
		sql=sql+","+model.getDiscount();
		sql=sql+",'"+model.getPicPath()+"'";
		sql=sql+","+model.getTypeId();
		sql=sql+",'"+model.getAddDate()+"'";
		sql=sql+","+model.getGoodssum();
		sql+=");";
		DBHandle dbHandle=new DBHandle();
		int ret=dbHandle.executeUpdate(sql);
		if(ret==1){
			id=Constant.getID(dbHandle);
		}
		dbHandle.close();
		return id;
	}
	/**
	 * 从数据库删除商品
	 * @param id	要删除的商品ID
	 * @return		删除是否成功：成功删除数据的条目数
	 */
	public int del(String id){
		String sql="delete from goods where goodsid="+id+";";
		DBHandle dbHandle=new DBHandle();
		int ret=dbHandle.executeUpdate(sql);
		dbHandle.close();
		return ret;
	}
	/**
	 * 修改数据库已有的商品
	 * @param model	要更新的商品实例（通过此实例ID定位商品条目）
	 * @return		修改是否成功：成功修改数据的条目数
	 */
	public int modify(Goods model){
		String sql="update goods set";
		sql=sql+" goodsname='"+model.getGoodsname()+"',";
		sql=sql+"summary='"+model.getSummary()+"',";
		sql=sql+"brand='"+model.getBrand()+"',";
		sql=sql+"place='"+model.getPlace()+"',";
		sql=sql+"price="+model.getPrice()+",";
		sql=sql+"discount="+model.getDiscount()+",";
		sql=sql+"picPath='"+model.getPicPath()+"',";
		sql=sql+"typeId="+model.getTypeId()+",";
		sql=sql+"addDate='"+model.getAddDate()+"',";
		sql=sql+"goodssum="+model.getGoodssum()+"";
		sql=sql+" where goodsid="+model.getGoodsid()+"";
		sql+=";";
		DBHandle dbHandle=new DBHandle();
		int ret=dbHandle.executeUpdate(sql);
		dbHandle.close();
		return ret;
	}
	/**
	 * 通过ID，从数据库查询得到商品实例
	 * @param id	要查询的商品ID
	 * @return		返回查询的商品实体：Goods类型
	 */
	public Goods getModel(String id){
		Goods model=new Goods();
		try{
			String sql = "select g.*,t.typeName as typeName from goods g join type t on g.typeId=t.id where goodsid="+id+";";
			DBHandle dbHandle = new DBHandle();
			ResultSet res = dbHandle.executeQuery(sql);
			while (res.next()) {
				model.setGoodsid(res.getString("goodsid"));
				model.setGoodsname(res.getString("goodsname"));
				model.setSummary(res.getString("summary"));
				model.setBrand(res.getString("brand"));
				model.setPlace(res.getString("place"));
				model.setPrice(res.getString("price"));
				model.setDiscount(res.getString("discount"));
				model.setPicPath(res.getString("picPath"));
				model.setTypeId(res.getString("typeId"));
				model.setAddDate(res.getString("addDate"));
				model.setGoodssum(res.getString("goodssum"));
				model.setTypeName(res.getString("typeName"));//辅助属性
			}
			dbHandle.close();
		} catch (Exception e){
			System.out.println("从数据库获取Goods实体出错");
		}
		return model;
	}
	
	/**
	 * 查询数据库的商品信息
	 * @param where	查询的条件
	 * @return		查询结果：以List<Goods>形式返回
	 */
	public List<Goods> query(String where){
		List<Goods> li = new ArrayList<Goods>();
		try {
			String sql = "select g.*,t.typeName as typeName from goods g join type t on g.typeId=t.id";
			if (where.length() > 0) {
				sql = sql + " where " + where;
			}
			sql += " order by goodsid;";
			DBHandle dbHandle = new DBHandle();
			ResultSet res = dbHandle.executeQuery(sql);
			// goodsid,goodsname,summary,brand,place,price,discount,picPath,typeId,addDate,goodssum,typeName
			while (res.next()) {
				Goods model = new Goods();
				model.setGoodsid(res.getString("goodsid"));
				model.setGoodsname(res.getString("goodsname"));
				model.setSummary(res.getString("summary"));
				model.setBrand(res.getString("brand"));
				model.setPlace(res.getString("place"));
				model.setPrice(res.getString("price"));
				model.setDiscount(res.getString("discount"));
				model.setPicPath(res.getString("picPath"));
				model.setTypeId(res.getString("typeId"));
				model.setAddDate(res.getString("addDate"));
				model.setGoodssum(res.getString("goodssum"));
				model.setTypeName(res.getString("typeName"));//辅助属性
				li.add(model);
			}
			dbHandle.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("List形式返回商品查询信息出错");
		}
		return li;
	}
}
