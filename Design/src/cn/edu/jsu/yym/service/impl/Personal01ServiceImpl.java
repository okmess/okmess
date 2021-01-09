package cn.edu.jsu.yym.service.impl;

import cn.edu.jsu.yym.dbc.DatabaseConnectionSql;
import cn.edu.jsu.yym.factory.DAOFactory;
import cn.edu.jsu.yym.service.IPersonal01Service;
import cn.edu.jsu.yym.vo.Personal01;

/**
 * 数据表Personal01开发层标准的实现类
 * @author 86152
 *
 */
public class Personal01ServiceImpl implements IPersonal01Service{
	private DatabaseConnectionSql dbc=new DatabaseConnectionSql();

	@Override
	public boolean insert(Personal01 vo) {
		try {
			return DAOFactory.getIPersonal01DAOInstance(this.dbc.getConnection()).doCreate(vo);
		}catch(Exception e) {
			throw e;
		}finally{
			this.dbc.close();
		}
	}

	@Override
	public boolean update(Personal01 vo) {
		try {
			return DAOFactory.getIPersonal01DAOInstance(this.dbc.getConnection()).doUpdate(vo);
		}catch(Exception e) {
			throw e;
		}finally {
			this.dbc.close();
		}
		
	}

	@Override
	public boolean delete(String useName) {
		try {
			return DAOFactory.getIPersonal01DAOInstance(this.dbc.getConnection()).doRemove(useName);
		}catch(Exception e) {
			throw e;
		}finally {
			this.dbc.close();
		}
	}

	@Override
	public Personal01 select(String useName,Integer i) {
		Personal01 vo=null;
		try {
			vo=DAOFactory.getIPersonal01DAOInstance(this.dbc.getConnection()).doSelect(useName,i);
			if(vo==null) {
				vo=new Personal01();
			}
		}catch(Exception e) {
			throw e;
		}finally {
			this.dbc.close();
		}
		return vo;
	}
	
}
