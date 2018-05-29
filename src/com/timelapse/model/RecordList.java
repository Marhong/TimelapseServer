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
 * 对战记录列表
 * @author Marhong
 * @time 2018年5月25日 下午5:56:42
 */
public class RecordList {
	
	/**
	 * 用于存储所有的对战记录
	 */
	private ArrayList<Record> recordList;
    /**
     * 从record表中将所有的对战记录转为Record类，添加到recordList中
     * 
     */
	public RecordList(){
		
		Connection conn=null;
		recordList = new ArrayList<Record>();
		try {
			conn = AccessJDBCUtil.getAccessDBConnection();
			Statement stmt = conn.createStatement();
			String queryString = "select * from record order by id desc";
			ResultSet rs = stmt.executeQuery(queryString);
				while (rs.next()) {
					Record record = new Record();
					record.setId(rs.getLong("id"));
					record.setInitiator(rs.getString("initiator"));
					record.setReceiver(rs.getString("receiver"));
					record.setTime(rs.getString("time"));
					record.setTimestring(rs.getString("timestring"));
					record.setInitiatorResult(rs.getInt("initiatorResult"));
					record.setReceiverResult(rs.getInt("receiverResult"));
					record.setIniUnfinishedNum(rs.getInt("iniUnfinishedNum"));
					record.setRecUnfinishedNum(rs.getInt("recUnfinishedNum"));
					recordList.add(record);
		
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
	public ArrayList<Record> getRecordList() {
		return recordList;
	}

	public void setRecordList(ArrayList<Record> recordList) {
		this.recordList = recordList;
	}
	/**
	 * 
	 * @see    通过用户名获取某一用户的所有对战记录
	 * @author wangbin
	 * @time 2017年11月15日 下午1:35:26
	 * @param name 待获取的用户的名字
	 * @return 若存在名字为name的用户，则返回该用户，否则返回空
	 */
	public ArrayList<Record> getRecordListByName(String name){
		ArrayList<Record> records = new ArrayList<Record>(); 
		for(Record record: recordList){
			if(record.getInitiator().equals(name) || record.getReceiver().equals(name)){
				records.add(record);
			}
		}
		if(records.size()>0) {
			return records;
		}
		return null;
	}

	/**
	 * 
	 * @see   添加一条对战记录
	 * @author wangbin
	 * @time 2017年11月15日 下午1:39:20
	 * @param record 待添加的对战记录
	 */
	public boolean addRecord(Record record) throws ClassNotFoundException{
		long id = record.getId();
		String initiator = record.getInitiator();
		String receiver = record.getReceiver();
		String time = record.getTime();
		String timestring = record.getTimestring();
		int initiatorResult = record.getInitiatorResult();
		int receiverResult = record.getReceiverResult();
		int iniUnfinishedNum = record.getIniUnfinishedNum();
		int recUnfinishedNum = record.getRecUnfinishedNum();
		Connection conn=null;
		try {
			conn = AccessJDBCUtil.getAccessDBConnection();
			Statement stmt = conn.createStatement();
			String sql = "insert into record (id,initiator,receiver,time,initiatorResult,receiverResult,iniUnfinishedNum,recUnfinishedNum,timestring) values("+id+",'" + initiator + "','"
					+ receiver + "','" + time+"',"+initiatorResult +","+receiverResult+","+iniUnfinishedNum+","+recUnfinishedNum+",'"+timestring+"');";
			int result = stmt.executeUpdate(sql);
			if (result != -1) {
				recordList.add(record);
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
