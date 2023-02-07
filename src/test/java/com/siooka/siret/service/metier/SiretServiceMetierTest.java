package com.siooka.siret.service.metier;

import com.siooka.siret.SiretApplication;
import com.siooka.siret.common.mapper.EtablissementMapper;
import com.siooka.siret.data.data_transfert_object.SiretDetailsDto;
import com.siooka.siret.repository.EtablissementRepository;
import com.siooka.siret.service.delegate.SiretDelegateService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = SiretApplication.class)
public class SiretServiceMetierTest {

    @Mock
    SiretDelegateService siretDelegate;

    @Mock
    EtablissementRepository repository;

    @Mock
    EtablissementMapper etablissementMapper;

    @Autowired
    private SiretServiceMetier siretServiceMetier;

    @Test
    public void testGetSiretDetailsNull() {
        SiretDetailsDto expected = siretServiceMetier.getSiretDetails("siret-test");
        Assertions.assertNull(expected);
    }

    @Test
    public void testGetSiretDetailsNotNull() {
    }
}
