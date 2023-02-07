package com.siooka.siret.common.factory;

import com.siooka.siret.data.data_transfert_object.ErrorDto;
import com.siooka.siret.data.data_transfert_object.SiretDetailsDto;
import org.springframework.stereotype.Component;

@Component
public class SiretFactoryImpl implements SiretFactory {

    public SiretDetailsDto getEmptySiret(String msg) {
        ErrorDto err = new ErrorDto();
        err.setCode(500);
        err.setMessage(msg);
        SiretDetailsDto res = new SiretDetailsDto();
        res.setFault(err);
        return res;
    }
}
