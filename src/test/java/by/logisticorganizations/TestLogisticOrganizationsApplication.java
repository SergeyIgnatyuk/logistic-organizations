package by.logisticorganizations;

import org.springframework.boot.SpringApplication;

public class TestLogisticOrganizationsApplication {

    public static void main(String[] args) {
        SpringApplication.from(LogisticOrganizationsApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
