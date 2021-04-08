package br.com.alura.school.domain.student;

import java.util.List;

public interface StudentsRepository {
    void enroll(Student student);
    Student findByCPF(CPF cpf);
    List<Student> getAllEnrolledStudents();
    // ...
}
