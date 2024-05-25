package br.com.migueldelgado.cursos_crud.exceptions;

public class AdminNotFoundException extends RuntimeException{

    public AdminNotFoundException(){
        super("Ops, esse Administrador nao existe, verifique o id!");
    }

    public AdminNotFoundException(String message){
        super (message);
    }
}
