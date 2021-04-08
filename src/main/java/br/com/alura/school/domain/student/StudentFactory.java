package br.com.alura.school.domain.student;

public class StudentFactory {
    private Student student;

    public StudentFactory withNameCPFEmail(String name, String cpf, String email){
        this.student = new Student(new CPF(cpf), name, new Email(email));
        return this;
    }

    public StudentFactory withPhoneNumber(String ddd, String number){
        this.student.setPhoneNumber(ddd, number);
        return this;
    }

    public Student createStudent(){
        return this.student;
    }

//    public static void main(String[] args) {
//        StudentFactory factory = new StudentFactory();
//        Student createdStudent = factory.withNameCPFEmail("", "", "")
//                .withPhoneNumber("", "")
//                .withPhoneNumber("", "")
//                .createStudent();
//    }
}

