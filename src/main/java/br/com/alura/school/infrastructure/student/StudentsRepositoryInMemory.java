package br.com.alura.school.infrastructure.student;

import br.com.alura.school.domain.student.CPF;
import br.com.alura.school.domain.student.Student;
import br.com.alura.school.domain.student.StudentNotFound;
import br.com.alura.school.domain.student.StudentsRepository;

import java.util.ArrayList;
import java.util.List;

public class StudentsRepositoryInMemory implements StudentsRepository {

    private List<Student> enrolled = new ArrayList<>();

    @Override
    public void enroll(Student student){
        this.enrolled.add(student);
    }

    @Override
    public Student findByCPF(CPF cpf){
        return this.enrolled.stream()
                .filter(a -> a.getCpf().equals(cpf.getNumber()))
                .findFirst()
                .orElseThrow(() -> new StudentNotFound(cpf));
    }

    @Override
    public List<Student> getAllEnrolledStudents(){
        return this.enrolled;
    }

}
