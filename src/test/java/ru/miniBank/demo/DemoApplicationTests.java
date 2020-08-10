package ru.miniBank.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import ru.miniBank.demo.entity.BankCard;
import ru.miniBank.demo.entity.BankUser;
import ru.miniBank.demo.service.BankCardService;
import ru.miniBank.demo.service.BankUserService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class DemoApplicationTests {
    /*
        Способ тестирования конечных точек:
        имитационная среда класс MockMvc
    */
    @Autowired
    private MockMvc mvc;

    /*
        Аннотация @MockBean, описывает имитационный объект Mockito
        для компонента в Applicationcontext
    */
    @MockBean
    private BankUserService bankUserService;

    @MockBean
    private BankCardService bankCardService;

    @Test
    public void testFindBankUserById() {
        List<BankCard> bankCards = new ArrayList<>();
        bankCards.add(new BankCard(1L, new Date(), 123, "1234 1234 1234 1234", 100D));
        given(this.bankUserService.findById(1L)).willReturn(java.util.Optional.of(new BankUser(1L, "Viktoria", bankCards)));
        assertThat(this.bankUserService.findById(1L).get().getBankCards()).isEqualTo(bankCards);
    }

    @Test
    public void testFindBankCardById() {
        BankCard bankCard = new BankCard(1L, new Date(), 123, "1234 1234 1234 1234", 100D);
        given(this.bankCardService.findById(1L)).willReturn(java.util.Optional.of(bankCard));
        assertThat(this.bankCardService.findById(1L).get().getBalance()).isEqualTo(100D);
    }

//    @Test
//    public void testViewShowTask() throws Exception {
//        this.mvc
//                .perform(get("/show_task"))
//                .andExpect(status().isOk())
//                .andExpect(content()
//                        .contentType(MediaType.APPLICATION_JSON));
//    }
//
//    @Test
//    public void testViewShowUser() throws Exception {
//        this.mvc
//                .perform(get("/show_user"))
//                .andExpect(status().isOk())
//                .andExpect(content()
//                        .contentType(MediaType.APPLICATION_JSON));
//    }
//
//
//    @Test
//    public void controllerTest() throws Exception {
//        given(this.userService.findById(1L))
//                .willReturn(java.util.Optional.of(new User(1L, "Viktoria")));
//        this.mvc.perform(get("/user_id=1").accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk()).andExpect(content().
//                string("{\"user_id\":1,\"fio\":\"Viktoria\",\"task_list\":[]}"));
//    }
//
//    @Test
//    public void testReturnTimeSpentOnWorkNotFound() throws Exception {
//        this.mvc.perform(get("/time_spent_on_work_for_user=1").accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isNotFound());
//    }
//
//    @Test
//    public void testReturnTimeSpentOnWorkFound() throws Exception {
//        User user = new User(1L, "Viki");
//        user.addTask(new Task(user, 1L, "title1", "desc1", new Date(20000)));
//        user.addTask(new Task(user, 2L, "title2", "desc2", new Date(5000)));
//        user.addTask(new Task(user, 3L, "title3", "desc3", new Date(10000)));
//        given(this.userService.findById(1L)).willReturn(java.util.Optional.of(user));
//        this.mvc.perform(get("/time_spent_on_work_for_user=1").accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk()).andExpect(content().
//                string("[{\"masterUser\":{\"user_id\":1,\"fio\":\"Viki\"},\"task_id\":1,\"title\":\"title1\",\"description\":\"desc1\",\"date_add_task\":\"2020-07-28T05:54:26.189+00:00\",\"date_start_task\":null,\"date_stop_task\":null,\"time\":\"1970-01-01T00:00:20.000+00:00\"},{\"masterUser\":{\"user_id\":1,\"fio\":\"Viki\"},\"task_id\":2,\"title\":\"title2\",\"description\":\"desc2\",\"date_add_task\":\"2020-07-28T05:54:26.189+00:00\",\"date_start_task\":null,\"date_stop_task\":null,\"time\":\"1970-01-01T00:00:05.000+00:00\"},{\"masterUser\":{\"user_id\":1,\"fio\":\"Viki\"},\"task_id\":3,\"title\":\"title3\",\"description\":\"desc3\",\"date_add_task\":\"2020-07-28T05:54:26.189+00:00\",\"date_start_task\":null,\"date_stop_task\":null,\"time\":\"1970-01-01T00:00:10.000+00:00\"}]"));
//
//    }

}
/*
 */
// .andExpect(status().isOk()) - код возврата был 200?