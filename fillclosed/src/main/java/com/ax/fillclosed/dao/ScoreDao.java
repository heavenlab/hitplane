package com.ax.fillclosed.dao;

import java.util.List;

import com.ax.fillclosed.bo.Score;

public interface ScoreDao {
	void saveHighScore(Score score);
	List<Score> getRankScore();
	void saveScoreBatch(List<Score> list);
}
