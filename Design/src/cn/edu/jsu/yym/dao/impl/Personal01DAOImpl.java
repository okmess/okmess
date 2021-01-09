package cn.edu.jsu.yym.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.edu.jsu.yym.dao.IPersonal01DAO;
import cn.edu.jsu.yym.vo.Login;
import cn.edu.jsu.yym.vo.Personal01;

/**
 * Personal01数据开发层的标准实现类
 * @author 86152
 *
 */
public class Personal01DAOImpl implements IPersonal01DAO{
	private Connection conn;//数据库连接对象
	private PreparedStatement pstmt;//数据库操作对象
	/**
	 * 
	 * @param conn
	 */
	public Personal01DAOImpl(Connection conn) {
		this.conn=conn;
	}

	@Override
	public boolean doCreate(Personal01 vo) {
		String sql="insert into Personal01(useName,name,sex,workPlace,style,describe,phone)values(?,?,?,?,?,?,?)";
		boolean i=false;
		try {
			this.pstmt=this.conn.prepareStatement(sql);
			this.pstmt.setString(1,vo.getUseName());
			this.pstmt.setString(2,vo.getName());
			this.pstmt.setString(3,vo.getSex());
			this.pstmt.setString(4,vo.getWorkPlace());
			this.pstmt.setString(5,vo.getStyle());
			this.pstmt.setString(6,vo.getDescribe());
			this.pstmt.setString(7, vo.getPhone());
			i=this.pstmt.executeUpdate()>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public boolean doUpdate(Personal01 vo) {
		String sql="update Personal01 set name=?,sex=?,workPlace=?,style=?,describe=?,phone=? where useName=?";
		boolean i=false;
		try {
			this.pstmt=this.conn.prepareStatement(sql);
			this.pstmt.setString(1,vo.getName());
			this.pstmt.setString(2,vo.getSex());
			this.pstmt.setString(3,vo.getWorkPlace());
			this.pstmt.setString(4,vo.getStyle());
			this.pstmt.setString(5,vo.getDescribe());
			this.pstmt.setString(6, vo.getPhone());
			this.pstmt.setString(7,vo.getUseName());
			i=this.pstmt.executeUpdate()>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public boolean doRemove(String useName) {
		String sql="delete from Personal01 where useName=?";
		boolean i=false;
		try {
			this.pstmt=this.conn.prepareStatement(sql);
			this.pstmt.setString(1,useName);
			i=this.pstmt.executeUpdate()>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	@Override
	public Personal01 doSelect(String useName,Integer i) {
		String sql=null;
		if(i==1) {
			sql="select useName,name,sex,workplace,style,describe,phone from Personal01 where useName=?";
		}else if(i==2) {
			sql="select useName,name,sex,workplace,style,describe,phone from Personal01 where name=?";
		}
		ResultSet rs = null;
		Personal01 vo=null;
		try {
			this.pstmt=this.conn.prepareStatement(sql);
			this.pstmt.setString(1, useName);
			rs=this.pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if(rs.next()) {
				vo=new Personal01();
				vo.setUseName(rs.getString(1));
				vo.setName(rs.getString(2));
				vo.setSex(rs.getString(3));
				vo.setWorkPlace(rs.getString(4));
				vo.setStyle(rs.getString(5));
				vo.setDescribe(rs.getString(6));
				vo.setPhone(rs.getString(7));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vo;
	}
}
