package com.cleartrip.properties;

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

import com.cleartrip.properties.command.CommandExecutors;
import com.cleartrip.properties.command.PropertiesRegisterCommand;
import com.cleartrip.properties.command.RegisterUserCommand;
import com.cleartrip.properties.command.SearchPropertiesCommand;
import com.cleartrip.properties.command.ShortListPropertyCommand;
import com.cleartrip.properties.command.ViewShortListedCommand;
import com.cleartrip.properties.model.Command;
import com.cleartrip.properties.service.PropertiesRegisterService;
import com.cleartrip.properties.service.SearchPropertiesService;
import com.cleartrip.properties.service.UserRegisterService;
import com.cleartrip.properties.utils.CommanUtils;

@SpringBootApplication
public class PropertiesMain implements CommandLineRunner {

	private List<CommandExecutors> listCommandExecutors;

	public PropertiesMain() {
		List<CommandExecutors> listCommandExecutors = new ArrayList<>();
		UserRegisterService userRegserv = new UserRegisterService();
		RegisterUserCommand RegisterUserCommand = new RegisterUserCommand(userRegserv);

		PropertiesRegisterService propertiesRegisterService = new PropertiesRegisterService(userRegserv);
		PropertiesRegisterCommand propertiesRegisterCommand = new PropertiesRegisterCommand(propertiesRegisterService);

		SearchPropertiesService searchPropertiesService = new SearchPropertiesService(userRegserv);
		SearchPropertiesCommand searchPropertiesCommand = new SearchPropertiesCommand(searchPropertiesService);

		ShortListPropertyCommand shortListPropertyCommand = new ShortListPropertyCommand(searchPropertiesService);
		ViewShortListedCommand viewShortListedCommand = new ViewShortListedCommand(shortListPropertyCommand);
		listCommandExecutors.add(viewShortListedCommand);
		listCommandExecutors.add(shortListPropertyCommand);
		listCommandExecutors.add(searchPropertiesCommand);
		listCommandExecutors.add(propertiesRegisterCommand);
		listCommandExecutors.add(RegisterUserCommand);
		this.listCommandExecutors = listCommandExecutors;

	}

	@Value("${input.filePath}")
	private String filePath;

	public void run(String... args) throws Exception {
		execute(args);
	}

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(PropertiesMain.class);
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
