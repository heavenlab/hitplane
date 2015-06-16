package com.ax.fillclosed.dao;

import com.ax.fillclosed.bo.User;

public interface UserDao {
	User getUserById(long id);
	boolean isExistByUserName(String username);
	User getUserByuserName(String username);
	int saveUser(User user);
	int updateUser(User user);
	int deleteUser(User user);
}
