package com.ax.fillclosed.service.imp;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ax.fillclosed.bo.User;
import com.ax.fillclosed.dao.UserDao;
import com.ax.fillclosed.service.UserService;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

@Service
public class UserServiceImpl implements UserService {
	@Resource
	private UserDao userDao;

	@Override
	public User getUserById(long id) {
		return userDao.getUserById(id);
	}

	public static void main(String[] args) throws SQLException,
			ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://45.78.24.174:3306/test";
		String username = "root";
		String password = "mysql1019";
		Connection con = (Connection) DriverManager.getConnection(url,
				username, password);
		Statement stmt = (Statement) con.createStatement();
		String sql = "select * from t_user";
		 ResultSet rs = stmt.executeQuery(sql) ; 
		 while(rs.next()){   
	         String name = rs.getString("username") ; 
	         System.out.println(name);
		 }
	}
}
