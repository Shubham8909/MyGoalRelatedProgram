package net.one97.processor.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class ImportHeader {
	
	private String id;
	private String msisdn;
	private String userText;
	private String channel;
	private String short_code;
	private String pack_name;
	private String action;
	private String action_status;
	private String amount;
	private String source_application;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMsisdn() {
		return msisdn;
	}
	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}
	public String getUserText() {
		return userText;
	}
	public void setUserText(String userText) {
		this.userText = userText;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public String getShort_code() {
		return short_code;
	}
	public void setShort_code(String short_code) {
		this.short_code = short_code;
	}
	public String getPack_name() {
		return pack_name;
	}
	public void setPack_name(String pack_name) {
		this.pack_name = pack_name;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getAction_status() {
		return action_status;
	}
	public void setAction_status(String action_status) {
		this.action_status = action_status;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getSource_application() {
		return source_application;
	}
	public void setSource_application(String source_application) {
		this.source_application = source_application;
	}
	public String getTransaction_time() {
		return transaction_time;
	}
	public void setTransaction_time(String transaction_time) {
		this.transaction_time = transaction_time;
	}
	private String transaction_time; 
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
	}
	

}
