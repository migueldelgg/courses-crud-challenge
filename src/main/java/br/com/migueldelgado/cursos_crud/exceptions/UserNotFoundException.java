package br.com.migueldelgado.cursos_crud.exceptions;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(){
        super("Ops, esse Usuario nao existe, verifique o id!");
    }

    public UserNotFoundException(String message){
        super (message);
    }
}
