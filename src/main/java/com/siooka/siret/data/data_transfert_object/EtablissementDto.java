package com.siooka.siret.data.data_transfert_object;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class EtablissementDto {
    private String siren;
    private String nic;
    private String siret;
    private Date dateCreationEtablissement;
    private UniteLegaleDto uniteLegale;
    private AdressEtablissementDto adresseEtablissement;
}
