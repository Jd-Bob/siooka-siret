package com.siooka.siret.data.data_transfert_object;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UniteLegaleDto {
    private String denominationUniteLegale;
    private String activitePrincipaleUniteLegale;
    private String nomenclatureActivitePrincipaleUniteLegale;
}
