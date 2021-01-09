package cn.edu.jsu.yym.service.impl;

import java.util.Vector;

import cn.edu.jsu.yym.dbc.DatabaseConnectionSql;
import cn.edu.jsu.yym.factory.DAOFactory;
import cn.edu.jsu.yym.service.ILoginService;
import cn.edu.jsu.yym.vo.Login;

/**
 * 数据表Login开发层标准的实现类
 * @author 86152
 *
 */
public class LoginServiceImpl implements ILoginService{
	private DatabaseConnectionSql dbc=new DatabaseConnectionSql();

	@Override
	public boolean insert(Login vo) {
		try {
			if(DAOFactory.getILoginDAOInstance(this.dbc.getConnection()).findByUserName(vo.getUserName()) != null)//查询注册的账号是否已存在
				return false;
			return DAOFactory.getILoginDAOInstance(this.dbc.getConnection()).doCreate(vo);
		}catch(Exception e) {
			throw e;
		}finally{
			this.dbc.close();
		}
	}

	@Override
	public boolean update(Login vo) {
		try {
			return DAOFactory.getILoginDAOInstance(this.dbc.getConnection()).doUpdate(vo);
		}catch(Exception e){
			throw e;
		}finally {
			this.dbc.close();
		}
	}

	@Override
	public boolean remove(String userName) {
		try {
			return DAOFactory.getILoginDAOInstance(this.dbc.getConnection()).doRemove(userName);
		}catch(Exception e) {
			throw e;
		}finally {
			this.dbc.close();
		}
	}

	@Override
	public Login select(String userName) {
		Login vo;
		try {
			vo=DAOFactory.getILoginDAOInstance(this.dbc.getConnection()).findByUserName(userName);
		}catch(Exception e) {
			throw e;
		}finally {
			this.dbc.close();
		}
		return vo;
	}

	@Override
	public Vector<String> getAllUserName() {
		Vector<String> vo = null;
		try {
			vo=DAOFactory.getILoginDAOInstance(this.dbc.getConnection()).findAllUserName();
		}catch(Exception e) {
			this.dbc.close();
		}
		return vo;
	}

}
