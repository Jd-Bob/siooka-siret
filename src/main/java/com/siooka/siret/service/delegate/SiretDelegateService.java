package com.siooka.siret.service.delegate;

import com.siooka.siret.data.data_transfert_object.SiretDetailsDto;

public interface SiretDelegateService {

    SiretDetailsDto getSiretDetails(String token, String id);
}
