package br.com.migueldelgado.cursos_crud.exceptions;

public class AdminNotFound extends RuntimeException{

    public AdminNotFound(){
        super("Ops, esse Administrador nao existe, verifique o id!");
    }

    public AdminNotFound(String message){
        super (message);
    }
}
