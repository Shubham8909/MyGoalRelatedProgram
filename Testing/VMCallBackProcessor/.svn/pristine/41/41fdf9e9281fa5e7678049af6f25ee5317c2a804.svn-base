package net.one97.processor.thread;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.one97.processor.dao.VMCallbackDaoImpl;
import net.one97.processor.vo.ImportHeader;

public class ImportListProcessThread implements Runnable {
	
	private static final Logger logger = LoggerFactory.getLogger(ImportListProcessThread.class);

	private List<ImportHeader> importList;
	private VMCallbackDaoImpl vMCallbackDaoImpl;

	public List<ImportHeader> getImportList() {
		return importList;
	}

	public void setImportList(List<ImportHeader> importList) {
		this.importList = importList;
	}

	public VMCallbackDaoImpl getvMCallbackDaoImpl() {
		return vMCallbackDaoImpl;
	}

	public void setvMCallbackDaoImpl(VMCallbackDaoImpl vMCallbackDaoImpl) {
		this.vMCallbackDaoImpl = vMCallbackDaoImpl;
	}

	public ImportListProcessThread(List<ImportHeader> importList, VMCallbackDaoImpl vMCallbackDaoImpl) {
		super();
		this.importList = importList;
		this.vMCallbackDaoImpl = vMCallbackDaoImpl;
	}

	@Override
	public void run() {
		int insertedRecord = vMCallbackDaoImpl.insertInDB(importList);
		logger.info("...........in InmortList Thread ...........insertedRecord -> " + insertedRecord);

	}

}
