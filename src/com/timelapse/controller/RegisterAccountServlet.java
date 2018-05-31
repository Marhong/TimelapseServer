package com.timelapse.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.timelapse.model.User;
import com.timelapse.model.UserList;

import net.sf.json.JSONObject;
import sun.text.normalizer.UTF16;

/**
 * Servlet implementation class RegisterAccountServlet
 */
@WebServlet("/RegisterAccountServlet")
public class RegisterAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterAccountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String signature = request.getParameter("signature");
		int victoryPoint = 0;
		int head = 1;
		
		UserList userList = new UserList();
		JSONObject result = new JSONObject();
		if(userList.getUserByName(userName) != null) {
			result.put("type", "exist");
		}else {
			User user = new User(userName,password,signature,victoryPoint,head);
			if(userList.addUser(user)) {
				result.put("type", "success");
			}else {
				result.put("type", "error");
			}
		}
		response.getWriter().print(result.toString());
	}

}
