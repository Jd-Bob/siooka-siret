package com.siooka.siret.data.data_transfert_object;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class SiretDetailsDto {
    private ErrorDto fault;
    private HeaderDto header;
    private EtablissementDto etablissement;
}
