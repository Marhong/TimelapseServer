package com.timelapse.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.timelapse.model.Record;
import com.timelapse.model.RecordList;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


/**
 * 获取某一用户的所有对战记录
 * @author Marhong
 * @time 2018年5月25日 下午6:31:07
 */
@WebServlet("/GetRecordServlet")
public class GetRecordsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetRecordsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


    /* (non-Javadoc)
     * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	JSONArray userList = new JSONArray();
		JSONObject user = new JSONObject();
		user.put("userName", "sdf");
		user.put("password", "sdf");
		user.put("signature", "sd");
		user.put("victoryPoint", 99);
		userList.add(user);
		resp.getWriter().print(user.toString() + "\n\n" + userList.toString());
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String userName = request.getParameter("userName");
		System.out.println(userName);
		RecordList recordList = new RecordList();
		ArrayList<Record> records = recordList.getRecordListByName(userName);
		JSONArray jsonArray = new JSONArray();
		if(records != null) {
			for(Record curRecord: records) {
				JSONObject record = new JSONObject();
				record.put("id", curRecord.getId());
				record.put("initiator",curRecord.getInitiator());
				record.put("receiver", curRecord.getReceiver());
				record.put("time", curRecord.getTime());
				record.put("initiatorResult", curRecord.getInitiatorResult());
				record.put("receiverResult", curRecord.getReceiverResult());
				record.put("iniUnfinishedNum",curRecord.getIniUnfinishedNum());
				record.put("recUnfinishedNum", curRecord.getRecUnfinishedNum());
				jsonArray.add(record);
			}
			response.getWriter().print(jsonArray.toString());
		}else {
			response.getWriter().print("emptyRecords");
		}
		
	}

}
