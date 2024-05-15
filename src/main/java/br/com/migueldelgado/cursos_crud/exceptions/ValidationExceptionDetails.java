package br.com.migueldelgado.cursos_crud.exceptions;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Data
@SuperBuilder
public class ValidationExceptionDetails {

    private String title;
    private int status;

    private String details;

    private String developerMessage;

    private LocalDateTime timeStamp;

    private String fields;
    private String fieldsMessage;


}
