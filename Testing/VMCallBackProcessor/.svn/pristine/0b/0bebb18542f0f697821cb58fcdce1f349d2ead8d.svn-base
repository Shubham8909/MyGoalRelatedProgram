package net.one97.processor.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ParameterizedPreparedStatementSetter;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import net.one97.processor.vo.ImportHeader;

@Repository
public class VMCallbackDaoImpl {
	private static final Logger logger = LoggerFactory.getLogger(VMCallbackDaoImpl.class);
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	@Transactional
	public int insertInDB(List<ImportHeader> importHeaderlist) {
		 logger.info("Started :: insertInDB method to insert baseImport data in table");
			  String sql = "INSERT INTO sm_vm_callback_vodafone "
						+ "(id,msisdn,user_text,channel,short_code,pack_name,action,action_status,amount,source_application,transaction_time)"
						+ " VALUES(?,?,?,?,?,?,?,?,?,?,?) ";
	          @SuppressWarnings("unused")
			int[][] updateCounts = jdbcTemplate.batchUpdate(
	          		sql,
	          		importHeaderlist,
	                  1000,
	                  new ParameterizedPreparedStatementSetter<ImportHeader>() {
							@Override
							public void setValues(PreparedStatement ps, ImportHeader record) throws SQLException {
								ps.setInt(1, Integer.parseInt(record.getId()));
								ps.setString(2, record.getMsisdn());
								ps.setString(3, record.getUserText());
								ps.setString(4, record.getChannel());
								ps.setString(5, record.getShort_code());
								ps.setString(6, record.getPack_name());
								ps.setString(7, record.getAction());
								ps.setString(8, record.getAction_status());
								ps.setDouble(9, Double.parseDouble(record.getAmount()));
								ps.setString(10, record.getSource_application());
								ps.setString(11, record.getTransaction_time());
							}
	                  });
	          logger.info("Total number of records inserted into table is-"+importHeaderlist.size());
	          return importHeaderlist.size();
			
		}

	/*
	 * public int insertRequestId(RequestIdDetails requestIdDetails) { int
	 * updatedRecord = 0; String sql =
	 * "insert into sm_requestId_tracker(charge_type,request_id, request_time) values(?,?,?)"
	 * ; logger.info("Insert Data in DB  @insertRequestId :: SQL :: " + sql); try {
	 * updatedRecord = jdbcTemplate.update(sql, new Object[] {
	 * requestIdDetails.getType(), requestIdDetails.getRequestId(),
	 * requestIdDetails.getRequestTime() }); } catch (Exception e) {
	 * logger.error("Error Occured while inserting in DB @insertRequestId  " + e); }
	 * return updatedRecord; }
	 * 
	 * public int updateRequestId(RequestIdDetails requestIdDetails) { int
	 * updatedRecord = 0; String sql =
	 * "update sm_requestId_tracker set request_id=?,request_time=? where charge_type=? "
	 * ; try { updatedRecord = jdbcTemplate.update(sql, new Object[] {
	 * requestIdDetails.getRequestId(), requestIdDetails.getRequestTime(),
	 * requestIdDetails.getType() }); } catch (Exception e) {
	 * logger.error("Error Occured while update in db @insertRequestId " + e); }
	 * return updatedRecord; }
	 * 
	 * public List<ImportHeader> getFreshChargedDetails(String tableName) { String
	 * sql =
	 * "Select sub_log_id,msisdn,response_code,channel,short_code,pack_name,price_point,source_application,billing_date  from "
	 * + tableName + " ";
	 * logger.info("Getting Data from DB for getFreshChargedDetails :: SQL :: " +
	 * sql); List<ImportHeader> importList = new ArrayList<ImportHeader>(); try {
	 * SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql); while (rowSet.next()) {
	 * ImportHeader importVO = new ImportHeader();
	 * importVO.setMsisdn(rowSet.getString("msisdn"));
	 * importVO.setId(String.valueOf(rowSet.getInt("sub_log_id"))); if
	 * (rowSet.getString("response_code").equalsIgnoreCase("0")) {
	 * importVO.setAction("ACT"); importVO.setAction_status("SUCCESS"); } else if
	 * (rowSet.getString("response_code").equalsIgnoreCase("9002")) {
	 * importVO.setAction("ACT"); importVO.setAction_status("BAL_LOW"); } else {
	 * importVO.setAction("ACT"); importVO.setAction_status("FAIL"); }
	 * importVO.setChannel(rowSet.getString("channel"));
	 * importVO.setShort_code(rowSet.getString("short_code"));
	 * importVO.setPack_name(rowSet.getString("pack_name"));
	 * importVO.setUserText("SUB " + rowSet.getString("pack_name"));
	 * importVO.setAmount(String.valueOf(rowSet.getDouble("price_point")));
	 * importVO.setSource_application("SMInterface");
	 * importVO.setTransaction_time(CsvUtil.getCurrentTime(rowSet.getDate(
	 * "billing_date"))); importList.add(importVO); } } catch (Exception e) {
	 * logger.error("Error occured while getting User Details From Db " + e); }
	 * return importList; }
	 * 
	 * public List<ImportHeader> getFreshChargedDetails(String tableName, int
	 * requestId) { String sql =
	 * "Select sub_log_id,msisdn,response_code,channel,short_code,pack_name,price_point,source_application,billing_date  from "
	 * + tableName + " where sub_log_id > '" + requestId + "' ";
	 * logger.info("Getting Data from DB for getFreshChargedDetails :: SQL :: " +
	 * sql); List<ImportHeader> importList = new ArrayList<ImportHeader>(); try {
	 * SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql); while (rowSet.next()) {
	 * ImportHeader importVO = new ImportHeader();
	 * importVO.setMsisdn(rowSet.getString("msisdn"));
	 * importVO.setId(String.valueOf(rowSet.getInt("sub_log_id"))); if
	 * (rowSet.getString("response_code").equalsIgnoreCase("0")) {
	 * importVO.setAction("ACT"); importVO.setAction_status("SUCCESS"); } else if
	 * (rowSet.getString("response_code").equalsIgnoreCase("9002")) {
	 * importVO.setAction("ACT"); importVO.setAction_status("BAL_LOW"); } else {
	 * importVO.setAction("ACT"); importVO.setAction_status("FAIL"); }
	 * importVO.setChannel(rowSet.getString("channel"));
	 * importVO.setShort_code(rowSet.getString("short_code"));
	 * importVO.setPack_name(rowSet.getString("pack_name"));
	 * importVO.setUserText("SUB " + rowSet.getString("pack_name"));
	 * importVO.setAmount(String.valueOf(rowSet.getDouble("price_point")));
	 * importVO.setSource_application("SMInterface");
	 * importVO.setTransaction_time(CsvUtil.getCurrentTime(rowSet.getDate(
	 * "billing_date"))); importList.add(importVO); } } catch (Exception e) {
	 * logger.error("Error occured while getting User Details From Db " + e); }
	 * return importList; }
	 * 
	 * public List<ImportHeader> getRenewalChargedDetails(String tableName, int
	 * requestId) { String sql =
	 * "Select id,msisdn,billing_response_code,channel,short_code,pack_name,billed_amount,source_application,transaction_time  from "
	 * + tableName + " where id > '" + requestId + "' ";
	 * logger.info("Getting Data from DB for getFreshChargedDetails :: SQL :: " +
	 * sql); List<ImportHeader> importList = new ArrayList<ImportHeader>(); try {
	 * SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql); while (rowSet.next()) {
	 * ImportHeader importVO = new ImportHeader();
	 * importVO.setMsisdn(rowSet.getString("msisdn"));
	 * importVO.setId(String.valueOf(rowSet.getInt("id"))); if
	 * (rowSet.getString("billing_response_code").equalsIgnoreCase("0") ||
	 * rowSet.getString("billing_response_code").equalsIgnoreCase("SUCCESS")) {
	 * importVO.setAction("REN"); importVO.setAction_status("SUCCESS"); } else if
	 * (rowSet.getString("billing_response_code").equalsIgnoreCase("9002") ||
	 * rowSet.getString("billing_response_code").equalsIgnoreCase("FAILED")) {
	 * importVO.setAction("REN"); importVO.setAction_status("BAL_LOW"); } else {
	 * importVO.setAction("REN"); importVO.setAction_status("FAIL"); }
	 * importVO.setChannel(rowSet.getString("channel"));
	 * importVO.setShort_code(rowSet.getString("short_code"));
	 * importVO.setPack_name(rowSet.getString("pack_name"));
	 * importVO.setUserText("SUB " + rowSet.getString("pack_name"));
	 * importVO.setAmount(String.valueOf(rowSet.getDouble("billed_amount")));
	 * importVO.setSource_application("SMInterface");
	 * importVO.setTransaction_time(CsvUtil.getCurrentTime(rowSet.getDate(
	 * "transaction_time"))); importList.add(importVO); } } catch (Exception e) {
	 * logger.error("Error occured while getting User Details From Db " + e); }
	 * return importList; }
	 * 
	 * public List<ImportHeader> getRenewalChargedDetails(String tableName) { String
	 * sql =
	 * "Select id,msisdn,billing_response_code,channel,short_code,pack_name,billed_amount,source_application,transaction_time  from "
	 * + tableName + " ";
	 * logger.info("Getting Data from DB for getFreshChargedDetails :: SQL :: " +
	 * sql); List<ImportHeader> importList = new ArrayList<ImportHeader>(); try {
	 * SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql); while (rowSet.next()) {
	 * ImportHeader importVO = new ImportHeader();
	 * importVO.setMsisdn(rowSet.getString("msisdn"));
	 * importVO.setId(String.valueOf(rowSet.getInt("id"))); if
	 * (rowSet.getString("billing_response_code").equalsIgnoreCase("0") ||
	 * rowSet.getString("billing_response_code").equalsIgnoreCase("SUCCESS")) {
	 * importVO.setAction("REN"); importVO.setAction_status("SUCCESS"); } else if
	 * (rowSet.getString("billing_response_code").equalsIgnoreCase("9002") ||
	 * rowSet.getString("billing_response_code").equalsIgnoreCase("FAILED")) {
	 * importVO.setAction("REN"); importVO.setAction_status("BAL_LOW"); } else {
	 * importVO.setAction("REN"); importVO.setAction_status("FAIL"); }
	 * importVO.setChannel(rowSet.getString("channel"));
	 * importVO.setShort_code(rowSet.getString("short_code"));
	 * importVO.setPack_name(rowSet.getString("pack_name"));
	 * importVO.setUserText("SUB " + rowSet.getString("pack_name"));
	 * importVO.setAmount(String.valueOf(rowSet.getDouble("billed_amount")));
	 * importVO.setSource_application("SMInterface");
	 * importVO.setTransaction_time(CsvUtil.getCurrentTime(rowSet.getDate(
	 * "transaction_time"))); importList.add(importVO); } } catch (Exception e) {
	 * logger.error("Error occured while getting User Details From Db " + e); }
	 * return importList; }
	 * 
	 * public List<ImportHeader> getUnSubDetails(String tableName, int requestId) {
	 * String sql =
	 * "Select request_id,msisdn,status,channel,short_code,pack_name,source_application,request_time  from "
	 * + tableName + " where request_type='UNSUB' and request_id > '" + requestId +
	 * "' ";
	 * logger.info("Getting Data from DB for getFreshChargedDetails :: SQL :: " +
	 * sql); List<ImportHeader> importList = new ArrayList<ImportHeader>(); try {
	 * SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql); while (rowSet.next()) {
	 * ImportHeader importVO = new ImportHeader();
	 * importVO.setMsisdn(rowSet.getString("msisdn"));
	 * importVO.setId(String.valueOf(rowSet.getInt("request_id"))); if
	 * (rowSet.getString("status").equalsIgnoreCase("success")) {
	 * importVO.setAction("DCT"); importVO.setAction_status("SUCCESS"); } else {
	 * importVO.setAction("DCT"); importVO.setAction_status("FAIL"); }
	 * importVO.setChannel(rowSet.getString("channel"));
	 * importVO.setShort_code(rowSet.getString("short_code"));
	 * importVO.setPack_name(rowSet.getString("pack_name"));
	 * importVO.setUserText("UNSUB " + rowSet.getString("pack_name"));
	 * importVO.setAmount("0"); importVO.setSource_application("SMInterface");
	 * importVO.setTransaction_time(CsvUtil.getCurrentTime(rowSet.getDate(
	 * "request_time"))); importList.add(importVO); } } catch (Exception e) {
	 * logger.error("Error occured while getting User Details From Db " + e); }
	 * return importList; }
	 * 
	 * public List<ImportHeader> getUnSubDetails(String tableName) { String sql =
	 * "Select request_id,msisdn,status,channel,short_code,pack_name,source_application,request_time  from "
	 * + tableName + " where request_type='UNSUB' ";
	 * logger.info("Getting Data from DB for getFreshChargedDetails :: SQL :: " +
	 * sql); List<ImportHeader> importList = new ArrayList<ImportHeader>(); try {
	 * SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql); while (rowSet.next()) {
	 * ImportHeader importVO = new ImportHeader();
	 * importVO.setMsisdn(rowSet.getString("msisdn"));
	 * importVO.setId(String.valueOf(rowSet.getInt("request_id"))); if
	 * (rowSet.getString("status").equalsIgnoreCase("success")) {
	 * importVO.setAction("DCT"); importVO.setAction_status("SUCCESS"); } else {
	 * importVO.setAction("DCT"); importVO.setAction_status("FAIL"); }
	 * importVO.setChannel(rowSet.getString("channel"));
	 * importVO.setShort_code(rowSet.getString("short_code"));
	 * importVO.setPack_name(rowSet.getString("pack_name"));
	 * importVO.setUserText("UNSUB " + rowSet.getString("pack_name"));
	 * importVO.setAmount("0"); importVO.setSource_application("SMInterface");
	 * importVO.setTransaction_time(CsvUtil.getCurrentTime(rowSet.getDate(
	 * "request_time"))); importList.add(importVO); } } catch (Exception e) {
	 * logger.error("Error occured while getting User Details From Db " + e); }
	 * return importList; }
	 * 
	 * public RequestIdDetails getRequestIdDeatils(String type) { String sql =
	 * "Select charge_type,request_id, request_time from sm_requestId_tracker where charge_type='"
	 * + type + "' limit 1";
	 * logger.info("Getting Data from DB for RequestId :: SQL :: " + sql);
	 * RequestIdDetails requestIdDetails = new RequestIdDetails(); try { SqlRowSet
	 * rowSet = jdbcTemplate.queryForRowSet(sql); while (rowSet.next()) {
	 * requestIdDetails.setRequestTime(rowSet.getString("request_time"));
	 * requestIdDetails.setRequestId(rowSet.getInt("request_id")); } } catch
	 * (Exception e) {
	 * logger.error("Error occured while getting User Details From Db " + e); }
	 * return requestIdDetails; }
	 */

}
