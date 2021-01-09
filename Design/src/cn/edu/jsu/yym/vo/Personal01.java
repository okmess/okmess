package cn.edu.jsu.yym.vo;

import java.sql.Date;

/**
 * Personal01数据类
 * @author 86152
 *
 */
public class Personal01 {
	private String useName;
	private String name;
	private String sex;
	private String workPlace;
	private String phone;
	/**
	 * 
	 * @return 返回用户名
	 */
	public String getUseName() {
		return useName;
	}
	/**
	 * 
	 * @param useName 设置用户名
	 */
	public void setUseName(String useName) {
		this.useName = useName;
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
	 * @param name 设置姓名
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
	 * @return 返回工作城市
	 */
	public String getWorkPlace() {
		return workPlace;
	}
	/**
	 * 
	 * @param workPlace 设置工作城市
	 */
	public void setWorkPlace(String workPlace) {
		this.workPlace = workPlace;
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
	 * @return 返回个人描述
	 */
	public String getDescribe() {
		return describe;
	}
	/**
	 * 
	 * @param describe 设置个人描述
	 */
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	/**
	 * 
	 * @return 
	 */
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	private String style;
	private String describe;
}
