package br.com.alura.school.domain.student;

public class StudentNotFound extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public StudentNotFound(CPF cpf){
        super("Student with CPF " + cpf.getNumber()+ " not found");
    }

}
