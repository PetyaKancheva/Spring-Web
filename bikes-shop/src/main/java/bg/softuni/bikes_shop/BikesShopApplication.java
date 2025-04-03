package bg.softuni.bikes_shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableCaching // TODO to implement for categories
@EnableScheduling
@SpringBootApplication
public class BikesShopApplication {
	public static void main(String[] args) {
		SpringApplication.run(BikesShopApplication.class, args);
		System.out.println("test");
	}

}
