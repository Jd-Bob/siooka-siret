package com.siooka.siret.service.metier;

import com.siooka.siret.data.data_transfert_object.ResponseDto;
import com.siooka.siret.data.data_transfert_object.SiretDetailsDto;
import com.siooka.siret.data.domain_object.Etablissement;

import java.io.File;
import java.util.List;

public interface SiretServiceMetier {
    SiretDetailsDto getSiretDetails(String id);
    List<Etablissement> getAll();
}
