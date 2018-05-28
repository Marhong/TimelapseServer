package com.timelapse.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.timelapse.model.Goal;
import com.timelapse.model.GoalList;

import net.sf.json.JSONObject;


/**
 * 获取某天的每日目标
 * @author Marhong
 * @time 2018年5月28日 上午8:31:13
 */
@WebServlet("/GetTodayGoal")
public class GetSomedayGoalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetSomedayGoalServlet() {
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
		String time = request.getParameter("time");
		GoalList goalList = new GoalList();
		Goal goal = goalList.getTodayGoalByName(userName,time);
		if(goal != null) {
			JSONObject object = new JSONObject();
			object.put("id", goal.getId());
			object.put("userName", goal.getUserName());
			object.put("planTotalTime", goal.getPlanTotalTime());
			object.put("planSpareTime", goal.getPlanSpareTime());
			object.put("planSocialTime", goal.getPlanSocialTime());
			object.put("planStudyTime", goal.getPlanStudyTime());
			object.put("planNewsTime", goal.getPlanNewsTime());
			object.put("planOtherTime", goal.getPlanOtherTime());
			object.put("actualTotalTime", goal.getActualTotalTime());
			object.put("actualSpareTime", goal.getActualSpareTime());
			object.put("actualSocialTime", goal.getActualSocialTime());
			object.put("actualStudyTime", goal.getActualStudyTime());
			object.put("actualNewsTime", goal.getActualNewsTime());
			object.put("actualOtherTime", goal.getActualOtherTime());
			object.put("unfinishedItems", goal.getUnfinishedItems());
			response.getWriter().print(object.toString());
		}else {
			response.getWriter().print("error");
		}
	}

}
