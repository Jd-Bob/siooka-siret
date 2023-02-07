package com.siooka.siret.service.metier;

import com.siooka.siret.common.mapper.EtablissementMapper;
import com.siooka.siret.data.data_transfert_object.ResponseDto;
import com.siooka.siret.data.data_transfert_object.SiretDetailsDto;
import com.siooka.siret.data.domain_object.Etablissement;
import com.siooka.siret.repository.EtablissementRepository;
import com.siooka.siret.service.delegate.SiretDelegateService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Service
public class SiretServiceMetierImpl implements SiretServiceMetier {

    @Autowired
    SiretDelegateService siretDelegate;

    @Autowired
    EtablissementRepository repository;

    @Autowired
    EtablissementMapper etablissementMapper;

    public SiretDetailsDto getSiretDetails(String token, String id) {
        SiretDetailsDto siretDto = siretDelegate.getSiretDetails(token, id);
        if (siretDto.getEtablissement() != null) {
            Etablissement etablissement = etablissementMapper.etablissementDTOtoEtablissement(siretDto.getEtablissement());
            repository.save(etablissement);
            return siretDto;
        }
        return null;
    }

    public List<Etablissement> getAll() {
        return repository.findAll();
    }
}
