package exp.deqart.bestpractices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <b>The class is the main Spring Boot application class for your project.</b><br>
 * Entry point for the application and responsible for bootstrapping the Spring context.
 *
 * <ul>
 * <li>{@link SpringBootApplication} enables SpringBoot autoconfiguration + component scanning.</li>
 * <li>{@code scanBasePackages} Specifies the base package to scan for components.<br>
 * Scans the package "exp.deqart.best_practices" and its sub-packages for components.</li>
 * </ul>
 *
 * @author Deqart
 */
@SpringBootApplication(scanBasePackages = "exp.deqart.best_practices")
public class BestPracticesApplication {
    public static void main(String[] args) {
        SpringApplication.run(BestPracticesApplication.class, args);
    }
}
