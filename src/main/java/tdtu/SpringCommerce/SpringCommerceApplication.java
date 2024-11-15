package tdtu.SpringCommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class SpringCommerceApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(SpringCommerceApplication.class, args);
	}

}
