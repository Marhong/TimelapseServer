/**
 * 
 */
package com.timelapse.model;

/**
 * 一次对战记录
 * @author Marhong
 * @time 2018年5月25日 下午5:51:36
 */
public class Record {
	private long id;
	private String initiator;
	private String receiver;
	private String time;
	private String timestring;
	private int initiatorResult;
	private int receiverResult;
	private int iniUnfinishedNum;
	private int recUnfinishedNum;
	/**
	 * 
	 */
	public Record() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param id
	 * @param initiator
	 * @param receiver
	 * @param time
	 * @param timestring
	 * @param initiatorResult
	 * @param receiverResult
	 * @param iniUnfinishedNum
	 * @param recUnfinishedNum
	 */
	public Record(long id, String initiator, String receiver, String time, String timestring, int initiatorResult,
			int receiverResult, int iniUnfinishedNum, int recUnfinishedNum) {
		super();
		this.id = id;
		this.initiator = initiator;
		this.receiver = receiver;
		this.time = time;
		this.timestring = timestring;
		this.initiatorResult = initiatorResult;
		this.receiverResult = receiverResult;
		this.iniUnfinishedNum = iniUnfinishedNum;
		this.recUnfinishedNum = recUnfinishedNum;
	}
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the initiator
	 */
	public String getInitiator() {
		return initiator;
	}
	/**
	 * @param initiator the initiator to set
	 */
	public void setInitiator(String initiator) {
		this.initiator = initiator;
	}
	/**
	 * @return the receiver
	 */
	public String getReceiver() {
		return receiver;
	}
	/**
	 * @param receiver the receiver to set
	 */
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}
	/**
	 * @param time the time to set
	 */
	public void setTime(String time) {
		this.time = time;
	}
	/**
	 * @return the timestring
	 */
	public String getTimestring() {
		return timestring;
	}
	/**
	 * @param timestring the timestring to set
	 */
	public void setTimestring(String timestring) {
		this.timestring = timestring;
	}
	/**
	 * @return the initiatorResult
	 */
	public int getInitiatorResult() {
		return initiatorResult;
	}
	/**
	 * @param initiatorResult the initiatorResult to set
	 */
	public void setInitiatorResult(int initiatorResult) {
		this.initiatorResult = initiatorResult;
	}
	/**
	 * @return the receiverResult
	 */
	public int getReceiverResult() {
		return receiverResult;
	}
	/**
	 * @param receiverResult the receiverResult to set
	 */
	public void setReceiverResult(int receiverResult) {
		this.receiverResult = receiverResult;
	}
	/**
	 * @return the iniUnfinishedNum
	 */
	public int getIniUnfinishedNum() {
		return iniUnfinishedNum;
	}
	/**
	 * @param iniUnfinishedNum the iniUnfinishedNum to set
	 */
	public void setIniUnfinishedNum(int iniUnfinishedNum) {
		this.iniUnfinishedNum = iniUnfinishedNum;
	}
	/**
	 * @return the recUnfinishedNum
	 */
	public int getRecUnfinishedNum() {
		return recUnfinishedNum;
	}
	/**
	 * @param recUnfinishedNum the recUnfinishedNum to set
	 */
	public void setRecUnfinishedNum(int recUnfinishedNum) {
		this.recUnfinishedNum = recUnfinishedNum;
	}
	
 }
