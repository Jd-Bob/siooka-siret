package com.siooka.siret.controller;


import com.siooka.siret.data.data_transfert_object.SiretDetailsDto;
import lombok.SneakyThrows;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SiretControllerTest {

//    @Autowired
//    private MockMvc mockMvc;

    @Autowired
    private TestRestTemplate restTemplate;

    @Value(value="${server.port}")
    private int port;

    @SneakyThrows
    @Test
    public void testGetAll() {
    }

    @SneakyThrows
    @Test
    public void testGetSiretDetails() {
    }
}
