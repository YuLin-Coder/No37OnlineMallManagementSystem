package comm;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import dao.GoodsDao;
import vo.Goods;

public class Demo {

	public static void main(String[] args) {
//		DBHandle db=new DBHandle();
//		ResultSet rs=db.executeQuery("select * from goods;");
//		try {
//			while(rs.next()){
//				for(int i=1;i<12;i++){
//					System.out.print(rs.getString(i)+" ");
//				}
//				System.out.println();
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try{
//			String id="7";
//			String sql = "select g.*,t.typeName as typeName from goods g join type t on g.typeId=t.id where goodsid="+id+";";
//			DBHandle dbHandle = new DBHandle();
//			ResultSet res = dbHandle.executeQuery(sql);
//			
//			while (res.next()) {
//				System.out.println(res.getString("goodsid"));
//				System.out.println(res.getString("goodsname"));
//			}
//			dbHandle.close();
//		}catch(Exception e){
//			
//		}
		
		List<Goods> li=new GoodsDao().query("");
//		Iterator<Goods> it=li.iterator();
//		while(it.hasNext()){
//			Goods model=it.next();
//			System.out.print(model.getGoodsid()+" ");
//			System.out.print(model.getGoodsname()+" ");
//			//summary,brand,place,price,discount,picPath,typeId,addDate,goodssum
//			System.out.print(model.getSummary()+" ");
//			System.out.print(model.getBrand()+" ");
//			System.out.print(model.getPlace()+" ");
//			System.out.print(model.getPrice()+" ");
//			System.out.print(model.getAddDate()+" ");
//			System.out.print(model.getGoodssum()+" ");
//			System.out.print(model.getTypeName()+" ");
//			System.out.println();
//		}
//		for(int i=0;i<li.size();i++){
//			Goods model=li.get(i);
//			System.out.print(model.getGoodsid()+" ");
//			System.out.print(model.getGoodsname()+" ");
//			//summary,brand,place,price,discount,picPath,typeId,addDate,goodssum
//			System.out.print(model.getSummary()+" ");
//			System.out.print(model.getBrand()+" ");
//			System.out.print(model.getPlace()+" ");
//			System.out.print(model.getPrice()+" ");
//			System.out.print(model.getAddDate()+" ");
//			System.out.print(model.getGoodssum()+" ");
//			System.out.print(model.getTypeName()+" ");
//			System.out.println();
//		}
		
//		System.out.println((new Timestamp(new Date().getTime())).toString());
		
		Goods model=new Goods();
		System.out.println(model!=null);
	}

}
