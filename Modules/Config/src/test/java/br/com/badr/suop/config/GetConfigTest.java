package br.com.badr.suop.config;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class GetConfigTest {

		@LocalServerPort
		private int port;
		
		@Autowired
		private TestRestTemplate restTemplate;
		
		@Test
		public void greetingShouldReturnDefaultMessage() throws Exception {
			String[] apps = { "common-data" };
			for (String app : apps) {
				getConfigByAppProfile(app);
			}
		}
		
		public void getConfigByAppProfile(String app) {
			String profile = "default";
			String data = this.restTemplate.getForObject("http://localhost:" + port + "/" + app + "/" + profile, String.class);
			assertThat(data).contains("https://github.com/badr-public/suop-config/" + app + "/" + app + ".yml");
		}
	
}
