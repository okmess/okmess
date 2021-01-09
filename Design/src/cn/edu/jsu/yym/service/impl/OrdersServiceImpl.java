package cn.edu.jsu.yym.service.impl;

import java.util.Vector;

import cn.edu.jsu.yym.dbc.DatabaseConnectionSql;
import cn.edu.jsu.yym.factory.DAOFactory;
import cn.edu.jsu.yym.service.IOrdersService;
import cn.edu.jsu.yym.vo.Orders;
import cn.edu.jsu.yym.vo.Personal01;

/**
 * 数据表Orders开发层标准的实现类
 * @author 86152
 *
 */
public class OrdersServiceImpl implements IOrdersService{
	private DatabaseConnectionSql dbc=new DatabaseConnectionSql();

	@Override
	public boolean insert(Orders vo) {
		try {
			return DAOFactory.getIOrdersDAOInstance(this.dbc.getConnection()).doCreate(vo);
		}catch(Exception e) {
			throw e;
		}finally {
			this.dbc.close();
		}
	}

	@Override
	public boolean update(Orders vo) {
		try {
			return DAOFactory.getIOrdersDAOInstance(this.dbc.getConnection()).doUpdate(vo);
		}catch(Exception e) {
			throw e;
		}finally {
			this.dbc.close();
		}
	}

	@Override
	public Vector<Vector> selectAll(String userName,Integer i) {
		Vector<Vector> rows=null;
		try {
			rows=DAOFactory.getIOrdersDAOInstance(this.dbc.getConnection()).getSelectAll(userName,i);
			if(rows==null) {
				rows=new Vector<Vector>();
			}
		}catch(Exception e) {
			throw e;
		}finally {
			this.dbc.close();
		}
		return rows;
	}

	@Override
	public boolean update(String userName, String newUserName) {
		try {
			return DAOFactory.getIOrdersDAOInstance(this.dbc.getConnection()).doUpdate(userName,newUserName);
		}catch(Exception e) {
			throw e;
		}finally {
			this.dbc.close();
		}
	}

}
