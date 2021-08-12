package net.one97.processor;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import net.one97.processor.dao.VMCallbackDaoImpl;
import net.one97.processor.thread.FreshChargeThread;
import net.one97.processor.thread.RenewalChargeThred;
import net.one97.processor.thread.UnSubscribThread;
import net.one97.processor.utils.Constant;
import net.one97.processor.utils.CsvUtil;
import net.one97.processor.vo.ImportHeader;

@SpringBootApplication
public class VMCallbackMain implements CommandLineRunner {

	@Value("${csv.filePath}")
	private String filePath;
	
	@Autowired
    private VMCallbackDaoImpl vMCallbackDaoImpl;
	
	@Autowired
	private Environment env;

	private static final Logger logger = LoggerFactory.getLogger(VMCallbackMain.class);

	public void run(String... args) throws Exception {
		execute(args);
	}

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(VMCallbackMain.class);
		app.run(args);
	}

	private void execute(String[] args) throws NumberFormatException, InterruptedException, FileNotFoundException {
		File folder = new File(filePath);
		if (folder.exists()) {
			logger.info("Path is exit..");
		} else {
			logger.info("><------------------Path is not exit..---------------------><");
			System.exit(0);
		}
		File[] listOfFiles = folder.listFiles();
		Arrays.sort(listOfFiles, new Comparator<File>() {
		    @Override
		    public int compare(File o1, File o2) {
		        return o1.getName().compareTo(o2.getName());
		    }
		});
		if (listOfFiles.length > 0) {
			for (int i = 0; i < listOfFiles.length; i++) {
				if (!listOfFiles[i].getName().startsWith("Processed")) {
					Map<String, List<ImportHeader>> chargedMap = CsvUtil.convertCSVFileToBaseImportRecordObject(listOfFiles[i]);
					if(!isNullOrEmptyMap(chargedMap)) {
					importBaseProcessStart(chargedMap.get("IMPORT"));
					logger.info(listOfFiles[i].getName() + " file Processed SuccessFully.");
					File folder1 = new File(filePath + "Processed_" + listOfFiles[i].getName());
					listOfFiles[i].renameTo(folder1);
					logger.info("Changed the Processed file name with Processed_"+ listOfFiles[i].getName());
					} else {
						logger.info("Data not present in Csv file...");
					}
				} else {
					logger.info("><------------------@@"+listOfFiles[i].getName() + "@@ file already Processed Successfully.--------------------->< ");
				}
			}
		} else {
			logger.info("><------------------No file present in given path.---------------------><");
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void importBaseProcessStart( List<ImportHeader> importList) {
		ExecutorService executor = Executors.newFixedThreadPool(3);
		List<Future<Runnable>> futures = new ArrayList<Future<Runnable>>();
		// creating 3 individual thread.
		FreshChargeThread freshChargedThread = new FreshChargeThread(vMCallbackDaoImpl, env,importList);
		/*
		 * RenewalChargeThred renewalChargeThred = new
		 * RenewalChargeThred(vMCallbackDaoImpl, env,renewalList); UnSubscribThread
		 * unSubscribThread = new UnSubscribThread(vMCallbackDaoImpl, env,unsubList);
		 */
		// execute All Thread
		Future f1 = executor.submit(freshChargedThread);
		/*
		 * Future f2 = executor.submit(renewalChargeThred); Future f3 =
		 * executor.submit(unSubscribThread);
		 */
		futures.add(f1);
		/*
		 * futures.add(f2); futures.add(f3);
		 */

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
	
	 private  boolean isNullOrEmptyMap(Map<String, List<ImportHeader>> map) {
	        return (map == null || map.isEmpty());
	    }


}
