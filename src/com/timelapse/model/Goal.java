/**
 * 
 */
package com.timelapse.model;

/**
 * 用户一天的计划
 * @author Marhong
 * @time 2018年5月27日 下午2:49:13
 */
public class Goal {
	private String id; 
	private String userName; 
	private int planTotalTime; 
	private int planSpareTime;
	private int planSocialTime; 
	private int planStudyTime; 
	private int planNewsTime; 
	private int planOtherTime; 
	private int actualTotalTime; 
	private int actualSpareTime; 
	private int actualSocialTime; 
	private int actualStudyTime; 
	private int actualNewsTime; 
	private int actualOtherTime; 
	private int unfinishedItems;
	
	/**
	 * 
	 */
	public Goal() {
		super();
		// TODO Auto-generated constructor stub
	}


	/**
	 * @param id // 该天的时间戳
	 * @param userName // 用户名
	 * @param planTotalTime // 计划总时间
	 * @param planSpareTime  // 计划休闲娱乐时间
	 * @param planSocailTime // 计划社交时间
	 * @param planStudyTime // 计划学习时间
	 * @param planNewsTime // 计划新闻资讯时间
	 * @param planOherTime // 计划其他类型app时间
	 * @param actutalTotalTime // 实际总时间
	 * @param actutaSpareTime // 实际休闲娱乐时间
	 * @param actutaSocailTime // 实际社交时间
	 * @param actutaStudyTime // 实际学习时间
	 * @param actutaNewsTime // 实际新闻资讯时间
	 * @param actutaOherTime // 实际其他类型app时间
	 * @param unfinishedItems // 未达标数目
	 */
	public Goal(String id, String userName, int planTotalTime, int planSpareTime, int planSocialTime, int planStudyTime,
			int planNewsTime, int planOtherTime, int actualTotalTime, int actualSpareTime, int actualSocialTime,
			int actualStudyTime, int actualNewsTime, int actualOtherTime, int unfinishedItems) {
		super();
		this.id = id;
		this.userName = userName;
		this.planTotalTime = planTotalTime;
		this.planSpareTime = planSpareTime;
		this.planSocialTime = planSocialTime;
		this.planStudyTime = planStudyTime;
		this.planNewsTime = planNewsTime;
		this.planOtherTime = planOtherTime;
		this.actualTotalTime = actualTotalTime;
		this.actualSpareTime = actualSpareTime;
		this.actualSocialTime = actualSocialTime;
		this.actualStudyTime = actualStudyTime;
		this.actualNewsTime = actualNewsTime;
		this.actualOtherTime = actualOtherTime;
		this.unfinishedItems = unfinishedItems;
	}


	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
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
	 * @return the planTotalTime
	 */
	public int getPlanTotalTime() {
		return planTotalTime;
	}


	/**
	 * @param planTotalTime the planTotalTime to set
	 */
	public void setPlanTotalTime(int planTotalTime) {
		this.planTotalTime = planTotalTime;
	}


	/**
	 * @return the planSpareTime
	 */
	public int getPlanSpareTime() {
		return planSpareTime;
	}


	/**
	 * @param planSpareTime the planSpareTime to set
	 */
	public void setPlanSpareTime(int planSpareTime) {
		this.planSpareTime = planSpareTime;
	}


	/**
	 * @return the planSocialTime
	 */
	public int getPlanSocialTime() {
		return planSocialTime;
	}


	/**
	 * @param planSocialTime the planSocialTime to set
	 */
	public void setPlanSocialTime(int planSocialTime) {
		this.planSocialTime = planSocialTime;
	}


	/**
	 * @return the planStudyTime
	 */
	public int getPlanStudyTime() {
		return planStudyTime;
	}


	/**
	 * @param planStudyTime the planStudyTime to set
	 */
	public void setPlanStudyTime(int planStudyTime) {
		this.planStudyTime = planStudyTime;
	}


	/**
	 * @return the planNewsTime
	 */
	public int getPlanNewsTime() {
		return planNewsTime;
	}


	/**
	 * @param planNewsTime the planNewsTime to set
	 */
	public void setPlanNewsTime(int planNewsTime) {
		this.planNewsTime = planNewsTime;
	}


	/**
	 * @return the planOherTime
	 */
	public int getPlanOtherTime() {
		return planOtherTime;
	}


	/**
	 * @param planOherTime the planOherTime to set
	 */
	public void setPlanOtherTime(int planOtherTime) {
		this.planOtherTime = planOtherTime;
	}


	/**
	 * @return the actualTotalTime
	 */
	public int getActualTotalTime() {
		return actualTotalTime;
	}


	/**
	 * @param actualTotalTime the actualTotalTime to set
	 */
	public void setActualTotalTime(int actualTotalTime) {
		this.actualTotalTime = actualTotalTime;
	}


	/**
	 * @return the actualSpareTime
	 */
	public int getActualSpareTime() {
		return actualSpareTime;
	}


	/**
	 * @param actualSpareTime the actualSpareTime to set
	 */
	public void setActualSpareTime(int actualSpareTime) {
		this.actualSpareTime = actualSpareTime;
	}


	/**
	 * @return the actualSocialTime
	 */
	public int getActualSocialTime() {
		return actualSocialTime;
	}


	/**
	 * @param actualSocialTime the actualSocialTime to set
	 */
	public void setActualSocialTime(int actualSocialTime) {
		this.actualSocialTime = actualSocialTime;
	}


	/**
	 * @return the actualStudyTime
	 */
	public int getActualStudyTime() {
		return actualStudyTime;
	}


	/**
	 * @param actualStudyTime the actualStudyTime to set
	 */
	public void setActualStudyTime(int actualStudyTime) {
		this.actualStudyTime = actualStudyTime;
	}


	/**
	 * @return the actualNewsTime
	 */
	public int getActualNewsTime() {
		return actualNewsTime;
	}


	/**
	 * @param actualNewsTime the actualNewsTime to set
	 */
	public void setActualNewsTime(int actualNewsTime) {
		this.actualNewsTime = actualNewsTime;
	}


	/**
	 * @return the actualOherTime
	 */
	public int getActualOtherTime() {
		return actualOtherTime;
	}


	/**
	 * @param actualOherTime the actualOherTime to set
	 */
	public void setActualOtherTime(int actualOtherTime) {
		this.actualOtherTime = actualOtherTime;
	}


	/**
	 * @return the unfinishedItems
	 */
	public int getUnfinishedItems() {
		return unfinishedItems;
	}


	/**
	 * @param unfinishedItems the unfinishedItems to set
	 */
	public void setUnfinishedItems(int unfinishedItems) {
		this.unfinishedItems = unfinishedItems;
	}

	
	
}
