package com.timelapse.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.regexp.internal.REUtil;
import com.timelapse.model.User;
import com.timelapse.model.UserList;

import javafx.print.Printer;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class ModifySignature
 */
@WebServlet("/ModifySignature")
public class ModifySignatureServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifySignatureServlet() {
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
		String signature = request.getParameter("signature");
		UserList userList = new UserList();
		User user = userList.getUserByName(userName);
		JSONObject type = new JSONObject();
		if(user != null) {
			user.setSignature(signature);
			if(userList.modifyUser(user)) {
				type.put("type", "success");
			}
		}
		response.getWriter().print(type.toString());
	}

}
