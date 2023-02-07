package com.siooka.siret.data.data_transfert_object;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ResponseDto<T> {
    private HttpStatus status;
    private String message;
    private T data;
}
