package com.ax.fillclosed.dao;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.ax.fillclosed.bo.User;

/**
 * @author zax
 *
 */
@Repository("userDao")
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {

	@Override
	public User getUserById(long id) {
		return getSqlSession().selectOne("UserDao.getUserById", id);
	}

	@Override
	@Autowired
	public void setSqlSessionFactory(
			@Qualifier("fillclosedSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	@Override
	public boolean isExistByUserName(String username) {
		User user = getUserByuserName(username);
		return user == null?true:false;
	}

	@Override
	public User getUserByuserName(String username) {
		return getSqlSession().selectOne("UserDao.getUserByuserName", username);
	}

	@Override
	public int saveUser(User user) {
		return getSqlSession().insert("UserDao.saveUser", user);
	}

	@Override
	public int updateUser(User user) {
		return getSqlSession().update("UserDao.updateUser", user);
	}

	@Override
	public int deleteUser(User user) {
		return getSqlSession().delete("UserDao.deleteUser", user.getId());
	}
}
