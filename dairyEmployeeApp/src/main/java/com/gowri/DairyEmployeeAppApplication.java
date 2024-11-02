package com.gowri;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.EventListener;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class DairyEmployeeAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(DairyEmployeeAppApplication.class, args);
		System.out.println("#########################################");
	}

	// Listener to get the active profile and port after the application is ready
	@EventListener(ApplicationReadyEvent.class)
	public void handleApplicationReadyEvent(ApplicationReadyEvent event) {
		Environment env = event.getApplicationContext().getEnvironment();

		// Get the active profile(s)
		String[] activeProfiles = env.getActiveProfiles();
		String activeProfile = (activeProfiles.length > 0) ? String.join(", ", activeProfiles) : "default";

		// Get the running port
		String port = env.getProperty("server.port", "8080"); // Default to 8080 if not set

		System.out.println("Active Profile: " + activeProfile);
		System.out.println("Running on Port: " + port);
		System.out.println("#########################################");
	}
}
