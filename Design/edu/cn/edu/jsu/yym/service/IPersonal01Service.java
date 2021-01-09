package cn.edu.jsu.yym.service;

import cn.edu.jsu.yym.vo.Personal01;

/**
 * Personal01数据表开发层操作标准
 * @author 86152
 *
 */
public interface IPersonal01Service {
	/**
	 * 实现根据用户名添加数据,调用IPersonal01DAO.doCreate()函数
	 * @param vo 包含添加的数据
	 * @return 添加成功返回true，否则返回false；
	 */
	public boolean insert(Personal01 vo);
	
	/**
	 * 实现根据用户名修改数据，调用IPersonal01DAO.doUpdate()函数
	 * @param vo 包含修改的数据
	 * @return 修改成功返回true，否则返回false
	 */
	public boolean update(Personal01 vo);
	
	/**
	 * 实现根据用户名删除数据，调用IPersonal01DAO.doRemove()函数
	 * @param useName 为要删除的用户名
	 * @return 删除成功返回true，否则返回false
	 */
	public boolean delete(String useName);
	
	/**
	 * 实现根据用户名查找数据，调用IPersona01DAO.doselect()函数
	 * @param useName 为待查找的用户名,或姓名
	 * @param i 为选择模式
	 * @return 返回查找到的数据
	 */
	public Personal01 select(String useName,Integer i);
}
