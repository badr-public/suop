package br.com.badr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
//@EnableAutoConfiguration
@EnableConfigServer
public class App {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(App.class, args);
	}
	
}
