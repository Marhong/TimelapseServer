/**
 * 
 */
package com.timelapse.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * 目标列表
 * @author Marhong
 * @time 2018年5月27日 下午2:53:49
 */
public class GoalList {
	/**
	 * 用于存储所有的每日目标信息
	 */
	private ArrayList<Goal> goalList;
    /**
     * 从goal表中将所有的每日目标信息转为Goal类，添加到goalList中
     * 
     */
	public GoalList(){
		
		Connection conn=null;
		goalList = new ArrayList<Goal>();
		try {
			conn = AccessJDBCUtil.getAccessDBConnection();
			Statement stmt = conn.createStatement();
			String queryString = "select * from goal order by id desc ";
			ResultSet rs = stmt.executeQuery(queryString);
				while (rs.next()) {
					Goal goal = new Goal();
					goal.setId(rs.getString("id"));
					goal.setUserName(rs.getString("userName"));
					goal.setPlanTotalTime(rs.getInt("planTotalTime"));
					goal.setPlanSpareTime(rs.getInt("planSpareTime"));
					goal.setPlanSocialTime(rs.getInt("planSocialTime"));
					goal.setPlanNewsTime(rs.getInt("planNewsTime"));
					goal.setPlanStudyTime(rs.getInt("planStudyTime"));
					goal.setPlanOtherTime(rs.getInt("planOtherTime"));
					goal.setActualTotalTime(rs.getInt("actualTotalTime"));
					goal.setActualSpareTime(rs.getInt("actualSpareTime"));
					goal.setActualStudyTime(rs.getInt("actualStudyTime"));
					goal.setActualNewsTime(rs.getInt("actualNewsTime"));
					goal.setActualSocialTime(rs.getInt("actualSocialTime"));
					goal.setActualOtherTime(rs.getInt("actualOtherTime"));
					goal.setUnfinishedItems(rs.getInt("unfinishedItems"));
					goalList.add(goal);
		
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	public ArrayList<Goal> getGoalList() {
		return goalList;
	}

	public void setGoalList(ArrayList<Goal> goalList) {
		this.goalList = goalList;
	}
	/**
	 * 
	 * @see    通过用户名获取用户的所有每日目标
	 * @author wangbin
	 * @time 2017年11月15日 下午1:35:26
	 * @param name 待获取的用户的名字
	 * @return 若存在名字为name的用户，则返回该用户，否则返回空
	 */
	public ArrayList<Goal> getGoalsByName(String name){
		ArrayList<Goal> curGoalList = new ArrayList<Goal>(); 
		for(Goal goal: goalList){
			if(goal.getUserName().equals(name)){
				curGoalList.add(goal);
			}
		}
		if(curGoalList.size()>0) {
			return curGoalList;
		}
		return null;
	}
	
	
	/**
	 * 通过用户名和时间戳获取当天的每日目标
	 * @author Marhong
	 * @time 2018年5月27日 下午3:21:20
	 */
	public Goal getTodayGoalByName(String name,String time) {
		for(Goal goal: goalList) {
			if(goal.getUserName().equals(name) && goal.getId().equals(time)) {
				return goal;
			}
		}
		return null;
	}
	/**
	 * 
	 * @see   添加一个每日目标
	 * @author wangbin
	 * @time 2017年11月15日 下午1:39:20
	 * @param goal 待添加的每日目标
	 */
	public boolean addGoal(Goal goal) throws ClassNotFoundException{
		String id = goal.getId();
		String userName = goal.getUserName();
		int planTotalTime = goal.getPlanTotalTime();
		int planSpareTime = goal.getPlanSpareTime();
		int planSocialTime = goal.getPlanSocialTime();
		int planStudyTime = goal.getPlanStudyTime();
		int planNewsTime = goal.getPlanNewsTime();
		int planOtherTime = goal.getPlanOtherTime();
		int actualTotalTime = goal.getActualTotalTime();
		int actualSpareTime = goal.getActualSpareTime();
		int actualStudyTime = goal.getActualStudyTime();
		int actualSocialTime = goal.getActualSocialTime();
		int actualNewsTime = goal.getActualSocialTime();
		int actualOtherTime = goal.getActualOtherTime();
		int unfinishedItems = goal.getUnfinishedItems();
		
		Connection conn=null;
		try {
			conn = AccessJDBCUtil.getAccessDBConnection();
			Statement stmt = conn.createStatement();
			String sql = "insert into goal (id,userName,planTotalTime,planSpareTime,planSocialTime,planStydyTime,planNewsTime,planOtherTime,actualTotalTime,actualSpareTime,actualSocialTime,actualStudyTime,actualNewsTime,actualOtherTime,unfinishedItems) values('" + id + "','"
					+ userName + "'," + planTotalTime+","+planSpareTime +","+planSocialTime+","+planStudyTime+","+planNewsTime+","+planOtherTime+","+actualTotalTime+","+actualSpareTime+","+actualSocialTime+","+actualStudyTime+","+actualNewsTime+","+actualOtherTime+","+unfinishedItems+ ");";
			int result = stmt.executeUpdate(sql);
			if (result != -1) {
				goalList.add(goal);
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return false;
	}
	
}
