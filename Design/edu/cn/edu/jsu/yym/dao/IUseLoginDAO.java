package cn.edu.jsu.yym.dao;

import java.util.Vector;

import cn.edu.jsu.yym.vo.Login;

/**
 * 定义UseLogin表的数据层操作标准
 * @author 李书豪
 */
public interface IUseLoginDAO {
	/**
	 * 账户注册的增加操作，执行的是INSERT语句
	 * @param vo 包含了要增加的账户名userName和密码password
	 * @return 账户注册成功返回true，否则返回false
	 */
	public boolean doCreate(Login vo);
	
	/**
	 * 密码的修改操作，执行的是UPDATE语句，根据用户名userName修改密码password
	 * @param vo 包含了要修改的新密码
	 * @return 密码修改成功返回true，否则返回false
	 */
	public boolean doUpdate(Login vo);
	
	/**
	 * 账户的注销操作，执行的是delete语句
	 * @param userName 包含要注销账户的用户名
	 * @return 账户注销成功返回true，否则返回false
	 */
	public boolean doRemove(String userName);
	
	/**
	 * 查找账户是否已经存在，执行的是select语句
	 * @param userName 查找的账号的用户名
	 * @return 查找得到该账户的用户名和密码
	 */
	public Login findByUserName(String userName);
	
	/**
	 * 查找全部的账户名，执行的是select语句
	 * @return 得到所有的账户名
	 */
	public Vector<String> findAllUserName();
}