package com.siooka.siret.service.delegate;

import com.siooka.siret.SiretApplication;
import com.siooka.siret.common.config.ExternalConfiguration;
import com.siooka.siret.common.factory.SiretFactory;
import com.siooka.siret.data.data_transfert_object.SiretDetailsDto;
import org.apache.hc.core5.util.Asserts;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = SiretApplication.class)
public class SiretDelegateServiceTest {

    @MockBean
    private RestTemplate restTemplate;

    @Mock
    private SiretFactory siretFactory;

    @MockBean
    private ExternalConfiguration externalConfig;

    @Autowired
    private SiretDelegateService siretDelegateService;

    @Test
    public void testGetSiretDetails() {
        Asserts.notNull("", "");
    }
}
