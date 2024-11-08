package es.aos.unex.microservicio1_eureka_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class Microservicio1EurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Microservicio1EurekaServerApplication.class, args);
	}

}
