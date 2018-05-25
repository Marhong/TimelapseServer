package com.timelapse.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.timelapse.model.User;
import com.timelapse.model.UserList;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 验证登录
 * 
 * @author Marhong
 * @time 2018年5月25日 上午1:34:45
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		JSONArray userList = new JSONArray();
		JSONObject user = new JSONObject();
		user.put("userName", "sdf");
		user.put("password", "sdf");
		user.put("signature", "sd");
		user.put("victoryPoint", 99);
		userList.add(user);
		resp.getWriter().print(user.toString() + "\n\n" + userList.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("utf-8");
		// 获取表单提交的信息
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		System.out.println(userName + " " + password);
		User user = new User(userName, password);
		UserList userList = new UserList();
		// 验证用户提交的用户是否存在
		// 通过判断是否能通过用户提交的用户名从用户列表中获取一个非空的Customer来判断该用户是否存在
		User curUser = userList.getUserByName(userName);

		if (curUser == null) {
			// 若不存在，则返回“incorrect"
			JSONObject result = new JSONObject();
			result.put("type", "incorrect");
			response.getWriter().print(result.toString());
		} else {
			// 若存在该用户，则验证密码是否正确
			if (curUser.equals(user)) {
				// 若密码正确，则返回success
				JSONObject result = new JSONObject();
				result.put("type", "success");
				result.put("userName", curUser.getUserName());
				result.put("password", curUser.getPassword());
				result.put("signature", curUser.getSignature());
				result.put("victoryPoint", curUser.getVitoryPoint());
				result.put("head", curUser.getHead());
				response.getWriter().print(result.toString());
			} else {
				// 若密码错误，则返回incorrect
				JSONObject result = new JSONObject();
				result.put("type", "incorrect");
				response.getWriter().print(result.toString());
			}

		}

	}

}
