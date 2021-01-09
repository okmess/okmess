package cn.edu.jsu.yym.vo;

/**
 * Orders数据类
 * @author 86152
 *
 */
public class Orders {
	private String orderNumber;
	private String name;
	private String sex;
	private String style;
	private String status;
	private String photographUserName;
	private String userName;
	/**
	 * 
	 * @return 返回订单号
	 */
	public String getOrderNumber() {
		return orderNumber;
	}
	/**
	 * 
	 * @param orderNumber 设置订单号
	 */
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	/**
	 * 
	 * @return 返回姓名
	 */
	public String getName() {
		return name;
	}
	/**
	 * 
	 * @param name 设置密码
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 
	 * @return 返回性别
	 */
	public String getSex() {
		return sex;
	}
	/**
	 * 
	 * @param sex 设置性别
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}
	/**
	 * 
	 * @return 返回风格
	 */
	public String getStyle() {
		return style;
	}
	/**
	 * 
	 * @param style 设置风格
	 */
	public void setStyle(String style) {
		this.style = style;
	}
	/**
	 * 
	 * @return 返回状态
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * 
	 * @param status 设置状态
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 
	 * @return 返回摄影师用户名
	 */
	public String getPhotographUserName() {
		return photographUserName;
	}
	/**
	 * 
	 * @param photographUserName 设置摄影师用户名
	 */
	public void setPhotographUserName(String photographUserName) {
		this.photographUserName = photographUserName;
	}
	/**
	 * 
	 * @return 返回用户名
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * 
	 * @param userName 设置用户名
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
