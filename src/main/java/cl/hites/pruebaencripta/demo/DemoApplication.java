package cl.hites.pruebaencripta.demo;

import cl.hites.pruebaencripta.demo.Config.Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    public static void main(String... args) {
        Config.args(args);
        SpringApplication.run(DemoApplication.class, args);
    }

}

