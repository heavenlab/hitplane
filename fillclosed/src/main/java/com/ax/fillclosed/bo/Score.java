package com.ax.fillclosed.bo;

import java.util.Date;

import lombok.Data;

@Data
public class Score {
	private long id;
	private long userId;
	private long score;
	private long usetime;
	private Date finishtime;
}
