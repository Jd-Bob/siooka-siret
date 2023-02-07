package com.siooka.siret.common.mapper;

import com.siooka.siret.data.data_transfert_object.AdressEtablissementDto;
import com.siooka.siret.data.data_transfert_object.EtablissementDto;
import com.siooka.siret.data.data_transfert_object.UniteLegaleDto;
import com.siooka.siret.data.domain_object.Etablissement;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EtablissementMapper {

    EtablissementMapper INSTANCE = Mappers.getMapper(EtablissementMapper.class);

    EtablissementDto etablissementToEtablissementDTO(Etablissement entity);

    @Mapping(source = "uniteLegale", target = "activite", qualifiedByName="activityFullName")
    @Mapping(source = "adresseEtablissement", target = "address", qualifiedByName="fullAddress")
    Etablissement etablissementDTOtoEtablissement(EtablissementDto dto);

    @Named("fullAddress")
    public static String fullAddress(AdressEtablissementDto address) {
        return address.getCodePostalEtablissement() + ", " + address.getLibelleVoieEtablissement() + ", "
                + address.getCodeCommuneEtablissement() + ", " + address.getLibelleCommuneEtablissement();
    }

    @Named("activityFullName")
    public static String activityFullName(UniteLegaleDto unit) {
        return unit.getDenominationUniteLegale();
    }
}
