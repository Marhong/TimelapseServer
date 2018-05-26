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
 * 荣誉列表
 * @author Marhong
 * @time 2018年5月27日 上午12:15:19
 */
public class HonorList {
	/**
	 * 用于存储所有的对战记录
	 */
	private ArrayList<Honor> honorList;
    /**
     * 从record表中将所有的对战记录转为Record类，添加到recordList中
     * 
     */
	public HonorList(){
		
		Connection conn=null;
		honorList = new ArrayList<Honor>();
		try {
			conn = AccessJDBCUtil.getAccessDBConnection();
			Statement stmt = conn.createStatement();
			String queryString = "select * from honor";
			ResultSet rs = stmt.executeQuery(queryString);
				while (rs.next()) {
					Honor honor = new Honor();
					honor.setUserName(rs.getString("userName"));
					honor.setTotalFights(rs.getInt("totalFights"));
					honor.setVictoryFights(rs.getInt("victoryFights"));
					honor.setVictoryPoints(rs.getInt("victoryPoints"));
					honor.setNineKills(rs.getInt("nineKills"));
					honor.setEightKills(rs.getInt("eightKills"));
					honor.setSevenKills(rs.getInt("sevenKills"));
					honor.setSixKills(rs.getInt("sixKills"));
					honor.setFiveKills(rs.getInt("fiveKills"));
					honor.setFourKills(rs.getInt("fourKills"));
					honor.setMaxVictory(rs.getInt("maxVictory"));
					honor.setSlainNum(rs.getInt("slainNum"));
					honorList.add(honor);
		
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
	public ArrayList<Honor> getHonorList() {
		return honorList;
	}

	public void setHonorList(ArrayList<Honor> honorList) {
		this.honorList = honorList;
	}
	/**
	 * 
	 * @see    通过用户名获取某一用户的荣誉记录
	 * @author wangbin
	 * @time 2017年11月15日 下午1:35:26
	 * @param name 待获取的用户的名字
	 * @return 若存在名字为name的用户，则返回该用户，否则返回空
	 */
	public Honor getHonorByName(String name){
		for(Honor honor: honorList){
			if(honor.getUserName().equals(name)){
				return honor;
			}
		}
		return null;
	}

	/**
	 * 
	 * @see   添加一条荣誉
	 * @author wangbin
	 * @time 2017年11月15日 下午1:39:20
	 * @param honor 待添加的对战记录
	 */
	public boolean addHonor(Honor honor) throws ClassNotFoundException{
		String userName = honor.getUserName();
		int totalFights = honor.getTotalFights();
		int victoryFights = honor.getVictoryFights();
		int victoryPoints = honor.getVictoryPoints();
		int nineKills = honor.getNineKills();
		int eightKills = honor.getEightKills();
		int sevenKills = honor.getSevenKills();
		int sixKills = honor.getSixKills();
		int fiveKills = honor.getFiveKills();
		int fourKills = honor.getFourKills();
		int maxVictory = honor.getMaxVictory();
		int slainNum = honor.getSlainNum();
		Connection conn=null;
		try {
			conn = AccessJDBCUtil.getAccessDBConnection();
			Statement stmt = conn.createStatement();
			String sql = "insert into honor (userName,totalFights,victoryFights,victoryPoints,nineKills,eightKills,sevenKills,sixKills,fiveKills,fourKills,maxVictory,slainNum) values('"+userName+"'," + totalFights + ","
					+ victoryFights + "," + victoryPoints+","+nineKills +","+eightKills+","+sevenKills+","+sixKills+","+fiveKills+","+fourKills+","+maxVictory+","+slainNum+");";
			int result = stmt.executeUpdate(sql);
			if (result != -1) {
				honorList.add(honor);
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
	

	/**
	 * 修改一条荣誉
	 * @author Marhong
	 * @time 2018年5月27日 上午12:32:33
	 * @param honor 具有新信息的荣誉
	 */
	public boolean modifyHnor(Honor honor) {
		String userName = honor.getUserName();
		int totalFights = honor.getTotalFights();
		int victoryFights = honor.getVictoryFights();
		int victoryPoints = honor.getVictoryPoints();
		int nineKills = honor.getNineKills();
		int eightKills = honor.getEightKills();
		int sevenKills = honor.getSevenKills();
		int sixKills = honor.getSixKills();
		int fiveKills = honor.getFiveKills();
		int fourKills = honor.getFourKills();
		int maxVictory = honor.getMaxVictory();
		int slainNum = honor.getSlainNum();
		Connection conn=null;
		for(Honor curHonor: honorList) {
			if(curHonor.getUserName().equals(userName)) {
				try {
					conn = AccessJDBCUtil.getAccessDBConnection();
					Statement stmt = conn.createStatement();
					String sql = "update honor set totalFights = "+totalFights+",victoryFights ="+ victoryFights+",victoryPoints = "+victoryPoints+",nineKills = "+nineKills+",eightKills = "+eightKills+",sevenKills = "+sevenKills+",sixKills = "+sixKills+",fiveKills = "+fiveKills+",fourKills = "+fourKills+",maxVictory = "+maxVictory+",slainNum = "+slainNum+" where userName ="+userName+";";
					int result = stmt.executeUpdate(sql);
					if (result != -1) {
						honorList.remove(honor);
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
			}
		}
		return false;
	}
}
