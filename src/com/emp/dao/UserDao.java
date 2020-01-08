package com.emp.dao;

import com.emp.vo.User;

public interface UserDao {

	User getByUsername(String name);
}
