/*
 * �������ݵĴ���Ͱ�װ
 */
package cn.edu.jsu.yym.vo;

import java.io.Serializable;

/**
 * Login������
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
	 * @return �Ż��û���
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * 
	 * @param userName �����û���
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * 
	 * @return ��������
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * 
	 * @param password ��������
	 */
	public void setPassword(String password) {
		this.password = password;
	};
	
}
