package br.com.alura.school.application.student.enroll;

import br.com.alura.school.domain.student.CPF;
import br.com.alura.school.domain.student.Student;
import br.com.alura.school.infrastructure.student.StudentsRepositoryInMemory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnrollStudentTest {

    @Test
    public void shouldPersistStudent(){
        StudentsRepositoryInMemory repository = new StudentsRepositoryInMemory();
        EnrollStudent useCase = new EnrollStudent(repository);

        EnrollStudentDto data = new EnrollStudentDto("Daenerys Targaryen", "123.456.789-10",
                "dany@asoiaf.com");
        useCase.execute(data);

        Student returnedStudent = repository.findByCPF(new CPF("123.456.789-10"));

        assertEquals("Daenerys Targaryen", returnedStudent.getName());
        assertEquals("123.456.789-10", returnedStudent.getCpf());
        assertEquals("dany@asoiaf.com", returnedStudent.getEmail());

    }

}