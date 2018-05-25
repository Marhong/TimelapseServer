/**
 * 
 */
package com.timelapse.model;


/**
 * 
 * @author Marhong
 * @time 2018年5月25日 上午9:48:31
 */
public class User {
	private String userName;
	private String password;
	private String signature;
	private int vitoryPoint;
	private int head;
	/**
	 * 
	 */
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String userName,String password) {
		this.userName = userName;
		this.password = password;
	}
	/**
	 * @param userName 用户名
	 * @param password 密码
	 * @param signature 签名
	 * @param vitoryPoint 胜点
	 */
	public User(String userName, String password, String signature, int vitoryPoint,int head) {
		super();
		this.userName = userName;
		this.password = password;
		this.signature = signature;
		this.vitoryPoint = vitoryPoint;
		this.head = head;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the signature
	 */
	public String getSignature() {
		return signature;
	}
	/**
	 * @param signature the signature to set
	 */
	public void setSignature(String signature) {
		this.signature = signature;
	}
	/**
	 * @return the vitoryPoint
	 */
	public int getVitoryPoint() {
		return vitoryPoint;
	}
	/**
	 * @param vitoryPoint the vitoryPoint to set
	 */
	public void setVitoryPoint(int vitoryPoint) {
		this.vitoryPoint = vitoryPoint;
	}
	
	/**
	 * @return the head
	 */
	public int getHead() {
		return head;
	}
	/**
	 * @param head the head to set
	 */
	public void setHead(int head) {
		this.head = head;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj != null){
			if(obj instanceof User){
				if((this.getUserName().equals(((User) obj).getUserName()) && this.getPassword().equals(((User) obj).getPassword()))){
					return true;
				}
			}
		}
		return false;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
