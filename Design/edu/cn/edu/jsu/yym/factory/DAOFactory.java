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
 * ���ݲ����๤��
 * @author 86152
 *
 */
public class DAOFactory {
	/**
	 * 
	 * @param conn ���ݿ������
	 * @return Login���ݲ��������
	 */
	public static ILoginDAO getILoginDAOInstance(Connection conn) {
		return new LoginDAOImpl(conn);
	}
	/**
	 * 
	 * @param conn ���ݿ������
	 * @return UseLogin���ݲ��������
	 */
	public static IUseLoginDAO getIUseLoginDAOInstance(Connection conn) {
		return new UseLoginDAOImpl(conn);
	}
	/**
	 * 
	 * @param conn ���ݿ������
	 * @return Personal01���ݲ��������
	 */
	public static IPersonal01DAO getIPersonal01DAOInstance(Connection conn) {
		return new Personal01DAOImpl(conn);
	}
	/**
	 * 
	 * @param conn ���ݿ������
	 * @return Orders���ݲ��������
	 */
	public static IOrdersDAO getIOrdersDAOInstance(Connection conn) {
		return new OrdersDAOImpl(conn);
		
	}
}
