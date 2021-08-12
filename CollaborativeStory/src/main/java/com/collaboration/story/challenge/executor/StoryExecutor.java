
package com.collaboration.story.challenge.executor;
import java.util.concurrent.ThreadPoolExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.collaboration.story.challenge.utils.PropertiesExtractor;

public class StoryExecutor {
	
	private StoryExecutor(){}
	private static ThreadPoolTaskExecutor threadPoolTaskExecutor=null;
	
	public static ThreadPoolTaskExecutor getStoryExcecutorInstance() {
		if (threadPoolTaskExecutor == null) {
			synchronized (StoryExecutor.class) {
				if (threadPoolTaskExecutor == null) {
					threadPoolTaskExecutor = StoryExecutor.myCustomExecutor();
				}
			}
		}
		return threadPoolTaskExecutor;
	}
	
	private static ThreadPoolTaskExecutor myCustomExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setMaxPoolSize(Integer.parseInt(PropertiesExtractor.getProperty("project.story.maxPoolSize")));
		executor.setCorePoolSize(Integer.parseInt(PropertiesExtractor.getProperty("project.story.corePoolSize")));
		executor.setQueueCapacity(Integer.parseInt(PropertiesExtractor.getProperty("project.story.queueCapacity")));
		executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
		executor.setWaitForTasksToCompleteOnShutdown(true);
		executor.setThreadNamePrefix("Story-Listener");
		executor.initialize();
		return executor;
	}

}
