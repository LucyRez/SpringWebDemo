package cs.hse.springWebJavaDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan("cs.hse.springWebJavaDemo")
class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

}
