package com.timelapse.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.timelapse.model.User;
import com.timelapse.model.UserList;

/**
 * Servlet implementation class ModifyUserNameServlet
 */
@WebServlet("/ModifyUserNameServlet")
public class ModifyUserNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyUserNameServlet() {
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
		
		String newUserName = request.getParameter("newUserName");
		String oldUserName = request.getParameter("oldUserName");
		//System.out.println(newUserName+"_"+oldUserName);
		UserList userList = new UserList();
		User user = userList.getUserByName(oldUserName);
		if(user != null) {
			//System.out.println("该用户存在");
			int result = userList.modifyUserName(newUserName,oldUserName);
			if(result>0) {
				System.out.println("修改成功");
				response.getWriter().print("success");
			}else if(result  == 0) {
				response.getWriter().print("exist");
			}
		}
	}

}
