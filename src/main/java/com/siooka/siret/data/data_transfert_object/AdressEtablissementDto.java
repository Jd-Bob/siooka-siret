package com.siooka.siret.data.data_transfert_object;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AdressEtablissementDto {
    private String codePostalEtablissement;
    private String libelleCommuneEtablissement;
    private String codeCommuneEtablissement;
    private String libelleVoieEtablissement;
}
