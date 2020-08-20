//package ru.miniBank.demo.been;
//
//import org.apache.log4j.Logger;
//        import org.springframework.beans.factory.annotation.Autowired;
//        import org.springframework.context.annotation.Configuration;
//        import org.springframework.scheduling.annotation.EnableScheduling;
//        import org.springframework.scheduling.annotation.Scheduled;
//import ru.miniBank.demo.entity.BankCard;
//import ru.miniBank.demo.entity.BankUser;
//import ru.miniBank.demo.service.BankCardService;
//import ru.miniBank.demo.service.BankUserService;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.Random;
//
///**
// * Класс для задач по расписанию
// * @author ViktoriaGatz
// * @version 1.0
// */
//@EnableScheduling
//@Configuration
//public class AppContext {
//
//    /** Итератор */
//    private static Long iterator = 1L;
//
//    /** Поля для логирования */
//    private static final Logger log = Logger.getLogger(AppContext.class.getName());
//
//    /** Поле для сервиса банковских карт */
//    private BankCardService bankCardService;
//
//    /** Поле для сервиса пользователей банка */
//    private BankUserService bankUserService;
//
//
//    /**
//     * Конструктор - создание нового объекта AppContext
//     * @param bankCardService - сервис банковских карт
//     * @param bankUserService - сервис пользователей банка
//     */
//    @Autowired
//    public AppContext(BankUserService bankUserService, BankCardService bankCardService) {
//        this.bankCardService = bankCardService;
//        this.bankUserService = bankUserService;
//    }
//
//    // private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
//    // log.info("The time is now " + dateFormat.format(new Date()));
//
//    /**
//     * Метод, выполняющийся каждые 10 секунд
//     */
//    @Scheduled(cron = "*/10 * * * * *") // каждые 10 секунд
//    public void createUser() {
//        bankUserService.save(new BankUser(iterator, "name" + iterator, new ArrayList<BankCard>()));
//        iterator++;
//    }
//
////    @Scheduled(cron = "*/2 * * * * *") // каждые 2 секунды
////    public void createCard() {
////        bankCardService.save(new BankCard(Long.valueOf(Random())))
////    }
//
//    /*
//        @Bean
//        @Lazy
//        @Scope("prototype")
//        public User userBean() {
//            log.info("Been User create");
//            return new User();
//        }
//
//        // @EnableTransactionManagement
//    */
//}