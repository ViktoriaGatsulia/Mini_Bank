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

}
/*
 */
// .andExpect(status().isOk()) - код возврата был 200?