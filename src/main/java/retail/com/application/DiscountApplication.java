package retail.com.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("retail.com.*")
public class DiscountApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiscountApplication.class, args);
	}
}
