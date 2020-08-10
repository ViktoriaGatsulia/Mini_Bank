package ru.miniBank.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Date;

import ru.miniBank.demo.entity.BankCard;
import ru.miniBank.demo.entity.BankUser;
import ru.miniBank.demo.service.BankCardService;
import ru.miniBank.demo.service.BankUserService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
        assertThat(this.bankUserService.findById(1L).get().getBankCard()).isEqualTo(bankCards);
    }

    @Test
    public void testFindBankCardById() {
        BankCard bankCard = new BankCard(1L, new Date(), 123, "1234 1234 1234 1234", 100D);
        given(this.bankCardService.findById(1L)).willReturn(java.util.Optional.of(bankCard));
        assertThat(this.bankCardService.findById(1L).get().getBalance()).isEqualTo(100D);
    }

    @Test
    public void testViewShowStartPage() throws Exception {
        this.mvc
                .perform(get("/"))
                .andExpect(status().isOk()).andExpect(content().
                string("hello"));
    }


    @Test
    public void testViewSaveBankUser() throws Exception {
        this.mvc
                .perform(post("/saveBankUser").contentType(MediaType.APPLICATION_JSON).content("{\n" +
                        "    \"user_id\": \"1\", \n" +
                        "    \"userName\": \"Viktoria\",\n" +
                        "    \"bankCards\": null\n" +
                        "}"))
                .andExpect(status().isOk())
                .andExpect(content()
                        .string("{\"user_id\":1,\"userName\":\"Viktoria\",\"bankCard\":null}"));
    }

    @Test
    public void testViewUserFindById() throws Exception {
        List<BankCard> bankCards = new ArrayList<>();
        bankCards.add(new BankCard(1L, new Date(10000), 123, "1234 1234 1234 1234", 100D));
        BankUser bankUser = new BankUser(1L, "Viktoria", bankCards);

        given(this.bankUserService.findById(1L))
                .willReturn(java.util.Optional.of(bankUser));
        this.mvc.perform(get("/user_id=1").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andExpect(content().
                string("{\"user_id\":1,\"userName\":\"Viktoria\",\"bankCard\":[{\"card_id\":1,\"card_expiry_date\":\"1970-01-01T00:00:10.000+00:00\",\"cvc2\":123,\"card_number\":\"1234 1234 1234 1234\",\"balance\":100.0}]}"));
    }

    @Test
    public void testViewUserFindByIdNotFound() throws Exception {
        this.mvc.perform(get("/user_id=2").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

}

// .andExpect(status().isOk()) - код возврата был 200?