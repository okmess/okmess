package cn.edu.jsu.yym.dao;

import java.util.Vector;

import cn.edu.jsu.yym.vo.Orders;

/**
 * 定义Orders表的数据层操作标准
 * @author 李书豪
 */
public interface IOrdersDAO {
	/**
	 * 添加新的订单信息
	 * @param vo 包含新订单的数据
	 * @return 添加成功返回true，否则返回false
	 */
	public boolean doCreate(Orders vo);
	
	/**
	 * 订单状态更新
	 * @param vo 包含订单状态信息
	 * @return 更新成功返回true,否则返回false
	 */
	public boolean doUpdate(Orders vo);
	
	/**
     * 根据用户名查询订单信息
     *@param userName 用户名或者订单名,i为查询的模式
     *@param i 查询模式
     * @return 查询语句的结果集，类型为Vector嵌套集合
     */
	 public Vector<Vector> getSelectAll(String userName,Integer i);
	 
	 /**
		 * 更新订单信息
		 * @param userName 待更改的订单用户名
		 * @param newUserName 将更改的订单用户名
		 * @return 更新成功返回true，否则返回false
		 */
	public boolean doUpdate(String userName, String newUserName);
	 
	 
}
