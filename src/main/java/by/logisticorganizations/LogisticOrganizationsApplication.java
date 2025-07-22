package by.logisticorganizations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@SpringBootApplication
@RefreshScope
public class LogisticOrganizationsApplication {

    public static void main(String[] args) {
        SpringApplication.run(LogisticOrganizationsApplication.class, args);
    }

}
