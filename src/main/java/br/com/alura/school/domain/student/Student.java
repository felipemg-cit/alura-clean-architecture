package br.com.alura.school.domain.student;

import java.util.ArrayList;
import java.util.List;

//Entity
public class Student {
    private CPF cpf;
    private String name;
    private Email email;
    private String senha;
    private List<PhoneNumber> phoneNumbers = new ArrayList<>();

    public Student(CPF cpf, String name, Email email){
        this.cpf = cpf;
        this.name = name;
        this.email = email;
    }
    public void setPhoneNumber(String DDD, String number){
        this.phoneNumbers.add(new PhoneNumber(DDD, number));
    }

    public String getCpf() {
        return cpf.getNumber();
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email.getAddress();
    }

    public List<PhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
    }
}
