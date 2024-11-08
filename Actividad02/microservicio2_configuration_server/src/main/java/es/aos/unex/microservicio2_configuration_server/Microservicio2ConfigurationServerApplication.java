package es.aos.unex.microservicio2_configuration_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class Microservicio2ConfigurationServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Microservicio2ConfigurationServerApplication.class, args);
	}

}
