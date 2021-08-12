package net.one97.processor.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import net.one97.processor.dao.VMCallbackDaoImpl;
import net.one97.processor.vo.ImportHeader;

public class FreshChargeThread implements Runnable {

	private static final Logger logger = LoggerFactory.getLogger(FreshChargeThread.class);

	public VMCallbackDaoImpl getCsvBaseImportDaoImpl() {
		return vMCallbackDaoImpl;
	}

	public void setCsvBaseImportDaoImpl(VMCallbackDaoImpl vMCallbackDaoImpl) {
		this.vMCallbackDaoImpl = vMCallbackDaoImpl;
	}

	public Environment getEnv() {
		return env;
	}

	public void setEnv(Environment env) {
		this.env = env;
	}

	public FreshChargeThread(VMCallbackDaoImpl vMCallbackDaoImpl, Environment env, List<ImportHeader> freshList) {
		super();
		this.vMCallbackDaoImpl = vMCallbackDaoImpl;
		this.env = env;
		this.freshList = freshList;
	}

	private VMCallbackDaoImpl vMCallbackDaoImpl;
	private Environment env;
	private List<ImportHeader> freshList;

	public List<ImportHeader> getFreshList() {
		return freshList;
	}

	public void setFreshList(List<ImportHeader> freshList) {
		this.freshList = freshList;
	}

	@Override
	public void run() {
		logger.info("...........in fresh charged Callback thread Started..........." + freshList.size());
		String callbackUrl=env.getProperty("callback.url");
		int poolSize=Integer.parseInt(env.getProperty("thread.poolSize"));
		processCallback(freshList,callbackUrl,poolSize);
		logger.info("...........in fresh charged Callback thread Ended Successfully.........." );
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void processCallback(List<ImportHeader> importList,String callbackUrl,int poolSize) {
		ExecutorService executor = Executors.newFixedThreadPool(poolSize);
		List<Future<Runnable>> futures = new ArrayList<Future<Runnable>>();
		for (ImportHeader importHeader:importList ) {
			CallbackProcessThread thread = new CallbackProcessThread(importHeader,callbackUrl);
			Future f = executor.submit(thread);
			futures.add(f);
	     }
		for (Future<Runnable> f : futures) {
			try {
				f.get();
			} catch (InterruptedException e) {
				logger.error("@Getting InterruptedException while lock the thread ");
			} catch (ExecutionException e) {
				logger.error("@Getting InterruptedException while lock the thread ");
			}
		}
		executor.shutdownNow();
	}
	

	/*
	 * @SuppressWarnings({ "rawtypes", "unchecked" }) private void
	 * importBaseProcessStart(List<List<ImportHeader>> importList, int poolSize) {
	 * ExecutorService executor = Executors.newFixedThreadPool(poolSize);
	 * List<Future<Runnable>> futures = new ArrayList<Future<Runnable>>();
	 * 
	 * for (int i = 0; i < poolSize; i++) { ImportListProcessThread thread = new
	 * ImportListProcessThread(importList.get(i), vMCallbackDaoImpl); Future f =
	 * executor.submit(thread); futures.add(f); }
	 * 
	 * for (Future<Runnable> f : futures) { try { f.get(); } catch
	 * (InterruptedException e) {
	 * logger.error("@Getting InterruptedException while lock the thread "); } catch
	 * (ExecutionException e) {
	 * logger.error("@Getting InterruptedException while lock the thread "); } }
	 * 
	 * executor.shutdownNow(); }
	 */

}
