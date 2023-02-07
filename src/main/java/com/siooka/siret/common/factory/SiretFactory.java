package com.siooka.siret.common.factory;

import com.siooka.siret.data.data_transfert_object.SiretDetailsDto;

public interface SiretFactory {
    SiretDetailsDto getEmptySiret(String msg);
}
