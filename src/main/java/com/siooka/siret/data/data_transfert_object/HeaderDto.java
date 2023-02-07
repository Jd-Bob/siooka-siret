package com.siooka.siret.data.data_transfert_object;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.http.HttpStatus;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class HeaderDto {
    private HttpStatus status;
    private String message;
}
