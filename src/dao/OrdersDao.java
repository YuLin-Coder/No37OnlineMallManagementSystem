package dao;

import comm.Constant;
import comm.DBHandle;
import vo.Orders;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 * 订单的增、删、改、查、得到实体提交数据库操作处理类
 * @author overlord
 *
 */
public class OrdersDao {
	
	/**
	 * 向数据库增加订单
	 * @param model	订单实例
	 * @return		添加是否成功：成功增加数据的条目数
	 */
	public String add(Orders model){
		String id=null;
		String sql="insert into Orders (orderDate,payType,transportType,amount,money,userId,goodsId,zhuang,youbian,number,beizhu,userName,address) values (";
		sql=sql+"'"+model.getOrderDate()+"'";
		sql=sql+",'"+model.getPayType()+"'";
		sql=sql+",'"+model.getTransportType()+"'";
		sql=sql+","+model.getAmount()+"";
		sql=sql+","+model.getMoney()+"";
		sql=sql+","+model.getUserId()+"";
		sql=sql+","+model.getGoodsId()+"";
		sql=sql+",'"+model.getZhuang()+"'";
		sql=sql+",'"+model.getYoubian()+"'";
		sql=sql+",'"+model.getNumber()+"'";
		sql=sql+",'"+model.getBeizhu()+"'";
		sql=sql+",'"+model.getUserName()+"'";
		sql=sql+",'"+model.getAddress()+"'";
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
	 * 从数据库删除订单
	 * @param id	要删除的订单ID
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
	 * 修改数据库已有的订单
	 * @param model	要更新的订单实例（通过此实例ID定位订单条目）
	 * @return		修改是否成功：成功修改数据的条目数
	 */
	public int modify(Orders model){
		String sql="update Orders set";
		sql=sql+" orderDate='"+model.getOrderDate()+"',";
		sql=sql+"payType='"+model.getPayType()+"',";
		sql=sql+"transportType='"+model.getPayType()+"',";
		sql=sql+"amount="+model.getAmount()+",";
		sql=sql+"money="+model.getMoney()+",";
		sql=sql+"userId="+model.getUserId()+",";
		sql=sql+"goodsId="+model.getGoodsId()+",";
		sql=sql+"zhuang='"+model.getZhuang()+"',";
		sql=sql+"youbian='"+model.getYoubian()+"',";
		sql=sql+"number='"+model.getNumber()+"',";
		sql=sql+"beizhu='"+model.getBeizhu()+"',";
		sql=sql+"userName='"+model.getUserName()+"',";
		sql=sql+"address='"+model.getAddress()+"',";
		sql=sql+" where id="+model.getId();
		sql+=";";
		DBHandle dbHandle=new DBHandle();
		int ret=dbHandle.executeUpdate(sql);
		dbHandle.close();
		return ret;
	}
	/**
	 * 通过ID，从数据库查询得到订单实例
	 * @param id	要查询的订单ID
	 * @return		返回查询的订单实例：Orders类型
	 */
	public Orders getModel(String id){
		Orders model=new Orders();
		try{
			String sql = "select * from orders o join Goods g on o.goodsId=g.goodsId where o.id="+id+";";
			DBHandle dbHandle = new DBHandle();
			ResultSet res = dbHandle.executeQuery(sql);
			dbHandle.close();
			while (res.next()) {
				model.setId(res.getString("id"));
				model.setOrderDate(res.getString("orderDate"));
				model.setPayType(res.getString("payType"));
				model.setTransportType(res.getString("transportType"));
				model.setAmount(res.getString("amount"));
				model.setMoney(res.getString("money"));
				model.setUserId(res.getString("userId"));
				model.setGoodsId(res.getString("goodsId"));
				model.setZhuang(res.getString("zhuang"));
				model.setYoubian(res.getString("youbian"));
				model.setNumber(res.getString("number"));
				model.setBeizhu(res.getString("beizhu"));
				model.setUserName(res.getString("userName"));
				model.setAddress(res.getString("address"));
				model.setGoodsName(res.getString("goodsName"));
			}
		} catch (Exception e){
			System.out.println("获取订单实例出错！");
		}
		return model;
	}
	/**
	 * 查询数据库的订单信息
	 * @param where	查询的条件
	 * @return		查询结果：以List<Orders>形式返回
	 */
	public List<Orders> query(String where){
		List<Orders> li = new ArrayList<Orders>();
		try {
			String sql = "select * from orders o join Goods g on o.goodsId=g.goodsId";
			if (where.length() > 0) {
				sql = sql + " where " + where;
			}
			sql += ";";
			DBHandle dbHandle = new DBHandle();
			ResultSet res = dbHandle.executeQuery(sql);
			while (res.next()) {
				Orders model = new Orders();
				model.setId(res.getString("id"));
				model.setOrderDate(res.getString("orderDate"));
				model.setPayType(res.getString("payType"));
				model.setTransportType(res.getString("transportType"));
				model.setAmount(res.getString("amount"));
				model.setMoney(res.getString("money"));
				model.setUserId(res.getString("userId"));
				model.setGoodsId(res.getString("goodsId"));
				model.setZhuang(res.getString("zhuang"));
				model.setYoubian(res.getString("youbian"));
				model.setNumber(res.getString("number"));
				model.setBeizhu(res.getString("beizhu"));
				model.setUserName(res.getString("userName"));
				model.setAddress(res.getString("address"));
				model.setGoodsName(res.getString("goodsName"));
				li.add(model);
			}
			dbHandle.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("List形式返回订单查询出错");
		}
		return li;
	}
}
