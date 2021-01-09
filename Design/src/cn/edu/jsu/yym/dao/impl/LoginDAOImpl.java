/**
 * 实现表Login的操作标准
 */
package cn.edu.jsu.yym.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import cn.edu.jsu.yym.dao.ILoginDAO;
import cn.edu.jsu.yym.vo.Login;

/**
 * Login数据开发层的标准实现类
 * @author 86152
 *
 */
public class LoginDAOImpl implements ILoginDAO{
	private Connection conn;//数据库连接对象
	private PreparedStatement pstmt;//数据库操作对象
	/**
	 * 
	 * @param conn
	 */
	public LoginDAOImpl(Connection conn) {
		this.conn=conn;
	}
	@Override
	public boolean doCreate(Login vo) {
		String sql="insert into Login(useName,password)values(?,?)";
		boolean i=false;
		try {
			this.pstmt=this.conn.prepareStatement(sql);
			this.pstmt.setString(1, vo.getUserName());
			this.pstmt.setString(2, vo.getPassword());
			i=this.pstmt.executeUpdate()>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public boolean doUpdate(Login vo) {
		String sql="update Login set password=? where useName=?";
		boolean i=false;
		try {
			this.pstmt=this.conn.prepareStatement(sql);
			this.pstmt.setString(2,vo.getUserName());
			this.pstmt.setString(1, vo.getPassword());
			i=this.pstmt.executeUpdate()>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public boolean doRemove(String userName) {
		String sql="delete from Login where useName=?";
		boolean i=false;
		try {
			this.pstmt=this.conn.prepareStatement(sql);
			this.pstmt.setString(1,userName);
			i=this.pstmt.executeUpdate()>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	@Override
	public Login findByUserName(String userName) {
		String sql="select useName,password from Login where useName=?";
		ResultSet rs = null;
		Login vo=null;
		try {
			this.pstmt=this.conn.prepareStatement(sql);
			this.pstmt.setString(1, userName);
			rs=this.pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if(rs.next()) {
				vo=new Login();
				vo.setUserName(rs.getString(1));
				vo.setPassword(rs.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vo;
	}
	@Override
	public Vector<String> findAllUserName(){
		String sql="select useName from Login";
		ResultSet rs = null;
		Vector<String> userNames=new Vector<String>();
		try {
			this.pstmt=this.conn.prepareStatement(sql);
			rs=this.pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while(rs.next()) {
				userNames.add(rs.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userNames;
	}
}
