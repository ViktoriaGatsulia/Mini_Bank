package ru.miniBank.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.log4j.Logger;
import ru.miniBank.demo.entity.BankCard;
import ru.miniBank.demo.entity.BankUser;
import ru.miniBank.demo.entity.CategoryCard;
import ru.miniBank.demo.service.BankCardService;
import ru.miniBank.demo.service.BankUserService;

import java.util.Date;

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

//        bankUserService.save(new BankUser(1L, "Viki", null));
//        log.info("create new bankUser");
//	    bankCardService.save(new BankCard(1L, new Date(), 111, "222", 3D, CategoryCard.MIR));
//    	log.info("create new bankCard");
    }

}
