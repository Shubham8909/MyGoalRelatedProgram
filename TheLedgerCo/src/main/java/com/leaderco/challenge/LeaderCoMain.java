package com.leaderco.challenge;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.leaderco.challenge.command.BalanceCommandExcecutor;
import com.leaderco.challenge.command.CommandExecutors;
import com.leaderco.challenge.command.LoanCommandExcecutor;
import com.leaderco.challenge.command.PaymentCommandExecutor;
import com.leaderco.challenge.emi.stratgy.EMIStrategy;
import com.leaderco.challenge.emi.stratgy.EMIStrategyDefaultImpl;
import com.leaderco.challenge.model.Command;
import com.leaderco.challenge.service.CommanService;
import com.leaderco.challenge.utils.CommanUtils;

@SpringBootApplication
public class LeaderCoMain implements CommandLineRunner {

	private List<CommandExecutors> listCommandExecutors;

	public LeaderCoMain() {
		List<CommandExecutors> listCommandExecutors = new ArrayList<>();
		EMIStrategy emi = new EMIStrategyDefaultImpl();
		CommanService cmmService = new CommanService();
		listCommandExecutors.add(new BalanceCommandExcecutor(cmmService));
		listCommandExecutors.add(new PaymentCommandExecutor(cmmService));
		listCommandExecutors.add(new LoanCommandExcecutor(emi, cmmService));
		this.listCommandExecutors = listCommandExecutors;
	}

	@Value("${input.filePath}")
	private String filePath;

	public void run(String... args) throws Exception {
		execute(args);
	}

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(LeaderCoMain.class);
		app.run(args);
	}

	private void execute(String[] args) {
		File file = new File(filePath);
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
			String st = null;
			while ((st = br.readLine()) != null) {
				Command command = CommanUtils.createCommand(st);
				String cmdResponse = runCommand(command);
				if (!StringUtils.isBlank(cmdResponse))
					System.out.println(cmdResponse);
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("[" + filePath + "] Given File Not Found!");
			return;
		} catch (IOException e) {
			System.out.println("Not Able to Read Given file !");
			return;
		}

	}

	private String runCommand(Command command) {
		for (CommandExecutors executor : listCommandExecutors) {
			if (executor.isAcceptable(command)) {
				return executor.execute(command);
			}
		}
		return "It's not Valid Command";
	}

}
