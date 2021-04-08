package br.com.alura.school.application.student.enroll;

import br.com.alura.school.domain.student.CPF;
import br.com.alura.school.domain.student.Email;
import br.com.alura.school.domain.student.Student;

public class EnrollStudentDto {
    private String studentName;
    private String studentCpf;
    private String studentEmail;

    public EnrollStudentDto(String studentName, String studentCpf, String studentEmail) {
        this.studentName = studentName;
        this.studentCpf = studentCpf;
        this.studentEmail = studentEmail;
    }

    public Student createStudent() {
        return new Student(new CPF(studentCpf), studentName, new Email(studentEmail));
    }
}
