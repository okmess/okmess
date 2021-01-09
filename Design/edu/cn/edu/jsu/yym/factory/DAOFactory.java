package cn.edu.jsu.yym.factory;

import java.sql.Connection;

import cn.edu.jsu.yym.dao.ILoginDAO;
import cn.edu.jsu.yym.dao.IOrdersDAO;
import cn.edu.jsu.yym.dao.IPersonal01DAO;
import cn.edu.jsu.yym.dao.IUseLoginDAO;
import cn.edu.jsu.yym.dao.impl.LoginDAOImpl;
import cn.edu.jsu.yym.dao.impl.OrdersDAOImpl;
import cn.edu.jsu.yym.dao.impl.Personal01DAOImpl;
import cn.edu.jsu.yym.dao.impl.UseLoginDAOImpl;
/**
 * 数据操作类工厂
 * @author 86152
 *
 */
public class DAOFactory {
	/**
	 * 
	 * @param conn 数据库的连接
	 * @return Login数据层操作对象
	 */
	public static ILoginDAO getILoginDAOInstance(Connection conn) {
		return new LoginDAOImpl(conn);
	}
	/**
	 * 
	 * @param conn 数据库的连接
	 * @return UseLogin数据层操作对象
	 */
	public static IUseLoginDAO getIUseLoginDAOInstance(Connection conn) {
		return new UseLoginDAOImpl(conn);
	}
	/**
	 * 
	 * @param conn 数据库的连接
	 * @return Personal01数据层操作对象
	 */
	public static IPersonal01DAO getIPersonal01DAOInstance(Connection conn) {
		return new Personal01DAOImpl(conn);
	}
	/**
	 * 
	 * @param conn 数据库的连接
	 * @return Orders数据层操作对象
	 */
	public static IOrdersDAO getIOrdersDAOInstance(Connection conn) {
		return new OrdersDAOImpl(conn);
		
	}
}
