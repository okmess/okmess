package cn.edu.jsu.yym.dao;

import cn.edu.jsu.yym.vo.Personal01;

/**
 * 定义Personal01表的数据层操作标准
 * @author 李书豪
 */
public interface IPersonal01DAO {
	/**
	 * 根据用户名向表添加数据
	 * @param vo 包含添加的数据
	 * @return 添加成功返回true，否则返回false；
	 */
	public boolean doCreate(Personal01 vo);
	
	/**
	 * 根据用户名修改数据
	 * @param vo 包含修改的数据
	 * @return 修改成功返回true，否则返回false
	 */
	public boolean doUpdate(Personal01 vo);
	
	/**
	 * 根据用户名删除数据
	 * @param useName 为要删除的用户名
	 * @return 删除成功返回true，否则返回false
	 */
	public boolean doRemove(String useName);
	
	/**
	 * 根据用户名查询数据
	 * @param useName 为要查询的用户名或姓名
	 * @param i 为查询的模式
	 * @return 查询成功返回Personal01 vo
	 */
	public Personal01 doSelect(String useName,Integer i);
}
