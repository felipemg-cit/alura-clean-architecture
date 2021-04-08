package br.com.alura.school.application.student.enroll;

import br.com.alura.school.domain.student.Student;
import br.com.alura.school.domain.student.StudentsRepository;

public class EnrollStudent {
    private final StudentsRepository repository;

    public EnrollStudent(StudentsRepository repository){
        this.repository = repository;
    }

    //Command
    public void execute(EnrollStudentDto studentDto){
        Student enrolled = studentDto.createStudent();
        repository.enroll(enrolled);
    }
}
