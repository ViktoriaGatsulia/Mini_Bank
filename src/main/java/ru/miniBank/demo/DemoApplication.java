package ru.miniBank.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.log4j.Logger;
/**
 * Класс запуска Spring приложения
 * @autor ViktoriaGatsulia
 * @version 1.0
 */
@SpringBootApplication
public class DemoApplication {
    /** Поле для логирования */
    private static final Logger log = Logger.getLogger(DemoApplication.class.getName());

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        log.info("Start application");
    }

}
