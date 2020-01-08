package com.emp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDao {

	public static final String drivername = "com.mysql.jdbc.Driver";
	public static final String url = "jdbc:mysql://localhost:3306/test?characterEncoding=utf8";
	public static final String username = "root";
	public static final String password = "123456";
	private Connection conn = null;
	private PreparedStatement pst = null;
		
	public Connection getConnection() {
		
		try {
			// 1.加载驱动
			Class.forName(drivername);
			// 2.连接数据库
			conn = DriverManager.getConnection(url, username,password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
		
	}

	public void closeResource() {
		try {
			
			if(pst != null )
				pst.close();
			
			if( conn != null )
				conn.close();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public boolean executeUpdate(String sql,Object...objects ) {
		try {
			getConnection();
			pst = conn.prepareStatement(sql);
			if(objects != null ) {
				//有参数，需要设置
				for( int i=0;i<objects.length;i++ ) {
					pst.setObject(i+1, objects[i]);
				}
			}
			return pst.executeUpdate()==0?false:true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResource();
		}
		return false;
	}
	//能进行事务操作的封装
	public boolean executeUpdate(Connection conn,String sql,Object...objects ) {
		try {
			//getConnection();
			pst = conn.prepareStatement(sql);
			if(objects != null ) {
				//有参数，需要设置
				for( int i=0;i<objects.length;i++ ) {
					pst.setObject(i+1, objects[i]);
				}
			}
			pst.executeUpdate();
			return true;
		} catch (SQLException e) {
			
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			closeResource();
		}
		return false;
	}
	
	public ResultSet executeQuery(String sql,Object...objects) {
		try {
			getConnection();
			pst = conn.prepareStatement(sql);
			if(objects != null ) {
				//有参数，需要设置
				for( int i=0;i<objects.length;i++ ) {
					pst.setObject(i+1, objects[i]);
				}
			}
			return pst.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//closeResource();
		}
		return null;
	}
}
