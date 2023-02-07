package com.siooka.siret.common.mapper;

import com.siooka.siret.data.data_transfert_object.EtablissementDto;
import com.siooka.siret.data.domain_object.Etablissement;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-07T23:34:42+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.5 (Private Build)"
)
@Component
public class EtablissementMapperImpl implements EtablissementMapper {

    @Override
    public EtablissementDto etablissementToEtablissementDTO(Etablissement entity) {
        if ( entity == null ) {
            return null;
        }

        EtablissementDto etablissementDto = new EtablissementDto();

        etablissementDto.setSiren( entity.getSiren() );
        etablissementDto.setNic( entity.getNic() );
        etablissementDto.setSiret( entity.getSiret() );
        etablissementDto.setDateCreationEtablissement( entity.getDateCreationEtablissement() );

        return etablissementDto;
    }

    @Override
    public Etablissement etablissementDTOtoEtablissement(EtablissementDto dto) {
        if ( dto == null ) {
            return null;
        }

        Etablissement etablissement = new Etablissement();

        etablissement.setActivite( EtablissementMapper.activityFullName( dto.getUniteLegale() ) );
        etablissement.setAddress( EtablissementMapper.fullAddress( dto.getAdresseEtablissement() ) );
        etablissement.setSiren( dto.getSiren() );
        etablissement.setNic( dto.getNic() );
        etablissement.setSiret( dto.getSiret() );
        etablissement.setDateCreationEtablissement( dto.getDateCreationEtablissement() );

        return etablissement;
    }
}
