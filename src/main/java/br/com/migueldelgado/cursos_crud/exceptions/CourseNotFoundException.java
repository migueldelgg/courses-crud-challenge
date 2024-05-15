package br.com.migueldelgado.cursos_crud.exceptions;

public class CourseNotFoundException extends RuntimeException{

    public CourseNotFoundException(){
        super("Ops, o seu curso não foi encontrado. Verifique o id do curso!");
    }

    public CourseNotFoundException(String message){
        super (message);
    }
}
