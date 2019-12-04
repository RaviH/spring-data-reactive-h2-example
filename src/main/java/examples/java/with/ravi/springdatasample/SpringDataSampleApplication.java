package examples.java.with.ravi.springdatasample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication
@EnableWebFlux
@EnableFeignClients
public class SpringDataSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataSampleApplication.class, args);
	}

}
