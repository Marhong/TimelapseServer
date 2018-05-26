/**
 * 
 */
package com.timelapse.model;

/**
 * 个人荣誉
 * @author Marhong
 * @time 2018年5月27日 上午12:09:54
 */
public class Honor {
	private String userName;
	private int totalFights;
	private int victoryFights;
	private int victoryPoints;
	private int nineKills;
	private int eightKills;
	private int sevenKills;
	private int sixKills;
	private int fiveKills;
	private int fourKills;
	private int maxVictory;
	private int slainNum;
	/**
	 * 
	 */
	public Honor() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param userName 用户名
	 * @param totalFights 总对战次数
	 * @param victoryFights 对战胜利次数
	 * @param victoryPoints 用户胜点
	 * @param nineKills 9连胜次数
	 * @param eightKills 8连胜次数
	 * @param sevenKills 7连胜次数
	 * @param sixKills 6连胜次数
	 * @param fiveKills 5连胜次数
	 * @param fourKills 4连胜次数
	 * @param maxVictory 最大连胜场数
	 * @param slainNum 击败的不同人数
	 */
	public Honor(String userName, int totalFights, int victoryFights, int victoryPoints, int nineKills, int eightKills,
			int sevenKills, int sixKills, int fiveKills, int fourKills, int maxVictory, int slainNum) {
		super();
		this.userName = userName;
		this.totalFights = totalFights;
		this.victoryFights = victoryFights;
		this.victoryPoints = victoryPoints;
		this.nineKills = nineKills;
		this.eightKills = eightKills;
		this.sevenKills = sevenKills;
		this.sixKills = sixKills;
		this.fiveKills = fiveKills;
		this.fourKills = fourKills;
		this.maxVictory = maxVictory;
		this.slainNum = slainNum;
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
	 * @return the totalFights
	 */
	public int getTotalFights() {
		return totalFights;
	}
	/**
	 * @param totalFights the totalFights to set
	 */
	public void setTotalFights(int totalFights) {
		this.totalFights = totalFights;
	}
	/**
	 * @return the victoryFights
	 */
	public int getVictoryFights() {
		return victoryFights;
	}
	/**
	 * @param victoryFights the victoryFights to set
	 */
	public void setVictoryFights(int victoryFights) {
		this.victoryFights = victoryFights;
	}
	/**
	 * @return the victoryPoints
	 */
	public int getVictoryPoints() {
		return victoryPoints;
	}
	/**
	 * @param victoryPoints the victoryPoints to set
	 */
	public void setVictoryPoints(int victoryPoints) {
		this.victoryPoints = victoryPoints;
	}
	/**
	 * @return the nineKills
	 */
	public int getNineKills() {
		return nineKills;
	}
	/**
	 * @param nineKills the nineKills to set
	 */
	public void setNineKills(int nineKills) {
		this.nineKills = nineKills;
	}
	/**
	 * @return the eightKills
	 */
	public int getEightKills() {
		return eightKills;
	}
	/**
	 * @param eightKills the eightKills to set
	 */
	public void setEightKills(int eightKills) {
		this.eightKills = eightKills;
	}
	/**
	 * @return the sevenKills
	 */
	public int getSevenKills() {
		return sevenKills;
	}
	/**
	 * @param sevenKills the sevenKills to set
	 */
	public void setSevenKills(int sevenKills) {
		this.sevenKills = sevenKills;
	}
	/**
	 * @return the sixKills
	 */
	public int getSixKills() {
		return sixKills;
	}
	/**
	 * @param sixKills the sixKills to set
	 */
	public void setSixKills(int sixKills) {
		this.sixKills = sixKills;
	}
	/**
	 * @return the fiveKills
	 */
	public int getFiveKills() {
		return fiveKills;
	}
	/**
	 * @param fiveKills the fiveKills to set
	 */
	public void setFiveKills(int fiveKills) {
		this.fiveKills = fiveKills;
	}
	/**
	 * @return the fourKills
	 */
	public int getFourKills() {
		return fourKills;
	}
	/**
	 * @param fourKills the fourKills to set
	 */
	public void setFourKills(int fourKills) {
		this.fourKills = fourKills;
	}
	/**
	 * @return the maxVictory
	 */
	public int getMaxVictory() {
		return maxVictory;
	}
	/**
	 * @param maxVictory the maxVictory to set
	 */
	public void setMaxVictory(int maxVictory) {
		this.maxVictory = maxVictory;
	}
	/**
	 * @return the slainNum
	 */
	public int getSlainNum() {
		return slainNum;
	}
	/**
	 * @param slainNum the slainNum to set
	 */
	public void setSlainNum(int slainNum) {
		this.slainNum = slainNum;
	}
	
}
