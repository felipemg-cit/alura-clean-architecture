package br.com.alura.school;

import br.com.alura.school.application.student.enroll.EnrollStudent;
import br.com.alura.school.application.student.enroll.EnrollStudentDto;
import br.com.alura.school.infrastructure.student.StudentsRepositoryInMemory;

public class EnrollStudentByCommandLine {
    public static void main(String[] args) {
        /*
        StudentFactory factory = new StudentFactory();

        Student student = factory.withNameCPFEmail("Jon Doe", "123.456.798-10", "jondoe@foo.com")
                .createStudent();
        StudentsRepository repository = new StudentsRepositoryInMemory();
         */
        String name = "Jon Snow";
        String cpf = "123.456.789-10";
        String email = "jonsnow@asoiaf.com";


        EnrollStudent enrollStudent = new EnrollStudent(new StudentsRepositoryInMemory());
        enrollStudent.execute(new EnrollStudentDto(name, cpf, email));
    }
}
