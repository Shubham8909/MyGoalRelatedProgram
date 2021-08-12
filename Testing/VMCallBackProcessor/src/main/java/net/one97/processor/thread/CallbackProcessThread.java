package net.one97.processor.thread;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.one97.processor.utils.CsvUtil;
import net.one97.processor.vo.ImportHeader;

public class CallbackProcessThread implements Runnable {
	private static final Logger logger = LoggerFactory.getLogger(CallbackProcessThread.class);
    private ImportHeader importHeader;
	private String url;
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public CallbackProcessThread(ImportHeader importHeader, String url) {
		super();
		this.importHeader = importHeader;
		this.url = url;
	}
	public ImportHeader getImportHeader() {
		return importHeader;
	}
	public void setImportHeader(ImportHeader importHeader) {
		this.importHeader = importHeader;
	}
	@Override
	public void run() {
		logger.info(importHeader.getMsisdn()+"---------Callback Process Start--------");
		String urlCreated=CsvUtil.createCallbackUrl(url, importHeader);
		String resp=CsvUtil.hitURL(importHeader.getMsisdn(), urlCreated);
		logger.info(importHeader.getMsisdn()+"--::-------Callback Process End with Response--------::--"+resp);	
	}

}
