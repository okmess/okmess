/*
 * 负责数据的传输和包装
 */
package cn.edu.jsu.yym.vo;

import java.io.Serializable;

/**
 * Login数据类
 * @author 86152
 *
 */
public class Login implements Serializable{
	private String userName;
	private String password;
	
	/**
	 * 
	 */
	public Login() {}
	
	/**
	 * 
	 * @return 放回用户名
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
	/**
	 * 
	 * @return 返回密码
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * 
	 * @param password 设置密码
	 */
	public void setPassword(String password) {
		this.password = password;
	};
	
}
