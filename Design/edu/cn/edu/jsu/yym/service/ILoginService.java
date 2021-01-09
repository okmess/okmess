package cn.edu.jsu.yym.service;

import java.util.Vector;

import cn.edu.jsu.yym.vo.Login;

/**
 * Login数据表开发层操作标准
 * @author 86152
 *
 */
public interface ILoginService {
	/**
	 * 实现账户的注册增加操作，调用的是ILoginDAO.doCreate()、ILoginDAO.findByuserName方法
	 * @param vo 包含了要增加的账户名userName和密码password
	 * @return 如果账户注册成功返回true，否则返回false
	 */
	public boolean insert(Login vo);
	
	/**
	 * 账户密码修改，调用的是ILoginDAO.daUpdate()方法
	 *@param vo 包含了要增加的账户名userName和密码password
	 *@return 如果账户密码修改成功返回true，否则返回false
	 */
	public boolean update(Login vo);
	
	/**
	 * 账户注销，调用的是ILoginDAO.DoRemove()方法
	 * @param userName 包含了要注销的账户名userName
	 *@return 如果账户注销改成功返回true，否则返回false
	 */
	public boolean remove(String userName);
	
	/**
	 * 账户的用户名和密码查询，调用的是ILoginDAO.findByuserName方法
	 * @param userName 包含了查找的用户名
	 * @return 如果查询到用户名返回查询到的用户名和密码
	 */
	public Login select(String userName);
	
	/**
	 * 查找全部的账户名，执行的是select语句
	 * @return 得到所有的账户名
	 */
	public Vector<String> getAllUserName();
}
