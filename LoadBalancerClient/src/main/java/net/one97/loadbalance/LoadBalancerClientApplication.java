package net.one97.loadbalance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import net.one97.config.RibbonConfiguration;

@SpringBootApplication
@RibbonClient(name="statusCheck",configuration = RibbonConfiguration.class)
public class LoadBalancerClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoadBalancerClientApplication.class, args);
	}
	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
