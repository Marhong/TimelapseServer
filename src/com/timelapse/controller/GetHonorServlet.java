package com.timelapse.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.timelapse.model.Honor;
import com.timelapse.model.HonorList;

import net.sf.json.JSONObject;


/**
 * 获取某一用户的荣誉
 * @author Marhong
 * @time 2018年5月27日 上午12:48:41
 */
@WebServlet("/GetHonorServlet")
public class GetHonorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetHonorServlet() {
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
		HonorList honorList = new HonorList();
		Honor honor = honorList.getHonorByName(userName);
		if(honor != null) {
			// 如果有该用户的荣誉记录
			JSONObject object = new JSONObject();
			object.put("userName", honor.getUserName());
			object.put("totalFights", honor.getTotalFights());
			object.put("victoryFights", honor.getVictoryFights());
			object.put("victoryPoints", honor.getVictoryPoints());
			object.put("nineKills", honor.getNineKills());
			object.put("eightKills", honor.getEightKills());
			object.put("sevenKills", honor.getSevenKills());
			object.put("sixKills", honor.getSixKills());
			object.put("fiveKills", honor.getFiveKills());
			object.put("fourKills", honor.getFourKills());
			object.put("maxVictory", honor.getMaxVictory());
			object.put("slainNum", honor.getSlainNum());
			response.getWriter().print(object.toString());
			System.out.print(object.toString());
		}else {
			// 如果没有该用户的荣誉记录
			response.getWriter().print("error");
		}
	}

}
