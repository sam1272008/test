package com.emp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.emp.vo.User;

public class UserDaoImpl extends BaseDao implements UserDao {

	@Override
	public User getByUsername(String name) {
		User u = null;
		ResultSet rs = this.executeQuery("select * from user where name=?", name);
		try {
			if( rs.next() ) {
				u = new User();
				u.setId( rs.getInt("id"));
				u.setName( rs.getString("name"));
				u.setPassword( rs.getString("password"));
				return u;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
