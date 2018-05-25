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
	 * @see    修改一个普通用户的信息
	 * @author wangbin
	 * @time 2017年11月15日 下午1:43:07
	 * @param userName 待修改用户的用户名
	 * @return  若存在该用户且修改信息成功，则返回true,否则返回false
	 */
	public boolean modifyUser(String userName){
		for(User user: userList){
			if(user.getUserName().equals(userName)){
				//进行相关修改操作
				return true;
			}
		}
		return false;
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

