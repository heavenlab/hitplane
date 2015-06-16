package com.ax.fillclosed.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ax.fillclosed.bo.Score;
import com.ax.fillclosed.bo.User;
import com.ax.fillclosed.dao.ScoreDao;
import com.ax.fillclosed.dao.UserDao;
import com.ax.fillclosed.service.UserService;
import com.ax.fillclosed.util.JsonUtil;
import com.google.common.base.Splitter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	private UserService userService;
	@Resource
	private UserDao userDao;
	@Resource
	private ScoreDao scoreDao;

	@RequestMapping("/showUser")
	public String toIndex(HttpServletRequest request, Model model) {
		int userId = Integer.parseInt(request.getParameter("id"));
		User user = this.userService.getUserById(userId);
		model.addAttribute("user", user);
		return "index";
	}

	@RequestMapping("/hscore")
	@ResponseBody
	public String getHighScore(HttpServletRequest request, Model model) {
		return JsonUtil.toJson(scoreDao.getRankScore());
	}

	@RequestMapping("/savescore")
	@ResponseBody
	public String saveScore(HttpServletRequest request, Model model) {
		String json = request.getParameter("scoreStr");
		if (StringUtils.isBlank(json)) {
			return "";
		}
		Gson g = new Gson();
		List<Score> list = g.fromJson(json, new TypeToken<List<Score>>() {
		}.getType());
		if (list == null || list.isEmpty()) {
			return "";
		}
		scoreDao.saveScoreBatch(list);
		return "success";
	}
}
