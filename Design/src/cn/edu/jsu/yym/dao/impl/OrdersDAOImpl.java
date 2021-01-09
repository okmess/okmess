package cn.edu.jsu.yym.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import cn.edu.jsu.yym.dao.IOrdersDAO;
import cn.edu.jsu.yym.vo.Orders;
import cn.edu.jsu.yym.vo.Personal01;

/**
 * Orders数据开发层的标准实现类
 * @author 86152
 *
 */
public class OrdersDAOImpl implements IOrdersDAO{
	private Connection conn;//数据库连接对象
	private PreparedStatement pstmt;//数据库操作对象
	/**
	 * 
	 * @param conn
	 */
	public OrdersDAOImpl(Connection conn) {
		this.conn=conn;
	}
	@Override
	public boolean doCreate(Orders vo) {
		String sql="insert into Orders(orderNumber,name,sex,style,status,photographUseName,useName)values(?,?,?,?,?,?,?)";
		boolean i=false;
			try {
				this.pstmt=this.conn.prepareStatement(sql);
				this.pstmt.setString(1, vo.getOrderNumber());
				this.pstmt.setString(2, vo.getName());
				this.pstmt.setString(3, vo.getSex());
				this.pstmt.setString(4, vo.getStyle());
				this.pstmt.setString(5, vo.getStatus());
				this.pstmt.setString(6, vo.getPhotographUserName());
				this.pstmt.setString(7, vo.getUserName());
				i=this.pstmt.executeUpdate()>0;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return i;
	}

	@Override
	public boolean doUpdate(Orders vo) {
		String sql="update Orders set status=? where orderNumber=?";
		boolean i=false;
		try {
			this.pstmt=this.conn.prepareStatement(sql);
			this.pstmt.setString(1,vo.getStatus());
			this.pstmt.setString(2, vo.getOrderNumber());
			i=this.pstmt.executeUpdate()>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	
	public boolean doUpdate(String userName,String newUserName) {
		String sql="update Orders set photographUseName=? where photographUseName=?";
		boolean i=false;
		try {
			this.pstmt=this.conn.prepareStatement(sql);
			this.pstmt.setString(1, newUserName);
			this.pstmt.setString(2, userName);
			i=this.pstmt.executeUpdate()>0;
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
		
		
	}
	@Override
	public Vector<Vector> getSelectAll(String userName,Integer i) {
		String sql = null;
		if(i==1) {
			sql="select orderNumber,name,sex,style,status,useName from Orders where photographUseName=?";
		}
		else if(i==2) {
			sql="select orderNumber,name,sex,style,status,photographUseName from Orders where useName=?";
		}else if(i==3) {
			sql="select orderNumber,name,sex,style,status from Orders where orderNumber=?";
		}
		ResultSet rs = null;
		Vector<Vector> rows=new Vector<Vector>();//定义要返回的所有记录集合
		try {
			this.pstmt=this.conn.prepareStatement(sql);
			this.pstmt.setString(1,userName);
			rs=this.pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while(rs.next()) {
				Vector row=new Vector();
				row.add(rs.getString(1));
				row.add(rs.getString(2));
				row.add(rs.getString(3));
				row.add(rs.getString(4));
				row.add(rs.getString(5));
				if(i==1||i==2) {
					row.add(rs.getString(6));
				}
				rows.add(row);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rows;
		
	}

}
