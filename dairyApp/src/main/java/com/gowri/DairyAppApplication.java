package com.gowri;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication
public class DairyAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(DairyAppApplication.class, args);
		System.out.println("**********************************");
		Thread.currentThread().setName("DairyAppApplication");
		System.out.println(Thread.currentThread().getName());
	}

	@EventListener(ApplicationReadyEvent.class)
	public void getAppConfig(ApplicationReadyEvent 	event) {
		ConfigurableEnvironment environment = event.getApplicationContext().getEnvironment();

		// Get the active profile(s)
		String[] activeProfiles = environment.getActiveProfiles();
		String activeProfile = (activeProfiles.length > 0) ? String.join(", ", activeProfiles) : "default";

		// Get the running port
		String port = environment.getProperty("server.port", "8080"); // Default to 8080 if not set

		System.out.println("Active Profile: " + activeProfile);
		System.out.println("Running on Port: " + port);
		System.out.println("#########################################");
	}
}

