package exp.deqart.best_practices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "exp.deqart.best_practices")
public class BestPracticesApplication {

	public static void main(String[] args) {
		SpringApplication.run(BestPracticesApplication.class, args);
	}

}
