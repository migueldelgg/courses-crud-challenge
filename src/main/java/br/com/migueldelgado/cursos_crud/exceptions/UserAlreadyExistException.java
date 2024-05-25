package br.com.migueldelgado.cursos_crud.exceptions;

public class UserAlreadyExistException extends RuntimeException{

    public UserAlreadyExistException(){
        super("Ops, esse username ou email já constam no nosso sistema, porfavor reveja!");
    }

    public UserAlreadyExistException(String message){
        super (message);
    }
}


