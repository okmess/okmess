package cn.edu.jsu.yym.service;

import java.util.Vector;

import cn.edu.jsu.yym.vo.Orders;

/**
 * Orders数据表开发层操作标准
 * @author 86152
 *
 */
public interface IOrdersService {
	/**
	 * 添加新的订单信息
	 * @param vo 包含待添加的订单信息
	 * @return 添加成功返回true，否则返回false
	 */
	public boolean insert(Orders vo); 
	
	/**
	 * 更新订单状态
	 * @param vo 包含待更改的订单状态
	 * @return 更新成功返回true，否则返回false
	 */
	public boolean update(Orders vo);
	
	/**
	 * 根据用户名查询订单信息
	 * @param userName 用户名
	 * @param i 查询模式
	 * @return 查询语句的结果集，类型为Vector嵌套集合
	 */
	public Vector<Vector> selectAll(String userName,Integer i);
	
	/**
	 * 更新订单信息
	 * @param userName 包含待更改的订单用户名
	 * @param newUserName 待更改的订单用户名
	 * @return 更新成功返回true，否则返回false
	 */
	public boolean update(String userName, String newUserName);
}
