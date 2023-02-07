package com.siooka.siret.repository;

import com.siooka.siret.SiretApplication;
import com.siooka.siret.data.domain_object.Etablissement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = SiretApplication.class)
public class EtablissementRepositoryTest {

    @Autowired
    private EtablissementRepository etablissementRepository;

    @Test
    public void testFindBySiret() {
        Etablissement etablissement = getEtablissementMock();
        etablissementRepository.save(etablissement);
        Etablissement result = etablissementRepository.findBySiret(etablissement.getSiret()).get(0);
        Assertions.assertEquals(etablissement.getSiret(), result.getSiret());
    }

    @Test
    public void testFindById() {
        Etablissement etablissement = getEtablissementMock();
        etablissementRepository.save(etablissement);
        Etablissement result = etablissementRepository.findById(etablissement.getId()).get();
        Assertions.assertEquals(etablissement.getId(), result.getId());
    }
    @Test
    public void testFindAll() {
        Etablissement etablissement = getEtablissementMock();
        etablissementRepository.save(etablissement);
        List<Etablissement> result = new ArrayList<>();
        etablissementRepository.findAll().forEach(e -> result.add(e));
        Assertions.assertEquals(result.size(), 1);
    }
    @Test
    public void testSave() {
        Etablissement etablissement = getEtablissementMock();
        etablissementRepository.save(etablissement);
        Etablissement found = etablissementRepository.findById(etablissement.getId()).get();
        Assertions.assertEquals(etablissement.getId(), found.getId());
    }

    private Etablissement getEtablissementMock() {
        Etablissement tmp = new Etablissement();
        tmp.setId(1);
        tmp.setActivite("activity-test");
        tmp.setAddress("address-test");
        tmp.setSiret("siret-test");
        return tmp;
    }
}
