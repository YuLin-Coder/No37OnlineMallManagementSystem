package vo;

public class Goods {
	private String goodsid;//主键，商品编号',
	private String goodsname;//商品名称',
	private String summary;//简介',
	private String brand;//品牌',
	private String place;//原产地',
	private String price;//单价',
	private String discount;//折扣',
	private String picPath;//图片地址',
	private String typeId;//外键参照类别表的主键',
	private String addDate;//添加时间',
	private String goodssum;//商品销售总数',

	//辅助属性
	private String typeName;//产品类型名称
//	select g.*,t.typeName from goods g join type t on g.typeid=t.id;
	
	
	
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
	public String getGoodsid() {
		return goodsid;
	}
	public void setGoodsid(String goodsid) {
		this.goodsid = goodsid;
	}
	public String getGoodsname() {
		return goodsname;
	}
	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getDiscount() {
		return discount;
	}
	public void setDiscount(String discount) {
		this.discount = discount;
	}
	public String getPicPath() {
		return picPath;
	}
	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}
	public String getTypeId() {
		return typeId;
	}
	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}
	public String getAddDate() {
		return addDate;
	}
	public void setAddDate(String addDate) {
		this.addDate = addDate;
	}
	public String getGoodssum() {
		return goodssum;
	}
	public void setGoodssum(String goodssum) {
		this.goodssum = goodssum;
	}
	

}
