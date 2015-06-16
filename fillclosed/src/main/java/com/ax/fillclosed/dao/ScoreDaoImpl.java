package com.ax.fillclosed.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.ax.fillclosed.bo.Score;
import com.ax.fillclosed.condition.ScoreQueryCondition;
@Repository("scoreDao")
public class ScoreDaoImpl extends SqlSessionDaoSupport implements ScoreDao {
	@Override
	@Autowired
	public void setSqlSessionFactory(
			@Qualifier("fillclosedSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	@Override
	public void saveHighScore(Score score) {
		getSqlSession().insert("ScoreDao.saveHighScore", score);
	}

	@Override
	public List<Score> getRankScore() {
		return getSqlSession().selectList("ScoreDao.getRankScore");
	}

	@Override
	public void saveScoreBatch(List<Score> scoreList) {
		getSqlSession().insert("ScoreDao.saveScoreBatch", scoreList);
	}

}
