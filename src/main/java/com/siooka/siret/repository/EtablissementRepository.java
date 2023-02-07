package com.siooka.siret.repository;

import com.siooka.siret.data.domain_object.Etablissement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EtablissementRepository extends JpaRepository<Etablissement, Long> {
    List<Etablissement> findBySiret(String siret);
}
