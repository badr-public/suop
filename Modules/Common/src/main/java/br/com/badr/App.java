package br.com.badr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "br.com.badr")
public class App {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(App.class, args);
	}
	
}
