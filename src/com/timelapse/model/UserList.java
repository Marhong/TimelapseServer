/**
 * 
 */
package com.timelapse.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.timelapse.controller.ModifyUserNameServlet;


/**
 * 用户列表
 * @author Marhong
 * @time 2018年5月25日 上午10:04:06
 */
public class UserList {
	/**
	 * 用于存储所有的用户信息
	 */
	private ArrayList<User> userList;
    /**
     * 从user表中将所有的用户信息转为user类，添加到userList中
     * 
     */
	public UserList(){
		
		Connection conn=null;
		userList = new ArrayList<User>();
		try {
			conn = AccessJDBCUtil.getAccessDBConnection();
			Statement stmt = conn.createStatement();
			String queryString = "select * from user ";
			ResultSet rs = stmt.executeQuery(queryString);
				while (rs.next()) {
					User user = new User();
					user.setUserName(rs.getString("userName"));
					user.setSignature(rs.getString("signature"));
					user.setPassword(rs.getString("password"));
					user.setVitoryPoint(rs.getInt("victoryPoint"));
					user.setHead(rs.getInt("head"));
					userList.add(user);
		
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
	public ArrayList<User> getUserList() {
		return userList;
	}

	public void setUserList(ArrayList<User> userList) {
		this.userList = userList;
	}
	/**
	 * 
	 * @see    通过用户名获取用户
	 * @author wangbin
	 * @time 2017年11月15日 下午1:35:26
	 * @param name 待获取的用户的名字
	 * @return 若存在名字为name的用户，则返回该用户，否则返回空
	 */
	public User getUserByName(String name){
		
		for(User user: userList){
			if(user.getUserName().equals(name)){
				return user;
			}
		}
		return null;
	}

	/**
	 * 
	 * @see   添加一个普通用户
	 * @author wangbin
	 * @time 2017年11月15日 下午1:39:20
	 * @param user 待添加的用户
	 */
	public boolean addUser(User user) throws ClassNotFoundException{
		String userName = user.getUserName();
		String password = user.getPassword();
		String signature = user.getSignature();
		int victoryPoint = user.getVitoryPoint();
		
		Connection conn=null;
		try {
			conn = AccessJDBCUtil.getAccessDBConnection();
			Statement stmt = conn.createStatement();
			String sql = "insert into user (userName,password,signature,victoryPoint) values('" + userName + "','"
					+ password + "','" + signature+"',"+victoryPoint + ");";
			int result = stmt.executeUpdate(sql);
			if (result != -1) {
				userList.add(user);
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
	 * 
	 * @see    删除一个用户
	 * @author wangbin
	 * @time 2017年11月15日 下午1:40:58
	 * @param userName 待删除用户的用户名
	 * @return 若存在该用户且成功删除，则返回true,否则返回false;
	 */
	public boolean deleteUser(String userName){
		User user = getUserByName(userName);
		if(user != null){
			userList.remove(user);
			return true;
		}
		return false;
	}
	/**
	 * 
	 * @see    修改一个用户的信息
	 * @author wangbin
	 * @time 2017年11月15日 下午1:43:07
	 * @param userName 待修改用户的用户名
	 * @return  若存在该用户且修改信息成功，则返回true,否则返回false
	 */
	public boolean modifyUser(User user){
		String userName = user.getUserName();
		String password = user.getPassword();
		String signature = user.getSignature();
		int victoryPoints = user.getVitoryPoint();
		int head = user.getHead();
		Connection conn=null;
		for(User curUser: userList) {
			if(curUser.getUserName().equals(userName)) {
				try {
					conn = AccessJDBCUtil.getAccessDBConnection();
					Statement stmt = conn.createStatement();
					String sql = "update user set userName = '"+userName+"',password ='"+ password+"',signature = '"+signature+"',victoryPoint = "+victoryPoints+",head = "+head+" where userName ='"+userName+"';";
					int result = stmt.executeUpdate(sql);
					if (result != -1) {
						curUser.setUserName(userName);
						curUser.setPassword(password);
						curUser.setSignature(signature);
						curUser.setVitoryPoint(victoryPoints);
						curUser.setHead(head);
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
	
	/**
	 * 修改用户名
	 * @author Marhong
	 * @time 2018年5月30日 上午12:50:16
	 */
	public int modifyUserName(String newname,String oldname) {
		System.out.println(newname+"_"+oldname);
		for(User curUser: userList) {
			if(curUser.getUserName().equals(newname)) {
				return 0;
			}
		}
		Connection conn=null;
		for(User curUser: userList) {
			System.out.println("用户名:"+curUser.getUserName());
			if(curUser.getUserName().equals(oldname)) {
				System.out.println("找到了就名字");
				try {
					conn = AccessJDBCUtil.getAccessDBConnection();
					Statement stmt = conn.createStatement();
					String sql = "update user set userName = '"+newname+"' where userName ='"+oldname+"';";
					String updateGoalTable = "update goal set userName = '" +newname+"' where userName ='"+oldname+"';";
					String updateHonorTable = "update honor set userName = '" +newname+"' where userName ='"+oldname+"';";
					String updateRecordIniTable = "update record set initiator = '" +newname+"' where initiator ='"+oldname+"';";
					String updateRecordRecTable = "update record set receiver = '" +newname+"' where receiver ='"+oldname+"';";
					int result = stmt.executeUpdate(sql);
					int rs2 = stmt.executeUpdate(updateGoalTable);
					int rs3 = stmt.executeUpdate(updateHonorTable);
					int rs4 = stmt.executeUpdate(updateRecordIniTable);
					int rs5 = stmt.executeUpdate(updateRecordRecTable);
					if (result != -1 && rs2 != -1 && rs3 != -1 && rs4 != -1 && rs5 != -1) {
						curUser.setUserName(newname);
						return 1;
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
		return -1;
	}
	/* 
	 * @see    判断两个userList是否相同
	 * @author wangbin
	 * @time   2017年11月15日 下午1:31:56
	 * @return 若两者相同，则返回true,否则返回false
	 */
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj != null){
			if(obj instanceof UserList){
				if(this.getUserList().equals(((UserList) obj).getUserList())){
					return true;
				}
			}
		}
		return false;
	}
}

